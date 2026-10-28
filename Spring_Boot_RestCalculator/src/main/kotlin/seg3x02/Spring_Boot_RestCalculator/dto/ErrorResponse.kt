package seg3x02.Spring_Boot_RestCalculator.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Error payload returned when a request cannot be processed")
data class ErrorResponse(
	@Schema(description = "HTTP status code", example = "400")
	val status: Int,

	@Schema(description = "HTTP status reason phrase", example = "Bad Request")
	val error: String,

	@Schema(description = "Human readable explanation of what went wrong", example = "Division by zero is not allowed")
	val message: String,
)
