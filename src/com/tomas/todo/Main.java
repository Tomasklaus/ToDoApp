package com.tomas.todo;

import com.tomas.todo.dao.TareaDAO;
import com.tomas.todo.model.Tarea;
import com.tomas.todo.util.DBConnection;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Inicializa la base de datos (crea tabla si no existe)
        DBConnection.createTableIfNotExists();

        TareaDAO dao = new TareaDAO();
        Scanner sc = new Scanner(System.in);
        int opcion;

        System.out.prin1tln("\n📝 Bienvenido a tu ToDoApp (versión consola)\n");

        do {
            System.out.println("""
                    -------------------------------
                    1️⃣  Agregar nueva tarea
                    2️⃣  Listar todas las tareas
                    3️⃣  Marcar tarea como completada
                    4️⃣  Eliminar tarea
                    0️⃣  Salir
                    -------------------------------
                    """);

            System.out.print("Elige una opción: ");
            while (!sc.hasNextInt()) {
                System.out.print("⚠️ Ingresa un número válido: ");
                sc.next();
            }
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> {
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();

                    System.out.print("Descripción: ");
                    String descripcion = sc.nextLine();

                    dao.agregarTarea(new Tarea(titulo, descripcion));
                }

                case 2 -> {
                    List<Tarea> tareas = dao.obtenerTareas();
                    System.out.println("\n📋 Lista de tareas:");

                    if (tareas.isEmpty()) {
                        System.out.println("  (No hay tareas registradas)");
                    } else {
                        for (Tarea t : tareas) {
                            System.out.println("  ID " + t.getId() + " → " + t);
                        }
                    }
                    System.out.println();
                }

                case 3 -> {
                    System.out.print("ID de la tarea a marcar como completada: ");
                    int id = sc.nextInt();
                    dao.marcarCompletada(id);
                }

                case 4 -> {
                    System.out.print("ID de la tarea a eliminar: ");
                    int id = sc.nextInt();
                    dao.eliminarTarea(id);
                }

                case 0 -> System.out.println("👋 ¡Hasta luego!");
                default -> System.out.println("❌ Opción no válida, intenta de nuevo.\n");
            }

        } while (opcion != 0);

        sc.close();
    }
}
