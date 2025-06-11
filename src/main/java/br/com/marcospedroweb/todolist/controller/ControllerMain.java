package br.com.marcospedroweb.todolist.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// Controller é um componente, fica entre a req e outras funções
import org.springframework.web.bind.annotation.GetMapping;

//@Controller // Para criar estrutura com paginas e templates (flexibilidade)
@RestController // Para Rest API e requisições
@RequestMapping("/route") // Rota da controller
public class ControllerMain {

  /*
   * GET - Buscar
   * POST - Adicionar um dado/informação
   * PUT - Atualizar um dado
   * DELETE - Remover
   * Patch - Alterar só uma parte da info
   */

  // Método de uma classe (funcionalidade)
  @GetMapping("")
  public String primeiraMensagem() {
    // String, vai retornar um string
    return "Hello world!";
  }
}
