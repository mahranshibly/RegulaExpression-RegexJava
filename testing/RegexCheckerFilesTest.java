package testing;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;

import org.junit.Before;
import org.junit.jupiter.api.Test;
/**
 * @author MahranSh.
 */
class RegexCheckerFilesTest {
	
	RegexChecker testA;
	RegexChecker testB;
	RegexChecker testC;
	RegexChecker testD;
	
	@Before
    public void setUp(){
		
		testA = new RegexChecker();
		testB = new RegexChecker();
		testC = new RegexChecker();
		testD = new RegexChecker();
		
		testC.pArrList.clear();
		testD.pArrList.clear();
		testA.pArrList.clear();
		testB.pArrList.clear();
    }
	
	@Test
	void test() throws IOException, RegexingException {
		
		setUp();
		
		 
		assertNotNull(testA.pArrList);
		assertEquals(0, testA.pArrList.size());
		assertEquals(true, testA.readFile("c:\\Users\\Public\\doc_all.txt"));
		assertEquals(32, testA.pArrList.size());

		////////////////////////////////////////////////////////////////////////////////////////
		
		
		assertNotNull(testB.pArrList);
		assertEquals(0, testB.pArrList.size());
		assertEquals(true, testB.readFile("c:\\Users\\Public\\doc_first_is_first.txt"));
		//assertEquals(16, testB.pArrList.size());
		
		
		assertNotNull(testC.pArrList);
		assertEquals(0, testC.pArrList.size());
		assertEquals(true, testC.readFile("c:\\Users\\Public\\doc_last_is_first.txt"));
		//assertEquals(16, testC.pArrList.size());
		
		
		int i=0;
		for (Person info : testC.pArrList) {
			assertTrue(  ((Person)info).equals((Person)testB.pArrList.get(i++) ) );
		}
		
		assertTrue(testC.pArrList.size()==testB.pArrList.size());
		assertTrue(testC.pArrList.equals(testB.pArrList));
		assertTrue(testB.pArrList.equals(testC.pArrList));
		 
		/*
		assertNotNull(testD.pArrList);
		assertEquals(0, testD.pArrList.size());
		assertEquals(true, testD.readFile("c:\\Users\\Public\\doc_last_is_first_no_comma.txt"));
		assertEquals(19, testD.pArrList.size());
		*/
	}

	
}