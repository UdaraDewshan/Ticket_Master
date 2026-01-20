package edu.icet.repository;

import edu.icet.model.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat,Long> {
}
