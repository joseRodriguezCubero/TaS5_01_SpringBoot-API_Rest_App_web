package cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.dto.SucursalDto;
import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.entity.Sucursal;
import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.exceptions.SucursalNotFoundException;

import java.util.List;

public interface SucursalServices {
    List<SucursalDto> getAllSucursals();

    Sucursal getSucursalById(Long id);

    List<SucursalDto> getSucursalContaining(String name);

    Sucursal createSucursal(SucursalDto sucursalDto);

    SucursalDto updateSucursal(Long id, SucursalDto updatedSucursal);

    void deleteSucursalById(Long id) throws SucursalNotFoundException;
}

/*UserDto createSucursal(UserDto user);

    SucursalDto getSucursalById(Long sucursalId);

    List<SucursalDto> getAllSucursals();

    SucursalDto updateSucursal(SucursalDto sucursal);

    void deleteSucursal(Long sucursalId);*/

