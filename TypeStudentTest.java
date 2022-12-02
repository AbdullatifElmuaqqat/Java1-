import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TypeStudentTest {
	
	Type type = Type.COFFEE;
	Type type1 = Type.SMOOTHIE;

	@Test
	 public void test() {
		assertEquals(type, Type.COFFEE);
		assertNotEquals(type1, Type.ALCOHOL);
	}

}
