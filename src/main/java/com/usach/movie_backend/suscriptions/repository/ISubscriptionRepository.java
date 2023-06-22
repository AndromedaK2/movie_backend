package com.usach.movie_backend.suscriptions.repository;

import com.usach.movie_backend.suscriptions.domain.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISubscriptionRepository extends JpaRepository<Subscription, Integer> {

    List<Subscription> findAll();


}
