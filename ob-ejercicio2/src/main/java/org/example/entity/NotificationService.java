package org.example.entity;

import org.springframework.stereotype.Component;

@Component
public class NotificationService {

    private final String message = "Notification: Greetings from Spring Framework.";

    public String greeting() {
        return message;
    }
}
