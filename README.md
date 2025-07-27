# Project Management System (PMS)

A comprehensive Spring Boot application for managing projects, priorities, statuses, and tasks. This system helps teams organize their work, track progress, and maintain clear workflows.

## Features

### Priority Management
- Create, view, update, and delete priority levels
- Assign priorities to projects to indicate urgency and importance
- Maintain a clear hierarchy of task urgency (High, Medium, Low, Critical, etc.)

### Status Management
- Create, view, update, and delete status types
- Track the lifecycle of tasks (To Do, In Progress, Under Review, Completed, etc.)
- Improve transparency and coordination across teams

### Project Management
- Create, view, update, and delete projects
- Organize tasks within project containers
- Monitor full scope, timeline, and deliverables
- Track progress through associated tasks

### Task Management
- Create, view, update, and delete tasks
- Assign tasks to specific projects
- Set task priorities and track status changes
- Define start and end dates for better planning

## Technologies Used

- **Backend**: Java 17, Spring Boot 3.5.4
- **Database**: PostgreSQL
- **ORM**: Hibernate/JPA
- **Frontend**: Thymeleaf, Bootstrap
- **Build Tool**: Maven

## Setup and Installation

### Prerequisites
- Java 17 or higher
- PostgreSQL 12 or higher
- Maven 3.6 or higher

### Database Setup
1. Create a PostgreSQL database named `pms`
2. Update the database configuration in `src/main/resources/application.properties` if needed:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/pms
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

### Building and Running the Application
1. Clone the repository
   ```bash
   git clone https://github.com/yourusername/pms.git
   cd pms
   ```

2. Build the application
   ```bash
   mvn clean install
   ```

3. Run the application
   ```bash
   mvn spring-boot:run
   ```

4. Access the application in your browser
   ```
   http://localhost:8080
   ```

## Usage

### Managing Priorities
1. Navigate to the Priorities section
2. View existing priorities or add new ones
3. Edit or delete priorities as needed

### Managing Statuses
1. Navigate to the Statuses section
2. View existing statuses or add new ones
3. Edit or delete statuses as needed

### Managing Projects
1. Navigate to the Projects section
2. Create new projects with name, description, start/end dates, and priority
3. View, edit, or delete existing projects
4. Search projects by name or priority type

### Managing Tasks
1. Navigate to the Tasks section
2. Create new tasks with name, description, start/end dates, status, and associated project
3. View, edit, or delete existing tasks

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgements

- Spring Boot for the robust application framework
- Thymeleaf for the server-side Java template engine
- Bootstrap for the responsive front-end components