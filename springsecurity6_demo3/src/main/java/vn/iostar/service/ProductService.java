package vn.iostar.service;

import java.util.List;

import vn.iostar.entity.Products;

public interface ProductService {
	void delete(Long id);
	Products get(Long id);
	Products save(Products product);
	List<Products> listAll();
}
