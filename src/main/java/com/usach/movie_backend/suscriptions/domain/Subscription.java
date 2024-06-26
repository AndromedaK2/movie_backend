package com.usach.movie_backend.suscriptions.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.usach.movie_backend.subscriptionType.domain.SubscriptionType;
import com.usach.movie_backend.users.domain.User;
import jakarta.persistence.*;
import lombok.*;

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

    @OneToOne(fetch = FetchType.LAZY ,mappedBy = "subscription")
    @JsonIgnore
    private transient User user;

}
