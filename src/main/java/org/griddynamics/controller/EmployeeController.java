package org.griddynamics.controller;

import org.griddynamics.dto.AuthRequest;
import org.griddynamics.service.AuthProcessor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final AuthProcessor authProcessor;

    public EmployeeController(AuthProcessor authProcessor) {
        this.authProcessor = authProcessor;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createEmployee(@RequestBody AuthRequest request) {
        authProcessor.process(request);
        return ResponseEntity.ok("Employee created");
    }
}
