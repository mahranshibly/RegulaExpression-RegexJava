package testing;

/**
 * @author MahranSh.
 */

public class Person implements Comparable<Person>{

	/**
	 * lambda expression
	 * @interface FuncInterface
	 */
	
	/**
	 * Class @param
	 */
	private String prefix, firstName, middleName, lastName, suffix;

	/**
	 * Default @Constructor
	 * Auto generate for Constructor, toString function, Getters & Setters 
	 * if needed :)
	 */
	public Person() {}
	
	// Constructor with expression.
	public Person(String prefix,String first,String middle,String last,String suffix) {

		//this.prefix = fixNullToEmptyStr.abstractFunc(prefix);
		this.prefix = prefix;
		this.firstName = first;
		this.middleName = middle; // double fix by lambda.
		this.lastName = last;
		this.suffix = suffix;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\nprefix(" + prefix + ")\n"+
				"\t firstName (" + firstName +")\n"+
				"\t middleName(" + middleName +")\n"+ 
				"\t lastName(" + lastName + ")\n"+
				"suffix(" + suffix +")\n\n";	
	}

	// my extra
	/**
	 * @see java.lang.Object#equals(Object o)
	 */
	@Override
    public boolean equals(Object o) {
		
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!(o instanceof Person)) { 
            return false; 
        } 
        
        Person person = (Person) o;
        return prefix.equals(person.prefix) &&
        		firstName.equals(person.firstName) &&
        		lastName.equals(person.lastName) &&
        		middleName.equals(person.middleName) &&
                suffix.equals(person.suffix);
    }

	@Override
	public int compareTo(Person arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}