package entidades;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Domicilio")
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Domicilio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreCalle;
    private int numero;
}
