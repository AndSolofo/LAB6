# SEG3502 — Lab 6

## Spring Boot Kotlin REST Calculator

**Étudiants :**
* Andrianina Rakotobe
* Darcy Joel-Kabura

---

## Prerequisites

* **Java 17 or greater** (JDK) — the project compiles to Java 17 bytecode.
* No Gradle install is needed; the included wrapper (`./gradlew`) handles it.

*Check your version with `java -version`.*

---

## How to Run

All commands are run from the `Spring_Boot_RestCalculator/` folder.

### Run the Application
Start the local development server:
```bash
./gradlew bootRun
```
*Open [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) in your browser to view and try the API.*

### Run the Tests
Execute the unit tests (test report output is found in './build/reports/tests/test/index.html'):
```bash
./gradlew test
```

---

## API Endpoints

Each operation is a `GET` taking two query parameters, `a` and `b` :

* `/api/calculator/add`
* `/api/calculator/subtract`
* `/api/calculator/multiply`
* `/api/calculator/divide`

```bash
curl "http://localhost:8080/api/calculator/add?a=5&b=3"
```
```json
{ "operation": "add", "a": 5.0, "b": 3.0, "result": 8.0 }
```

*A division by zero, a missing operand, or a non-numeric operand returns `400` :*
```json
{ "status": 400, "error": "Bad Request", "message": "Division by zero is not allowed" }
```

---

## OpenAPI Documentation

* Swagger UI — [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
* OpenAPI JSON — [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)
