package oop_16_Ocak_Tekrar.example2;

import java.util.Random;

public class TeamManager {

    //iki takım maç yapacak, 3 adet durum var
    //1-> galibiyet, 2->beraberlik 3-> malubiyet
    //Kazanan ve berabere kalan takımların kazandıkları bir ücret olacak
    //Beraberlik için ücret --> 5000, Galibiyet için ücret --> 10000

    public void footballMatch(Team team1, Team team2){
        Random random = new Random();
        int status = random.nextInt(3);

        if(status == 1){
            team1.setEarning(team1.getEarning() + 10000);
            team1.setPoint(team1.getPoint() + 3);
            System.out.println(team1.getName() + ", " + team2.getName() + " e karşı maçı kazanmıştır.");
        }
        else if (status == 2){
            team2.setPoint(team2.getPoint() + 3);
            team2.setEarning(team2.getEarning() + 10000);
            System.out.println(team2.getName() + ", " + team1.getName() + " e karşı maçı kazanmıştır.");
        }
        else {
            team1.setPoint(team1.getPoint() + 1);
            team1.setEarning(team1.getEarning() + 5000);
            team2.setPoint(team2.getPoint() + 1);
            team2.setEarning(team2.getEarning() + 5000);
            System.out.println(team1.getName() + " ve " + team2.getName() + " berabere kalmıştır.");
        }
        System.out.println("--------------------------------------------------------------------------");
    }

    public void earningStatus(Team team){
        System.out.println(team.getName() + " Earning: " + team.getEarning());
    }

    //pointStatus --> puan durumunu gösteren bir metot yazınız, bu metot bütün takımların puanlarını göstersin(sout içerisinde tek tek yazdırılmamalıdır)
    //bankruptStatus --> iflas eden takımları gösteren metot, takımın kazancı 5000 altındaysa iflas etmiştir
    //champion --> şampiyon olan takımı gösteren metot, en büyük puana sahip takıp şampiyondur

    //11:48
}
