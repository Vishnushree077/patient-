package nimblix.in.HealthCareHub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import nimblix.in.HealthCareHub.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/roles")
    public ResponseEntity<List<String>> getAllRoles() {

        return ResponseEntity.ok(doctorService.getAllRoles());
    }
}
