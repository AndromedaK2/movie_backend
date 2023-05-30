package com.usach.movie_backend.subscriptionType.repository;

import com.usach.movie_backend.subscriptionType.domain.SubscriptionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISubscriptionTypeRepository extends JpaRepository<SubscriptionType,Integer> {
List<SubscriptionType>findAll();
}
