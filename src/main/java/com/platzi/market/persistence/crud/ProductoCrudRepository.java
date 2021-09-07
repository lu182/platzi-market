package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    //implementamos Query Methods:

    //Recuperar toda la lista de Productos que pertenezcan a una Categoria en específico (por ej: aseo)
    //ordenados en órden alfabético:
      List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    //Recuperar los Productos escasos (es decir, los productos que se están agotando y que actualmente yo los estoy vendiendo (activos):
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
