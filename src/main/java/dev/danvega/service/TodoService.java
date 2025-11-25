/*
 * Service Spring générique pour gestion d'une entité.
 * À dupliquer/adapter selon votre besoin métier !
 */
package dev.danvega.service;

import dev.danvega.model.Todo;
import dev.danvega.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service permettant la gestion métier des tâches (CRUD).
 * A dupliquer ou généraliser facilement pour d'autres entités.
 */
@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    /**
     * Récupère toutes les tâches.
     */
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    /**
     * Récupérer une tâche par ID.
     */
    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    /**
     * Crée une nouvelle tâche.
     */
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    /**
     * Met à jour une tâche existante.
     */
    public Todo updateTodo(Long id, Todo todoDetails) {
        Optional<Todo> todo = todoRepository.findById(id);
        if (todo.isPresent()) {
            Todo existingTodo = todo.get();
            existingTodo.setTitle(todoDetails.getTitle());
            existingTodo.setCompleted(todoDetails.isCompleted());
            return todoRepository.save(existingTodo);
        }
        return null;
    }

    /**
     * Supprime une tâche par ID.
     */
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
