package com.programagit.service;

import com.programagit.model.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Contiene la lógica de negocio relacionada con los robots
 * registrados en el inventario de RoboInventory & Sales.
 */
@Service
public class ProductoService {

    // Lista temporal utilizada para realizar las pruebas iniciales del módulo.
    private final List<Producto> productos = new ArrayList<>();

    /**
     * Carga robots de ejemplo para comprobar el funcionamiento del módulo.
     */
    public ProductoService() {
        productos.add(new Producto(
                1L,
                "RoboTech X1",
                "RT-X1",
                2500000,
                5
        ));

        productos.add(new Producto(
                2L,
                "RoboClean Pro",
                "RC-PRO",
                1800000,
                10
        ));

        productos.add(new Producto(
                3L,
                "Explorer Robot",
                "EXP-01",
                3200000,
                3
        ));
    }

    /**
     * Obtiene todos los robots registrados.
     *
     * @return lista de robots disponibles.
     */
    public List<Producto> listarProductos() {
        return productos;
    }

    /**
     * Busca un robot mediante su identificador.
     *
     * @param id identificador del robot.
     * @return robot encontrado o null si no existe.
     */
    public Producto buscarPorId(Long id) {
        return productos.stream()
                .filter(producto -> producto.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    /**
     * Agrega un nuevo robot al inventario.
     *
     * @param producto robot que se desea registrar.
     * @return robot agregado.
     */
    public Producto agregarProducto(Producto producto) {
        productos.add(producto);
        return producto;
    }

    /**
     * Actualiza los datos de un robot existente.
     *
     * @param id identificador del robot que se desea actualizar.
     * @param producto datos nuevos del robot.
     * @return robot actualizado o null si no existe.
     */
    public Producto actualizarProducto(Long id, Producto producto) {
        Producto productoExistente = buscarPorId(id);

        if (productoExistente != null) {
            productoExistente.setNombre(producto.getNombre());
            productoExistente.setModelo(producto.getModelo());
            productoExistente.setPrecio(producto.getPrecio());
            productoExistente.setCantidad(producto.getCantidad());
        }

        return productoExistente;
    }

    /**
     * Elimina un robot del inventario.
     *
     * @param id identificador del robot que se desea eliminar.
     * @return true si el robot fue eliminado, false si no existe.
     */
    public boolean eliminarProducto(Long id) {
        return productos.removeIf(producto -> producto.getId().equals(id));
    }
}