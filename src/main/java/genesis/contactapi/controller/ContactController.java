package genesis.contactapi.controller;

import genesis.contactapi.dto.ContactDto;
import genesis.contactapi.service.DtoMapperService;
import genesis.contactapi.service.impl.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
public class ContactController {


    private ContactServiceImpl contactService;
    private DtoMapperService dtoMapperService;

    @Autowired
    public ContactController(ContactServiceImpl contactService, DtoMapperService dtoMapperService) {
        this.contactService = contactService;
        this.dtoMapperService = dtoMapperService;
    }

    @PostMapping("/contact")
    public ResponseEntity<ContactDto> createContact(@Valid @RequestBody ContactDto contactDto) {
        if (!contactService.isValidContact(dtoMapperService.mapDtoContactToContact(contactDto))) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ContactDto createdContactDto = dtoMapperService.mapToContactDto(contactService.createContact(dtoMapperService.mapDtoContactToContact(contactDto)));
        return new ResponseEntity<>(createdContactDto, HttpStatus.CREATED);

    }

    @PutMapping("/contact/{id}")
    public ResponseEntity<ContactDto> updateContact(@Valid @RequestBody ContactDto contactDto,
                                                    @PathVariable Long id) {
        if (!contactService.isValidContact(dtoMapperService.mapDtoContactToContact(contactDto))) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ContactDto updatedContactDto = dtoMapperService.mapToContactDto(contactService.updateContact(dtoMapperService.mapDtoContactToContact(contactDto), id));
        return new ResponseEntity<>(updatedContactDto, HttpStatus.OK);
    }

    @DeleteMapping("/contact/{id}")
    public ResponseEntity<ContactDto> deleteContact(@PathVariable Long id) {
        contactService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/contacts")
    public ResponseEntity<List<ContactDto>> getAllContact() {
        List<ContactDto> contactDtoList = contactService.getAllContact().stream()
                .map(contact -> dtoMapperService.mapToContactDto(contact))
                .collect(Collectors.toList());
        return new ResponseEntity<>(contactDtoList, HttpStatus.OK);
    }
}
