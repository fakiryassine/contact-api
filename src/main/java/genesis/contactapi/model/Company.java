package genesis.contactapi.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "COMPANY")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMPANY_ID")
    private Long id;

    @Column(name = "COMPANY_NAME")
    private String name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "COMPANY_ADDRESS_STREET")),
            @AttributeOverride(name = "streetNumber", column = @Column(name = "COMPANY_ADDRESS_NUMBER")),
            @AttributeOverride(name = "country", column = @Column(name = "COMPANY_ADDRESS_COUNTRY")),
            @AttributeOverride(name = "municipality", column = @Column(name = "COMPANY_ADDRESS_MUNICIPALITY")),
            @AttributeOverride(name = "postCode", column = @Column(name = "COMPANY_ADDRESS_POST_CODE"))
    })

    private Address address;

    @Column(name = "COMPANY_VAT_NUMBER", nullable = false)
    private String vatNumber;

    @ManyToMany
    @JoinTable(
            name = "company_contact",
            joinColumns = @JoinColumn(name = "CONTACT_ID"),
            inverseJoinColumns = @JoinColumn(name = "COMPANY_ID"))
    private Set<Contact> contacts;

    public void addContact(Contact contact) {
        this.contacts.add(contact);
    }

    public void deleteContact(Contact contact) {
        this.contacts.remove(contact);
    }
}
