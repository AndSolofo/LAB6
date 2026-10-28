package seg3x02.Spring_Boot_RestCalculator.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest
import org.springframework.context.annotation.Import
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import seg3x02.Spring_Boot_RestCalculator.service.CalculatorService

@WebMvcTest(CalculatorController::class)
@Import(CalculatorService::class)
class CalculatorControllerTest {

	@Autowired
	private lateinit var mockMvc: MockMvc

	@Test
	fun `add returns the sum`() {
		mockMvc.perform(get("/api/calculator/add").param("a", "5").param("b", "3"))
			.andExpect(status().isOk)
			.andExpect(jsonPath("$.operation").value("add"))
			.andExpect(jsonPath("$.a").value(5.0))
			.andExpect(jsonPath("$.b").value(3.0))
			.andExpect(jsonPath("$.result").value(8.0))
	}

	@Test
	fun `subtract returns the difference`() {
		mockMvc.perform(get("/api/calculator/subtract").param("a", "5").param("b", "3"))
			.andExpect(status().isOk)
			.andExpect(jsonPath("$.operation").value("subtract"))
			.andExpect(jsonPath("$.result").value(2.0))
	}

	@Test
	fun `multiply returns the product`() {
		mockMvc.perform(get("/api/calculator/multiply").param("a", "5").param("b", "3"))
			.andExpect(status().isOk)
			.andExpect(jsonPath("$.operation").value("multiply"))
			.andExpect(jsonPath("$.result").value(15.0))
	}

	@Test
	fun `divide returns the quotient`() {
		mockMvc.perform(get("/api/calculator/divide").param("a", "5").param("b", "2"))
			.andExpect(status().isOk)
			.andExpect(jsonPath("$.operation").value("divide"))
			.andExpect(jsonPath("$.result").value(2.5))
	}

	@Test
	fun `divide by zero returns 400 with an error body`() {
		mockMvc.perform(get("/api/calculator/divide").param("a", "1").param("b", "0"))
			.andExpect(status().isBadRequest)
			.andExpect(jsonPath("$.status").value(400))
			.andExpect(jsonPath("$.error").value("Bad Request"))
			.andExpect(jsonPath("$.message").value("Division by zero is not allowed"))
	}

	@Test
	fun `a non numeric operand returns 400 with an error body`() {
		mockMvc.perform(get("/api/calculator/add").param("a", "abc").param("b", "2"))
			.andExpect(status().isBadRequest)
			.andExpect(jsonPath("$.status").value(400))
			.andExpect(jsonPath("$.message").exists())
	}

	@Test
	fun `a missing operand returns 400 with an error body`() {
		mockMvc.perform(get("/api/calculator/add").param("a", "2"))
			.andExpect(status().isBadRequest)
			.andExpect(jsonPath("$.status").value(400))
			.andExpect(jsonPath("$.message").exists())
	}
}
