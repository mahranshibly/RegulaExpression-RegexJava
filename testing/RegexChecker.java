package testing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @author MahranSh.
 */
public class RegexChecker{

	public ArrayList<Person> pArrList = null ;

	private Pattern firstnameIsFirstPattern;
	private Pattern lastnameIsFirstPattern;
	private Pattern lastnameIsFirstNoCommaPattern;

	private final static String firstnameIsFirstRegex = "(?<prefix>[A-Z]{1}[a-z]{1,3}[\\.]?)?[ ]?"
			+ "(?<first>[A-Z][a-z]{1,11})\\s+"
			+ "(?<middle>\\w{1,5}[\\.]?)?[ ]?"
			+ "(?<last>[A-Z][a-z]{1,11})"
			+ "[ ]?(?<suffix>[A-Z]{1}[A-Za-z]{1,3}[\\.]?)?";

	private final static String lastnameIsFirstRegex = "(?<prefix>[A-Z]{1}[a-z]{1,3}\\.)?[ ]?"
			+ "(?<last>[A-Z][a-z]{1,11})[, ]?\\s+"
			+"(?<first>[A-Z][a-z]{1,11})" 
			+"[ ]?(?<middle>[A-Z][\\.]?[a-z]{0,3})?"
			+ "[ ]?(?<suffix>[A-Z]{1}[A-Za-z]{1,3}[\\.]?)?";

	private final static String lastnameIsFirstNoCommaRegex = "(?<prefix>[A-Z]{1}[a-z]{1,3}\\.)?[ ]?"
			+ "(?<last>[A-Z][a-z]{1,11})[, ]?\\s+"
			+"(?<first>[A-Z][a-z]{1,11})" 
			+"[ ]?(?<middle>[A-Z][\\.]?[a-z]{0,3})?( |$)"
			+ "[ ]?(?<suffix>[A-Z]{1}[A-Za-z]{1,3}[\\.]?)?";

	//  str :  NULL  >>>  "" (null to empty str!)
	private FuncInterface fixMiddleNameDot = (str)-> ( str!=null && str.length()==1 ) ? str+"." : str ;  // str :  A  >>>  A. (fix dot, middleName!)

	/**
	 * @param
	 */
	public RegexChecker() {
		this.pArrList = new ArrayList<>();
		this.firstnameIsFirstPattern = Pattern.compile(firstnameIsFirstRegex);
		lastnameIsFirstPattern = Pattern.compile(lastnameIsFirstRegex);
		lastnameIsFirstNoCommaPattern = Pattern.compile(lastnameIsFirstNoCommaRegex);
	}


	public boolean readFile(String filePath) throws IOException {

		pArrList.clear();
		FileReader fr = new FileReader(filePath);
		BufferedReader reader = new BufferedReader(fr);

		try {

			String line=null;
			while((line=reader.readLine())!=null) {

				regexChecker(line);		
			}

			return true;
		}

		catch (IOException ex) {

			ex.printStackTrace();
			return false;
		}

		finally {
			if ( reader != null ) 
				reader.close();
		}

	}

	public void regexChecker(String line) throws RegexingException{
		Person person = null;	

		person = regexingOrderBy(firstnameIsFirstPattern,line);
		if (person==null) person = regexingOrderBy(lastnameIsFirstPattern,line);
		else if (person==null) person = regexingOrderBy(lastnameIsFirstNoCommaPattern,line);

		if (person!=null) {
			pArrList.add(person);
			System.out.println( person.toString() );
		} else
			try {
				throw new RegexingException("Str : ("+line+") throw Pattern regexing exception!!!");
			}catch (RegexingException e) { e.printStackTrace(); }

	}

	public Person regexingOrderBy( Pattern pattern, String str) {

		Matcher matcher = pattern.matcher( str );
		Boolean flag = matcher.matches();

		if (flag) printStrGroups(matcher); 

		// return a person object if their is pattern match
		// else return null (no match found)!!!
		return ( flag ) ? new Person
				(matcher.group("prefix"),
						matcher.group("first"),
						fixMiddleNameDot.abstractFunc(matcher.group("middle")),
						matcher.group("last"),
						matcher.group("suffix")) : null;
	}


	private void printStrGroups (Matcher matcher) {
		System.out.println( "\n str  ("+matcher.group(0)+")\n\n"+ // full str (line from a file)
				"("+matcher.group("prefix")+  
				") ("+matcher.group("first")+
				") ("+matcher.group("middle")+
				") ("+matcher.group("last")+
				") ("+matcher.group("suffix")+")") ; 
	}

	public static void main( String args[] ) {

		RegexChecker ro = new RegexChecker();
		try {
			ro.readFile("c:\\Users\\Public\\doc_all.txt");
			//ro.readFile("c:\\Users\\Public\\doc_last_is_first_no_comma.txt");
		} 
		catch (IOException exp) {	
			exp.printStackTrace();
		} 
		/*
		 * catch (RegexingException e) { e.printStackTrace(); }
		 */
	}

}