/**
* This StringAPI program is to accept an argument: school name.  The program ignore all cases then it will then 
* check if the school name either contain the word "university" or "college".  if it contain the word "university".
* The output format is: "<school_name> is a university".  If it contain the word "college".
* The output format is: "<school_name> is a college".  If it doesn't contain both words.  
* The output format is "<school_name> is neither a university nor a college"
*
* Author: Nattadol Tongbu
* ID: 653040445-9
* Sec: 2
* Date: December 11, 2022
*
**/
package tongbu.nattadol.lab2;
public class StringAPI {
    public static void main(String[] args) {
        String schoolName = args[0];
        String uni = "university";
        String coll = "college";
        if (schoolName.toLowerCase().contains(uni)) {
            System.out.println(schoolName + " is a university");
        }
        else if (schoolName.toLowerCase().contains(coll)) {
            System.out.println(schoolName + " is a college");
        }
        else {
            System.out.println(schoolName + " is neither a university nor a college");
        }
    }
}