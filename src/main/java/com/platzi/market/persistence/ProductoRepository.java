package com.platzi.market.persistence;

import com.platzi.market.persistence.crud.ProductoCrudRepository;
import com.platzi.market.persistence.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {

    @Autowired
    private ProductoCrudRepository productoCrudRepository;


    public List<Producto> getAllProducts(){

        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria){

        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }


    public Optional<List<Producto>> getEscasos(int cantidadDeSock){

        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidadDeSock, true);
    }


    public Optional<Producto> getProducto(int idProducto){

        return productoCrudRepository.findById(idProducto);

    }


    public Producto saveProducto(Producto producto){

        return productoCrudRepository.save(producto);
    }


    public void delete(int idProducto) {

        productoCrudRepository.deleteById(idProducto);
    }

}