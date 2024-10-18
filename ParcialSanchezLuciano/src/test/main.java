package test;

import java.time.LocalDate;
import model.Gastronomia;
import model.Hospedaje;
import model.Servicio;
import model.Sistema;

/**
 *
 * @author ike
 */

public class main {
    public static void main(String[] args) {
        try {
            Sistema sistema = new Sistema();
            
            // 1-1: Intento crear el objeto Gastronomia con codigo incorrecto.
            try {
                sistema.agregarGastronomia("4892", 15.0, true, "Hamburguesa criolla", 180.0, 4);
            } catch (Exception e) {
                System.out.println("Error al agregar gastronomia: " + e.getMessage());
            }

            // 1-2: Crear objeto Gastronomia.
            sistema.agregarGastronomia("489235", 15.0, true, "Hamburguesa criolla", 180.0, 4);
            
            // 1-3: Intento crear el objeto Hospedaje con codigo incorrecto.
            try {
                sistema.agregarHospedaje("2872", 10.0, true, "Cabaña 3 personas", 1500.0);
            } catch (Exception e) {
                System.out.println("Error al agregar hospedaje: " + e.getMessage());
            }

            // 1-4: Crear el objeto Hospedaje.
            sistema.agregarHospedaje("287282", 10.0, true, "Cabaña 3 personas", 1500.0);

            // Pruebas de calculo de precios.
            LocalDate dia1 = LocalDate.of(2020, 10, 28); // Miercoles,Gastronomia(no aplica descuento ya que no coincide el dia)
            LocalDate dia2 = LocalDate.of(2020, 10, 27); // Martes,hospedaje(aplica descuento)

            // Recorrer servicios y calcular precios segun el servicio.
            for (Servicio s : sistema.traerServicio(true)) {
                if (s instanceof Gastronomia) {
                    System.out.println("Precio final de Gastronomia: " + s.calcularPrecioFinal(dia1));
                } else if (s instanceof Hospedaje) {
                    System.out.println("Precio final de Hospedaje: " + s.calcularPrecioFinal(dia2));
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
