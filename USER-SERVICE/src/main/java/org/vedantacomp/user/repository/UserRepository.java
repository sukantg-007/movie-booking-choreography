package org.vedantacomp.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vedantacomp.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	boolean existsByEmail(String email);
}

