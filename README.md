# LAB6 — Spring Boot REST Calculator

A Spring Boot REST API exposing `add`, `subtract`, `multiply` and `divide` on two numeric
operands, documented with OpenAPI 3 (springdoc) and browsable through Swagger UI.

- **Stack:** Kotlin 2.3.21, Spring Boot 4.1.2, Gradle 9.8.2 wrapper, Java 20
- **Project root:** `Spring_Boot_RestCalculator/`

## Running

```bash
cd Spring_Boot_RestCalculator
./gradlew bootRun          # Windows: .\gradlew.bat bootRun
```

The app listens on `http://localhost:8080`.

## Endpoints

All operations are `GET` requests taking two query parameters, `a` and `b`.

| Operation | Endpoint |
| --- | --- |
| Addition | `GET /api/calculator/add?a=5&b=3` |
| Subtraction | `GET /api/calculator/subtract?a=5&b=3` |
| Multiplication | `GET /api/calculator/multiply?a=5&b=3` |
| Division | `GET /api/calculator/divide?a=6&b=3` |

### Success — `200 OK`

```bash
curl "http://localhost:8080/api/calculator/add?a=5&b=3"
```

```json
{ "operation": "add", "a": 5.0, "b": 3.0, "result": 8.0 }
```

### Error — `400 Bad Request`

Returned on division by zero, a non-numeric operand, or a missing operand.

```bash
curl -i "http://localhost:8080/api/calculator/divide?a=5&b=0"
```

```json
{ "status": 400, "error": "Bad Request", "message": "Division by zero is not allowed" }
```

## OpenAPI documentation

| Resource | URL |
| --- | --- |
| Swagger UI | <http://localhost:8080/swagger-ui.html> |
| OpenAPI JSON | <http://localhost:8080/v3/api-docs> |

## Tests

```bash
cd Spring_Boot_RestCalculator
./gradlew test             # Windows: .\gradlew.bat test
```

- `CalculatorServiceTest` — arithmetic logic and the zero-divisor guard
- `CalculatorControllerTest` — HTTP contract for all four endpoints plus the `400` error body
- `SpringBootRestCalculatorApplicationTests` — application context wiring

## Layout

```
src/main/kotlin/seg3x02/Spring_Boot_RestCalculator/
├── SpringBootRestCalculatorApplication.kt
├── config/OpenApiConfig.kt              # OpenAPI title / version / description
├── controller/CalculatorController.kt   # the four endpoints + OpenAPI annotations
├── dto/CalculationResponse.kt           # success payload
├── dto/ErrorResponse.kt                 # error payload
├── exception/DivisionByZeroException.kt
├── exception/GlobalExceptionHandler.kt  # maps failures to 400 + ErrorResponse
└── service/CalculatorService.kt         # arithmetic, free of web concerns
```
