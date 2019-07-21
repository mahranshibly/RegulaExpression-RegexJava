# RegulaExpression-RegexJava

See attached question breaking down the basics over the naming conventions.
 

To clarify, you may choose whatever method you see proper to parse a given full name into an object with the following structure:

 

For example: Mr. David J Goldman MD

prefix: Mr.

firstName: David

middleName:    J         

lastName: Goldman

suffix: MD

 

Try to keep as simple as possible.

*We reverted to Regex to capture the relevant groups (prefix, firstName, middleName, lastName, suffix), though we do think there's some room for improvements 😊

You may use an array of regex patterns as long as the parsing is done correctly with minimum complexity.

 

Optional: The implementation can be executed by a tester that reads a txt file from FileSystem and runs each input (name convention) on your algorithm.

 




A typical name in English can have five parts
1. Prefix, a title, such as Mr. Ms. Mrs. Miss. Dr. Prof.
2. First Name (personal name)
3. Middle name, a second personal name, or a woman wishing to use her name before marriage.
   - Middle initial, usually the middle name is given as a single initial.
4. Last Name (family name)
5. Suffix, additional information on the name, examples Jr. II, III, Md. PhD. The initials of a professional degree such as BSME, Bachler of Mechanical Engineering.

#Basic patterns should be used
**First name first,**
Dr. Jane Ann Doe PhD.
Jane A. Doe
Jane Doe
**Last name first,**
Dr. Doe, Jane Ann PhD.
Doe, Jane A.
Doe, Jane
Note the comma.

In the real commas, periods and other markers may not be present. 
The following examples will help extract the parts of a name from a full name.

#Examples
Full_Name    :       Order          First-Name    Last-Name    Middle(Initial)                    notes
-----------------------------------------------------------------------------------------------------------------------------------
Jane A. Doe  :  first Middle Last   Jane          Doe           A.
Jane A Doe   :  first Middle Last   Jane          Doe           A.              despite the lack a comma the initial shows the order
Doe, Jane    :  Last first          Jane          Doe                           the comma should be after a last name when first
Doe Jane A.  :  Last First Middle   Jane          Doe           A.              The initial always comes after the first name.
Doe Jane     :  Last Middle         Doe           Jane                          Without a comma or a middle Initial one must

Guess the order.

Prefixes such as Dr., Mr., Mrs., Miss are not important and can be dropped.
Suffixes such as MD. And PhD, when used most likely refer to staff of a hospital or clinic.

Mahran Sh.
