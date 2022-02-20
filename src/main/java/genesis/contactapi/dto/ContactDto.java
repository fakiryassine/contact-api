package genesis.contactapi.dto;

import genesis.contactapi.enumeration.Type;
import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@Data
@Builder
public class ContactDto {
    private Long id;
    @NotNull(message = "First is mandatory")
    private String firstName;
    @NotNull(message = "Last name is mandatory")
    private String lastName;
    private String vatNumber;
    @Valid
    @NotNull(message = "Address is mandatory")
    private AddressDto address;
    private Type type;

}
