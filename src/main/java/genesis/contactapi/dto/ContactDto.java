package genesis.contactapi.dto;

import genesis.contactapi.enumeration.Type;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Data
@Builder
@Validated
public class ContactDto {
    private Long id;
    @NotNull(message = "First is mandatory")
    private String firstName;
    @NotNull(message = "Last name is mandatory")
    private String lastName;
    private String vatNumber;
    @NotNull(message = "Last name is mandatory")
    private AddressDto address;
    private Type type;

}
