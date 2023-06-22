package com.usach.movie_backend.subscriptionType.service.dto;

import com.usach.movie_backend.subscriptionType.domain.SubscriptionTypes;

public record SubscriptionTypeUpdate(String descriptionType, SubscriptionTypes nameSubscription,
                                     Float price, Integer quantityProfiles) {
}
