package seg3x02.Spring_Boot_RestCalculator.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import seg3x02.Spring_Boot_RestCalculator.dto.ErrorResponse

@RestControllerAdvice
class GlobalExceptionHandler {

	@ExceptionHandler(DivisionByZeroException::class)
	fun handleDivisionByZero(ex: DivisionByZeroException): ResponseEntity<ErrorResponse> =
		badRequest(ex.message ?: "Division by zero is not allowed")

	@ExceptionHandler(MethodArgumentTypeMismatchException::class)
	fun handleTypeMismatch(ex: MethodArgumentTypeMismatchException): ResponseEntity<ErrorResponse> =
		badRequest("Parameter '${ex.name}' must be a number, but was '${ex.value}'")

	@ExceptionHandler(MissingServletRequestParameterException::class)
	fun handleMissingParameter(ex: MissingServletRequestParameterException): ResponseEntity<ErrorResponse> =
		badRequest("Required parameter '${ex.parameterName}' is missing")

	private fun badRequest(message: String): ResponseEntity<ErrorResponse> =
		ResponseEntity
			.status(HttpStatus.BAD_REQUEST)
			.body(
				ErrorResponse(
					status = HttpStatus.BAD_REQUEST.value(),
					error = HttpStatus.BAD_REQUEST.reasonPhrase,
					message = message,
				),
			)
}
