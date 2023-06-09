package com.usach.movie_backend.suscription.service;

import com.usach.movie_backend.subscriptionType.domain.SubscriptionType;
import com.usach.movie_backend.suscription.domain.Subscription;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class SubscriptionMapper {

    public Subscription createSubscriptionMapping(SubscriptionType subscriptionType){
        Subscription subscription = new Subscription();
        subscription.setSubscriptionType(subscriptionType);
        subscription.setActive(true);
        subscription.setPaymentDate(new Date());
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.MONTH, 1);
        Date updatedDate = calendar.getTime();

        subscription.setExpirationDate(updatedDate);

        return subscription;
    }
}
