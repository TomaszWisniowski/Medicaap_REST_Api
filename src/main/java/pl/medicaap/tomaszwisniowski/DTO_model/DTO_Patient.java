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
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class DTO_Patient {


    private int id;

    @NotEmpty(message = "Pesel must be not empty")
    private int pesel;

    @NotEmpty(message = "First name must be not empty")
    private String first_name;

    @NotEmpty(message = "Last name must be not empty")
    private String last_name;

    @NotEmpty(message = "Date of Birth must be not empty")
    private LocalDate date_of_birth;

    @NotEmpty(message = "Telephone number must be not empty")
    private int tel;

    @NotEmpty(message = "City must be not empty")
    private String city;

    @NotEmpty(message = "Street must be not empty")
    private String street;

    @NotEmpty(message = "House number must be not empty")
    private int house_number;

    @NotEmpty(message = "Flat number must be not empty")
    private int flat_number;
}
