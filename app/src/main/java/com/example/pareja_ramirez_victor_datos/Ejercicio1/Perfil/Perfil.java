package com.example.pareja_ramirez_victor_datos.Ejercicio1.Perfil;

public class Perfil {
    String nombre;
    String apellidos;
    int edad;
    String colegio;
    String profesor;

    public Perfil(String nombre, String apellidos, int edad, String colegio, String profesor) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.colegio = colegio;
        this.profesor = profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public String getColegio() {
        return colegio;
    }

    public String getProfesor() {
        return profesor;
    }
}
