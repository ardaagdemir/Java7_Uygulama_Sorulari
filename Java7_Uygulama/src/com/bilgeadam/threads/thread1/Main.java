package com.bilgeadam.threads.thread1;

public class Main {
    public static void main(String[] args) {


        //process, thread
        //process --> Bir program bellekten, işlemci(CPU--> centrel processing unit) aracılığıyla çalıştırıldığında bu programın çalışır haldeki sürecine process denir.
        //thread --> Bir programın process aşamasına geçmesiyle arka planda bir thread oluşturulur ve buna --main thread-- denir. Artık program thread ile yürütlür.
        //multi-thread --> Process ortamındaki işin birden çok thread ile parçalara ayırarak daha kısa sürede daha çok işlem yapabilmeye yarar.

        Calisan calisan1 = new Calisan("Ahmet");
        Calisan calisan2 = new Calisan("Mehmet");

        calisan1.start();
        calisan2.start();

    }
}
