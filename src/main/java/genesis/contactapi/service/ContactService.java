package genesis.contactapi.service;

import genesis.contactapi.dto.ContactDto;
import genesis.contactapi.model.Contact;

import java.util.List;

public interface ContactService {

    Contact createContact(Contact contact);


    Contact updateContact(Contact contact, Long id);

    void deleteById(Long id);

    List<Contact> getAllContact();

    boolean isValidContact(Contact contact);

}
