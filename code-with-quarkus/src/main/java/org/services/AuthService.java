package org.services;

import org.DAO.AuthDAO;
import org.models.User;
import org.responses.LoginResponse;
import org.responses.SignupResponse;

import java.util.UUID;

public class AuthService {
  AuthDAO authDAO;
  public AuthService() {
    authDAO = new AuthDAO();
  }
  public LoginResponse login(String email, String password) {
    User user = authDAO.getUserByEmail(email);
    if (user == null ) return new LoginResponse(null, null, false, "No user found with email: " + email);
    return new LoginResponse(user, user.getID(), true, "login successful");
  }

  public SignupResponse signup(String email, String password, String name) {
    String id = UUID.randomUUID().toString();
    User user = new User(name, id, email, password);
    Boolean success = authDAO.addUser(user);
    return new SignupResponse(user, id, success, "signup successful");
  }
}
