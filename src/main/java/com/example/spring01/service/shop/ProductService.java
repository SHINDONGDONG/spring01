package com.example.spring01.service.shop;

import java.util.List;

import com.example.spring01.model.dto.ProductDTO;
import com.example.spring01.model.shop.dto.ProductDTO1;

public interface ProductService {

	List<ProductDTO1> listProduct();
	ProductDTO1 detailProduct(int product_id);
	String fileInfo(int product_id);
	void updateProduct(ProductDTO dto);
	void deleteProduct(int product_id);
	void insertProduct(ProductDTO dto);
}
