package edu.icet.controller;

import edu.icet.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seats")
@RequiredArgsConstructor
public class SeatController {

    private final SeatService seatService;

    // Endpoint: POST http://localhost:8080/seats/1/hold?userId=U001
    @PostMapping("/{seatId}/hold")
    public ResponseEntity<String> holdSeat(
            @PathVariable Long seatId,
            @RequestParam String userId
    )
    {
        return ResponseEntity.ok(seatService.holdSeat(seatId, userId));
    }
}