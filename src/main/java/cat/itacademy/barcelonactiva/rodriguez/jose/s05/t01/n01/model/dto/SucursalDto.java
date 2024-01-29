package cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.Arrays;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SucursalDto {

    private Long pk_SucursalID;
    private String nomSucursal;
    private String paisSucursal;
    private String typeSucursal;
    private ArrayList<String> euroCountries = new ArrayList<>(Arrays.asList("Austria", "Belgium", "Cyprus", "Estonia", "Finland", "France", "Germany", "Greece", "Ireland", "Italy", "Latvia", "Lithuania", "Luxembourg", "Malta", "Netherlands", "Portugal", "Slovakia", "Slovenia", "Spain"));;

}
