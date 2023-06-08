package com.usach.movie_backend.suscription.service;


import com.usach.movie_backend.subscriptionType.domain.SubscriptionType;
import com.usach.movie_backend.subscriptionType.domain.SubscriptionTypes;
import com.usach.movie_backend.subscriptionType.service.ISubscriptionTypeService;
import com.usach.movie_backend.suscription.domain.Subscription;
import com.usach.movie_backend.suscription.repository.ISubscriptionRepository;
import com.usach.movie_backend.user.domain.User;
import com.usach.movie_backend.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService implements ISubscriptionService{
    @Autowired
    private ISubscriptionRepository subscriptionRepository;

    @Autowired
    private IUserService userService;

    @Autowired
    private ISubscriptionTypeService subscriptionTypeService;


    public List<Subscription> findAll() {
        return subscriptionRepository.findAll();
    }


    public Optional<Subscription> findBySubscription(Integer idSubscription) {
        return subscriptionRepository.findById(idSubscription);
    }


    @Transactional
    public Subscription create(String userEmail , SubscriptionTypes subscriptionTypes) {

        // get subscriptionType
        Optional<SubscriptionType> subscriptionType = subscriptionTypeService.findBySubscriptionTypeName(subscriptionTypes);
        // get userEmail
        Optional<User> user = userService.findByEmail(userEmail);
        // create Subscription
        if(user.get().getSubscription() != null){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User already has a subscription");
        }

        Subscription subscription = new Subscription();
        subscription.setSubscriptionType(subscriptionType.get());
        subscription.setActive(true);
        subscription.setPaymentDate(new Date());
        subscription.setExpirationDate(new Date());
        Subscription newSubscription = subscriptionRepository.save(subscription);

        userService.updateUserSubscription(userEmail,subscription);

        return newSubscription;

    }


    public Subscription update(Subscription subscription) {
        return  subscriptionRepository.save(subscription);
    }


    public void delete(Integer idSubscription) {
    subscriptionRepository.deleteById(idSubscription);
    }
}
