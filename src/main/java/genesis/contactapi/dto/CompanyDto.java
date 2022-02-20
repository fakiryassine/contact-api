package genesis.contactapi.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Builder
public class CompanyDto {
    private Long id;
    private String name;
    @Valid
    @NotNull(message = "Address is mandatory")
    private AddressDto address;
    @NotNull(message = "vatNumber is mandatory")
    private String vatNumber;
    private Set<ContactDto> contacts;
}
