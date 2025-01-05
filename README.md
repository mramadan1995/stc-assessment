Here is a **README.md** fileBinary for your project:

---

# **STC System Design**

## **Features**

- **Space Management**:
    - Create a space with assigned permission groups.
- **Folder Management**:
    - Create folders under spaces
- **File Management**:
    - Upload and View files (binary data like PDFs) under folders.

---

## **Technologies Used**

- **Backend**:
    - Spring Boot (3.3.4)
    - Spring Data JPA
    - PostgresSQL
    - Docker
---
## **Getting Started**

### **Requirements**

- Docker
- Docker Compose
- Java 17+
- Maven

---

### **Setup and Run**

1. **Clone the Repository**:
   ```bash
   git clone git@github.com:mramadan1995/stc-assessment.git
   cd stc-assessment
   ```

2. **Build the Application**:
   Ensure the Spring Boot JAR fileBinary is generated:
   ```bash
   mvn clean package
   ```

3. **Start the Docker Services**:
   Bring up the application and database using Docker Compose:
   ```bash
   docker-compose up --build
   ```

4. **Access the Application**:
    - **API**: `http://localhost:8080`
    - **PostgresSQL Database**: Port `5432`.

---

## **API Endpoints**

- **Swagger**: `http://localhost:8080/swagger-ui/index.html#/`
