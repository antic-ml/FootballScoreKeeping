import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * A program for keeping football scores, using ArrayList.
 *
 * @author Mario Gianota (gianotamario@gmail.com) 5 March 2021
 */
public class Run {

    private ArrayList<String> teamNames = new ArrayList<>();
    private ArrayList<Integer> scores = new ArrayList<>();

    public Run() {}

    public void keepScores() throws IOException {
        String teamName = "";
        while(true) {
            teamName = getTeamName();
            if( teamName.equals("") )
                break;
            teamNames.add(teamName);
            for(int i=1; i<5; i++) {
                System.out.println("Quarter #"+i);
                scores.add(getScore());
            }
        }
        showScoreBoard();
    }

    private String getTeamName() throws IOException {
        System.out.print("Team name: ");
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(System.in));
        String teamName = bufIn.readLine();
        return teamName;
    }

    private int getScore() throws IOException {
        System.out.print("Enter score: ");
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(System.in));
        String scoreStr = bufIn.readLine();
        return Integer.parseInt(scoreStr);
    }

    private void showScoreBoard() {
        System.out.println("Team name\tQ1\tQ2\tQ3\tQ4\tTotal");
        int total = 0;
        int teamIndex = 0;
        for(int i=0; i<teamNames.size(); i++) {
            System.out.print(teamNames.get(i) + "\t");
            total = 0;
            for(int j=0; j<4; j++) {
                System.out.print(scores.get(j+teamIndex) + "\t");
                total += scores.get(j+teamIndex);
            }
            System.out.println(total);
            teamIndex += 4;
        }
        System.out.println();
    }
    public static void main(String[] args) throws IOException {
        Run r = new Run();
        r.keepScores();
    }
}
