import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerStudentTest {

	Customer cus;
	@BeforeEach
	public void setUp() throws Exception {
		cus = new Customer("Abdullatif", 20);
	}

	@AfterEach
	public void tearDown() throws Exception {
		cus = null;
	}

	@Test
	public void testgetName() {
		assertEquals("Abdullatif", cus.getName());
	}
	
	@Test
	public void testgetAge() {
		assertEquals(20, cus.getAge());
	}
	
	@Test
	public void testtostring() {
		assertEquals("Name: Abdullatif\nAge: 20",cus.toString());
	}

}
