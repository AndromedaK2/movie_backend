package com.usach.movie_backend.subscriptionType.service.dto;

import jakarta.persistence.Column;

public record SubscriptionTypeCreate(String descriptionType,String nameSubscription,
                                     Float price,Integer quantityProfiles) {
}

