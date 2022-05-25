/**
 * @author Tomasz Wiśniowski
 * @version 1.0
 * @since 5/04/22

 */

package pl.medicaap.tomaszwisniowski.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.medicaap.tomaszwisniowski.model.Nurse;
import pl.medicaap.tomaszwisniowski.repository.NurseRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class NurseService {

    @Autowired
    private NurseRepository NurseRepository;

    public Nurse addNurse(int medical_license_number, String first_name, String last_name, LocalDate date_of_birth, int tel, String city, String street, int house_number, int flat_number) {
        Nurse nurse = Nurse.builder()
                .medical_license_number(medical_license_number)
                .first_name(first_name)
                .last_name(last_name)
                .date_of_birth(date_of_birth)
                .tel(tel)
                .city(city)
                .street(street)
                .house_number(house_number)
                .flat_number(flat_number)
                .build();
        return NurseRepository.save(nurse);
    }

    public List<Nurse> getNurse(String sortBy) {
        if ("id".equals(sortBy)) {
            return NurseRepository.findAllOrderById();
        } else if ("first_name".equals(sortBy)) {
            return NurseRepository.findAllOrderByFirstName();
        } else if ("last_name".equals(sortBy)) {
            return NurseRepository.findAllOrderByLastName();
        } else {
            return NurseRepository.findAll();
        }
    }

    public Optional<Nurse> getNurse(int id) {
        return NurseRepository.findById(id);
    }

    public Optional<Nurse> updateNurse(int id, int medical_license_number, String first_name, String last_name, LocalDate date_of_birth, int tel, String city, String street, int house_number, int flat_number) {
        Nurse nurse = Nurse.builder()
                .id(id)
                .medical_license_number(medical_license_number)
                .first_name(first_name)
                .last_name(last_name)
                .date_of_birth(date_of_birth)
                .tel(tel)
                .city(city)
                .street(street)
                .house_number(house_number)
                .flat_number(flat_number)
                .build();
        return NurseRepository
                .findById(id)
                .map(savedCustomer -> NurseRepository.save(nurse));
    }

    public void deleteNurse(int id) {
        NurseRepository.deleteById(id);
    }
}
