package br.com.marcospedroweb.todolist.task;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ITaskRepository extends JpaRepository<TaskModel, UUID> {
  List<TaskModel> findByIdUser(UUID idUser); // Lista os tasks de tal usuario

  TaskModel findByIdAndIdUser(UUID id, UUID idUser);
}
