import java.util.Scanner;

class Main
{
	static Scanner sc = new Scanner(System.in);
	static boolean[] penyakit = new boolean[7];

	public static void main(String[] args)
	{
		exsysTembakau();
	}

	public static void exsysTembakau()
	{
		for (int i = 0; i < 7; ++i)
			penyakit[i] = true;

		System.out.println("apakah masih berbentuk tunas?");
		System.out.println("1. ya\n2. tidak");
		int jawaban = mintaPilihan(1, 2);
		if (jawaban == 1)
			expertTunas();
		else
			expertBatangDaun();
	}

	public static int mintaPilihan(int minimum, int maksimum)
	{
		System.out.print("jawaban: ");
		int pilihan = minimum - 1;
		pilihan = sc.nextInt();
		while (pilihan < minimum || pilihan > maksimum)
		{
			System.out.println("tolong pilih dari nomor yg disediakan :)");
			System.out.print("jawaban: ");
			pilihan = sc.nextInt();
		}

		return pilihan;
	}

	public static void expertTunas()
	{
		System.out.println("apakah tunasnya tumbuh?");
		System.out.println("1. ya\n2. tidak");
		int jawaban = mintaPilihan(1, 2);
		if (jawaban == 2) {
			System.out.println("penyakit: Damping Off");
		} else {
			cekBijiMembusuk();
			cekTunasBerlekuk();
			cekTunasLembabTidakKokoh();
			cekTunasDekatPermukaanTanahRusak();
			cekBintikCoklatPadaDaun();
			cekBintikPutih();

			diagnosa();
		}
	}

	public static void expertBatangDaun()
	{
		// Batang
		cekAreaDekatPermukaanTanah();
		cekBatangLunakTidakKokoh();
		cekBatangHitamBusuk();
		cekLukaPadaBatang();
		cekBatangKecoklatan();

		// Daun
		cekBintikPutihTepianCoklat();
		cekBintikCoklat();
		cekBintikMenyebabkanKeringLayu();
		cekLukaDaun();
		cekLukaCoklatTepianHijau();
		cekBentukLukaTidakBeraturan();
		cekLukaBintikBasah();
		cekDaunLayu();
		cekDaunBercakMosaik();
		cekDaunMelepuh();
		cekDaunMengkerut();
		cekDaunMenggulung();
		cekTulangDaunBerkelok();
		cekPermukaanDaunTidakRata();
		cekDaunKakuRapuh();
		cekBungaTidakTerbentuk();

		diagnosa();
	}

	public static void cekBungaTidakTerbentuk()
	{
		boolean[] rule = {false, false, false, false, false, false, true};
		tanya(rule, "apakah bunga tidak terbentuk?");
	}

	public static void cekDaunKakuRapuh()
	{
		boolean[] rule = {false, false, false, false, false, false, true};
		tanya(rule, "apakah daun kaku dan rapuh?");
	}

	public static void cekPermukaanDaunTidakRata()
	{
		boolean[] rule = {false, false, false, false, false, false, true};
		tanya(rule, "apakah permukaan daunnya tidak rata?");
	}

	public static void cekTulangDaunBerkelok()
	{
		boolean[] rule = {false, false, false, false, false, false, true};
		tanya(rule, "apakah tulang daunnya berkelok?");
	}

	public static void cekDaunMenggulung()
	{
		boolean[] rule = {false, false, false, false, false, false, true};
		tanya(rule, "apakah daunnya menggulung ke bawah?");
	}

	public static void cekDaunMengkerut()
	{
		boolean[] rule = {false, false, false, false, false, true, false};
		tanya(rule, "apakah daunnya mengkerut?");
	}

	public static void cekDaunMelepuh() {
		boolean[] rule = {false, false, false, false, false, true, false};
		tanya(rule, "apakah daun terlihat melepuh?");
	}

	public static void cekDaunBercakMosaik() {
		boolean[] rule = {false, false, false, false, false, true, false};
		tanya(rule, "apakah daun memiliki bercak mosaik?");
	}

	public static void cekDaunLayu() {
		boolean[] rule = {false, false, false, false, true, false, false};
		tanya(rule, "apakah ada daun yang layu?");
	}

	public static void cekLukaBintikBasah() {
		boolean[] rule = {false, false, true, true, false, false, false};
		tanya(rule, "apakah ada luka/bintik basah?");
	}

	public static void cekBentukLukaTidakBeraturan() {
		boolean[] rule = {false, false, true, false, false, false, false};
		tanya(rule, "apakah ada bentuk luka tidak beraturan?");
	}

	public static void cekLukaCoklatTepianHijau() {
		boolean[] rule = {false, false, true, false, false, false, false};
		tanya(rule, "apakah ada luka coklat dengan tepian hitam?");
	}

	public static void cekLukaDaun() {
		boolean[] rule = {false, false, true, true, false, false, false};
		tanya(rule, "apakah ada luka pada daun?");
	}

	public static void cekBintikMenyebabkanKeringLayu() {
		boolean[] rule = {false, true, false, false, false, false, false};
		tanya(rule, "apakah bintik menyebabkan daun kering dan layu?");
	}

