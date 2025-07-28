package org.griddynamics.service;

import org.griddynamics.dto.AuthRequest;
import org.griddynamics.handler.AuthHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthProcessor {

    private final List<AuthHandler> handlers;

    public AuthProcessor(List<AuthHandler> handlers) {
        this.handlers = handlers;
    }

    public void process(AuthRequest request) {
        for (AuthHandler handler : handlers) {
            handler.handle(request);
        }
        System.out.println("✅ All auth checks passed. Request allowed.");
    }
}
