/**
 * @author Tomasz Wiśniowski
 * @version 1.0
 * @since 5/04/22

 */

package pl.medicaap.tomaszwisniowski.DTO_model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class DTO_PatientCard {


    private int id;

    @NotEmpty(message = "patient_id field must be not empty")
    private int patient_id;

    @NotEmpty(message = "Interview field must be not empty")
    private String interview;

    @NotEmpty(message = "physical_examination field must be not empty")
    private String physical_examination;

    @NotEmpty(message = "Diagnosis field must be not empty")
    private String diagnosis;

    @NotEmpty(message = "Visit_history must be not empty")
    private String visit_history;
}
