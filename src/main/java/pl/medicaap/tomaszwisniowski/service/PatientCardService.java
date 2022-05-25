/**
 * @author Tomasz Wiśniowski
 * @version 1.0
 * @since 5/04/22

 */

package pl.medicaap.tomaszwisniowski.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.medicaap.tomaszwisniowski.model.Patient;
import pl.medicaap.tomaszwisniowski.model.PatientCard;
import pl.medicaap.tomaszwisniowski.repository.PatientCardRepository;
import pl.medicaap.tomaszwisniowski.repository.PatientRepository;
import java.util.List;
import java.util.Optional;

@Service
public class PatientCardService {

    @Autowired
    private PatientCardRepository patientCardRepository;
    @Autowired
    private PatientRepository patientRepository;

    public PatientCard addPatientCard(String interview, String physical_examination, String diagnosis, String visit_history, int patient_id) {
        {
            Patient patient = patientRepository.getById(patient_id);

            PatientCard patientCard = PatientCard.builder()
                    .interview(interview)
                    .physical_examination(physical_examination)
                    .diagnosis(diagnosis)
                    .visit_history(visit_history)
                    .patient(patient)
                    .build();
            patient.setPatientCard(patientCard);

            return patientCardRepository.save(patientCard);
        }
    }

    public List<PatientCard> getPatientCard(String sortBy) {

            return patientCardRepository.findAllOrderById();
    }

    public Optional<PatientCard> getPatientCard(int id) {
        return patientCardRepository.findById(id);
    }

    public Optional<PatientCard> updatePatientCard(int id, String interview, String physical_examination, String diagnosis, String visit_history) {
        PatientCard patientCard = PatientCard.builder()
                .interview(interview)
                .physical_examination(physical_examination)
                .diagnosis(diagnosis)
                .visit_history(visit_history)
                .build();
        return patientCardRepository
                .findById(id)
                .map(savedCustomer -> patientCardRepository.save(patientCard));
    }

    public void deletePatientCard(int id) {
        patientCardRepository.deleteById(id);
    }
}
