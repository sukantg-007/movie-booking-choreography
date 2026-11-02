package org.vedantacomp.booking.service;

import org.vedantacomp.booking.dto.BookingDto;
import org.vedantacomp.common.dto.BookingResponseDTO;
import org.vedantacomp.common.dto.SagaCompensationCommand;
import org.vedantacomp.common.dto.SagaFinalCommand;

public interface BookingService {

    BookingDto createBooking(BookingDto bookingDto);

    BookingResponseDTO getBookingById(Long id);
    
    void updateBookingStatus(SagaCompensationCommand command);
}
