package org.paths;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.requests.LoginRequest;
import org.requests.SignupRequest;
import org.responses.LoginResponse;
import org.responses.SignupResponse;
import org.services.AuthService;

@Path("signup")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Signup {
  private final AuthService authService = new AuthService();

  @POST
  public Response signup(SignupRequest signupRequest) {
    SignupResponse signupResponse = authService.signup(signupRequest.getEmail(), signupRequest.getPassword(), signupRequest.getName());

    String userId = signupResponse.getUserID();

    String cookieValue = String.format("userID=%s; Path=/; Max-Age=3600; HttpOnly; SameSite=Lax", userId);

    return Response.ok(signupResponse)
      .header("Set-Cookie", cookieValue)
      .build();
  }
}
