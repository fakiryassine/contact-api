package genesis.contactapi.service.impl;

import genesis.contactapi.model.Company;
import genesis.contactapi.model.Contact;
import genesis.contactapi.repository.CompanyRepository;
import genesis.contactapi.repository.ContactRepository;
import genesis.contactapi.service.CompanyService;
import genesis.contactapi.service.DtoMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    CompanyRepository companyRepository;
    ContactRepository contactRepository;
    DtoMapperService dtoMapperService;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository, ContactRepository contactRepository, DtoMapperService dtoMapperService) {
        this.companyRepository = companyRepository;
        this.contactRepository = contactRepository;
        this.dtoMapperService = dtoMapperService;
    }

    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company getCompanyByVatNumber(String vatNumber) {
        return companyRepository.findCompanyByVatNumber(vatNumber);
    }

    @Override
    public Company updateCompany(Company company, Long id) {
        company.setId(id);
        return companyRepository.save(company);
    }

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public Company addContact(Long companyId, Long contactId) {
        Contact contactToAdd = contactRepository.getById(contactId);
        Company company = companyRepository.getById(companyId);
        company.addContact(contactToAdd);
        return companyRepository.save(company);
    }
}
