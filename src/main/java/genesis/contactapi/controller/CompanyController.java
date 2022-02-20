package genesis.contactapi.controller;

import genesis.contactapi.dto.CompanyDto;
import genesis.contactapi.service.CompanyService;
import genesis.contactapi.service.DtoMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
public class CompanyController {

    private CompanyService companyService;
    private DtoMapperService dtoMapperService;

    @Autowired
    public CompanyController(CompanyService companyService, DtoMapperService dtoMapperService) {
        this.companyService = companyService;
        this.dtoMapperService = dtoMapperService;
    }

    @PostMapping("/company")
    public ResponseEntity<CompanyDto> createCompany(@Valid @RequestBody CompanyDto companyDto) {
        CompanyDto createdCompanyDto = dtoMapperService.mapToCompanyDto(companyService.createCompany(dtoMapperService.mapDtoCompanyToCompany(companyDto)));
        return new ResponseEntity<>(createdCompanyDto, HttpStatus.CREATED);
    }

    @PutMapping("/company/{companyId}")
    public ResponseEntity<CompanyDto> updateCompany(@Valid @RequestBody CompanyDto companyDto,
                                                    @PathVariable("companyId") Long companyId) {
        CompanyDto updatedCompanyDto = dtoMapperService.mapToCompanyDto(companyService.updateCompany(dtoMapperService.mapDtoCompanyToCompany(companyDto), companyId));
        return new ResponseEntity<>(updatedCompanyDto, HttpStatus.OK);
    }

    @GetMapping("/companies")
    public ResponseEntity<List<CompanyDto>> getAllCompany() {
        List<CompanyDto> companyDtoList = companyService.getAllCompany().stream()
                .map(company -> dtoMapperService.mapToCompanyDto(company))
                .collect(Collectors.toList());
        return new ResponseEntity<>(companyDtoList, HttpStatus.OK);
    }

    @GetMapping("/company")
    public ResponseEntity<CompanyDto> getCompanyByVatNumber(@RequestParam String vatNumber) {
        CompanyDto companyDto = dtoMapperService.mapToCompanyDto(companyService.getCompanyByVatNumber(vatNumber));
        return new ResponseEntity<>(companyDto, HttpStatus.OK);
    }

    @PostMapping("/company/{companyId}/addContact/{contactId}")
    public ResponseEntity<CompanyDto> addContact(@PathVariable("companyId") Long companyId,
                                                 @PathVariable("contactId") Long contactId) {

        CompanyDto updatedCompanyDto = dtoMapperService.mapToCompanyDto(companyService.addContact(companyId, contactId));
        return new ResponseEntity<>(updatedCompanyDto, HttpStatus.OK);
    }

}
