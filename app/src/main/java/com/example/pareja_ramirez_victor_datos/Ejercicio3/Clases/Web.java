package com.example.pareja_ramirez_victor_datos.Ejercicio3.Clases;

public class Web {
    String nombre;
    String link;
    String email;
    String categoria;
    int imagen;

    public Web(String nombre, String link, String email, String categoria, int imagen) {
        this.nombre = nombre;
        this.link = link;
        this.email = email;
        this.categoria = categoria;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
