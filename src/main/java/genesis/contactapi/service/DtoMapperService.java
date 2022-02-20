package genesis.contactapi.service;

import genesis.contactapi.dto.CompanyDto;
import genesis.contactapi.dto.ContactDto;
import genesis.contactapi.model.Company;
import genesis.contactapi.model.Contact;

public interface DtoMapperService {

    CompanyDto mapToCompanyDto(Company company);

    Company mapDtoCompanyToCompany(CompanyDto companyDto);

    ContactDto mapToContactDto(Contact contact);

    Contact mapDtoContactToContact(ContactDto contactDto);


}
