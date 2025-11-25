/*
 * Repository générique pour entité Spring Data JPA.
 * À dupliquer/adapter pour chaque nouvelle entité persistée.
 */
package dev.danvega.repository;

import dev.danvega.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    // Ajouter des méthodes de requête personnalisées si besoin
}
