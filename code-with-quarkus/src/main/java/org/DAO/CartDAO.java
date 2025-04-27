package org.DAO;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.*;
import com.amazonaws.regions.Regions;
import org.models.CartItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CartDAO {
  private final AmazonDynamoDB client;

  public CartDAO() {
    this.client = AmazonDynamoDBClientBuilder.standard()
      .withRegion(Regions.US_EAST_1)
      .build();
  }

  public List<CartItem> getCart(String userID) {
    List<CartItem> cartItems = new ArrayList<>();

    QueryRequest queryRequest = new QueryRequest()
      .withTableName("cart")
      .withKeyConditionExpression("userID = :uid")
      .withExpressionAttributeValues(Map.of(":uid", new AttributeValue().withS(userID)));

    QueryResult result = client.query(queryRequest);

    for (Map<String, AttributeValue> item : result.getItems()) {
      CartItem cartItem = new CartItem();
      cartItem.setUserID(item.get("userID").getS());
      cartItem.setId(item.get("id").getS());
      cartItem.setName(item.get("name").getS());
      cartItems.add(cartItem);
    }

    return cartItems;
  }
  public List<CartItem> addItemToCart(CartItem item) {

    // Create the item map for DynamoDB
    Map<String, AttributeValue> itemValues = Map.of(
      "userID", new AttributeValue().withS(item.getUserID()),
      "id", new AttributeValue().withS(String.valueOf(item.getId())),
      "name", new AttributeValue().withS(item.getName())
    );

    // Create and send the PutItem request
    PutItemRequest putItemRequest = new PutItemRequest()
      .withTableName("cart")
      .withItem(itemValues);

    client.putItem(putItemRequest);

    // Return the updated cart
    return getCart(item.getUserID());
  }

}
