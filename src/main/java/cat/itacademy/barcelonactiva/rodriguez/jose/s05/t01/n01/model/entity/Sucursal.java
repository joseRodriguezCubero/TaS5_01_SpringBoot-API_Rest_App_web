package cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Entity
@Table(name = "sucursales")
public class Sucursal implements Serializable {
    @Serial
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk_SucursalID;

    @Setter
    @Column(name = "nom_sucursal")
    private String nomSucursal;


    @Setter
    @ManyToOne
    @JoinColumn (name="countries_id")
    private Country country;

    public Sucursal(String nomSucursal, Country paisSucursal) {
        this.nomSucursal=nomSucursal;
        this.country=paisSucursal;
    }

    public Sucursal() {
    }


    @Override
    public String toString() {
        return "Sucursal{" +
                "pk_SucursalID=" + pk_SucursalID +
                ", nomSucursal='" + nomSucursal + '\'' +
                ", paisSucursal='" + country.getCountryName() + '\'' +
                '}';
    }
}
