# 🚀 Portail de Suivi du Doctorat - Architecture Microservices

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.7-brightgreen)
![Spring Cloud](https://img.shields.io/badge/Spring%20Cloud-2025.0.0-blue)
![Java](https://img.shields.io/badge/Java-21-orange)
![License](https://img.shields.io/badge/License-MIT-yellow)

Plateforme moderne de gestion du parcours doctoral basée sur une architecture microservices avec Spring Boot et Spring Cloud.

---

## 📋 Table des Matières

- [À Propos](#à-propos)
- [Architecture](#architecture)
- [Technologies](#technologies)
- [Structure du Projet](#structure-du-projet)
- [Prérequis](#prérequis)
- [Installation](#installation)
- [Lancement](#lancement)
- [Documentation API](#documentation-api)
- [Roadmap](#roadmap)
- [Contribution](#contribution)
- [Licence](#licence)

---

## 🎯 À Propos

Le **Portail de Suivi du Doctorat** est une application web qui digitalise et optimise l'ensemble du parcours doctoral :

- ✅ **Gestion des utilisateurs** (doctorants, directeurs de thèse, administration)
- ✅ **Inscription et réinscription** des doctorants
- ✅ **Validation des dossiers** avec workflow automatisé
- ✅ **Suivi en temps réel** de l'avancement des dossiers

### 🎓 Projet Pédagogique

Ce projet fait partie de la série **"Architecture microservice avec Spring Boot "** sur YouTube - une formation complète sur l'architecture microservices en français.

📺 [Voir la série complète](https://youtube.com/@devbuildacademy)

---

## 🏗️ Architecture

### Vue d'Ensemble
```
                    ┌─────────────────┐
                    │   Angular App   │
                    └────────┬────────┘
                             │
                             ▼
                    ┌─────────────────┐
                    │  API Gateway    │
                    │   Port: 8080    │
                    └────────┬────────┘
                             │
              ┌──────────────┼──────────────┐
              ▼              ▼              ▼
     ┌────────────┐  ┌────────────┐  ┌────────────┐
     │   User     │  │Inscription │  │   Config   │
     │  Service   │  │  Service   │  │   Server   │
     │ Port: 8081 │  │ Port: 8082 │  │ Port: 8888 │
     └─────┬──────┘  └──────┬─────┘  └────────────┘
           │                │
           ▼                ▼
      ┌────────┐      ┌──────────┐
      │ MySQL  │      │PostgreSQL│
      └────────┘      └──────────┘
```

### Microservices

| Service | Port | Description | Base de Données |
|---------|------|-------------|-----------------|
| **Config Server** | 8888 | Configuration centralisée | - |
| **Eureka Server** | 8761 | Service Discovery | - |
| **API Gateway** | 8080 | Point d'entrée unique | - |
| **User Service** | 8081 | Gestion des utilisateurs | MySQL |
| **Inscription Service** | 8082 | Gestion des inscriptions | PostgreSQL |

---

## 🛠️ Technologies

### Backend

- **Spring Boot** 3.5.7 - Framework Java
- **Spring Cloud** 2025.0.0 - Écosystème microservices
- **Spring Cloud Config** - Configuration centralisée
- **Netflix Eureka** - Service Discovery
- **Spring Cloud Gateway** - API Gateway
- **OpenFeign** - Communication inter-services
- **Spring Data JPA** - Accès aux données
- **Lombok** - Réduction du boilerplate
- **MapStruct** - Mapping objet
- **SpringDoc OpenAPI** - Documentation API

### Frontend

- **Angular** 17.x
- **TypeScript** 5.x
- **Bootstrap** 5
- **RxJS**

### Bases de Données

- **MySQL** 8.0 - User Service
- **PostgreSQL** 15 - Inscription Service

### DevOps

- **Docker** & **Docker Compose** - Containerisation
- **GitHub Actions** - CI/CD
- **Maven** 3.9+ - Build tool

---

## 📁 Structure du Projet
```
portail-doctorat/
│
├── common-lib/              # Module partagé (DTOs, Exceptions, Utils)
├── config-server/           # Configuration centralisée
├── eureka-server/           # Service Registry
├── api-gateway/             # API Gateway
├── user-service/            # Microservice Users
├── inscription-service/     # Microservice Inscriptions
├── docker-compose.yml       # Orchestration Docker
└── pom.xml                  # Parent POM
```

---

## ✅ Prérequis

- **Java 21** (LTS)
- **Maven 3.9+**
- **Docker** & **Docker Compose**
- **Git**
- **IntelliJ IDEA** (recommandé) ou Eclipse
- **Node.js 18+** & **npm** (pour le frontend Angular)

---

## 🚀 Installation

### 1. Cloner le projet
```bash
git clone https://github.com/devbuildai/portail-doctorat.git
cd portail-doctorat
```

### 2. Build le projet
```bash
mvn clean install -DskipTests
```

### 3. Lancer les bases de données avec Docker
```bash
docker-compose up -d mysql postgres
```

---

## ▶️ Lancement

### Option 1 : Lancement manuel (développement)

**Dans l'ordre :**
```bash
# 1. Config Server
cd config-server
mvn spring-boot:run

# 2. Eureka Server
cd ../eureka-server
mvn spring-boot:run

# 3. API Gateway
cd ../api-gateway
mvn spring-boot:run

# 4. User Service
cd ../user-service
mvn spring-boot:run

# 5. Inscription Service
cd ../inscription-service
mvn spring-boot:run
```

### Option 2 : Docker Compose (production)
```bash
docker-compose up -d
```

---

## 📚 Documentation API

Une fois les services lancés :

- **User Service API** : http://localhost:8081/swagger-ui/index.html
- **Inscription Service API** : http://localhost:8082/swagger-ui/index.html
- **Eureka Dashboard** : http://localhost:8761

---

## 🗺️ Roadmap

### ✅ Phase 1 - Infrastructure (Complété)
- [x] Setup Maven multi-module
- [x] Config Server
- [x] Eureka Server
- [x] API Gateway

### 🔄 Phase 2 - Microservices (En cours)
- [x] User Service (CRUD)
- [x] Inscription Service (CRUD)
- [ ] Communication OpenFeign
- [ ] Exception Handling global

### 📅 Phase 3 - Frontend
- [ ] Angular Setup
- [ ] Login & Authentication
- [ ] Dashboard Inscriptions

### 🚀 Phase 4 - DevOps
- [ ] Dockerisation complète
- [ ] CI/CD Pipeline (GitHub Actions)
- [ ] Monitoring & Logging

---

## 🤝 Contribution

Les contributions sont les bienvenues ! Pour contribuer :

1. Forkez le projet
2. Créez une branche (`git checkout -b feature/AmazingFeature`)
3. Committez vos changements (`git commit -m 'Add AmazingFeature'`)
4. Pushez vers la branche (`git push origin feature/AmazingFeature`)
5. Ouvrez une Pull Request

---

## 📧 Contact

**DevBuild Academy** - [@devbuildacademy](https://youtube.com/@devbuildacademy)

Project Link: [https://github.com/devbuildai/portail-doctorat](https://github.com/devbuildai/portail-doctorat)

---

## 📄 Licence

Distribué sous licence MIT. Voir `LICENSE` pour plus d'informations.

---

## 🙏 Remerciements

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Cloud](https://spring.io/projects/spring-cloud)
- [Netflix OSS](https://netflix.github.io/)
- [Docker](https://www.docker.com/)

---

<p align="center">
  <b>⭐ Si ce projet vous aide, n'hésitez pas à lui donner une étoile ! ⭐</b>
</p>