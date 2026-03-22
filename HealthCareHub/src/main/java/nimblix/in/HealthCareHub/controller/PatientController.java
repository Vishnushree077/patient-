package nimblix.in.HealthCareHub.controller;

import lombok.RequiredArgsConstructor;
import nimblix.in.HealthCareHub.constants.HealthCareConstants;
import nimblix.in.HealthCareHub.request.AdmitPatientRequest;
import nimblix.in.HealthCareHub.response.AdmitPatientResponse;
import nimblix.in.HealthCareHub.response.LabResultResponse;
import nimblix.in.HealthCareHub.service.AdmissionService;
import nimblix.in.HealthCareHub.service.LabResultService;
import nimblix.in.HealthCareHub.utility.HealthCareUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/patient")
@RequiredArgsConstructor
public class PatientController {

    private final AdmissionService admissionService;
    private final LabResultService labResultService;


   /*
       Description of this API
    */
    @PostMapping("/admissions/admit")
    public ResponseEntity<Map<String, Object>> admitPatient(
            @RequestBody AdmitPatientRequest request) {

        AdmitPatientResponse data = admissionService.admitPatient(request);

        if (data == null) {
            Map<String, Object> error = new HashMap<>();
            error.put(HealthCareConstants.STATUS, HttpStatus.NOT_FOUND.value());
            error.put(HealthCareConstants.MESSAGE, "Patient or Doctor not found");

            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }

        Map<String, Object> response = new HashMap<>();
        response.put(HealthCareConstants.STATUS, HttpStatus.CREATED.value());
        response.put(HealthCareConstants.MESSAGE, HealthCareConstants.PATIENT_ADMITTED_SUCCESSFULLY);
        response.put(HealthCareConstants.DATA, data);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Task 186 – Lab Result Endpoint

    // GET api/patient/lab-results/patient/{patientId}
    @GetMapping("/lab-results/patient/{patientId}")
    public ResponseEntity<Map<String, Object>> getLabResultsByPatient(
            @PathVariable Long patientId) {

        List<LabResultResponse> data = labResultService.getLabResultsByPatient(patientId);

        if (data == null) {
            Map<String, Object> error = new HashMap<>();
            error.put(HealthCareConstants.STATUS, HttpStatus.NOT_FOUND.value());
            error.put(HealthCareConstants.MESSAGE, "Patient not found with id: " + patientId);

            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }

        Map<String, Object> response = new HashMap<>();
        response.put(HealthCareConstants.STATUS, HttpStatus.OK.value());
        response.put(HealthCareConstants.MESSAGE, HealthCareConstants.LAB_RESULT_FETCHED_SUCCESSFULLY);
        response.put(HealthCareConstants.COUNT, data.size());
        response.put(HealthCareConstants.DATA, data);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
