package org.griddynamics.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {
    private String token;
    private String companyId;
    private String userId;
    private String role;
    private String action;

    private boolean validToken;
    private boolean accountActive;
    private boolean hasRequiredRole;
    private boolean hasPermission;


}
