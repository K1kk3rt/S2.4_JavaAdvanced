package nl.k1kk3rt.controller;

import nl.k1kk3rt.service.SecurityService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    private SecurityService service;

    public SecurityController(SecurityService service) {
        this.service = service;
    }
}
