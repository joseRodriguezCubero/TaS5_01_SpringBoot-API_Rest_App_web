package cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "sucursales")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pk_SucursalID;

    @Setter
    @Column(name = "nomSucursal")
    private String nomSucursal;

    @Setter
    @Column(name= "paisSucursal")
    private String paisSucursal;

    public Sucursal(Long pk_SucursalID, String nomSucursal, String paisSucursal) {
        this.pk_SucursalID = pk_SucursalID;
        this.nomSucursal = nomSucursal;
        this.paisSucursal = paisSucursal;
    }

    public Sucursal() {
    }

    @Override
    public String toString() {
        return "Sucursal{" +
                "pk_SucursalID=" + pk_SucursalID +
                ", nomSucursal='" + nomSucursal + '\'' +
                ", paisSucursal='" + paisSucursal + '\'' +
                '}';
    }
}
