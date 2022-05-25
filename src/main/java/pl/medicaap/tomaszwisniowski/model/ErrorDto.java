/**
 * @author Tomasz Wiśniowski
 * @version 1.0
 * @since 5/04/22

 */

package pl.medicaap.tomaszwisniowski.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorDto {

    public final String message;
}
