import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Doctor {
    int id;
    String nombre;
    String especialidad;

    Doctor(int id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public String toString() {
        return id + nombre + especialidad;
    }

class Paciente {
    int id;
    String nombre;

    Paciente(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String toString() {
        return id + nombre;
    }
}

class Cita {
    int id;
    String fechaHora;
    String motivo;
    Doctor doctor;
    Paciente paciente;

    Cita(int id, String fechaHora, String motivo, Doctor doctor, Paciente paciente) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.doctor = doctor;
        this.paciente = paciente;
    }

    public String toString() {
        return id + fechaHora + motivo +
                "Doctor: " + doctor.nombre +
                "Paciente: " + paciente.nombre;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Doctor> doctores = new ArrayList<>();
        List<Paciente> pacientes = new ArrayList<>();
        List<Cita> citas = new ArrayList<>();

        int idDoctor = 1, idPaciente = 1, idCita = 1;

        System.out.println("Programa ejecutado");

        System.out.print("Usuario: ");
        String user = scanner.nextLine();
        System.out.print("Contrasena: ");
        String pass = scanner.nextLine();

        if (!(user.equals("admin") && pass.equals("12345"))) {
            System.out.println("Usuario o contrasena incorrectos");
            return;
        }

        int opcion;
        do {
            System.out.println("1. Registrar doctor");
            System.out.println("2. Registrar paciente");
            System.out.println("3. Crear cita");
            System.out.println("4. Ver doctores");
            System.out.println("5. Ver pacientes");
            System.out.println("6. Ver citas");
            System.out.println("7. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del doctor: ");
                    String nombreDoc = scanner.nextLine();
                    System.out.print("Especialidad: ");
                    String esp = scanner.nextLine();
                    doctores.add(new Doctor(idDoctor++, nombreDoc, esp));
                    System.out.println("Doctor dado de alta.");
                    break;

                case 2:
                    System.out.print("Nombre del paciente: ");
                    String nombrePac = scanner.nextLine();
                    pacientes.add(new Paciente(idPaciente++, nombrePac));
                    System.out.println("Paciente dado de alta");
                    break;

                case 3:
                    System.out.print("Fecha y hora de la cita: ");
                    String fecha = scanner.nextLine();
                    System.out.print("Motivo de la cita: ");
                    String motivo = scanner.nextLine();

                    System.out.println("Doctor asignado a la citas");
                    for (Doctor d : doctores) {
                        System.out.println(d);
                    }
                    int dSel = scanner.nextInt();
                    scanner.nextLine();
                    Doctor doc = null;
                    for (Doctor d : doctores) {
                        if (d.id == dSel) {
                            doc = d;
                            break;
                        }
                    }

                    System.out.println("Paciente a ciitar");
                    for (Paciente p : pacientes) {
                        System.out.println(p);
                    }
                    int pSel = scanner.nextInt();
                    scanner.nextLine();
                    Paciente pac = null;
                    for (Paciente p : pacientes) {
                        if (p.id == pSel) {
                            pac = p;
                            break;
                        }
                    }

                    citas.add(new Cita(idCita++, fecha, motivo, doc, pac));
                    System.out.println("Cita asignada con exito");
                    break;

                case 4:
                    System.out.println("Doctores");
                    for (Doctor d : doctores) {
                        System.out.println(d);
                    }
                    break;

                case 5:
                    System.out.println("Pacientes");
                    for (Paciente p : pacientes) {
                        System.out.println(p);
                    }
                    break;

                case 6:
                    System.out.println("Citas");
                    for (Cita c : citas) {
                        System.out.println(c);
                    }
                    break;

                case 7:
                    System.out.println("Salida de programa.");
                    break;
            }
        } while (opcion != 7);

        scanner.close();
    }
}
