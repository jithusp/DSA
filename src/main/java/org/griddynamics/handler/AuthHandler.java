package org.griddynamics.handler;

import org.griddynamics.dto.AuthRequest;

public interface AuthHandler {
    void handle(AuthRequest request);
}
