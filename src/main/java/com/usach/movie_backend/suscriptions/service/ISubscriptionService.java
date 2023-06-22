package com.usach.movie_backend.suscriptions.service;

import com.usach.movie_backend.subscriptionType.domain.SubscriptionTypes;
import com.usach.movie_backend.suscriptions.domain.Subscription;
import com.usach.movie_backend.users.domain.User;

import java.util.List;

public interface ISubscriptionService{

    List<Subscription> findAll();

    Subscription subscribe(String userEmail, SubscriptionTypes subscriptionTypes);

    void unsubscribe(String userEmail);

    User paySubscription(String email, Float money);
}
