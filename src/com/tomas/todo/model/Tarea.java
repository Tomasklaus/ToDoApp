package com.tomas.todo.model;

public class Tarea {
    private int id;
    private String titulo;
    private String descripcion;
    private boolean completada;

    // Constructor sin ID (para tareas nuevas)
    public Tarea(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.completada = false;
    }

    // Constructor con ID (para tareas ya existentes en la base)
    public Tarea(int id, String titulo, String descripcion, boolean completada) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.completada = completada;
    }

    // Getters y setters
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getDescripcion() { return descripcion; }
    public boolean isCompletada() { return completada; }

    public void setId(int id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setCompletada(boolean completada) { this.completada = completada; }

    @Override
    public String toString() {
        return "[" + (completada ? "✔" : " ") + "] " + titulo + " - " + descripcion;
    }
}
