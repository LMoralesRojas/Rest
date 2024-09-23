package aplicacion.Rest.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import java.io.Serializable;
@Entity
@Table(name = "localidad")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Audited

public class Localidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "denominacion")
    private String denominacion;

}
