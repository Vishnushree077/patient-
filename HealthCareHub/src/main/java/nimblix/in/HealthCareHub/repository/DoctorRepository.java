package nimblix.in.HealthCareHub.repository;

import nimblix.in.HealthCareHub.model.Doctor;
import nimblix.in.HealthCareHub.response.DoctorProfileResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {

    Optional<Doctor> findByEmailId(String emailId);

    Optional<Doctor> findByIdAndHospitalId(Long doctorId, Long hospitalId);

    @Query("""
            SELECT new nimblix.in.HealthCareHub.response.DoctorProfileResponse(
                d.id,
                d.name,
                d.emailId,
                d.phone,
                d.qualification,
                d.experienceYears,
                s.id,
                s.name,
                h.id,
                h.name,
                h.address,
                h.city,
                h.state,
                h.phone,
                h.email,
                h.totalBeds
            )
            FROM Doctor d
            LEFT JOIN d.specialization s
            LEFT JOIN d.hospital h
            WHERE d.id = :doctorId
            """)
    Optional<DoctorProfileResponse> findDoctorProfileById(@Param("doctorId") Long doctorId);
}