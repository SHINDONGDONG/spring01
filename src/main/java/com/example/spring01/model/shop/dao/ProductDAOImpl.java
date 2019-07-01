package com.example.spring01.model.shop.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.spring01.model.dto.ProductDTO;
import com.example.spring01.model.shop.dto.ProductDTO1;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<ProductDTO1> listProduct() {
		return sqlSession.selectList("product.list_product");
	}

	@Override
	public ProductDTO1 detailProduct(int product_id) {
		return sqlSession.selectOne(
				"product.detail_product",product_id);
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

	@Override
	public String fileinfo(int product_id) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
