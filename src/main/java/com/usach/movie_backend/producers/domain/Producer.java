package com.usach.movie_backend.producers.domain;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

@Entity
@Table(name ="producers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


public class Producer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producer")
    private Integer idProducer;
    @Column(name = "name")
    private String nameProducer;
}
