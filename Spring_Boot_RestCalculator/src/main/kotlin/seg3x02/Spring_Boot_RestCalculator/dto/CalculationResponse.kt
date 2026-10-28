package seg3x02.Spring_Boot_RestCalculator.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Result of an arithmetic operation, echoing back the operands it was computed from")
data class CalculationResponse(
	@Schema(description = "Name of the operation that was applied", example = "add")
	val operation: String,

	@Schema(description = "First operand", example = "5.0")
	val a: Double,

	@Schema(description = "Second operand", example = "3.0")
	val b: Double,

	@Schema(description = "Computed result", example = "8.0")
	val result: Double,
)
