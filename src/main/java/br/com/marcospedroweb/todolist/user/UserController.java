package br.com.marcospedroweb.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

/*
 * Modificadores (Tipos de acesso)
 * public - todos
 * private - Só alguns atributos
 * protected - Apenas o que está dentro do package
 */
@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired // Gerenciar o ciclo de vida
  private IUserRepository userRepository;

  @PostMapping("/")
  public ResponseEntity create(@RequestBody UserModel userModel) {
    // ResponseEntity - JSON para sucess ou error no request
    // @RequestBody - Arg para acessar o body da req
    var user = this.userRepository.findByUsername(userModel.getUsername());

    if (user != null) {
      System.out.println("Usuario já existe");
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario já existe");

    }

    var passwordHashred = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());

    userModel.setPassword(passwordHashred);

    var userCreated = this.userRepository.save(userModel);
    return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
  }
}
