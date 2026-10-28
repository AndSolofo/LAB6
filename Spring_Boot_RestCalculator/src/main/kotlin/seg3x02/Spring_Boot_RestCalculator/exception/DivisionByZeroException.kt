package seg3x02.Spring_Boot_RestCalculator.exception

class DivisionByZeroException(
	message: String = "Division by zero is not allowed",
) : RuntimeException(message)
