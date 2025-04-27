package org.paths;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.requests.LoginRequest;
import org.responses.LoginResponse;
import org.services.AuthService;

@Path("login")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Login {
  private final AuthService authService = new AuthService();

  @POST
  public Response login(LoginRequest loginRequest) {
    LoginResponse loginResponse = authService.login(loginRequest.getEmail(), loginRequest.getPassword());

    String userId = loginResponse.getUserID();

    String cookieValue = String.format("userID=%s; Path=/; Max-Age=3600; HttpOnly; SameSite=Lax", userId);

    return Response.ok(loginResponse)
      .header("Set-Cookie", cookieValue)
      .build();
  }
}
