package com.usach.movie_backend.suscription.service;


import com.usach.movie_backend.subscriptionType.domain.SubscriptionTypes;
import com.usach.movie_backend.subscriptionType.service.ISubscriptionTypeService;
import com.usach.movie_backend.suscription.domain.Subscription;
import com.usach.movie_backend.suscription.repository.ISubscriptionRepository;
import com.usach.movie_backend.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService implements ISubscriptionService<Subscription>{
    @Autowired
    private ISubscriptionRepository subscriptionRepository;

    @Autowired
    private IUserService userService;

    @Autowired
    private ISubscriptionTypeService subscriptionTypeService;

    @Override
    public List<Subscription> findAll() {
        return subscriptionRepository.findAll();
    }

    @Override
    public Optional<Subscription> findBySubscription(Integer idSubscription) {
        return subscriptionRepository.findById(idSubscription);
    }

    @Override
    public Subscription create(String userEmail , SubscriptionTypes subscriptionTypes) {
        // get subscriptionType
        // get userEmail

        // create Subscription
        // update User
        return new Subscription();
       // return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription update(Subscription subscription) {
        return  subscriptionRepository.save(subscription);
    }

    @Override
    public void delete(Integer idSubscription) {
    subscriptionRepository.deleteById(idSubscription);
    }
}
