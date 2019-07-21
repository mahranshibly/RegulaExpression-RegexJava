package testing;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import static testing.RegexChecker.regexCheckerBy;
import static testing.RegexChecker.firstnameIsFirstPattern;
import static testing.RegexChecker.lastnameIsFirstPattern;
//import static testing.RegexChecker.lastnameIsFirstP;
/**
 * @author MahranSh.
 */
class RegexCheckerPatternsTest {

	private RegexChecker test;
	
	@Before
    public void setUpBeforeTest() throws Exception {
		test = new RegexChecker();
    }

	
	@Test //1/ first-name is first, without prefix & without suffix
	public void noPrefixNoSuffixRegexingWithFirstnameIsFirstPattern() {

		System.err.println("first-name is first, without pre/suf -fix");
		
		assertTrue(((Person)regexCheckerBy(firstnameIsFirstPattern,"Jane Ann Doe")).equals( 
				new Person("", "Jane","Ann", "Doe", "")));

		assertTrue(((Person)regexCheckerBy(firstnameIsFirstPattern,"Jane A. Doe")).equals( 
				new Person("", "Jane","A.", "Doe", "")));

		assertTrue(((Person)regexCheckerBy(firstnameIsFirstPattern,"Jane A Doe")).equals( 
				new Person("", "Jane","A", "Doe", "")));
		
		assertTrue(((Person)regexCheckerBy(firstnameIsFirstPattern,"Jane Doe")).equals( 
				new Person("", "Jane","", "Doe", "")));

	}

	
	@Test //2/ last-name is first, without prefix & without suffix
	public void noPrefixNoSuffixRegexingWithLastnameIsFirstPattern() {

		System.err.println("last-name is first, without pre/suf -fix");
		assertTrue(((Person)regexCheckerBy(lastnameIsFirstPattern,"Doe, Jane Ann")).equals( 
				new Person("", "Jane","Ann", "Doe", "")));

		assertTrue(((Person)regexCheckerBy(lastnameIsFirstPattern,"Doe, Jane A.")).equals( 
				new Person("", "Jane","A.", "Doe", "")));

		assertTrue(((Person)regexCheckerBy(lastnameIsFirstPattern,"Doe, Jane A")).equals( 
				new Person("", "Jane","A", "Doe", "")));
		
		assertTrue(((Person)regexCheckerBy(lastnameIsFirstPattern,"Doe, Jane")).equals( 
				new Person("", "Jane","", "Doe", "")));

	}
	
	
	@Test //3/ first-name is first, with prefix & without suffix
	public void onlyPrefixNoSuffixRegexingWithFirstnameIsFirstPattern() {

		System.err.println("first-name is first, with prefix only");
		
		assertTrue(((Person)regexCheckerBy(firstnameIsFirstPattern,"Dr. Jane Ann Doe")).equals( 
				new Person("Dr.", "Jane","Ann", "Doe", "")));

		assertTrue(((Person)regexCheckerBy(firstnameIsFirstPattern,"Miss. Jane A. Doe")).equals( 
				new Person("Miss.", "Jane","A.", "Doe", "")));

		assertTrue(((Person)regexCheckerBy(firstnameIsFirstPattern,"Mrs. Jane A Doe")).equals( 
				new Person("Mrs.", "Jane","A", "Doe", "")));

		assertTrue(((Person)regexCheckerBy(firstnameIsFirstPattern,"Prof. Jane Doe")).equals( 
				new Person("Prof.", "Jane","", "Doe", "")));
	}

	
	@Test //4/ last-name is first, with prefix & without suffix
	public void onlyPrefixNoSuffixRegexingWithLastnameIsFirstPattern() {

		System.err.println("last-name is first, with prefix only");
		
		assertTrue(((Person)regexCheckerBy(lastnameIsFirstPattern,"Miss. Doe, Jane Ann")).equals( 
				new Person("Miss.", "Jane","Ann", "Doe", "")));

		assertTrue(((Person)regexCheckerBy(lastnameIsFirstPattern,"Ms. Doe, Jane A.")).equals( 
				new Person("Ms.", "Jane","A.", "Doe", "")));

		assertTrue(((Person)regexCheckerBy(lastnameIsFirstPattern,"Mr. Doe, Jane A")).equals( 
				new Person("Mr.", "Jane","A", "Doe", "")));

		assertTrue(((Person)regexCheckerBy(lastnameIsFirstPattern,"Dr. Doe, Jane")).equals( 
				new Person("Dr.", "Jane","", "Doe", "")));
	}
	
	
	@Test //5/ first-name is first, without prefix & with suffix
	public void noPrefixOnlysuffixRegexingWithFirstnameIsFirstPattern() {

		System.err.println("first-name is first, with suffix only");
		
		assertTrue(((Person)regexCheckerBy(firstnameIsFirstPattern,"Jane Ann Doe Jr.")).equals( 
				new Person("", "Jane","Ann", "Doe", "Jr.")));

		assertTrue(((Person)regexCheckerBy(firstnameIsFirstPattern,"Jane A. Doe PhD.")).equals( 
				new Person("", "Jane","A.", "Doe", "PhD.")));

		assertTrue(((Person)regexCheckerBy(firstnameIsFirstPattern,"Jane A Doe II")).equals( 
				new Person("", "Jane","A", "Doe", "II")));

		assertTrue(((Person)regexCheckerBy(firstnameIsFirstPattern,"Jane Doe III")).equals( 
				new Person("", "Jane","", "Doe", "III")));

	}

	
	@Test //6/ last-name is first, without prefix &  with suffix
	public void noPrefixOnlySuffixRegexingWithLastnameIsFirstPattern() {

		System.err.println("last-name is first, with suffix only");
		
		assertTrue(((Person)regexCheckerBy(lastnameIsFirstPattern,"Doe, Jane Ann BSME")).equals( 
				new Person("", "Jane","Ann", "Doe", "BSME")));

		assertTrue(((Person)regexCheckerBy(lastnameIsFirstPattern,"Doe, Jane A. BSC")).equals( 
				new Person("", "Jane","A.", "Doe", "BSC")));

		assertTrue(((Person)regexCheckerBy(lastnameIsFirstPattern,"Doe, Jane A Md.")).equals( 
				new Person("", "Jane","A", "Doe", "Md.")));

		assertTrue(((Person)regexCheckerBy(lastnameIsFirstPattern,"Doe, Jane BA")).equals( 
				new Person("", "Jane","", "Doe", "BA")));

	}
	
	
	@Test //7/ first-name is first, with prefix & suffix
	public void withSuffixAndPrefixRegexingWithFirstnameIsFirstPattern() {

		System.err.println("first-name is first, with prefix & suffix");
		
		assertTrue(((Person)regexCheckerBy(firstnameIsFirstPattern,"Miss. Jane Doe BA")).equals( 
				new Person("Miss.", "Jane","", "Doe", "BA")));

		assertTrue(((Person)regexCheckerBy(firstnameIsFirstPattern,"Prof. Jane Ann Doe Jr.")).equals( 
				new Person("Prof.", "Jane","Ann", "Doe", "Jr.")));

		assertTrue(((Person)regexCheckerBy(firstnameIsFirstPattern,"Ms. Jane A. Doe BSC")).equals( 
				new Person("Ms.", "Jane","A.", "Doe", "BSC")));

		assertTrue(((Person)regexCheckerBy(firstnameIsFirstPattern,"Mr. Jane A Doe PhD.")).equals( 
				new Person("Mr.", "Jane","A", "Doe", "PhD.")));

	}

	
	@Test //8/ last-name is first, with prefix & suffix
	public void withSffixAndPrefixRegexingWithLastnameIsFirstPattern() {

		System.err.println("last-name is first, with prefix & suffix");
		
		assertTrue(((Person)regexCheckerBy(lastnameIsFirstPattern,"Mr. Doe, Jane BA")).equals( 
				new Person("Mr.", "Jane","", "Doe", "BA")));

		assertTrue(((Person)regexCheckerBy(lastnameIsFirstPattern,"Ms. Doe, Jane Ann BSC")).equals( 
				new Person("Ms.", "Jane","Ann", "Doe", "BSC")));

		assertTrue(((Person)regexCheckerBy(lastnameIsFirstPattern,"Mrs. Doe, Jane A. II")).equals( 
				new Person("Mrs.", "Jane","A.", "Doe", "II")));

		assertTrue(((Person)regexCheckerBy(lastnameIsFirstPattern,"Dr. Doe, Jane A III")).equals( 
				new Person("Dr.", "Jane","A", "Doe", "III")));

	}
	
	
	
