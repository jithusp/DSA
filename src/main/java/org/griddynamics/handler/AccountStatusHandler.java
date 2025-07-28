package org.griddynamics.handler;

import org.griddynamics.dto.AuthRequest;
import org.griddynamics.handler.AuthHandler;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class AccountStatusHandler implements AuthHandler {
    @Override
    public void handle(AuthRequest request) {
        if (!request.isAccountActive()) {
            throw new RuntimeException("Account is inactive or subscription expired");
        }
        System.out.println("✅ Account status verified");
    }
}
