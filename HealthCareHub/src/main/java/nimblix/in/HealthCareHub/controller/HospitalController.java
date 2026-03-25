package nimblix.in.HealthCareHub.controller;

import lombok.RequiredArgsConstructor;
import nimblix.in.HealthCareHub.constants.HealthCareConstants;
import nimblix.in.HealthCareHub.model.Hospital;
import nimblix.in.HealthCareHub.request.HospitalRegistrationRequest;
import nimblix.in.HealthCareHub.request.MedicineAddRequest;
import nimblix.in.HealthCareHub.response.ApiResponse;
import nimblix.in.HealthCareHub.response.RoomResponse;
import nimblix.in.HealthCareHub.service.HospitalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/hospital")
@RequiredArgsConstructor
public class HospitalController {

    private final HospitalService hospitalService;

    @PostMapping("/register")
    public String registerHospital(
            @RequestBody HospitalRegistrationRequest request) {

        return hospitalService.registerHospital(request);
    }

    @PostMapping("/medicine/add")
    public String addMedicine(@RequestBody MedicineAddRequest request){

        if (request == null) {
            throw new IllegalArgumentException("Request body cannot be null");
        }
        if (request.getHospitalId() == null) {
            throw new IllegalArgumentException("Hospital Id is required");
        }
        if (request.getMedicineName()==null || request.getMedicineName().trim().isEmpty()){
            throw new IllegalArgumentException("medicine name is required");
        }
        return hospitalService.addMedicine(request);
    }

    @PostMapping("/{hospitalId}/rooms")
    public String addRooms(
            @PathVariable Long hospitalId,
            @RequestBody List<HospitalRegistrationRequest.Room> rooms) {

        hospitalService.addRooms(hospitalId, rooms);
        return "Rooms added successfully";
    }

    @GetMapping("/{hospitalId}/available-rooms")
    public List<RoomResponse> getAvailableRooms(
            @PathVariable Long hospitalId) {

        return hospitalService.getAvailableRooms(hospitalId);
    }

    @GetMapping("/searchByName")
    public ResponseEntity<ApiResponse<Map<String,Object>>> searchHospitalByName(
            @RequestParam String hospitalName) {

        Map<String,Object> data = hospitalService.searchHospitalByName(hospitalName);

        ApiResponse<Map<String,Object>> response =
                new ApiResponse<>(
                        HealthCareConstants.STATUS_SUCCESS,
                        "Hospitals fetched successfully",
                        data
                );

        return ResponseEntity.ok(response);
    }


    @GetMapping("/sort")
    public ResponseEntity<Map<String, Object>> sortHospitals(@RequestParam String sortBy) {

        List<Hospital> data = hospitalService.sortHospitals(sortBy);

        if (data == null || data.isEmpty()) {
            Map<String, Object> error = new HashMap<>();
            error.put(HealthCareConstants.STATUS, HttpStatus.NOT_FOUND.value());
            error.put(HealthCareConstants.MESSAGE, "No hospitals found");

            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }

        Map<String, Object> response = new HashMap<>();
        response.put(HealthCareConstants.STATUS, HttpStatus.OK.value());
        response.put(HealthCareConstants.MESSAGE, "Hospitals sorted successfully");
        response.put(HealthCareConstants.COUNT, data.size());
        response.put(HealthCareConstants.DATA, data);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}