	@Test //9/ last-name is first, without comma
	public void lastFirstMidNoCommaRegexingWithLastnameIsFirstPattern() {

		System.err.println("last>first>mid-name, without comma");
		
		assertTrue(((Person)regexCheckerBy(lastnameIsFirstPattern,"Doe Jane A")).equals( 
				new Person("", "Jane","A.", "Doe", "")));

		assertTrue(((Person)regexCheckerBy(lastnameIsFirstPattern,"Doe Jane A.")).equals( 
				new Person("", "Jane","A.", "Doe", "")));
		
		assertTrue(((Person)regexCheckerBy(lastnameIsFirstPattern,"Doe Jane Ann")).equals( 
				new Person("", "Jane","Ann", "Doe", "")));
		
		
		assertTrue(((Person)regexCheckerBy(firstnameIsFirstPattern,"Doe Jane")).equals( 
				new Person("", "Doe","", "Jane", "")));
		
		assertTrue(((Person)regexCheckerBy(lastnameIsFirstPattern,"Doe Jane")).equals( 
				new Person("", "Jane","", "Doe", "")));
	}
	
	@Test //10/ last-name is first, without comma
	public void complexRegexing() {

		System.err.println("complex regexing");

		assertTrue(((Person)regexCheckerBy(firstnameIsFirstPattern,"Jane Doe BSME")).equals( 
				new Person("", "Jane","", "Doe", "BSME")));
		
		assertTrue(((Person)regexCheckerBy(firstnameIsFirstPattern,"Jane A Doe BSME")).equals( 
				new Person("", "Jane","A.", "Doe", "BSME")));
		
		assertTrue(((Person)regexCheckerBy(firstnameIsFirstPattern,"Jane A. Doe BSME")).equals( 
				new Person("", "Jane","A.", "Doe", "BSME")));
		
		assertTrue(((Person)regexCheckerBy(firstnameIsFirstPattern,"Jane Ann Doe BSME")).equals( 
				new Person("", "Jane","Ann", "Doe", "BSME")));
		
		assertTrue(((Person)regexCheckerBy(lastnameIsFirstPattern,"Doe, Jane A BSME")).equals( 
				new Person("", "Jane","A.", "Doe", "BSME")));

		assertTrue(((Person)regexCheckerBy(lastnameIsFirstPattern,"Doe, Jane A. BSME")).equals( 
				new Person("", "Jane","A.", "Doe", "BSME")));

		assertTrue(((Person)regexCheckerBy(lastnameIsFirstPattern,"Doe, Jane Ann BSME")).equals( 
				new Person("", "Jane","Ann", "Doe", "BSME")));

		assertTrue(((Person)regexCheckerBy(firstnameIsFirstPattern,"Jane Doe BSME")).equals( 
				new Person("", "Jane","", "Doe", "BSME")));
		
		assertTrue(((Person)regexCheckerBy(lastnameIsFirstPattern,"Doe, Jane BSME")).equals( 
				new Person("", "Jane","", "Doe", "BSME")));
		
		
		
	}
	
}