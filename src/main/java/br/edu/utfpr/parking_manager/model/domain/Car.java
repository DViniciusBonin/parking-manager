package br.edu.utfpr.parking_manager.model.domain;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "cars")
@Data
@NoArgsConstructor
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String model;

    @NonNull
    private String code;

    @NonNull
    private String color;

    @NonNull
    private Boolean parked = true;

    @NonNull
    private ZonedDateTime created_at = ZonedDateTime.now();


    private ZonedDateTime updated_at;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    @NonNull
    private Brand brand;
}
