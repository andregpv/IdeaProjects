import java.util.*;
import java.io.*;

public class AddressBook {
    private HashMap<String, String> contactos;
    private String archivo;

    public AddressBook() {
        contactos = new HashMap<>();
        archivo = "contactos.csv";
        load();
    }

    public void load() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 2) {
                    contactos.put(partes[0], partes[1]);
                }
            }
            br.close();
        } catch (Exception e) {}
    }

    public void save() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
            for (String num : contactos.keySet())
                bw.write(num + "," + contactos.get(num) + "\n");
            bw.close();
        } catch (IOException e) {
            System.out.println("No se guardo correctamente.");
        }
    }

    public void list() {
        System.out.println("Contactos:");
        for (String num : contactos.keySet()) {
            System.out.println(num + " : " + contactos.get(num));
        }
    }

    public void create() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Numero: ");
        String num = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        if (contactos.containsKey(num)) {
            System.out.println("Contacto Existente.");
        } else {
            contactos.put(num, nombre);
            System.out.println("Contacto Creado.");
        }
    }

    public void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Numero a eliminar: ");
        String num = sc.nextLine();

        if (contactos.remove(num) != null) {
            System.out.println("Numero eliminado.");
        } else {
            System.out.println("Numero no encontrado.");
        }
    }

    public static void main(String[] args) {
        AddressBook agenda = new AddressBook();
        Scanner sc = new Scanner(System.in);
        String op = "";

        while (!op.equals("4")) {
            System.out.println("1. Listar contactos");
            System.out.println("2. Crear contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Salir");
            op = sc.nextLine();

            switch(op) {
                case "1":
                    agenda.list();
                    break;
                case "2":
                    agenda.create();
                    break;
                case "3":
                    agenda.delete();
                    break;
                case "4":
                    agenda.save();
                    System.out.println("Se guardaron los cambios.");
                    break;
                default:
                    System.out.println("opcion no valida");
            }
        }
        sc.close();
    }
}