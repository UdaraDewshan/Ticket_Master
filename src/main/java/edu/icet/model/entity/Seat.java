package edu.icet.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

enum SeatStatus {
    AVAILABLE, HELD, SOLD
}

@Entity
@Table(name = "seats")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "seat_number")
    private String seatNumber;

    @Enumerated(EnumType.STRING)
    private SeatStatus status;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @ManyToOne
    @JoinColumn(name = "held_by_user_id")
    private User heldByUser;

    @Column(name = "hold_expiry")
    private LocalDateTime holdExpiry;

    @Version
    private Integer version;
}