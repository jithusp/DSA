package org.griddynamics.handler;

import org.griddynamics.dto.AuthRequest;
import org.griddynamics.handler.AuthHandler;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(4)
public class PermissionCheckHandler implements AuthHandler {
    @Override
    public void handle(AuthRequest request) {
        if (!request.isHasPermission()) {
            throw new RuntimeException("Permission denied for action: " + request.getAction());
        }
        System.out.println("✅ Permission granted");
    }
}
