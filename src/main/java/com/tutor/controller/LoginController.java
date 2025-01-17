package com.tutor.controller;

import com.tutor.service.serviceImpl.EmailVerificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/tutor")
public class LoginController {
    @Autowired
    private EmailVerificationServiceImpl emailVerificationService;

    //http://localhost:8080/tutor/send-otp-for-login?email=twilio.send.sms3@gmail.com
    @PostMapping("/send-otp-for-login")
    public Map<String, String> sendOtpForLogin(@RequestParam String email) {
        return emailVerificationService.sendOtpForLogin(email);
    }

    //http://localhost:8080/api//verify-otp-for-login?email=twilio.send.sms3@gmail.com&otp=355639
    @PostMapping("/verify-otp-for-login")
    public Map<String, String> verifyOtpForLogin(@RequestParam String email, @RequestParam String otp) {
        return emailVerificationService.verifyOtpForLogin(email, otp);
    }
}
