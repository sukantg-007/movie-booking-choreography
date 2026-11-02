package org.vedantacomp.user.service;

import org.vedantacomp.common.dto.UserDto;

public interface UserService {

//    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long id);
}
