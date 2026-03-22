package nimblix.in.HealthCareHub.controller;

import lombok.RequiredArgsConstructor;
import nimblix.in.HealthCareHub.model.Medicine;
import nimblix.in.HealthCareHub.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import nimblix.in.HealthCareHub.request.MedicineRequest;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

        private final AdminService adminService;

        @PostMapping("/addMedicine")
        public String addMedicine(@RequestBody MedicineRequest request) {
                return adminService.addMedicine(request);
        }

        @GetMapping("/getMedicineDetails/{medicineId}/{hospitalId}")
        public ResponseEntity<?> getMedicineDetails(@PathVariable Long medicineId,
                                                    @PathVariable Long hospitalId) {
                return adminService.getMedicineDetails(medicineId, hospitalId);
        }

        @PutMapping("/updateMedicineDetails")
        public String updateMedicineDetails(@RequestBody MedicineRequest request) {
                return adminService.updateMedicineDetails(request);
        }

        @DeleteMapping("/deleteMedicineDetails")
        public String deleteMedicineDetails(@RequestParam Long medicineId) {
                return adminService.deleteMedicineDetails(medicineId);
        }

        @PutMapping("/updateMedicineStock")
        public String updateMedicineStock(@RequestParam Long medicineId,
                                          @RequestParam Integer quantity) {
                return adminService.updateMedicineStock(medicineId, quantity);
        }
}