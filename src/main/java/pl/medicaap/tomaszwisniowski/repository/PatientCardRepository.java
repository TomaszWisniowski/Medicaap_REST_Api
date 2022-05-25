/**
 * @author Tomasz Wiśniowski
 * @version 1.0
 * @since 5/04/22

 */

package pl.medicaap.tomaszwisniowski.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.medicaap.tomaszwisniowski.model.PatientCard;

import java.util.List;

@Repository
public interface PatientCardRepository extends JpaRepository<PatientCard, Integer> {

    @Query("FROM PatientCard ORDER BY id")
    List<PatientCard> findAllOrderById();

}