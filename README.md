# 🐋 Configuration de la base de données (Docker)

## 1️⃣ Créer le fichier `docker-compose.yml` à la racine

```yaml
services:
  postgres:
    image: postgres:15
    container_name: my_postgres
    environment:
      POSTGRES_USER: myuser
      POSTGRES_PASSWORD: mypassword
      POSTGRES_DB: mydb
    ports:
      - "5433:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data

volumes:
  postgres_data:
  ```

## 2️⃣ Configurer src/main/resources/application.properties

# ===============================
# = DATABASE CONFIGURATION =
# ===============================
```
spring.datasource.url=jdbc:postgresql://localhost:5432/mydb
spring.datasource.username=myuser
spring.datasource.password=mypassword
spring.datasource.driver-class-name=org.postgresql.Driver
```
# ===============================
# = SERVER CONFIGURATION =
# ===============================
```
server.port=8080
```

##  3️⃣ Lancer PostgreSQL avec Docker
```
docker-compose up -d
```

Vérifie que le conteneur tourne correctement :
```
docker ps
```
Arrête les containers définis dans ton docker-compose.yml : 
```
docker-compose down
```
# 🚀 Démarrage du projet
## 🧠 Lancer le backend (Spring Boot)

Depuis la racine du projet :

```
./mvnw clean spring-boot:run
```
### 👉 Accès : http://localhost:8080

Endpoint de test :
```
GET http://localhost:8080/api/messages/hello
```

## 💻 Lancer le frontend (Vue.js)

Depuis le dossier frontend :

```
cd src/frontend
npm install
npm run serve
```

### 👉 Accès : http://localhost:3000

# full-stack-java-vue

# full-stack-java-vue
