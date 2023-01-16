package oop_16_Ocak_Tekrar.example2;

public class Main {
    public static void main(String[] args) {

        TeamManager teamManager = new TeamManager();

        Team team1 = new Team("Barcelona");
        Team team2 = new Team("Real Madrid");
        Team team3 = new Team("PSG");
        Team team4 = new Team("Sevilla");

        teamManager.footballMatch(team1, team2);
        teamManager.footballMatch(team1, team3);
        teamManager.footballMatch(team1, team4);

        teamManager.footballMatch(team2, team1);
        teamManager.footballMatch(team2, team3);
        teamManager.footballMatch(team2, team4);

        teamManager.footballMatch(team3, team1);
        teamManager.footballMatch(team3, team2);
        teamManager.footballMatch(team3, team4);

        teamManager.footballMatch(team4, team1);
        teamManager.footballMatch(team4, team2);
        teamManager.footballMatch(team4, team3);

        teamManager.earningStatus(team1);
        teamManager.earningStatus(team2);
        teamManager.earningStatus(team3);
        teamManager.earningStatus(team4);
        System.out.println("-------------------------------------------------------------------------------");

        Team[] teams = new Team[4];
        teams[0] = team1;
        teams[1] = team2;
        teams[2] = team3;
        teams[3] = team4;

        teamManager.pointStatus(teams);
        System.out.println("--------------------------------------------------------------------------------");
        teamManager.bankruptStatus(teams);
        System.out.println("--------------------------------------------------------------------------------");
        teamManager.champion3(teams);

    }
}
