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

            // 1-1: Intento crear el objeto Gastronomia con código incorrecto.
            System.out.println("1-1: Intentando crear Gastronomia con codigo incorrecto.");
            try {
                sistema.agregarGastronomia("4892", 15.0, true, "Hamburguesa criolla", 180.0, 4);
            } catch (Exception e) {
                System.out.println("Error al agregar gastronomia: " + e.getMessage());
            }

            // 1-2: Crear objeto Gastronomia.
            System.out.println("1-2: Creando objeto Gastronomia con codigo correcto.");
            sistema.agregarGastronomia("489235", 15.0, true, "Hamburguesa criolla", 180.0, 4);

            // 1-3: Intento crear el objeto Hospedaje con código incorrecto.
            System.out.println("1-3: Intentando crear Hospedaje con codigo incorrecto.");
            try {
                sistema.agregarHospedaje("2872", 10.0, true, "Cabaña 3 personas", 1500.0);
            } catch (Exception e) {
                System.out.println("Error al agregar hospedaje: " + e.getMessage());
            }

            // 1-4: Crear el objeto Hospedaje.
            System.out.println("1-4: Creando objeto Hospedaje con codigo correcto.");
            sistema.agregarHospedaje("287282", 10.0, true, "Cabaña 3 personas", 1500.0);

            // 2-1: Calcular e imprimir precio final del servicio Gastronomia.
            System.out.println("2-1: Calculando precio final de Gastronomia.");
            LocalDate dia1 = LocalDate.of(2020, 10, 28); // Miércoles, Gastronomía (no aplica descuento ya que no coincide el día)
            for (Servicio s : sistema.traerServicio(true)) {
                if (s instanceof Gastronomia) {
                    System.out.println("Precio final de Gastronomia: " + s.calcularPrecioFinal(dia1));
                }
            }

            // 2-2: Calcular e imprimir precio final del servicio Hospedaje.
            System.out.println("2-2: Calculando precio final de Hospedaje.");
            LocalDate dia2 = LocalDate.of(2020, 10, 27); // Martes, Hospedaje (aplica descuento)
            for (Servicio s : sistema.traerServicio(true)) {
                if (s instanceof Hospedaje) {
                    System.out.println("Precio final de Hospedaje: " + s.calcularPrecioFinal(dia2));
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
