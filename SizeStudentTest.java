import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SizeStudentTest {

	Size size = Size.LARGE;
	Size size1 = Size.SMALL;

	@Test
	public void test() {
		assertEquals(size, Size.LARGE);
		assertNotEquals(size1, Size.MEDIUM);
	}

}
