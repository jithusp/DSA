package org.griddynamics.handler;

import org.griddynamics.dto.AuthRequest;
import org.griddynamics.handler.AuthHandler;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class TokenValidationHandler implements AuthHandler {
    @Override
    public void handle(AuthRequest request) {
        if (request.getToken() == null || !request.isValidToken()) {
            throw new RuntimeException("Invalid token");
        }
        System.out.println("✅ Token validated");
    }
}
