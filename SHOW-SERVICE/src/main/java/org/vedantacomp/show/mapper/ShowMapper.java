package org.vedantacomp.show.mapper;

import org.mapstruct.Mapper;
import org.vedantacomp.common.dto.ShowDto;
import org.vedantacomp.show.entity.Show;

@Mapper(componentModel = "spring")
public interface ShowMapper {

    ShowDto toDto(Show show);

    Show toEntity(ShowDto showDto);
}
