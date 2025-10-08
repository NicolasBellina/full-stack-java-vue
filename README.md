# Full Stack Java avec Spring Boot et Vue.js

Ce projet est une application full-stack utilisant Spring Boot pour le backend et Vue.js pour le frontend.

## Prérequis

- Java 11 (OpenJDK)
```bash
brew install openjdk@11
```

- Node.js et npm
```bash
brew install node
```

## Configuration de l'environnement

### 1. Configuration de Java 11

```bash
# Configurer Java 11 comme JDK par défaut
sudo ln -sfn /opt/homebrew/opt/openjdk@11/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk-11.jdk

# Ajouter Java 11 au PATH (à ajouter dans ~/.zshrc)
export PATH="/opt/homebrew/opt/openjdk@11/bin:$PATH"
export JAVA_HOME=$(/usr/libexec/java_home -v 11)
```

## Structure du projet

```
src/
├── frontend/          # Application Vue.js
└── main/
    └── java/         # Application Spring Boot
```

## Démarrage du projet

### Backend (Spring Boot)

```bash
# À la racine du projet
./mvnw clean spring-boot:run
```
Le backend sera accessible sur http://localhost:8080
Point d'entrée API de test : http://localhost:8080/api/messages/hello

### Frontend (Vue.js)

```bash
# Dans le dossier src/frontend
cd src/frontend

# Installation des dépendances
npm install

# Démarrage du serveur de développement
npm run serve
```
Le frontend sera accessible sur http://localhost:3000

## Construction pour la production

```bash
# À la racine du projet
./mvnw clean package
```

Cette commande va :
1. Compiler le backend Spring Boot
2. Construire le frontend Vue.js
3. Intégrer le frontend dans les ressources statiques du backend

Le fichier JAR final sera créé dans le dossier `target/`.

## API Endpoints

- GET `/api/messages/hello` : Retourne un message de bienvenue

## Notes de développement

- Le frontend est configuré avec un proxy qui redirige tous les appels `/api/**` vers le backend (port 8080)
- Le fichier de configuration du proxy se trouve dans `src/frontend/vue.config.js`
- Les tests peuvent être exécutés avec `./mvnw test`

## Dépannage

### Problèmes courants

1. Si vous obtenez une erreur de compilation Java :
   ```
   No compiler is provided in this environment
   ```
   Vérifiez que vous utilisez bien Java 11 :
   ```bash
   java -version
   javac -version
   ```

2. Si le frontend ne peut pas se connecter au backend :
   - Vérifiez que le backend est bien lancé sur le port 8080
   - Vérifiez la configuration du proxy dans `vue.config.js`

3. En cas de problèmes avec npm :
   ```bash
   # Nettoyer le cache npm
   npm cache clean --force
   # Supprimer node_modules et réinstaller
   rm -rf node_modules package-lock.json
   npm install
   ```



# full-stack-java-vue
