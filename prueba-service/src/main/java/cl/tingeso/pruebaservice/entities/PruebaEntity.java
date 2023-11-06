package cl.tingeso.pruebaservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.sun.istack.NotNull;

@Entity
@Table(name = "pruebas")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PruebaEntity {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rut;
    private String fecha;
    private String puntaje;

}
