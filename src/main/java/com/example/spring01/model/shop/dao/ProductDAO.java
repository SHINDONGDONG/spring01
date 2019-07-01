package com.example.spring01.model.shop.dao;

import java.util.List;

import com.example.spring01.model.dto.ProductDTO;
import com.example.spring01.model.shop.dto.ProductDTO1;

public interface ProductDAO {

	List<ProductDTO1> listProduct();
	ProductDTO1 detailProduct(int product_id);
	void updateProduct(ProductDTO dto);
	void deleteProduct(int product_id);
	void insertProduct(ProductDTO dto);
	String fileinfo(int product_id);
}
