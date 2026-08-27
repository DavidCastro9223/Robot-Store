package com.programagit.controller;

import com.programagit.model.Producto;
import com.programagit.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar los robots de RoboInventory & Sales.
 *
 * Permite consultar, registrar, actualizar y eliminar robots
 * mediante peticiones HTTP.
 */
@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    /**
     * Constructor para inyectar el servicio de productos.
     */
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    /**
     * Consulta todos los robots registrados.
     *
     * @return lista de robots.
     */
    @GetMapping
    public List<Producto> listarProductos() {
        return productoService.listarProductos();
    }

    /**
     * Consulta un robot por su identificador.
     *
     * @param id identificador del robot.
     * @return robot encontrado.
     */
    @GetMapping("/{id}")
    public Producto buscarProducto(@PathVariable Long id) {
        return productoService.buscarPorId(id);
    }

    /**
     * Registra un nuevo robot en el inventario.
     *
     * @param producto robot que se desea registrar.
     * @return robot registrado.
     */
    @PostMapping
    public Producto agregarProducto(@RequestBody Producto producto) {
        return productoService.agregarProducto(producto);
    }

    /**
     * Actualiza la información de un robot existente.
     *
     * @param id identificador del robot.
     * @param producto nuevos datos del robot.
     * @return robot actualizado.
     */
    @PutMapping("/{id}")
    public Producto actualizarProducto(
            @PathVariable Long id,
            @RequestBody Producto producto) {

        return productoService.actualizarProducto(id, producto);
    }

    /**
     * Elimina un robot del inventario.
     *
     * @param id identificador del robot.
     * @return mensaje indicando el resultado de la operación.
     */
    @DeleteMapping("/{id}")
    public String eliminarProducto(@PathVariable Long id) {

        boolean eliminado = productoService.eliminarProducto(id);

        if (eliminado) {
            return "Robot eliminado correctamente.";
        }

        return "No se encontró un robot con el ID indicado.";
    }
}