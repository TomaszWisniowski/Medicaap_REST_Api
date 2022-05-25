/**
 * @author Tomasz Wiśniowski
 * @version 1.0
 * @since 5/04/22

 */

package pl.medicaap.tomaszwisniowski.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "patients_cards")
public class PatientCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "interview", length = 1000)
    private String interview;

    @Column(name = "physical_examination", length = 1000)
    private String physical_examination;

    @Column(name = "diagnosis", length = 1000)
    private String diagnosis;

    @Column(name = "visit_history", length = 10000)
    private String visit_history;

    @OneToOne
    private Patient patient;

}
