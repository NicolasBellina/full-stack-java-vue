# 🐋 Configuration de la base de données (Docker)

## 1️⃣ Créer le fichier `docker-compose.yml` à la racine

```yaml
services:
  postgres:
    image: postgres
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
GET http://localhost:8080/api
```

## 💻 Lancer le frontend (Vue.js)

Depuis le dossier frontend :

```
cd src/frontend
npm install
npm run dev
```

### 👉 Accès : http://localhost:3000

# 🪾 Fusion et branches: 
## 1️⃣ Création de la branche : 
```
git checkout -b feature/V1
```
👉 Cette commande crées une nouvelle branche.

## 2️⃣ Push des modifications :
```
git add .
git commit -m 'nom-du-commit'
git push
```

## 3️⃣ Va sur la branche main :
```
git checkout main
```
👉 Tu dois te placer sur la branche qui va recevoir les modifications

## 4️⃣ Mets-la à jour (équipe)

```
git pull origin main
```
👉 Sert à récupérer et intégrer les dernières modifications de la branche main (équipe).

## 5️⃣ Fusionner ta branche dans main

```
git merge feature/V1
```
👉 Fusionne le contenu de feature/V1 dans main.

## 6️⃣ Envoyer la fusion sur GitLab

```
git push origin main
```
👉 Pousse le contenu sur la branche main
## 7️⃣ Vérifier la synchro (équipe)
```
git pull origin main
```
👉 Sert à récupérer et intégrer les dernières modifications de la branche main (équipe).


# full-stack-java-vue
