/**
 * @author Tomasz Wiśniowski
 * @version 1.0
 * @since 5/04/22

 */

package pl.medicaap.tomaszwisniowski.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.medicaap.tomaszwisniowski.model.PatientRegistration;
import java.util.List;

@Repository
public interface PatientRegistrationRepository extends JpaRepository<PatientRegistration, Integer> {

    @Query("FROM PatientRegistration ORDER BY id")
    List<PatientRegistration> findAllOrderById();

}