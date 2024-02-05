package cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.repository;

import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CountryRepository extends JpaRepository<Country,Long> {

}
