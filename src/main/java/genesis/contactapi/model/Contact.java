package genesis.contactapi.model;

import genesis.contactapi.enumeration.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CONTACT")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONTACT_ID")
    private Long id;

    @Column(name = "CONTACT_FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "CONTACT_LAST_NAME", nullable = false)
    private String lastName;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "CONTACT_ADDRESS_STREET")),
            @AttributeOverride(name = "streetNumber", column = @Column(name = "CONTACT_ADDRESS_STREET_NUMBER")),
            @AttributeOverride(name = "country", column = @Column(name = "CONTACT_ADDRESS_COUNTRY")),
            @AttributeOverride(name = "municipality", column = @Column(name = "CONTACT_ADDRESS_MUNICIPALITY")),
            @AttributeOverride(name = "postCode", column = @Column(name = "CONTACT_ADDRESS_POST_CODE"))
    })
    private Address address;

    @Column(name = "CONTACT_VAT_NUMBER")

    private String vatNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "CONTACT_TYPE")
    private Type type;

    @ManyToMany(mappedBy = "contacts")
    private Set<Company> companies;

}
