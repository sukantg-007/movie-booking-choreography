package org.vedantacomp.user.mapper;

import org.mapstruct.Mapper;
import org.vedantacomp.common.dto.UserDto;
import org.vedantacomp.user.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto userDto);
}
