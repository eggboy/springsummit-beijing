package io.pivotal.spring.summit.cachedemo.controller;


import io.pivotal.spring.summit.cachedemo.domain.UserProfile;
import io.pivotal.spring.summit.cachedemo.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class UserProfileController {

    @Autowired
    UserProfileService userProfileService;

    @GetMapping("/user/{id}")
    public ResponseEntity getUserProfile(@PathVariable Integer id) {
        return new ResponseEntity(userProfileService.getUserProfile(id), HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity putUserProfile(@RequestBody UserProfile userProfile) {
        userProfileService.putUserProfile(userProfile);

        return new ResponseEntity(userProfile, HttpStatus.OK);
    }

    @RequestMapping("/session")
    public String hello(HttpSession session) {

        String sessionId = (String) session.getAttribute("sessionId");
        if (sessionId == null) {
            sessionId = session.getId();
        }
        session.setAttribute("sessionId", sessionId);
        return sessionId;
    }
}
