package nimblix.in.HealthCareHub.serviceImpl;

import lombok.RequiredArgsConstructor;
import nimblix.in.HealthCareHub.constants.HealthCareConstants;
import nimblix.in.HealthCareHub.model.Hospital;
import nimblix.in.HealthCareHub.model.Medicine;
import nimblix.in.HealthCareHub.repository.HospitalRepository;
import nimblix.in.HealthCareHub.repository.MedicineRepository;
import nimblix.in.HealthCareHub.request.MedicineRequest;
import nimblix.in.HealthCareHub.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final MedicineRepository medicineRepository;
    private final HospitalRepository hospitalRepository;

    @Override
    public String addMedicine(MedicineRequest request) {

        if (request.getMedicineName() == null || request.getMedicineName().isBlank()) {
            return "Medicine name is required";
        }

        if (request.getHospitalId() == null) {
            return "Hospital ID is required";
        }

        if (request.getPrice() != null && request.getPrice() < 0) {
            return "Price cannot be negative";
        }

        if (request.getStockQuantity() != null && request.getStockQuantity() < 0) {
            return "Stock quantity cannot be negative";
        }

        Hospital hospital = hospitalRepository.findById(request.getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital not found"));

        Medicine medicine = new Medicine();
        medicine.setMedicineName(request.getMedicineName());
        medicine.setManufacturer(request.getManufacturer());
        medicine.setDescription(request.getDescription());
        medicine.setDosage(request.getDosage());
        medicine.setPrice(request.getPrice());
        medicine.setStockQuantity(request.getStockQuantity());
        medicine.setHospital(hospital);
        medicine.setIsActive(HealthCareConstants.ACTIVE);

        medicineRepository.save(medicine);

        return "Medicine Added Successfully";
    }

    @Override
    public ResponseEntity<?> getMedicineDetails(Long medicineId, Long hospitalId) {

        Medicine medicine = medicineRepository
                .findByIdAndHospitalId(medicineId, hospitalId)
                .orElseThrow(() ->
                        new RuntimeException("Medicine not found in this hospital"));

        return ResponseEntity.status(HttpStatus.OK).body(medicine);
    }

    @Override
    public String updateMedicineDetails(MedicineRequest request) {

        Medicine medicine = medicineRepository.findById(request.getMedicineId())
                .orElseThrow(() -> new RuntimeException("Medicine not found"));

        if (request.getPrice() != null && request.getPrice() < 0) {
            return "Price cannot be negative";
        }

        if (request.getStockQuantity() != null && request.getStockQuantity() < 0) {
            return "Stock quantity cannot be negative";
        }

        Hospital hospital = hospitalRepository.findById(request.getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital not found"));

        medicine.setMedicineName(request.getMedicineName());
        medicine.setManufacturer(request.getManufacturer());
        medicine.setDescription(request.getDescription());
        medicine.setDosage(request.getDosage());
        medicine.setPrice(request.getPrice());
        medicine.setStockQuantity(request.getStockQuantity());
        medicine.setHospital(hospital);

        medicineRepository.save(medicine);

        return "Medicine Updated Successfully";
    }

    @Override
    public String deleteMedicineDetails(Long medicineId) {

        Medicine medicine = medicineRepository.findById(medicineId)
                .orElseThrow(() ->
                        new RuntimeException("Medicine not found with id: " + medicineId));

        medicine.setIsActive(HealthCareConstants.IN_ACTIVE);
        medicineRepository.save(medicine);

        return "Medicine deleted successfully";
    }

    @Override
    public String updateMedicineStock(Long medicineId, Integer quantity) {

        if (quantity == null) {
            return "Quantity cannot be null";
        }

        if (quantity < 0) {
            return "Quantity cannot be negative";
        }

        Medicine medicine = medicineRepository.findById(medicineId)
                .orElseThrow(() ->
                        new RuntimeException("Medicine not found with id: " + medicineId));

        medicine.setStockQuantity(quantity);
        medicineRepository.save(medicine);

        return "Medicine Stock Updated Successfully";
    }
}