	public static void cekBintikCoklat() {
		boolean[] rule = {false, true, false, false, false, false, false};
		tanya(rule, "apakah ada bintik coklat?");
	}

	public static void cekBintikPutihTepianCoklat() {
		boolean[] rule = {false, true, false, true, false, false, false};
		tanya(rule, "apakah ada bintik putih dengan tepian coklat?");
	}

	public static void cekAreaDekatPermukaanTanah() {
		boolean[] rule = {true, false, false, false, false, false, false};
		tanya(rule, "apakah di area dekat permukaan tanah?");
	}

	public static void cekBatangLunakTidakKokoh() {
		boolean[] rule = {true, false, false, true, false, false, false};
		tanya(rule, "apakah batang lunak dan tidak kokoh?");
	}

	public static void cekBatangHitamBusuk() {
		boolean[] rule = {false, false, true, false, false, false, false};
		tanya(rule, "apakah batang hitam dan busuk?");
	}

	public static void cekLukaPadaBatang() {
		boolean[] rule = {false, false, false, true, false, false, false};
		tanya(rule, "apakah ada luka pada batang?");
	}

	public static void cekBatangKecoklatan() {
		boolean[] rule = {false, false, false, false, true, false, false};
		tanya(rule, "apakah batang berwarna kecoklatan?");
	}

	public static void diagnosa()
	{
		if (adaPenyakit())
			tampilkanPenyakit();
		else
			System.out.println("tidak ada penyakit yang cocok");
	}

	public static void cekBijiMembusuk() {
		boolean[] rule = {true, false, false, false, false, false, false};
		tanya(rule, "apakah bijinya membusuk?");
	}

	public static void cekTunasBerlekuk() {
		boolean[] rule = {true, false, false, false, false, false, false};
		tanya(rule, "apakah tunasnya berlekuk?");
	}

	public static void cekTunasLembabTidakKokoh() {
		boolean[] rule = {true, false, false, false, false, false, false};
		tanya(rule, "apakah tunasnya lembab dan tidak kokoh?");
	}

	public static void cekTunasDekatPermukaanTanahRusak() {
		boolean[] rule = {true, false, false, false, false, false, false};
		tanya(rule, "apakah tunasnya dekat permukaan tanah rusak?");
	}

	public static void cekBintikCoklatPadaDaun() {
		boolean[] rule = {false, true, false, false, false, false, false};
		tanya(rule, "apakah terdapat bintik coklat pada daun yang berukuran 2-10mm?");
	}

	public static void cekBintikPutih() {
		boolean[] rule = {false, true, false, false, false, false, false};
		tanya(rule, "apakah terdapat bintik putih yang dikelilingi tepian coklat?");
	}

	public static boolean adaPenyakit()
	{
		for (int i = 0; i < 7; ++i)
			if (penyakit[i])
				return true;
		return false;
	}

	public static void tampilkanPenyakit()
	{
		System.out.println("Berikut penyakitnya:");
		for (int i = 0; i < 7; ++i)
			if (penyakit[i])
				if (i == 0)
					System.out.println("Damping Off");
				else if (i == 1)
					System.out.println("Frog Eye Leaf");
				else if (i == 2)
					System.out.println("Leaf Blight");
				else if (i == 3)
					System.out.println("Anthracnose");
				else if (i == 4)
					System.out.println("Fusarium Wilz");
				else if (i == 5)
					System.out.println("Tobacco Mosaic");
				else if (i == 6)
					System.out.println("Tobacco Leaf Curl");
	}

	public static void tanya(boolean[] rule, String pertanyaan)
	{
		if (adaYangTrue(rule)) {
			System.out.println(pertanyaan);
			System.out.println("1. ya\n2. tidak");
			int jawaban = mintaPilihan(1, 2);
			if (jawaban == 2)
				penyakit = eliminasiYangIya(rule);
			//else
			//	penyakit = eliminasiYangTidak(rule);
		}
	}

	public static boolean adaYangTrue(boolean[] rule)
	{
		for (int i = 0; i < 7; ++i)
			if (penyakit[i] && rule[i])
				return true;
		return false;
	}

	/*
	public static boolean adaPerbedaan(boolean[] rule)
	{
		boolean penyakitPertamaYangTrue = true;
		boolean rulePatokan = false;// terserah true atau false
		for (int i = 0; i < 7; ++i)
		{
			if (penyakit[i] == true) {
				if (penyakitPertamaYangTrue) {
					rulePatokan = rule[i];
					penyakitPertamaYangTrue = false;
				} else {
					if (rulePatokan != rule[i])
						return true;
				}
			}
		}
		return false;
	}
	*/

	/*
	public static boolean[] eliminasiYangTidak(boolean[] rule)
	{
		for (int i = 0; i < 7; ++i)
			if (rule[i] == false)
				penyakit[i] = false;
		return penyakit;
	}
	*/

	public static boolean[] eliminasiYangIya(boolean[] rule)
	{
		for (int i = 0; i < 7; ++i)
			if (rule[i])
				penyakit[i] = false;
		return penyakit;
	}
}
