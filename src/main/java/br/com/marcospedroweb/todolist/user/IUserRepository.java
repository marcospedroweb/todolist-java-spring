package br.com.marcospedroweb.todolist.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IUserRepository extends JpaRepository<UserModel, UUID> {
  UserModel findByUsername(String username); // Busca user pelo username
}