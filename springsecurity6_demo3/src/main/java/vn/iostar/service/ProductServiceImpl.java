package vn.iostar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iostar.entity.Products;
import vn.iostar.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository repository;
	
	public ProductServiceImpl(ProductRepository repository) {
		this.repository = repository;
	}
	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Products get(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public Products save(Products products) {
		// TODO Auto-generated method stub
		return repository.save(products);
	}

	@Override
	public List<Products> listAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
