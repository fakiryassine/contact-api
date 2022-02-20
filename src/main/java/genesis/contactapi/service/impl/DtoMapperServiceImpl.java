package genesis.contactapi.service.impl;

import genesis.contactapi.dto.AddressDto;
import genesis.contactapi.dto.CompanyDto;
import genesis.contactapi.dto.ContactDto;
import genesis.contactapi.model.Address;
import genesis.contactapi.model.Company;
import genesis.contactapi.model.Contact;
import genesis.contactapi.service.DtoMapperService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class DtoMapperServiceImpl implements DtoMapperService {


    @Override
    public CompanyDto mapToCompanyDto(Company company) {
        return CompanyDto.builder()
                .id(company.getId())
                .name(company.getName())
                .vatNumber(company.getVatNumber())
                .address(mapAddressToAddressDto(company.getAddress()))
                .contacts(company.getContacts() != null ? company.getContacts().stream().map(this::mapToContactDto).collect(Collectors.toSet()) : Collections.emptySet())
                .build();
    }

    @Override
    public Company mapDtoCompanyToCompany(CompanyDto companyDto) {
        return Company.builder()
                .address(mapAddressDtoToAddress(companyDto.getAddress()))
                .name(companyDto.getName())
                .vatNumber(companyDto.getVatNumber())
                .build();
    }

    @Override
    public ContactDto mapToContactDto(Contact contact) {
        return ContactDto.builder()
                .id(contact.getId())
                .address(mapAddressToAddressDto(contact.getAddress()))
                .firstName(contact.getFirstName())
                .lastName(contact.getLastName())
                .vatNumber(contact.getVatNumber())
                .type(contact.getType())
                .build();
    }


    @Override
    public Contact mapDtoContactToContact(ContactDto contactDto) {
        return Contact.builder()
                .address(mapAddressDtoToAddress(contactDto.getAddress()))
                .firstName(contactDto.getFirstName())
                .lastName(contactDto.getLastName())
                .vatNumber(contactDto.getVatNumber())
                .type(contactDto.getType())
                .build();
    }

    private AddressDto mapAddressToAddressDto(Address address) {
        return AddressDto.builder()
                .country(address.getCountry())
                .municipality(address.getCountry())
                .postCode(address.getPostCode())
                .street(address.getStreet())
                .streetNumber(address.getStreetNumber())
                .build();
    }

    private Address mapAddressDtoToAddress(AddressDto addressDto) {
        return Address.builder()
                .country(addressDto.getCountry())
                .municipality(addressDto.getMunicipality())
                .postCode(addressDto.getPostCode())
                .street(addressDto.getStreet())
                .streetNumber(addressDto.getStreetNumber())
                .build();
    }
}
