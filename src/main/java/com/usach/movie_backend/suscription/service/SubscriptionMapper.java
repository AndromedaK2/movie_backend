package com.usach.movie_backend.suscription.service;

import com.usach.movie_backend.subscriptionType.domain.SubscriptionType;
import com.usach.movie_backend.suscription.domain.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class SubscriptionMapper {

    @Autowired SubscriptionHelper subscriptionHelper;
    public Subscription createSubscriptionMapping(SubscriptionType subscriptionType){
        Subscription subscription = new Subscription();
        subscription.setSubscriptionType(subscriptionType);
        SubscriptionHelper.activeSubscription(subscription);

        return subscription;
    }
}
