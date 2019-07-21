package testing;

import java.io.IOException;

/**
* @author Mahran Sh.
*/
// Java8 code program to demonstrate lambda expressions, 
// A sample functional interface  
// (An interface with single abstract method).

interface FuncInterface { 
 
// An abstract function 
 String abstractFunc(String str); 

 // A non-abstract (or default) function 
 default  void readFile() throws IOException{ 
    System.out.println("..."); 
 } 
 
} 