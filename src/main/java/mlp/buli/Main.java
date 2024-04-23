package mlp.buli;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Season season = new SeasonCsvFile("C:\\Users\\Eldin B\\Football-Bundesliga\\data\\bundesliga-1819.csv").read();
        printFootballTable(season);
    }

    private static void printFootballTable(Season season) {
        List<Team> teams = season.getTeamsSortedByRank();
        int i = 1;
        System.out.printf("    %-20s %2s %3s %4s %4s %4s %4s %4s %4s\n", "Team", "Gm", "PTs", "W", "D", "L", "GS", "GR", "GD");
        for (Team team : teams) {
            if (i > 9) {
                System.out.printf(i++ +". %-20s %2s %3s %4s %4s %4s %4s %4s %4s\n", team.getName(), 34 , team.getPoints(), team.getWins(), team.getDraws(), team.getDefeats(), team.getGoalsShot(), team.getGoalsReceived(), team.getGoalDifference());
            } else{
                System.out.printf(i++ +".  %-20s %2s %3s %4s %4s %4s %4s %4s %4s\n", team.getName(), 34 , team.getPoints(), team.getWins(), team.getDraws(), team.getDefeats(), team.getGoalsShot(), team.getGoalsReceived(), team.getGoalDifference());
            }
        }
        System.out.println("\nPts...Points, W...Won, D...Drawn, L..Lost,\n" +
                "Gs...Goals shot, GR...Goals received, GD...Goal difference\n" +
                "Gm...Games");
    }
}
