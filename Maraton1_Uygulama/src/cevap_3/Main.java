package cevap_3;

public class Main {

	public static void main(String[] args) {
		
		HayvanatBahcesi hayvanatBahcesi = new HayvanatBahcesi();
		
		Aslan aslan1 = new Aslan("Simba", 70, 110);
		Aslan aslan2 = new Aslan("Jr.Simba", 40, 80);
		Maymun maymun1 = new Maymun("Charlie", 50, 120);
		
		Yılan yılan1 = new Yılan("Cobra", 60, 500);
		
		
		hayvanatBahcesi.memeliHayvanEkle(aslan1);
		hayvanatBahcesi.memeliHayvanEkle(aslan2);
		hayvanatBahcesi.memeliHayvanEkle(maymun1);
		hayvanatBahcesi.surungenEkle(yılan1);
		
		hayvanatBahcesi.hayvanSesCikarsin(aslan1);
		hayvanatBahcesi.hayvanSesCikarsin(maymun1);
		hayvanatBahcesi.hayvanSesCikarsin(yılan1);
		System.out.println("==========================================");
		hayvanatBahcesi.hayvaninCinsiniBul("Simba");
		hayvanatBahcesi.hayvaninCinsiniBul("Charlie");
		hayvanatBahcesi.hayvaninCinsiniBul("Cobra");
		hayvanatBahcesi.hayvaninCinsiniBul("Jr.Simbaa");
		System.out.println("==========================================");
		hayvanatBahcesi.hayvaninBilgileriniYazdir("Simba");
		hayvanatBahcesi.hayvaninBilgileriniYazdir("Charlie");
		hayvanatBahcesi.hayvaninBilgileriniYazdir("Cobra");
		System.out.println("==========================================");
		hayvanatBahcesi.hayvaniHareketEttir("Simba");
		hayvanatBahcesi.hayvaniHareketEttir("Cobra");
		hayvanatBahcesi.hayvaniHareketEttir("Charlie");
		hayvanatBahcesi.hayvaniHareketEttir("Charlieee");
	}

}
