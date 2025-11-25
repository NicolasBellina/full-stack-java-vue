/*
 * Exemple de contrôleur utilitaire/annexe pour un projet Spring Boot.
 * Peut servir de base pour exposer des endpoints personnalisés simples.
 */
package dev.danvega.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin(origins = "http://localhost:3000")
public class MessageController {
    /**
     * GET /api/messages/ - Message de bienvenue générique.
     * 
     * @return String - Message de bienvenue.
     */
    @GetMapping("/")
    public String hello() {
        return "Hello from Spring Boot!";
    }

    @GetMapping("/hello")
    public String helloHello() {
        return "Full Stack Java with Spring Boot and VueJS!";
    }
}
