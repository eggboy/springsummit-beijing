package io.pivotal.spring.summit.cachedemo.service;

import io.pivotal.spring.summit.cachedemo.domain.UserProfile;
import io.pivotal.spring.summit.cachedemo.repository.UserProfileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class UserProfileService {
    Logger logger = LoggerFactory.getLogger(UserProfileService.class.getName());

    UserProfileRepository userProfileRepository;

    @Autowired
    public UserProfileService(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Cacheable(cacheNames = "UserProfile")
    public UserProfile getUserProfile(Integer userId) {
        logger.info("getUserProfile invoked for Id : " + userId);
        return userProfileRepository.getOne(userId);
    }

    @CachePut(cacheNames = "UserProfileCapitalized")
    public UserProfile capitalizeLastName(Integer id)
    {
        logger.info("capitalizeLastName invoked for Id : " + id);
        UserProfile userProfile = userProfileRepository.getOne(id);
        userProfile.setLastName(userProfile.getLastName().toUpperCase());
        return userProfile;
    }

    public void putUserProfile(UserProfile userProfile) {
        logger.info("putUserProfile invoked for Id : " + userProfile.getUserId());
        userProfileRepository.save(userProfile);
    }

}
