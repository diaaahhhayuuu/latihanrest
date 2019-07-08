package com.eksad.latihanrest.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.eksad.latihanrest.model.ProductGrocery;

@RepositoryRestResource(path = "groceries")
public interface ProductGroceryDao extends CrudRepository<ProductGrocery, Long>{

}
