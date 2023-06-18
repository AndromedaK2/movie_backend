package com.usach.movie_backend.suscription.service;


import com.usach.movie_backend.subscriptionType.domain.SubscriptionType;
import com.usach.movie_backend.subscriptionType.domain.SubscriptionTypes;
import com.usach.movie_backend.subscriptionType.service.ISubscriptionTypeService;
import com.usach.movie_backend.suscription.domain.Subscription;
import com.usach.movie_backend.suscription.repository.ISubscriptionRepository;
import com.usach.movie_backend.user.domain.User;
import com.usach.movie_backend.user.repository.IUserRepository;
import com.usach.movie_backend.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.util.Calendar;
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
    private IUserRepository userRepository;

    @Autowired
    private ISubscriptionTypeService subscriptionTypeService;

    @Autowired
    private SubscriptionMapper subscriptionMapper;


    @Transactional(readOnly = true)
    public List<Subscription> findAll() {
        return subscriptionRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Subscription> findBySubscription(Integer idSubscription) {
        return subscriptionRepository.findById(idSubscription);
    }

    @Transactional
    public Subscription create(String userEmail , SubscriptionTypes subscriptionTypes) {
        Optional<SubscriptionType> subscriptionType = subscriptionTypeService.findBySubscriptionTypeName(subscriptionTypes);
        Optional<User> user = userService.findByEmail(userEmail);
        if(user.get().getSubscription() != null){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User already has a subscription");
        }
        Subscription subscription = subscriptionMapper.createSubscriptionMapping(subscriptionType.get());
        Subscription newSubscription = subscriptionRepository.save(subscription);
        userService.updateUserSubscription(userEmail,subscription);
        return newSubscription;
    }


    @Transactional
    public Subscription update(Subscription subscription) {
        return  subscriptionRepository.save(subscription);
    }

    @Transactional
    public void delete(Integer idSubscription) {
    subscriptionRepository.deleteById(idSubscription);
    }

    @Transactional(noRollbackFor = { SQLException.class })
    public User paySubscription(String email, Float money) {

        try {
            if(money < 0 || money.toString().contains("-")){
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Money must be equal or greater than 0");
            }
            User user = userService.findByEmail(email).get();
            Subscription subscription = user.getSubscription();

            if(subscription.isActive()){
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                        String.format("Subscription is still active. You must pay in %s", subscription.getExpirationDate()));
            }
            SubscriptionType subscriptionType = subscription.getSubscriptionType();

            Float totalMoney = (user.getWallet() + money);
            Float remainingMoney = totalMoney - subscriptionType.getPrice();

            if( remainingMoney < 0 ){
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, String.format("Money is not enough "));
            }

            user.setWallet(remainingMoney);


            subscription.setActive(true);
            subscription.setPaymentDate(new Date());
            Date currentDate = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(currentDate);
            calendar.add(Calendar.MONTH, 1);
            Date updatedDate = calendar.getTime();
            subscription.setExpirationDate(updatedDate);

            user.setSubscription(subscription);

            User userUpdated = userRepository.save(user);

            return userUpdated;
        }
        catch (ResponseStatusException e){
            throw new ResponseStatusException(e.getStatusCode(), e.getMessage());
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }


    }
}
