package org.griddynamics.handler;

import org.griddynamics.dto.AuthRequest;
import org.griddynamics.handler.AuthHandler;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(5)
public class AuditLogHandler implements AuthHandler {
    @Override
    public void handle(AuthRequest request) {
        System.out.println("📝 Audit Log → User: " + request.getUserId() + ", Action: " + request.getAction());
    }
}
