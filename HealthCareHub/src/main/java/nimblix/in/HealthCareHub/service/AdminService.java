package nimblix.in.HealthCareHub.service;

import nimblix.in.HealthCareHub.request.MedicineRequest;
import org.springframework.http.ResponseEntity;

public interface AdminService {

    String addMedicine(MedicineRequest request);

    ResponseEntity<?> getMedicineDetails(Long medicineId, Long hospitalId);

    String updateMedicineDetails(MedicineRequest request);

    String deleteMedicineDetails(Long medicineId);

    String updateMedicineStock(Long medicineId, Integer quantity);
}