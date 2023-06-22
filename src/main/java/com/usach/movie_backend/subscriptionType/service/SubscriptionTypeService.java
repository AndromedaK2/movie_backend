package com.usach.movie_backend.subscriptionType.service;

import com.usach.movie_backend.subscriptionType.domain.SubscriptionType;
import com.usach.movie_backend.subscriptionType.domain.SubscriptionTypes;
import com.usach.movie_backend.subscriptionType.repository.ISubscriptionTypeRepository;
import com.usach.movie_backend.subscriptionType.service.dto.SubscriptionTypeCreate;
import com.usach.movie_backend.subscriptionType.service.dto.SubscriptionTypeUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
@Service
public class SubscriptionTypeService implements ISubscriptionTypeService{
    @Autowired
    private ISubscriptionTypeRepository subscriptionTypeRepository;

    @Override
    public List<SubscriptionType> findAll() {
        return subscriptionTypeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public SubscriptionType findByIdSubscriptionType(Integer SubscriptionType) {
        return subscriptionTypeRepository.findById(SubscriptionType).get();
    }

    @Transactional(readOnly = true)
    public SubscriptionType findBySubscriptionTypeName(SubscriptionTypes subscriptionTypeName){
        Optional<SubscriptionType> subscriptionType = subscriptionTypeRepository.findByNameSubscription(subscriptionTypeName.toString());
        if(subscriptionType.isEmpty()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Subscription Type does not exist");
        }
        return subscriptionType.get();
    }
    @Transactional(noRollbackFor = {ResponseStatusException.class})
    public SubscriptionType create(SubscriptionTypeCreate subscriptionTypeCreate) {
        if(subscriptionTypeRepository.findByNameSubscription(subscriptionTypeCreate.nameSubscription()).isPresent())
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Subscription already exists");
        SubscriptionType subscriptionType = new SubscriptionType();
        subscriptionType.setDescriptionType(subscriptionTypeCreate.descriptionType());
        subscriptionType.setPrice(subscriptionTypeCreate.price());
        subscriptionType.setNameSubscription(subscriptionType.getNameSubscription());
        subscriptionType.setQuantityProfiles(subscriptionTypeCreate.quantityProfiles());
        return subscriptionTypeRepository.save(subscriptionType);
    }

    @Transactional(noRollbackFor = {ResponseStatusException.class})
    public SubscriptionType update(SubscriptionTypeUpdate subscriptionTypeUpdate) {
        SubscriptionType subscriptionType = findBySubscriptionTypeName(subscriptionTypeUpdate.nameSubscription());
        subscriptionType.setDescriptionType(subscriptionTypeUpdate.descriptionType());
        subscriptionType.setPrice(subscriptionTypeUpdate.price());
        subscriptionType.setNameSubscription(subscriptionType.getNameSubscription());
        subscriptionType.setQuantityProfiles(subscriptionTypeUpdate.quantityProfiles());
        return subscriptionTypeRepository.save(subscriptionType);
    }

    @Transactional(noRollbackFor = {ResponseStatusException.class})
    public void delete(Integer id) {
        subscriptionTypeRepository.deleteById(id);
    }
}
