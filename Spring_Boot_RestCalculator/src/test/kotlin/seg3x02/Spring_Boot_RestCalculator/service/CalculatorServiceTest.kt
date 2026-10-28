package seg3x02.Spring_Boot_RestCalculator.service

import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import org.junit.jupiter.api.Test
import seg3x02.Spring_Boot_RestCalculator.exception.DivisionByZeroException

class CalculatorServiceTest {

	private val service = CalculatorService()

	private val tolerance = 1e-9

	@Test
	fun `add returns the sum of both operands`() {
		assertEquals(8.0, service.add(5.0, 3.0), tolerance)
		assertEquals(-1.5, service.add(-4.0, 2.5), tolerance)
		assertEquals(0.3, service.add(0.1, 0.2), tolerance)
	}

	@Test
	fun `subtract returns the difference of both operands`() {
		assertEquals(2.0, service.subtract(5.0, 3.0), tolerance)
		assertEquals(-6.5, service.subtract(-4.0, 2.5), tolerance)
	}

	@Test
	fun `multiply returns the product of both operands`() {
		assertEquals(15.0, service.multiply(5.0, 3.0), tolerance)
		assertEquals(-10.0, service.multiply(-4.0, 2.5), tolerance)
		assertEquals(0.0, service.multiply(5.0, 0.0), tolerance)
	}

	@Test
	fun `divide returns the quotient of both operands`() {
		assertEquals(2.5, service.divide(5.0, 2.0), tolerance)
		assertEquals(-1.6, service.divide(-4.0, 2.5), tolerance)
	}

	@Test
	fun `divide rejects a zero divisor`() {
		val ex = assertFailsWith<DivisionByZeroException> { service.divide(5.0, 0.0) }
		assertEquals("Division by zero is not allowed", ex.message)
	}
}
