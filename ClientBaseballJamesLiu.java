import java.util.Scanner;

/**
 * This is a tester client to test the class Baseball.
 *
 * @author James Liu
 * @version 1.2<P>
 * 
 * 4/8/2020  - version 1.0<P>
 *           - Created tester client to test Baseball.<P>
 *           - added for method to simulate a full game of baseball between 2 teams.<P>
 *           - tested for method and for bugs and errors.<P>
 *           - revised for method and added an if statement to prevent promp after the 8th inning.<P>
 *           <P>
 * 4/10/2020 - version 1.1<P>
 *           - added an if else statement to utilize equals() method in class Baseball.<P>
 *           - tested if else statement for bugs and errors.<P>
 *           <P>
 * 4/11/2020 - version 1.2<P>
 *           - Added if else statement to test the equals() method.<P>
 *           - Added if else statement to determine the winner.<P>
 *           - Added a marker around the current inning.<P>
 *           - Cleaned upformatting for terminal window.<P>
 *           - Tested client for bugs and errors, none found.<P>
 */
public class ClientBaseballJamesLiu
{
    /**
     * Tester client to test the class Baseball.
     */
    public void testBaseball(){
        String winner = "";
        Baseball t1 = new Baseball();
        Baseball t2 = new Baseball();

        String teamName1 = "Ivc";
        String teamName2 = "Uci";

        System.out.println("This is a baseball game between " +teamName1+ " and " +teamName2);
        System.out.println("To play ball, press enter");

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        for (int i = 0; i < 9; i++){
            System.out.println("Inning: " + (t1.getInning()+1));
            System.out.println("Current Scores:");
            System.out.print("-------------------------------\n|");

            int in = t1.getInning();
            for (int c = 0; c < in; c++)
                System.out.print((c+1)+" ");
            if (in >= 0)
                System.out.print("[" +(in+1)+ "]");
            for (int c = (in+2); c < 10; c++)
                System.out.print(" "+(c));

            System.out.print(" |Inning  |");

            System.out.print("\n|--------------------|--------|\n|");

            t1.playBall();
            t2.playBall();

            t1.printMe();   System.out.print(" |Team " +teamName1+ "|\n|");
            t2.printMe();   System.out.print(" |Team " +teamName2+ "|");
            System.out.println("\n-------------------------------");

            if (i < 8){
                System.out.println("\nTo play the next inning, press enter");
                input = sc.nextLine();
            }
        }

        int t1Score = t1.totalScore();
        int t2Score = t2.totalScore();

        if (t1Score > t2Score)
            winner = teamName1;
        else
            winner = teamName2;

        System.out.println("The total score for team " +teamName1+ " is "+ t1Score);
        System.out.println("The total score for team " +teamName2+ " is "+ t2Score);
        System.out.println("");

        if (t2.equals(t1) == true)
            System.out.println("The scores are tied " +t1Score+ " to " +t2Score);
        else
            System.out.println("The winner for this game is " +winner);
    }
}
