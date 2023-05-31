package com.usach.movie_backend.suscription.domain;

import com.usach.movie_backend.subscriptionType.domain.SubscriptionType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "subscriptions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subscription")
    private Integer idSubscription;


    @Column(name = "payment_date")
    private Date paymentDate;

    @Column(name = "active")
    private boolean active;

    @Column(name = "expiration_date")
    private Date expirationDate;

    @OneToOne
    @JoinColumn(name = "id_subscription_type", referencedColumnName = "id_subscription_type")
    private SubscriptionType subscriptionType;

}
