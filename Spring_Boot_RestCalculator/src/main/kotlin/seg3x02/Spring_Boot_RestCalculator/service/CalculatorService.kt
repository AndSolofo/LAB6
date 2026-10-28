package seg3x02.Spring_Boot_RestCalculator.service

import org.springframework.stereotype.Service
import seg3x02.Spring_Boot_RestCalculator.exception.DivisionByZeroException

@Service
class CalculatorService {

	fun add(a: Double, b: Double): Double = a + b

	fun subtract(a: Double, b: Double): Double = a - b

	fun multiply(a: Double, b: Double): Double = a * b

	fun divide(a: Double, b: Double): Double {
		if (b == 0.0) {
			throw DivisionByZeroException()
		}
		return a / b
	}
}
