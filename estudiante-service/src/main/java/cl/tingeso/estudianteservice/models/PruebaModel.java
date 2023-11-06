package cl.tingeso.estudianteservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PruebaModel {
    private String rut;
    private String fecha;
    private String puntaje;
}
