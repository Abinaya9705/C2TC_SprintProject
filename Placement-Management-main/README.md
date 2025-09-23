# Placement Management (Spring Boot)

Features:

- College signup: add departments and batches (start/end year) dynamically.
- Student signup: select college -> department -> batch dynamically via REST.
- Browse flow: view colleges -> departments -> batches -> students.
- In-memory H2 database with console at /h2-console.

Run locally (macOS):

- Ensure Java 17+ is installed (java -version)
- ./mvnw spring-boot:run

Endpoints:

- UI: /colleges/signup, /students/signup, /colleges, /colleges/{id}, /departments/{id}, /batches/{id}
- APIs: /api/colleges/{collegeId}/departments, /api/departments/{deptId}/batches

Notes:

- Tailwind CSS via CDN in layout at templates/fragments/layout.html
- Seed data is loaded on startup for demo (see DataSeeder).
