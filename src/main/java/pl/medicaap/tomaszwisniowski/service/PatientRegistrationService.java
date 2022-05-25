/**
 * @author Tomasz Wiśniowski
 * @version 1.0
 * @since 5/04/22

 */

package pl.medicaap.tomaszwisniowski.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.medicaap.tomaszwisniowski.model.Patient;
import pl.medicaap.tomaszwisniowski.model.PatientRegistration;
import pl.medicaap.tomaszwisniowski.repository.PatientCardRepository;
import pl.medicaap.tomaszwisniowski.repository.PatientRegistrationRepository;
import pl.medicaap.tomaszwisniowski.repository.PatientRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientRegistrationService {

    @Autowired
    private PatientRegistrationRepository patientRegistrationRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientCardRepository patientCardRepository;

    public PatientRegistration addPatientRegistration(LocalDate date_of_visit, LocalDate date_of_registration, int patient_id) {

        Patient patient = patientRepository.getById(patient_id);

        PatientRegistration patientRegistration = PatientRegistration.builder()
                .date_of_visit(date_of_visit)
                .date_of_registration(date_of_registration)
                .build();

        patient.setPatientRegistration(patientRegistration);

        return patientRegistrationRepository.save(patientRegistration);
    }

    public List<PatientRegistration> getPatientRegistrations(String sortBy) {
        List<PatientRegistration> registrationsList = new ArrayList<>();

        return patientRegistrationRepository.findAll();
    }

    public Optional<PatientRegistration> getPatientRegistration(int id) {
        return patientRegistrationRepository.findById(id);
    }



    public Optional<PatientRegistration> updatePatientRegistration(int id, LocalDate date_of_visit, LocalDate date_of_registration) {
        PatientRegistration patientRegistration = PatientRegistration.builder()
                .id(id)
                .date_of_visit(date_of_visit)
                .date_of_registration(date_of_registration)
                .build();
        return patientRegistrationRepository
                .findById(id)
                .map(savedCustomer -> patientRegistrationRepository.save(patientRegistration));
    }

    public void deletePatientRegistration(int id) {
        patientRegistrationRepository.deleteById(id);
    }
}
