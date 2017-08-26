package io.pivotal.spring.summit.cachedemo;

import io.pivotal.spring.summit.cachedemo.domain.UserProfile;
import io.pivotal.spring.summit.cachedemo.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class CacheDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CacheDemoApplication.class, args);
	}

	@Autowired
	UserProfileService userProfileService;

	@Component
	class InitialLoading implements CommandLineRunner {

		@Override
		public void run(String... strings) throws Exception {
			UserProfile userProfile1 = new UserProfile();
			userProfile1.setUserId(1);
			userProfile1.setLastName("Lee");
			userProfile1.setFirstName("Jay");
			userProfile1.setAddress("Singapore");
			userProfile1.setSSN("1234567");

			UserProfile userProfile2 = new UserProfile();
			userProfile2.setUserId(2);
			userProfile2.setLastName("Lee");
			userProfile2.setFirstName("Jay");
			userProfile2.setAddress("Singapore");
			userProfile2.setSSN("1234567");

			UserProfile userProfile3 = new UserProfile();
			userProfile3.setUserId(3);
			userProfile3.setLastName("Lee");
			userProfile3.setFirstName("Jay");
			userProfile3.setAddress("Singapore");
			userProfile3.setSSN("1234567");

			userProfileService.putUserProfile(userProfile1);
			userProfileService.putUserProfile(userProfile2);
			userProfileService.putUserProfile(userProfile3);
		}
	}
}
