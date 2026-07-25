# Attendance Management System

A web-based attendance application built for a small organization (~40-50 employees). Employees check in and out with photo-based identity verification, and the administrator can view records, generate a monthly attendance register, and export data to Excel and Google Sheets.

> Status: in active development. See [Progress log](#progress-log) below for what's built so far.

## Features (planned)

- [ ] Employee check-in / check-out with timestamped records
- [ ] Photo-based identity verification (photo is verified in-memory and never stored)
- [ ] Daily attendance records (employee ID, name, date, check-in/out time, status)
- [ ] Monthly attendance register, print-friendly
- [ ] Export attendance data to Excel (Apache POI)
- [ ] Google Sheets integration for backup/reporting
- [ ] Admin authentication and role-based access

## Tech stack

| Layer | Technology |
|---|---|
| Backend | Java 21, Spring Boot 4.1.0 (Spring Web, Spring Data JPA, Spring Security) |
| Frontend | Thymeleaf (server-rendered HTML), CSS, JS |
| Database | MySQL |
| Build tool | Maven |

## Architecture

3-tier architecture: a Thymeleaf-rendered client layer (browser + webcam capture), a Spring Boot backend (controllers, services, security), and a MySQL data layer, with outbound integrations to Google Sheets and Excel export.

## Database design

Three tables:
- `admin_users` — admin login credentials, kept separate from employee data
- `employees` — employee master data
- `attendance` — daily check-in/check-out records, linked to `employees` via `employee_id`

Tables are generated from JPA entity classes via Hibernate (`spring.jpa.hibernate.ddl-auto=update`), not hand-written SQL.

## Getting started

### Prerequisites
- JDK 21
- Maven
- MySQL Server

### Setup
1. Clone the repo
   ```bash
   git clone https://github.com/YOUR_USERNAME/attendance-management-system.git
   ```
2. Create the database:
   ```sql
   CREATE DATABASE attendance_db;
   ```
3. Set the `DB_PASSWORD` environment variable to your MySQL password (do not hard-code it in `application.properties`).
4. Run the app:
   ```bash
   mvn spring-boot:run
   ```
5. Visit `http://localhost:8080`

## Progress log

Day-by-day development notes are kept in [`docs/day1-progress-log.docx`](docs/day1-progress-log.docx) (or linked here as the project grows).