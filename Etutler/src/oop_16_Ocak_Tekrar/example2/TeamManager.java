package oop_16_Ocak_Tekrar.example2;

import java.util.Random;

public class TeamManager {

    //iki takım maç yapacak, 3 adet durum var
    //1-> galibiyet, 2->beraberlik 3-> malubiyet
    //Kazanan ve berabere kalan takımların kazandıkları bir ücret olacak
    //Beraberlik için ücret --> 5000, Galibiyet için ücret --> 10000

    public void footballMatch(Team team1, Team team2) {
        Random random = new Random();
        int status = random.nextInt(3);

        if (status == 1) {
            team1.setEarning(team1.getEarning() + 10000);
            team1.setPoint(team1.getPoint() + 3);
            System.out.println(team1.getName() + ", " + team2.getName() + " e karşı maçı kazanmıştır.");
        } else if (status == 2) {
            team2.setPoint(team2.getPoint() + 3);
            team2.setEarning(team2.getEarning() + 10000);
            System.out.println(team2.getName() + ", " + team1.getName() + " e karşı maçı kazanmıştır.");
        } else {
            team1.setPoint(team1.getPoint() + 1);
            team1.setEarning(team1.getEarning() + 5000);
            team2.setPoint(team2.getPoint() + 1);
            team2.setEarning(team2.getEarning() + 5000);
            System.out.println(team1.getName() + " ve " + team2.getName() + " berabere kalmıştır.");
        }
        System.out.println("--------------------------------------------------------------------------");
    }

    public void earningStatus(Team team) {
        System.out.println(team.getName() + " Earning: " + team.getEarning());
    }

    //pointStatus --> puan durumunu gösteren bir metot yazınız, bu metot bütün takımların puanlarını göstersin(sout içerisinde tek tek yazdırılmamalıdır)
    //bankruptStatus --> iflas eden takımları gösteren metot, takımın kazancı 5000 altındaysa iflas etmiştir
    //champion --> şampiyon olan takımı gösteren metot, en büyük puana sahip takıp şampiyondur

    public void pointStatus(Team[] teams) {
        System.out.println("Puan Durumu");
        for (int i = 0; i < teams.length; i++) {
            System.out.println(teams[i].getName() + " Puan: " + teams[i].getPoint());
        }
    }

    public void bankruptStatus(Team[] teams) {
        //Emre Kazancı
        /*for (Team item : teams){
            if (item.getEarning() <= 15000){
                System.out.println(item.getName() + " iflas etmiştir." + " Kazanç: " + item.getEarning());
            }
            else {
                System.out.println("İflas eden takım bulunmamaktadır.");
                break;
            }
        }*/

        //Mücahit Doğan
        int count = 0;
        for (int i = 0; i < teams.length; i++) {
            if (teams[i].getEarning() < 30000) {
                System.out.println(teams[i].getName() + " iflas etmiştir");
                count++;
            }
        }
        if (count == 0) {
            System.out.println("İflas eden takım yoktur.");
        }
    }

    //T.C Orkun
    public Team champion1(Team[] teams) {

        Team champion = teams[0];
        for (int i = 1; i< teams.length; i++){
            if (teams[i].getPoint() > champion.getPoint()){
                champion = teams[i];
            }
        }
        System.out.println("Şampiyon: " + champion.getName());
        return champion;
    }

    //Tunç Cenk Ergüven
    public void champion2(Team[] teams){
        //champion-- > şampiyon olan takımı gösteren metot Team team = new Team(null);
        Team team = new Team(null);
        for (int i = 0; i < teams.length; i++) {
            for (int j = 1; j < teams.length; j++) {
                if (teams[i].getPoint() > teams[j].getPoint()) {
                    if (team.getPoint() < teams[i].getPoint()) {
                        team = teams[i];
                    }
                }
            }
        }
        System.out.println("Şampiyon : " + team.getName());
    }

    //Enes Doğanoğlu
    public void champion3(Team[] teams){
        //Emre-Mücahit
        //Bubble sort
        Team champion = null;
        int count = 0;
        for (int i = 0; i < teams.length; i++) { //i=3
            for (int j = 3; j >= 0; j--) {//j=3
                if (teams[i].getPoint() > teams[j].getPoint()) {
                    count++;
                    champion = teams[i];
                    if (count == 3) {
                        System.out.println("Şampiyon: " + champion.getName());
                    }
                }
            }
            count = 0;
        }
    }
}
