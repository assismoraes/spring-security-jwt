package com.assismoraes.springsecurityjwt.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    @GetMapping
    public ResponseEntity<Object> publicHome() {
        return ResponseEntity.ok().body("public home");
    }

    @GetMapping("admin")
    public ResponseEntity<Object> onlyAdminRole() {
        return ResponseEntity.ok().body("admin home");
    }

    @GetMapping("manager")
    public ResponseEntity<Object> onlyManagerRole() {
        return ResponseEntity.ok().body("manager home");
    }

    @GetMapping("super-admin")
    public ResponseEntity<Object> onlySuperAdminRole() {
        return ResponseEntity.ok().body("super admin home");
    }
}
