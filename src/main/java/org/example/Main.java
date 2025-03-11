import org.example.CabinaTelefonica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<CabinaTelefonica> cabinas = new ArrayList<>();
        int opcion;

        do {
            System.out.println("----------Telefonia Udec------------");
            System.out.println("1. Crear cabina telefónica");
            System.out.println("2. Escoger cabina telefónica");
            System.out.println("3. Registrar llamada");
            System.out.println("4. Mostrar información de cabina");
            System.out.println("5. Mostrar consolidado total");
            System.out.println("6. Reiniciar cabina");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre de la cabina: ");
                    String nombreCabina = scanner.nextLine();
                    cabinas.add(new CabinaTelefonica(nombreCabina));
                    System.out.println("Cabina " + nombreCabina + " creada.");
                    break;

                case 2:
                    System.out.println("Cabinas disponibles:");
                    for (int i = 0; i < cabinas.size(); i++) {
                        System.out.println((i + 1) + ". " + cabinas.get(i).getNombre());
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el número de la cabina: ");
                    int numCabina = scanner.nextInt() - 1;
                    if (numCabina >= 0 && numCabina < cabinas.size()) {
                        System.out.print("Ingrese el tipo de llamada (local, larga distancia, celular): ");
                        String tipoLlamada = scanner.next();
                        System.out.print("Ingrese la duración de la llamada en minutos: ");
                        int duracion = scanner.nextInt();
                        cabinas.get(numCabina).registrarLlamada(tipoLlamada, duracion);
                    } else {
                        System.out.println("Número de cabina no válido.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el número de la cabina: ");
                    int numCabinaInfo = scanner.nextInt() - 1;
                    if (numCabinaInfo >= 0 && numCabinaInfo < cabinas.size()) {
                        cabinas.get(numCabinaInfo).mostrarInformacion();
                    } else {
                        System.out.println("Número de cabina no válido.");
                    }
                    break;

                case 5:
                    int totalLlamadas = 0;
                    int totalDuracion = 0;
                    double totalCosto = 0.0;

                    for (CabinaTelefonica cabina : cabinas) {
                        totalLlamadas += cabina.getNumeroLlamadas();
                        totalDuracion += cabina.getDuracionTotal();
                        totalCosto += cabina.getCostoTotal();
                    }

                    System.out.println("Consolidado total:");
                    System.out.println("Número total de llamadas: " + totalLlamadas);
                    System.out.println("Duración total de llamadas: " + totalDuracion + " minutos");
                    System.out.println("Costo total: $" + totalCosto);
                    break;

                case 6:
                    System.out.print("Ingrese el número de la cabina a reiniciar: ");
                    int numCabinaReiniciar = scanner.nextInt() - 1;
                    if (numCabinaReiniciar >= 0 && numCabinaReiniciar < cabinas.size()) {
                        cabinas.get(numCabinaReiniciar).reiniciar();
                    } else {
                        System.out.println("Número de cabina no válido.");
                    }
                    break;

                case 7:
                    System.out.println("Saliendo de la aplicación.");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;

            }


        } while (opcion != 7);

        scanner.close();
    }
}