package org.vedantacomp.user.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.vedantacomp.user.entity.User;
import org.vedantacomp.user.repository.UserRepository;

import java.util.List;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class UserDataInitializer {

    private final UserRepository userRepository;

    @Bean
    public CommandLineRunner initUserData() {
        return args -> {
            String defaultEmail = "john.doe@example.com";

            if (!userRepository.existsByEmail(defaultEmail)) {
                User dummyUser = User.builder()
                        .name("John Doe")
                        .email(defaultEmail)
                        .phone("+1-555-0199")
                        .status("ACTIVE")
                        .build();

                userRepository.save(dummyUser);
                log.info("Initialized default dummy user: {} ({})", dummyUser.getName(), dummyUser.getEmail());
            } else {
                log.info("Dummy user with email '{}' already exists. Skipping initialization.", defaultEmail);
            }
        };
    }
}