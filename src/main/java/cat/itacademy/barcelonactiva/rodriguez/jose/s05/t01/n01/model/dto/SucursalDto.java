package cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.Arrays;


@Setter
@Getter

public class SucursalDto {

    private Long pk_SucursalID;
    private String nomSucursal;
    private String paisSucursal;
    private String typeSucursal;
    private final ArrayList<String> euroCountries;

    public SucursalDto(Long pk_SucursalID, String nomSucursal, String paisSucursal) {
        this.pk_SucursalID = pk_SucursalID;
        this.nomSucursal = nomSucursal;
        this.paisSucursal = paisSucursal;
        this.typeSucursal = createTypeSucursal(paisSucursal);
        this.euroCountries = new ArrayList<>(Arrays.asList("Austria", "Belgium", "Cyprus", "Estonia", "Finland", "France", "Germany", "Greece", "Ireland", "Italy", "Latvia", "Lithuania", "Luxembourg", "Malta", "Netherlands", "Portugal", "Slovakia", "Slovenia", "Spain"));
    }

    public String createTypeSucursal(String pais){
        if(pais!=null) {
            if (this.euroCountries.contains(pais)) {
                return "EU";
            }
        }
        return "Not EU";
    }
}
