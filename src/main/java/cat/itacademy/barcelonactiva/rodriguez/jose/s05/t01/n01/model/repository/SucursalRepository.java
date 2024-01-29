package cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.repository;

import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.entity.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SucursalRepository extends JpaRepository<Sucursal, Long> {

    List<Sucursal> findAllByOrderById();


    Optional<Sucursal> findByNameIgnoreCase (String name);

    List<Sucursal> findByNameContainingIgnoreCaseOrderById(String name);
}