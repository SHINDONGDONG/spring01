package com.example.spring01.service.shop;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.spring01.model.shop.dao.CartDAO;
import com.example.spring01.model.shop.dto.CartDTO;

@Service
public class CartServiceImpl implements CartService {

	@Inject
	CartDAO cartDao;
	
	@Override
	public List<CartDTO> cartMoney() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void insert(CartDTO dto) {
		cartDao.insert(dto);
	}

	@Override
	public List<CartDTO> listCart(String userid) {
		return cartDao.listCart(userid);
	}

	@Override
	public void delete(int cart_id) {
		cartDao.delete(cart_id);
	}

	@Override
	public void deleteAll(String userid) {
		cartDao.deleteAll(userid);
	}

	@Override
	public void update(int cart_id) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public int sumMoney(String userid) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public int countCart(String userid, int product_id) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public void updateCart(CartDTO dto) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void modifyCart(CartDTO dto) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
