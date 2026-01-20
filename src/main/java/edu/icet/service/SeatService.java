package edu.icet.service;

import edu.icet.exception.SeatLockedException;
import edu.icet.model.entity.Seat;
import edu.icet.model.entity.SeatStatus; // අලුතින් හදපු Enum එක import කරන්න
import edu.icet.model.entity.User;
import edu.icet.repository.SeatRepository;
import edu.icet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SeatService {

    private final SeatRepository seatRepository;
    private final UserRepository userRepository;

    @Transactional
    public String holdSeat(Long seatId, String userId) {

        Seat seat = seatRepository.findById(seatId)
                .orElseThrow(() -> new RuntimeException("Seat not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (seat.getStatus() == SeatStatus.SOLD) {
            throw new SeatLockedException("This seat is already SOLD.");
        }

        if (seat.getStatus() == SeatStatus.HELD) {

            // Check expiry
            if (seat.getHoldExpiry() != null && seat.getHoldExpiry().isAfter(LocalDateTime.now())) {
                throw new SeatLockedException("Seat is currently held by another user.");
            }
        }

        seat.setStatus(SeatStatus.HELD);
        seat.setHeldByUser(user);
        seat.setHoldExpiry(LocalDateTime.now().plusMinutes(10));

        seatRepository.save(seat);
        return "Seat held successfully!";
    }
}