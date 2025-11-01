package com.tomas.todo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

    private static final String URL = "jdbc:sqlite:database/todo_app.db";

    // Conectar con la base de datos
    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
            System.out.println("✅ Conexión establecida con la base de datos SQLite");
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar con la base de datos: " + e.getMessage());
        }
        return conn;
    }

    // Crear tabla si no existe
    public static void createTableIfNotExists() {
        String sql = """
                CREATE TABLE IF NOT EXISTS tareas (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    titulo TEXT NOT NULL,
                    descripcion TEXT,
                    completada INTEGER DEFAULT 0
                );
                """;

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("🗂️ Tabla 'tareas' verificada o creada correctamente.");

        } catch (SQLException e) {
            System.out.println("❌ Error al crear tabla: " + e.getMessage());
        }
    }
}
