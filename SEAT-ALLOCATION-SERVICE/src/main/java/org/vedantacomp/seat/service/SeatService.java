package org.vedantacomp.seat.service;

import java.util.List;

import org.vedantacomp.common.dto.SeatDto;

public interface SeatService {

    void createSeat(SeatDto seatDto);
    
    void updateSeat(SeatDto seatDto);

    SeatDto getSeatById(Long id);
    
    List<SeatDto> getAllSeats();
}
