package io.pivotal.spring.summit.cachedemo.repository;

import io.pivotal.spring.summit.cachedemo.domain.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {
}
