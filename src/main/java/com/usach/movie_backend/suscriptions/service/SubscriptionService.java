package com.usach.movie_backend.suscriptions.service;

import com.usach.movie_backend.configuration.exceptions.BusinessException;
import com.usach.movie_backend.subscriptionType.domain.SubscriptionType;
import com.usach.movie_backend.subscriptionType.domain.SubscriptionTypes;
import com.usach.movie_backend.subscriptionType.service.ISubscriptionTypeService;
import com.usach.movie_backend.suscriptions.domain.Subscription;
import com.usach.movie_backend.suscriptions.repository.ISubscriptionRepository;
import com.usach.movie_backend.users.domain.User;
import com.usach.movie_backend.users.repository.IUserRepository;
import com.usach.movie_backend.users.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@Service
public class SubscriptionService implements ISubscriptionService{
    @Autowired
    private ISubscriptionRepository subscriptionRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IUserService userService;

    @Autowired
    private ISubscriptionTypeService subscriptionTypeService;

    @Autowired
    private SubscriptionMapper subscriptionMapper;

    @Transactional(readOnly = true)
    public List<Subscription> findAll() {
        return subscriptionRepository.findAll();
    }

    @Transactional
    public Subscription subscribe(String userEmail , SubscriptionTypes subscriptionTypes) {
        SubscriptionType subscriptionType = subscriptionTypeService.findBySubscriptionTypeName(subscriptionTypes);
        User user = userService.findByEmail(userEmail);
        if(user.getSubscription() != null){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User already has a subscription");
        }
        Subscription subscription = subscriptionMapper.createSubscriptionMapping(subscriptionType);
        Subscription newSubscription = subscriptionRepository.save(subscription);
        userService.updateUserSubscription(userEmail,subscription);
        return newSubscription;
    }

    @Transactional(noRollbackFor = {BusinessException.class, ResponseStatusException.class})
    public void unsubscribe(String userEmail) {
        User user = userService.findByEmail(userEmail);
        Subscription subscription = user.getSubscription();
        subscription.setActive(false);
        subscriptionRepository.save(subscription);
    }

    @Transactional (noRollbackFor = { BusinessException.class })
    public User paySubscription(String email, Float money) {

        if(money < 0 || money.toString().contains("-"))
            throw new BusinessException(HttpStatus.NOT_ACCEPTABLE.toString(), HttpStatus.NOT_ACCEPTABLE, "Money must be equal or greater than 0");
        User user = userService.findByEmail(email);
        Subscription subscription = user.getSubscription();

        if(subscription.isActive())
            throw new BusinessException(HttpStatus.NOT_ACCEPTABLE.toString(), HttpStatus.NOT_ACCEPTABLE, String.format("Subscription is still active. You must pay in %s", subscription.getExpirationDate()));
        SubscriptionType subscriptionType = subscription.getSubscriptionType();

        Float totalMoney = (user.getWallet() + money);
        Float remainingMoney = totalMoney - subscriptionType.getPrice();

        if( remainingMoney < 0 )
            throw new BusinessException(HttpStatus.NOT_ACCEPTABLE.toString(), HttpStatus.NOT_ACCEPTABLE, String.format("Money is not enough"));

        user.setWallet(remainingMoney);

        SubscriptionHelper.activeSubscription(subscription);

        user.setSubscription(subscription);

        User userUpdated = userRepository.save(user);

        return userUpdated;
    }
}



