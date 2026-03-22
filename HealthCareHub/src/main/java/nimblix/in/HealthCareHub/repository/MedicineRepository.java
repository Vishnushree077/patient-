package nimblix.in.HealthCareHub.repository;

import nimblix.in.HealthCareHub.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {

    Optional<Medicine> findByIdAndHospitalId(Long medicineId, Long hospitalId);
}
