package org.vedantacomp.user.service;

import org.springframework.stereotype.Service;
import org.vedantacomp.common.dto.UserDto;
import org.vedantacomp.user.mapper.UserMapper;
import org.vedantacomp.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	private final UserMapper userMapper;

	@Override
	public UserDto getUserById(Long id) {
		return userMapper.toDto(userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found for id: " + id)));
	}

}
