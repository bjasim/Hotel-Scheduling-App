# Hotel-Scheduling-App

### Prerequisites

- Java 17 or higher
- Node.js and npm
- Angular CLI (`npm install -g @angular/cli`)
- MySQL Server 
- Maven
- Docker

---

### Backend Setup (Spring Boot)

1. **Clone the repository:**
   ```bash
   git clone https://github.com/bjasim/Hotel-Scheduling-App.git
   cd Hotel-Scheduling-App/backend
   ```

2. **Configure the database connection** in `src/main/resources/application.properties` if needed.

3. **Run the application:**
   - Using IntelliJ IDEA: Open the project and run the main application class.
   - Or using Maven:
     ```bash
     mvn spring-boot:run
     ```
   - Or build and run the JAR:
     ```bash
     mvn clean package
     java -jar target/your-app-name.jar
     ```

   The backend will start on `http://localhost:8080`.
   The application (both backend API and frontend UI) will be available at `http://localhost:8080`.

---

### Frontend Setup (Angular), If you want to run the frontend Seperately

1. **Navigate to the frontend directory:**
   ```bash
   cd ../frontend
   ```

2. **Install dependencies:**
   ```bash
   npm install
   ```

3. **Start the development server:**
   ```bash
   ng serve
   ```
   The frontend will be available at `http://localhost:4200`.

---

### Running with Docker

1. **Build the Docker image:**
   ```bash
   cd ../backend
   docker build -t Hotel-Scheduling-App .
   ```

2. **Run the container:**
   ```bash
   docker run -p 8080:8080 --name Hotel-Scheduling-App Hotel-Scheduling-App
   ```

---

### Accessing the Application

- **Frontend:** Open `http://localhost:4200` in your browser.
- **Backend API:** Available at `http://localhost:8080/api`.

---

## Cloud Deployment

To deploy this application to the cloud, you can use any major cloud provider that supports Docker containers, such as **Azure Container Apps**, **AWS Elastic Beanstalk**, or **Google Cloud Run**.

1. Push your Docker image to a container registry (e.g., Docker Hub or Azure Container Registry).
2. Create a container app/service in your chosen cloud provider.
3. Configure environment variables and networking as needed.
4. Deploy your container image and access your application via the provided URL.

