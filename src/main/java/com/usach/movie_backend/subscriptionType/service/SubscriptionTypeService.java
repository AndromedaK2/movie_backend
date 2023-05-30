package com.usach.movie_backend.subscriptionType.service;

import com.usach.movie_backend.subscriptionType.domain.SubscriptionType;
import com.usach.movie_backend.subscriptionType.repository.ISubscriptionTypeRepository;
import com.usach.movie_backend.suscription.repository.ISubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SubscriptionTypeService implements ISubscriptionTypeService<SubscriptionType>{
    @Autowired
    private ISubscriptionTypeRepository iSubscriptionTypeRepository;

    @Override
    public List<SubscriptionType> findAll() {
        return iSubscriptionTypeRepository.findAll();
    }

    @Override
    public Optional<SubscriptionType> findBySubscriptionType(Integer SubscriptionType) {
        return iSubscriptionTypeRepository.findById(SubscriptionType);
    }

    @Override
    public SubscriptionType create(SubscriptionType subscriptionType) {
        return iSubscriptionTypeRepository.save(subscriptionType);
    }

    @Override
    public SubscriptionType update(SubscriptionType subscriptionType) {
        return iSubscriptionTypeRepository.save(subscriptionType);
    }

    @Override
    public void delete(Integer id) {
     iSubscriptionTypeRepository.deleteById(id);
    }
}
