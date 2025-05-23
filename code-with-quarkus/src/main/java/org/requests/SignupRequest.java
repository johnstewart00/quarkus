package org.requests;

public class SignupRequest {
  private String email;
  private String password;
  private String name;

  public SignupRequest(String email, String password, String name) {
    this.email = email;
    this.password = password;
    this.name = name;
  }
  public SignupRequest() {}

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
