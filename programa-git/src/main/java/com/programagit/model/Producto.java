package com.programagit.model;

/**
 * Representa un robot registrado en el inventario de RoboInventory & Sales.
 *
 * Contiene los datos básicos definidos para el registro de productos:
 * nombre, modelo, precio y cantidad disponible.
 */
public class Producto {

    private Long id;
    private String nombre;
    private String modelo;
    private double precio;
    private int cantidad;

    /**
     * Constructor vacío requerido para crear objetos mediante el controlador.
     */
    public Producto() {
    }

    /**
     * Constructor para crear un producto con sus datos principales.
     */
    public Producto(Long id, String nombre, String modelo,
                    double precio, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.modelo = modelo;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}