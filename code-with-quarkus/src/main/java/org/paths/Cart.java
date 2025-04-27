package org.paths;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.models.CartItem;
import org.responses.CartResponse;
import org.services.CartService;

import java.util.ArrayList;
import java.util.List;

@Path("cart")
public class Cart {
  private CartService cartService;

  public Cart() {
    cartService = new CartService();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public CartResponse cart(@QueryParam("userID") String userID) {
    System.out.println("userID is: " + userID);
    List<CartItem> cartItems = cartService.getCart(userID);
    return new CartResponse(cartItems);
  }

  @POST
  public CartResponse addItem(CartItem item) {
    List<CartItem> cartItems = cartService.addItemToCart(item);
    return new CartResponse(cartItems);
  }
}
