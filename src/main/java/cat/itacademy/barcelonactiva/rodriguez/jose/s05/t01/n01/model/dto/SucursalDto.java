package cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.dto;

import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.entity.Country;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
public class SucursalDto implements Serializable {

    private Long pk_SucursalID;
    @NotBlank(message = "El campo no puede estar vacío")
    private String nomSucursal;
    private Country country;
    private String typeSucursal;
    private final ArrayList<String> euroCountries = new ArrayList<>(List.of("Alemania", "Austria", "Bélgica", "Chipre", "Croacia", "Eslovaquia", "Eslovenia", "España", "Estonia", "Finlandia", "Francia", "Grecia", "Irlanda", "Italia", "Letonia", "Lituania", "Luxemburgo", "Malta", "Países Bajos", "Portugal"));

    public SucursalDto(Long pk_SucursalID, String nomSucursal, Country paisSucursal) {
        this.pk_SucursalID = pk_SucursalID;
        this.nomSucursal = nomSucursal;
        this.country = paisSucursal;
        this.typeSucursal = createTypeSucursal(paisSucursal);
    }

    public SucursalDto() {
    }

    public String createTypeSucursal(Country pais) {
        if (pais != null) {
            if (this.euroCountries.contains(pais.getCountryName())) {
                return "EURO";
            }
        }
        return "NO EURO";
    }
}
