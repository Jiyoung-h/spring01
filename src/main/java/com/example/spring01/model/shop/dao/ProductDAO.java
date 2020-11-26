package com.example.spring01.model.shop.dao;

import java.util.List;

import com.example.spring01.model.shop.dto.ProductDTO;

public interface ProductDAO {
	List<ProductDTO> listProduct();
	ProductDTO detailProduct(int product_id);
	void updateProduct(ProductDTO dto);
	void insertProduct(ProductDTO dto);
	String fileInfo(int product_id);
	void deleteProduct(int product_id);
}
