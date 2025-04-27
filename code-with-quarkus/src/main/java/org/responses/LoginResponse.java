package org.responses;

import org.models.User;

public class LoginResponse {
  private User user;
  private String userID;
  private Boolean success;
  private String message;

  public LoginResponse(User user, String userID, Boolean success, String message) {
    this.user = user;
    this.userID = userID;
    this.success = success;
    this.message = message;
  }
  public LoginResponse() {};

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getUserID() {
    return userID;
  }

  public void setUserID(String id) {
    this.userID = id;
  }

  public Boolean getSuccess() {
    return success;
  }

  public void setSuccess(Boolean success) {
    this.success = success;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
