package com.tomas.todo.dao;

import com.tomas.todo.model.Tarea;
import com.tomas.todo.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TareaDAO {

    // Crear nueva tarea
    public void agregarTarea(Tarea tarea) {
        String sql = "INSERT INTO tareas(titulo, descripcion, completada) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, tarea.getTitulo());
            pstmt.setString(2, tarea.getDescripcion());
            pstmt.setBoolean(3, tarea.isCompletada());
            pstmt.executeUpdate();

            System.out.println("✅ Tarea agregada correctamente.");

        } catch (SQLException e) {
            System.out.println("❌ Error al agregar tarea: " + e.getMessage());
        }
    }

    // Obtener todas las tareas
    public List<Tarea> obtenerTareas() {
        List<Tarea> tareas = new ArrayList<>();
        String sql = "SELECT * FROM tareas";

        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Tarea t = new Tarea(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("descripcion"),
                        rs.getBoolean("completada")
                );
                tareas.add(t);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al obtener tareas: " + e.getMessage());
        }

        return tareas;
    }

    // Marcar tarea como completada
    public void marcarCompletada(int id) {
        String sql = "UPDATE tareas SET completada = 1 WHERE id = ?";

        try (Connection conn = DBConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int filas = pstmt.executeUpdate();

            if (filas > 0)
                System.out.println("✅ Tarea marcada como completada.");
            else
                System.out.println("⚠️ No se encontró una tarea con ese ID.");

        } catch (SQLException e) {
            System.out.println("❌ Error al actualizar tarea: " + e.getMessage());
        }
    }

    // Eliminar tarea por ID
    public void eliminarTarea(int id) {
        String sql = "DELETE FROM tareas WHERE id = ?";

        try (Connection conn = DBConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int filas = pstmt.executeUpdate();

            if (filas > 0)
                System.out.println("🗑️ Tarea eliminada correctamente.");
            else
                System.out.println("⚠️ No se encontró una tarea con ese ID.");

        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar tarea: " + e.getMessage());
        }
    }
}
