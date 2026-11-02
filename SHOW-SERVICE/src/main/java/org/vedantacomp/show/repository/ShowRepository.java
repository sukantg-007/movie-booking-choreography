package org.vedantacomp.show.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vedantacomp.show.entity.Show;

public interface ShowRepository extends JpaRepository<Show, Long> {
	boolean existsByShowId(Long showId);
}
