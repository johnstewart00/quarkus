package org.responses;

import org.models.CartItem;

import java.util.List;

public class CartResponse {
  public List<CartItem> items;

  public CartResponse() {}
  public CartResponse(List<CartItem> items) {
    this.items = items;
  }

  public List<CartItem> getItems() {
    return items;
  }

  public void setItems(List<CartItem> items) {
    this.items = items;
  }
}

