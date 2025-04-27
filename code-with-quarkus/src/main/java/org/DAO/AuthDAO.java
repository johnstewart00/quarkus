package org.DAO;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazonaws.services.dynamodbv2.model.QueryResult;
import org.models.User;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;

import java.util.Map;

public class AuthDAO {
  private final AmazonDynamoDB client;

  public AuthDAO() {
    this.client = AmazonDynamoDBClientBuilder.standard()
      .withRegion(Regions.US_EAST_1)
      .build();
  }
  public User getUserByEmail (String email) {
    User user = null;
    QueryRequest queryRequest = new QueryRequest()
      .withTableName("user")
      .withIndexName("email-index") // The name of your GSI
      .withKeyConditionExpression("email = :email")
      .withExpressionAttributeValues(Map.of(
        ":email", new AttributeValue().withS(email)
      ));

    QueryResult result = client.query(queryRequest);

    if (!result.getItems().isEmpty()) {
      Map<String, AttributeValue> item = result.getItems().getFirst();
      user = new User();

      user.setEmail(item.get("email").getS());
      user.setPassword(item.get("password").getS()); // Optional
      user.setName(item.get("name").getS());
      user.setID(item.get("id").getS());
    }

    return user;
  }

  public Boolean addUser(User user) {
    try {
      Map<String, AttributeValue> item = Map.of(
        "id", new AttributeValue(user.getID()),
        "email", new AttributeValue(user.getEmail()),
        "password", new AttributeValue(user.getPassword()),
        "name", new AttributeValue(user.getName())
      );

      PutItemRequest request = new PutItemRequest()
        .withTableName("user")
        .withItem(item);

      PutItemResult result = client.putItem(request);

      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }
}
