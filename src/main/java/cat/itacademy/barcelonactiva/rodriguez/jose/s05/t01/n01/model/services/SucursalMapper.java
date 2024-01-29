package cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.dto.SucursalDto;
import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.entity.Sucursal;

public class SucursalMapper {
    // Convert User JPA Entity into UserDto
    public static SucursalDto mapToSucursalDto(Sucursal sucursal){
        return new SucursalDto(
                sucursal.getPk_SucursalID(),
                sucursal.getNomSucursal(),
                sucursal.getPaisSucursal(),
                sucursal.getEmail() //TODO implementar método de typo de sucursal
        );
    }

    // Convert UserDto into User JPA Entity
    public static Sucursal mapToSucursal(SucursalDto sucursalDto){
        return new Sucursal(
                sucursalDto.getPk_SucursalID(),
                sucursalDto.getNomSucursal(),
                sucursalDto.getPaisSucursal()
        );
    }
}

