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