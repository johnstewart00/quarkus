package org.services;

import org.DAO.CartDAO;
import org.models.CartItem;

import java.util.List;

public class CartService {
  private CartDAO cartDAO;
  public CartService() {
    cartDAO = new CartDAO();
  }

  public List<CartItem> getCart(String userID) {
    return cartDAO.getCart(userID);
  }
  public List<CartItem> addItemToCart( CartItem item) {
    return cartDAO.addItemToCart(item);
  }
}
