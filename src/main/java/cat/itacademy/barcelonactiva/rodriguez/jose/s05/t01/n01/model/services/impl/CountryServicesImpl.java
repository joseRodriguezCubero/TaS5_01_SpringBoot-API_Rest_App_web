package cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.services.impl;

import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.entity.Country;
import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.repository.CountryRepository;
import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.services.CountryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CountryServicesImpl implements CountryServices {
   private final CountryRepository countryRepository;
    @Autowired
    public CountryServicesImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> countryList() {

        return countryRepository.findAll();
    }
}
