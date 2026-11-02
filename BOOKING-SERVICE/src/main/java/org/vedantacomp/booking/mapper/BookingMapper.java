package org.vedantacomp.booking.mapper;

import org.mapstruct.Mapper;
import org.vedantacomp.booking.dto.BookingDto;
import org.vedantacomp.booking.entity.Booking;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    BookingDto toDto(Booking booking);

    Booking toEntity(BookingDto bookingDto);
}
