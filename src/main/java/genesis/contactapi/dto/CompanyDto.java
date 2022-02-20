package genesis.contactapi.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Validated
@Data
@Builder
public class CompanyDto {
    private Long id;
    private String name;
    @NotNull(message = "Address is mandatory")
    private AddressDto address;
    @NotNull(message = "vatNumber is mandatory")
    private String vatNumber;
    private Set<ContactDto> contacts;
}
