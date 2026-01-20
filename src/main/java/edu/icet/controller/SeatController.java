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

    // POST /seats/{id}/hold?userId=U001
    @PostMapping("/{seatId}/hold")
    public ResponseEntity<String> holdSeat(@PathVariable Long seatId, @RequestParam String userId) {

        String result = seatService.holdSeat(seatId, userId);
        return ResponseEntity.ok(result);
    }
}