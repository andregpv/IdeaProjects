import java.util.Scanner;

class Alumno {
    String nombre;
    int[] calificaciones = new int[5];

    Alumno(String nombre, int[] calificaciones) {
        this.nombre = nombre;
        this.calificaciones = calificaciones;
    }

    double calcularPromedio() {
        int suma = 0;
        for (int i = 0; i < calificaciones.length; i++) {
            suma = suma + calificaciones[i];
        }
        return suma / 5.0;
    }

    char obtenerLetra(double promedio) {
        if (promedio >= 90) return 'A';
        else if (promedio >= 80) return 'B';
        else if (promedio >= 70) return 'C';
        else if (promedio >= 60) return 'D';
        else return 'F';
    }

    void mostrarResultados() {
        double prom = calcularPromedio();
        char letra = obtenerLetra(prom);

        System.out.println("Nombre del participante: " + nombre);
        for (int i = 0; i < 5; i++) {
            System.out.println("Calificación " + (i+1) + ": " + calificaciones[i]);
        }
        System.out.println("Promedio: " + prom);
        System.out.println("Calificación final: " + letra);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Nombre del participante: ");
        String nombre = input.nextLine();

        int[] calif = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Calificación " + (i+1) + ": ");
            calif[i] = input.nextInt();
        }

        Alumno participante = new Alumno(nombre, calif);
        participante.mostrarResultados();

        input.close();
    }
}