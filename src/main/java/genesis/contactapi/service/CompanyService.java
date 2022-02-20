package genesis.contactapi.service;

import genesis.contactapi.model.Company;
import genesis.contactapi.model.Contact;

import java.util.List;

public interface CompanyService {
    Company createCompany(Company company);

    Company getCompanyByVatNumber(String vatNumber);

    Company updateCompany(Company company,Long id);

    List<Company> getAllCompany();

    Company addContact(Long companyId, Long contactId);

}
