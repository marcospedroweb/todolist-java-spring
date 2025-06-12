package br.com.marcospedroweb.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.marcospedroweb.todolist.user.IUserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component // Precisa colocar isso para que o Spring gerencie
public class FilterTaskAuth extends OncePerRequestFilter {

  @Autowired
  private IUserRepository userRepository;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    // Pega a autenticação (usuario e senha)
    var authorization = request.getHeader("Authorization");

    // extrai parte de texto
    var authEncoded = authorization.substring("Basic".length()).trim();

    // Converte a senha para array de byte
    byte[] authDecode = Base64.getDecoder().decode(authEncoded);

    // usuario:senha
    var authString = new String(authDecode);

    String[] credentials = authString.split(":");

    String username = credentials[0];
    String password = credentials[1];

    // Validando usuario
    var user = this.userRepository.findByUsername(username);
    if (user == null) {
      response.sendError(401, "Usuario sem autorização");
    } else {
      var passwordVerify = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
      if (passwordVerify.verified) {
        filterChain.doFilter(request, response);
      } else {
        response.sendError(401);
      }

    }

  }

}
