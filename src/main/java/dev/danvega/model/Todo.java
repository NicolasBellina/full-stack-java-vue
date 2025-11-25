/*
 * Classe d'entité Todo générique.
 * Peut servir de base à toute entité persistée ; ajoutez simplement de nouveaux champs si besoin.
 * Duplicatez/rénommer ce fichier pour de futurs projets !
 */
package dev.danvega.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entité Todo - un exemple de tâche élémentaire pour projet Spring Boot générique.
 * <br>
 * Pour utiliser comme modèle :
 *  - Ajoutez vos propres champs ou méthodes
 *  - Changez le nom de la classe
 */
@Entity
public class Todo {
    /** ID interne auto-généré */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /** Intitulé de la tâche */
    private String title;
    /** Statut (complété ou non) */
    private boolean completed;

    // Exemple pour l'extension :
    // private String description;
    // private LocalDate dueDate;

    public Todo() {}

    public Todo(String title) {
        this.title = title;
        this.completed = false;
    }

    /**
     * Récupère l'identifiant
     */
    public Long getId() {
        return id;
    }

    /**
     * Récupère le titre
     */
    public String getTitle() {
        return title;
    }

    /**
     * Modifie le titre
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Statut terminé ?
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Modification du statut
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
