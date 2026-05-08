package com.example.demo.Login;

public class Usuario {

    public enum Rol {
        ADMIN, DOCTOR
    }

    private int id;
    private String correo;
    private String contrasena;
    private Rol rol;
    private String nombre;

    public Usuario() {}

    public Usuario(int id, String correo, String contrasena, Rol rol, String nombre) {
        this.id = id;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = rol;
        this.nombre = nombre;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public Rol getRol() { return rol; }
    public void setRol(Rol rol) { this.rol = rol; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}
