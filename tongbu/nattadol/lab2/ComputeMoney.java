/**
* This ComeputeMoney program is to accept four arguments: number of one thousand notes, number of five hundred notes,
* number of one hundred notes, and number of twenty notes.  The program will then calculate the total money you have 
* from each type of your notes.  The output format is: 
* "Total Money is <Total_money>"
* For example, if you have 5 one thousand notes, 2 five hundred notes, 0 one hundred notes, and 14 twenty notes.  
* Your total money then equal 6,280.0.  So in this case, the program will output as:
* "Total Money is 6,280.0"
* 
* Author: Nattadol Tongbu
* ID: 653040445-9
* Sec: 2
* Date: December 11, 2022
*
**/

package tongbu.nattadol.lab2;

public class ComputeMoney {
    public static void main(String[] args) {
        if (args.length == 4) {
            int oneThousanNotes = Integer.parseInt(args[0]);
            int fiveHundredNotes = Integer.parseInt(args[1]);
            int oneHundredNotes = Integer.parseInt(args[2]);
            int twentyNotes = Integer.parseInt(args[3]);
            double total = (oneThousanNotes*1000) + (fiveHundredNotes*500) + (oneHundredNotes*100) + (twentyNotes*20);
            System.out.println("Total Money is " + total);
        }
        else {
            System.out.println("Usage: MoneyProcessor <# of 1,000 Baht Notes> <# of 500 Baht Notes> <# of 100 Baht Notes> <# of 20 Baht Notes>");
        }
    }
}