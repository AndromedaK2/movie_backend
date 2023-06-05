package com.usach.movie_backend.subscriptionType.service;

import com.usach.movie_backend.subscriptionType.domain.SubscriptionType;
import com.usach.movie_backend.subscriptionType.domain.SubscriptionTypes;
import com.usach.movie_backend.subscriptionType.repository.ISubscriptionTypeRepository;
import com.usach.movie_backend.suscription.repository.ISubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    public Optional<SubscriptionType> findByIdSubscriptionType(Integer SubscriptionType) {
        return subscriptionTypeRepository.findById(SubscriptionType);
    }


    public Optional<SubscriptionType> findBySubscriptionTypeName(SubscriptionTypes subscriptionTypeName){
        return subscriptionTypeRepository.findByNameSubscription(subscriptionTypeName.toString());
    }

    @Override
    public SubscriptionType create(SubscriptionType subscriptionType) {
        return subscriptionTypeRepository.save(subscriptionType);
    }

    @Override
    public SubscriptionType update(SubscriptionType subscriptionType) {
        return subscriptionTypeRepository.save(subscriptionType);
    }

    @Override
    public void delete(Integer id) {
        subscriptionTypeRepository.deleteById(id);
    }
}
