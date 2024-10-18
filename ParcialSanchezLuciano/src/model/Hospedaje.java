/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ike
 */
public class Hospedaje extends Servicio {
    private String hospedaje;
    private double precioPorNoche;

    public Hospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche) throws Exception {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.hospedaje = hospedaje;
        this.precioPorNoche = precioPorNoche;
    }

    @Override
    public double calcularPrecioFinal(java.time.LocalDate dia) {
        // El descuento se aplica solo si el servicio este en promocion y el dia es de lunes a viernes (1 a 5).
        if (enPromocion && dia.getDayOfWeek().getValue() >= 1 && dia.getDayOfWeek().getValue() <= 5) {
            return precioPorNoche * (1 - (porcentajeDescuento / 100));
        }
        return precioPorNoche;
    }
}

