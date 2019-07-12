package com.eksad.latihanrest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eksad.latihanrest.dao.BrandDao;
import com.eksad.latihanrest.dao.ProductDao;
import com.eksad.latihanrest.model.Brand;
import com.eksad.latihanrest.model.Product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/product")
@Api(tags = "Product")
public class ProductController {
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	BrandDao brandDao;

	@ApiOperation (
			value = "API to retrive to all producst's data",
			notes = "Return data with JSON format",
			tags = "Get Data API" 
			)
	@GetMapping("getByBrandId/{brandId}")
	public List<Product> getByBrandId(@PathVariable Long brandId) {
		List<Product> result = new ArrayList<Product>();
		productDao.findByBrandId(brandId).forEach(result::add);
		return  result;
	}
	
	@ApiOperation (
			value = "API to save new product's data",
			notes = "Return data with JSON format",
			tags = "Input Data API" 
			)
	@PostMapping(value = "saveProduct")
	public Product save(@RequestBody Product product) {
		Brand brand = brandDao.findById(product.getBrandId()).orElse(null);
		if (brand != null) {
			product.setBrand(brand);
			return productDao.save(product);
		}
			return null;
		
	}
	@ApiOperation (
			value = "API to update product's data",
			notes = "Return data with JSON format",
			tags = "Update Data API" 
			)
	@PutMapping (value = "updateProduct/{id}")
	public Product update(@RequestBody Product product, @PathVariable Long id) {
		Product productSelected = productDao.findById(id).orElse(null);
		if (productSelected != null) {
			productSelected.setBrandId(product.getBrandId());
			productSelected.setName(product.getName());
			productSelected.setPrice(product.getPrice());
			
			return productDao.save(productSelected);
		}else {
			return null;
		}
	}

	@ApiOperation (
			value = "API to delete product's data",
			notes = "Return data with JSON format",
			tags = "Delete Data API" 
			)
	@DeleteMapping (value = "deleteProduct/{id}")
	public HashMap<String, Object> delete(@PathVariable Long id){
		HashMap<String, Object> result = new HashMap<String, Object>();
		productDao.deleteById(id);
		result.put("message", "berhasil dihapus");
		return result;
	}

	@ApiOperation (
			value = "API to retrive to all producst's data",
			notes = "Return data with JSON format",
			tags = "Get Data API" 
			)
	@GetMapping("getBySearch/{search}")
	public List<Product> getBySearch(@PathVariable String search) {
		List<Product> result = new ArrayList<Product>();
		productDao.findBySearch(search).forEach(result::add);
		return  result;
	}
}
