package com.example.spring01.service.shop;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring01.model.dto.ProductDTO;
import com.example.spring01.model.shop.dao.ProductDAO;
import com.example.spring01.model.shop.dto.ProductDTO1;
@Service
public class ProductServiceImpl implements ProductService {

	@Inject
	ProductDAO productDao;
	
	@Override
	public List<ProductDTO1> listProduct() {
		return productDao.listProduct();
	}

	@Override
	public ProductDTO1 detailProduct(int product_id) {
		return productDao.detailProduct(product_id);
	}

	@Override
	public String fileInfo(int product_id) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void updateProduct(ProductDTO dto) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void deleteProduct(int product_id) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void insertProduct(ProductDTO dto) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
