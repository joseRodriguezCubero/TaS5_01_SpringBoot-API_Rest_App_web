package cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Entity
@Table(name = "countries")
public class Country implements Serializable {
    @Serial
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Setter
    @Column(name="iso")
    private String iso;

    @Setter
    @Column(name = "country_name")
    private String countryName;


    @Override
    public String toString() {
        return "Country{" +
                "ID=" + Id +
                ",country Name='" + countryName + "\n}";
    }
}
