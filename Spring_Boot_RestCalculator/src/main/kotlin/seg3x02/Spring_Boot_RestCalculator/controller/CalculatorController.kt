package seg3x02.Spring_Boot_RestCalculator.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import seg3x02.Spring_Boot_RestCalculator.dto.CalculationResponse
import seg3x02.Spring_Boot_RestCalculator.dto.ErrorResponse
import seg3x02.Spring_Boot_RestCalculator.service.CalculatorService

@RestController
@RequestMapping("/api/calculator", produces = [MediaType.APPLICATION_JSON_VALUE])
@Tag(name = "Calculator", description = "Basic arithmetic operations on two operands")
class CalculatorController(
	private val calculatorService: CalculatorService,
) {

	@GetMapping("/add")
	@Operation(
		summary = "Add two numbers",
		description = "Returns the sum a + b.",
	)
	@ApiResponses(
		ApiResponse(
			responseCode = "200",
			description = "The sum was computed successfully",
			content = [Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = Schema(implementation = CalculationResponse::class))],
		),
		ApiResponse(
			responseCode = "400",
			description = "One of the operands is missing or not a number",
			content = [Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = Schema(implementation = ErrorResponse::class))],
		),
	)
	fun add(
		@Parameter(description = "First operand", example = "5") @RequestParam a: Double,
		@Parameter(description = "Second operand", example = "3") @RequestParam b: Double,
	): CalculationResponse = CalculationResponse("add", a, b, calculatorService.add(a, b))

	@GetMapping("/subtract")
	@Operation(
		summary = "Subtract two numbers",
		description = "Returns the difference a - b.",
	)
	@ApiResponses(
		ApiResponse(
			responseCode = "200",
			description = "The difference was computed successfully",
			content = [Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = Schema(implementation = CalculationResponse::class))],
		),
		ApiResponse(
			responseCode = "400",
			description = "One of the operands is missing or not a number",
			content = [Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = Schema(implementation = ErrorResponse::class))],
		),
	)
	fun subtract(
		@Parameter(description = "First operand", example = "5") @RequestParam a: Double,
		@Parameter(description = "Second operand", example = "3") @RequestParam b: Double,
	): CalculationResponse = CalculationResponse("subtract", a, b, calculatorService.subtract(a, b))

	@GetMapping("/multiply")
	@Operation(
		summary = "Multiply two numbers",
		description = "Returns the product a * b.",
	)
	@ApiResponses(
		ApiResponse(
			responseCode = "200",
			description = "The product was computed successfully",
			content = [Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = Schema(implementation = CalculationResponse::class))],
		),
		ApiResponse(
			responseCode = "400",
			description = "One of the operands is missing or not a number",
			content = [Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = Schema(implementation = ErrorResponse::class))],
		),
	)
	fun multiply(
		@Parameter(description = "First operand", example = "5") @RequestParam a: Double,
		@Parameter(description = "Second operand", example = "3") @RequestParam b: Double,
	): CalculationResponse = CalculationResponse("multiply", a, b, calculatorService.multiply(a, b))

	@GetMapping("/divide")
	@Operation(
		summary = "Divide two numbers",
		description = "Returns the quotient a / b. The second operand must not be zero.",
	)
	@ApiResponses(
		ApiResponse(
			responseCode = "200",
			description = "The quotient was computed successfully",
			content = [Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = Schema(implementation = CalculationResponse::class))],
		),
		ApiResponse(
			responseCode = "400",
			description = "The second operand is zero, missing, or not a number",
			content = [Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = Schema(implementation = ErrorResponse::class))],
		),
	)
	fun divide(
		@Parameter(description = "Dividend", example = "6") @RequestParam a: Double,
		@Parameter(description = "Divisor, must not be zero", example = "3") @RequestParam b: Double,
	): CalculationResponse = CalculationResponse("divide", a, b, calculatorService.divide(a, b))
}
