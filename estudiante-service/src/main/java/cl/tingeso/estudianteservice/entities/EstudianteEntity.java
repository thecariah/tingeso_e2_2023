package cl.tingeso.estudianteservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.sun.istack.NotNull;

@Entity
@Table(name = "estudiantes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EstudianteEntity {
    @Id
    @NotNull
    private String rut;
    private String apellidos;
    private String nombres;
    private String nacimiento;

    private String tipo_colegio;
    private String nombre_colegio;
    private String egreso;

}
