package genesis.contactapi.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Validated
@Data
@Builder

public class AddressDto {
    @NotBlank(message = "street is mandatory")
    private String street;
    @NotBlank(message = "streetNumber is mandatory")
    private String streetNumber;
    @NotBlank(message = "country is mandatory")
    private String country;
    @NotBlank(message = "municipality is mandatory")
    private String municipality;
    @NotBlank(message = "postCode is mandatory")
    private String postCode;
}
