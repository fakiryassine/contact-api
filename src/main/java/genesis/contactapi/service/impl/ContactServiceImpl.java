package genesis.contactapi.service.impl;

import genesis.contactapi.enumeration.Type;
import genesis.contactapi.model.Contact;
import genesis.contactapi.repository.ContactRepository;
import genesis.contactapi.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;


    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;

    }


    @Override
    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact updateContact(Contact contact, Long id) {
        contact.setId(id);
        return contactRepository.save(contact);
    }

    @Override
    public void deleteById(Long id) {
        Contact contact = contactRepository.getById(id);
        contact.getCompanies().forEach(company -> company.deleteContact(contact));
        contactRepository.deleteById(id);
    }

    @Override
    public List<Contact> getAllContact() {
        return contactRepository.findAll();

    }

    @Override
    public boolean isValidContact(Contact contact) {
        if ((contact.getType() == Type.EMPLOYEE && contact.getVatNumber() != null)) {
            return false;
        }
        return (contact.getType() != Type.FREELANCE || (contact.getVatNumber() != null)
                && !contact.getVatNumber().isEmpty());


    }
}
