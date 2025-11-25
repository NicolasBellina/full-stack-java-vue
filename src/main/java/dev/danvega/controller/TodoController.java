/*
 * Exemple de contrôleur REST Spring générique pour gestion CRUD.
 * À dupliquer et adapter pour toute nouvelle entité de projet !
 */
package dev.danvega.controller;

import dev.danvega.model.Todo;
import dev.danvega.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {
    @Autowired
    private TodoService todoService;

    /**
     * GET /api/todo - Liste toutes les tâches.
     */
    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    /**
     * GET /api/todo/{id} - Récupère une tâche par son ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        return todoService.getTodoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * POST /api/todo - Crée une nouvelle tâche.
     */
    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }

    /**
     * PUT /api/todo/{id} - Met à jour une tâche existante.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo todoDetails) {
        Todo updatedTodo = todoService.updateTodo(id, todoDetails);
        if (updatedTodo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedTodo);
    }

    /**
     * DELETE /api/todo/{id} - Supprime une tâche par son ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.ok().build();
    }
}
