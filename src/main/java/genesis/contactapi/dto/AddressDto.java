package genesis.contactapi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDto {
    private String street;
    private String streetNumber;
    private String country;
    private String municipality;
    private String postCode;
}
