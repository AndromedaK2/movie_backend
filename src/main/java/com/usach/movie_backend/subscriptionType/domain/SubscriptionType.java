package com.usach.movie_backend.subscriptionType.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springdoc.core.converters.models.MonetaryAmount;

import java.math.BigDecimal;

@Entity
@Table(name ="subscription_types")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SubscriptionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subscription_type")
    private Integer idSubscriptionType;
    @Column(name = "description")
    private String descriptionType;
    @Column(name = "name")
    private String nameSubscription;
    @Column(name = "price")
    private Float price;
    @Column(name = "quantity_profiles")
    private Integer quantityProfiles;

}
