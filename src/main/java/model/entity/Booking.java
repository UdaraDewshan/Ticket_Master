package model.entity;

import jakarta.persistence.*;
import lombok.*;

enum BookingStatus {
    CONFIRMED, CANCELLED
}

@Entity
@Table(name = "bookings")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    @ManyToOne
    @JoinColumn(name = "seat_id", nullable = false)
    private Seat seat;

    @Column(name = "amount_paid")
    private Double amountPaid;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;
}