package org.griddynamics.handler;

import org.griddynamics.dto.AuthRequest;
import org.griddynamics.handler.AuthHandler;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class RoleCheckHandler implements AuthHandler {
    @Override
    public void handle(AuthRequest request) {
        if (!request.isHasRequiredRole()) {
            throw new RuntimeException("Access denied: insufficient role");
        }
        System.out.println("Role check passed");
    }
}
