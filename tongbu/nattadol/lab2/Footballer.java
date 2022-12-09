/**
 * This Foojtballer program is to accept three arguments: footballer name, the 
*  the nationality of the footballer, and the football club that the footballer plays.
*  Its output format is 
*  “My Favorite football player  is <athlete_name>.  
*  His nationality as <athlete_nationality>
*  He plays for <his football club>” 
*
* Author: Nattadol Tongbu
* ID: 653040445-9
* Sec: 2
* Date: December 9, 2022
*
**/
package tongbu.nattadol.lab2;
public class Footballer {
    public static void main(String[] args) {
        if (args.length == 3) {
            System.out.println("My favorite football player is " + args[0]);
            System.out.println("His nationality is " + args[1]);
            System.out.println("He plays for " + args[2]);
        }
        else {
            System.out.println("Usage: Footballer <footballer name> <nationality> <club name>");
        }
    }
}
