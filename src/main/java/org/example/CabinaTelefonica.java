package org.example;

public class CabinaTelefonica {
    private String nombre;
    private int numeroLlamadas;
    private int duracionTotal;
    private double costoTotal;

    public CabinaTelefonica(String nombre) {
        this.nombre = nombre;
        this.numeroLlamadas = 0;
        this.duracionTotal = 0;
        this.costoTotal = 0.0;
    }

    //Metodo para registrar llamadas
    public void registrarLlamada(String tipo, int duracion) {
        double tarifa = 0.0;

        switch (tipo.toLowerCase()) {
            case "local":
                tarifa = 50.0;
                break;
            case "larga":
                tarifa = 350.0;
                break;
            case "celular":
                tarifa = 150.0;
                break;
            default:
                System.out.println("Tipo de llamada no válido.");
                return;
        }

        numeroLlamadas++;
        duracionTotal += duracion;
        costoTotal += duracion * tarifa;
    }

    //Metodo para mostrar informacion
    public void mostrarInformacion() {
        System.out.println("Cabina: " + nombre);
        System.out.println("Número de llamadas: " + numeroLlamadas);
        System.out.println("Duración total de llamadas: " + duracionTotal + " minutos");
        System.out.println("Costo total de llamadas: $" + costoTotal);
    }
    //Metodo para reinciar
    public void reiniciar() {
        numeroLlamadas = 0;
        duracionTotal = 0;
        costoTotal = 0.0;
        System.out.println("Cabina " + nombre + " reiniciada.");
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroLlamadas() {
        return numeroLlamadas;
    }

    public int getDuracionTotal() {
        return duracionTotal;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    @Override
    public String toString() {
        return "CabinaTelefonica{" +
                "nombre='" + nombre + '\'' +
                ", numeroLlamadas=" + numeroLlamadas +
                ", duracionTotal=" + duracionTotal +
                ", costoTotal=" + costoTotal +
                '}';
    }
}