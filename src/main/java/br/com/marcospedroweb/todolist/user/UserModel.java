package br.com.marcospedroweb.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
// O lombok já "add" os getters e setters
import lombok.Data;

@Data // Para definir getters e setters
@Entity(name = "tb_users") // Torna a model uma entidade (tabela no banco)
public class UserModel {

  @Id // Informando primary key
  @GeneratedValue(generator = "UUID") // Gerador automatico do UUID
  private UUID id; // Primary key

  /*
   * @Column(name = "Usuario") // Não é necessário, ele gera automatico, porem
   * assim dá para mudar o nome
   */
  @Column(unique = true) // Column de valor unico, validaçã
  private String username;
  // @Getter e @Setter - Tambem é possivel add de forma individual, ao inves na
  // classe toda
  private String name;
  private String password;

  @CreationTimestamp // Para gerar o timestamp automatico
  private LocalDateTime createdAt;

  // // setters - adicionar valor ao atributo
  // public void setUsername(String username) {
  // this.username = username;
  // }

  // // getters - pegar atributos
  // public String getUsername() {
  // return username;
  // }

  // // setters - adicionar valor ao atributo
  // public void setName(String name) {
  // this.name = name;
  // }

  // // getters - pegar atributos
  // public String getName() {
  // return name;
  // }

  // // setters - adicionar valor ao atributo
  // public void setPassword(String password) {
  // this.password = password;
  // }

  // // getters - pegar atributos
  // public String getPassword() {
  // return password;
  // }

  // getters - pegar atributos
  // setters - adicionar valor ao atributo
}
