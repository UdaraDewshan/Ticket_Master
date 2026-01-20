package edu.icet.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "events")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "base_price")
    private Double basePrice;

    @Column(name = "is_high_demand")
    private boolean isHighDemand;

    @Column(name = "event_date")
    private LocalDateTime eventDate;
}