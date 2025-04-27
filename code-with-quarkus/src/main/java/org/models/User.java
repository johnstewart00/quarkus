package org.models;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.*;

@DynamoDbBean
public class User {
  private String name;
  private String id;
  private String email;
  private String password;

  public User(String name, String id, String email, String password) {
    this.name = name;
    this.id = id;
    this.email = email;
    this.password = password;
  }
  public User() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @DynamoDbPartitionKey
  public String getID() {
    return id;
  }

  public void setID(String id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
