import java.util.Random;

/**
 * The Baseball program simulates a baseball game with 9 inning and a maximun score of 4 per inning.
 *
 * @author James Liu
 * @version 1.2<P>
 * <P>
 * 4/6/2020  - version 1.0<P>
 *           - Created skeleton code.<P>
 *           - Completed constructor(), getInning(), playBall(), playMultiInnings(), totalScore()
 *             printMe(), and toString().<P>
 *           - Tested all methods for bugs and errors.<P>
 *           - Revised playMultiInnings() method.<P>
 *             <P>
 * 4/10/2020 - version 1.1
 *           - Added equals() method.<P>
 *           - Tested equals() method.<P>
 *           - Found a bug in equals() method that didn't returned expected results.<P>
 *             <P>
 * 4/11/2020 - version 1.2<P>
 *           - Fixed equals() method to return expected results.<P>
 *           - Tested equals() method for errors and bugs.<P>
 *           - Modified playBall() method to reflect more realistic scores.<P>
 *           - Reduced lines of unnecessary codes and removed chance of error by 
 *             revising playMultiInnings() method to use playBall() method.<P>
 *           - Modified toString() method to add a marker around the current inning.<P>
 *           - Tested all methods for bugs and errors, none found.<P>
 */
public class Baseball
{
    /**
     * Creates an intance varibale for the class.
     */
    private int team[] = new int[9];
    private int inning;

    /**
     * This initialize each private variable and array of the class.
     * 
     */
    public Baseball(){
        team = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        inning = -1;
    }

    /**
     * This returns the current inning of the game.
     * @return this inning
     */
    public int getInning(){ 
        return inning+1;
    }

    /**
     * This method plays a single inning for a score between 0-4 for that inning with 
     * 0 runs at 52%, 1 runs at 30%, 2 runs at 10%, 3 runs at 5%, and 4 runs at 3%.
     */
    public void playBall(){
        Random rng = new Random();
        int runs = rng.nextInt(100);
        int ball = 0;

        if (runs <= 52)
            ball = 0;
        else if (runs > 52 && runs <= 82)
            ball = 1;
        else if (runs > 82 && runs <= 92)
            ball = 2;
        else if (runs > 92 && runs <= 97)
            ball = 3;
        else if (runs > 97)
            ball = 4;

        int i = inning+1;
        team[i] = ball;
        inning++;
    }

    /**
     * This method uses playBall() to plays multiple inning for a score between 0-4 for that inning.
     * @param t this is how many innings you would like to play.
     */
    public void playMultiInnings(int t){
        for (int c = 0; c < t; c++)
            playBall();
    }

    /**
     * This adds up and returns the total scores of all innings played.
     * @return the total score.
     */
    public int totalScore(){
        int total = 0;

        for (int i = 0; i < team.length; i++)
            total += team[i];

        return total;
    }

    /**
     * This method uses the method toString to print the scores for each inning. Maining used for 
     * debugging purposes.
     */
    public void printMe(){
        System.out.print(toString());
    }

    /**
     * This method prints the current scores for each inning and returns it as a string.
     * @return this returns the scores as a string.
     */
    public String toString(){
        String msg = "";
        int i = inning;

        for (int c = 0; c < i; c++){
            msg += team[c]+" ";
        }
        if (i >= 0){
            msg += ("[" +team[i]+ "]");
        }
        for (int c = team.length-1; c > i; c--){
            msg += " 0";
        }

        return msg;
    }

    /**
     * This method checks if the scores are equal.
     * @return return true if the scores are equal, false if not.
     */
    public boolean equals(Object team2){
        if ( ! (team2 instanceof Baseball) )
            return false;
        else {
            Baseball team = (Baseball) team2;
            return (totalScore() == (team.totalScore()));
        }
    }
}
