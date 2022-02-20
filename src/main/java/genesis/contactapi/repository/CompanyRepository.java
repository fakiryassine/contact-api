package genesis.contactapi.repository;

import genesis.contactapi.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    // @Query("select c from Company c where c.vatNumber = :vatNumber")
    Company findCompanyByVatNumber(@Param("vatNumber") String vatNumber);
}
