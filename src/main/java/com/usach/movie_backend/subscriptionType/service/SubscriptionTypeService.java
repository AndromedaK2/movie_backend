package com.usach.movie_backend.subscriptionType.service;

import com.usach.movie_backend.subscriptionType.domain.SubscriptionType;
import com.usach.movie_backend.subscriptionType.domain.SubscriptionTypes;
import com.usach.movie_backend.subscriptionType.repository.ISubscriptionTypeRepository;
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

    public Optional<SubscriptionType> findByIdSubscriptionType(Integer SubscriptionType) {
        return subscriptionTypeRepository.findById(SubscriptionType);
    }

    @Transactional(readOnly = true)
    public Optional<SubscriptionType> findBySubscriptionTypeName(SubscriptionTypes subscriptionTypeName){
        Optional<SubscriptionType> subscriptionType = subscriptionTypeRepository.findByNameSubscription(subscriptionTypeName.toString());
        if(subscriptionType.isEmpty()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Subscription Type does not exist");
        }
        return subscriptionType;
    }
    @Transactional
    @Override
    public SubscriptionType create(SubscriptionType subscriptionType) {
        return subscriptionTypeRepository.save(subscriptionType);
    }

    @Transactional
    @Override
    public SubscriptionType update(SubscriptionType subscriptionType) {
        return subscriptionTypeRepository.save(subscriptionType);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        subscriptionTypeRepository.deleteById(id);
    }
}
