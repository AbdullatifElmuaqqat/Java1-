
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class FXDriverTest {
	CryptoManager cryptoManager;
	
	@Test
	public void testStringInBounds() {

			assertTrue(CryptoManager.isStringInBounds("COMPUTER"));
			assertTrue(CryptoManager.isStringInBounds("\"COMPUTER SCIENCE\""));
			assertFalse(CryptoManager.isStringInBounds("{ABDULLATIF"));
			assertFalse(CryptoManager.isStringInBounds("\"THIS TEST THAT SHOULD FAIL BECAUSE { IS OUTSIDE THE RANGE\""));
	}

	@Test
	public void testEncryptCaesar() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("}{?e", 11));
		assertEquals("YWE", CryptoManager.caesarEncryption("USA", 4));
		assertEquals("\"#P", CryptoManager.caesarEncryption("UVC", 77));
		assertEquals("WKLV#LV#DQRWKHU#WHVW", CryptoManager.caesarEncryption("THIS IS ANOTHER TEST", 3));
	}

	@Test
	public void testDecryptCaesar() {
		assertEquals("QJE?KNJ", CryptoManager.caesarDecryption("UNICORN",4));
		assertEquals("K==XQGMX9JGMF<", CryptoManager.caesarDecryption("SEE YOU AROUND",8));
		assertEquals("G8FGS4ABG;8ESG<@8", CryptoManager.caesarDecryption("TEST ANOTHER TIME",13 ));
	}

	@Test
	public void testEncryptBellaso() {
		
		assertEquals("L)XI[W?O(-,#VLWW", CryptoManager.bellasoEncryption("I HAVE FUN THERE", "CIPHER_IS_LONGER_THAN_THE_PLAIN_TEXT"));
		assertEquals("\\IU/,4WRR", CryptoManager.bellasoEncryption("HAPPY EID", "THE_STRING_IS_SHORT"));
		
	}

	@Test
	public void testDecryptBellaso() {
		
		assertEquals("HERE IS ANOTHER EXAMPLE", CryptoManager.bellasoDecryption("KR%H#V&#D[\"WKR%#H%TPSYX", "CMSC"));
		assertEquals("LOVE YOU", CryptoManager.bellasoDecryption("O\\)HRIBX", "CMSC203"));
	}

}
