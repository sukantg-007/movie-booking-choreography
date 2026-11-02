package org.vedantacomp.show.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.vedantacomp.show.entity.Show;
import org.vedantacomp.show.repository.ShowRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class ShowDataInitializer {

    private final ShowRepository showRepository;

    @Bean
    // Optional: add @Profile("!prod") to ensure dummy data is not loaded in production
    public CommandLineRunner initShowData() {
        return args -> {
            Long dummyShowId = 1001L;

            if (!showRepository.existsByShowId(dummyShowId)) {
                Show dummyShow = Show.builder()
                        .showId(dummyShowId)
                        .movieName("Inception")
                        .theaterName("PVR Cinemas - Screen 1")
                        .showTime(LocalDateTime.now().plusDays(1).withHour(18).withMinute(30))
                        .ticketPrice(new BigDecimal("250.00"))
                        .totalSeats(120)
                        .build();

                showRepository.save(dummyShow);
                log.info("Initialized default dummy show with showId: {}", dummyShow.getShowId());
            } else {
                log.info("Dummy show with showId: {} already exists. Skipping initialization.", dummyShowId);
            }
        };
    }
}
