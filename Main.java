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
		//else
		//	expertBatangDaun();
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
		}
	}

	public static void cekBijiMembusuk()
	{
		boolean[] rule = {true, false, false, false, false, false, false};

		tanya(rule, "apakah bijinya membusuk?");
		cekTunasBerlekuk();
	}

	public static void cekTunasBerlekuk()
	{
		boolean[] rule = {true, false, false, false, false, false, false};
		tanya(rule, "apakah tunasnya berlekuk?");
		cekTunasLembabTidakKokoh();
	}

	public static void cekTunasLembabTidakKokoh()
	{
		boolean[] rule = {true, false, false, false, false, false, false};
		tanya(rule, "apakah tunasnya lembab dan tidak kokoh?");
		cekTunasDekatPermukaanTanahRusak();
	}

	public static void cekTunasDekatPermukaanTanahRusak()
	{
		boolean[] rule = {true, false, false, false, false, false, false};
		tanya(rule, "apakah tunasnya dekat permukaan tanah rusak?");
		cekBintikCoklatPadaDaun();
	}

	public static void cekBintikCoklatPadaDaun()
	{
		boolean[] rule = {false, true, false, false, false, false, false};
		tanya(rule, "apakah terdapat bintik coklat pada daun yang berukuran 2-10mm?");
		cekBintikPutih();
	}

	public static void cekBintikPutih()
	{
		boolean[] rule = {false, true, false, false, false, false, false};
		tanya(rule, "apakah terdapat bintik putih yang dikelilingi tepian coklat?");
		if (adaPenyakit())
			tampilkanPenyakit();
		else
			System.out.println("tidak ada penyakit yang cocok");
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
			if (jawaban == 1)
				penyakit = eliminasiYangTidak(rule);
			else
				penyakit = eliminasiYangIya(rule);
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

	public static boolean[] eliminasiYangTidak(boolean[] rule)
	{
		for (int i = 0; i < 7; ++i)
			if (rule[i] == false)
				penyakit[i] = false;

		return penyakit;
	}

	public static boolean[] eliminasiYangIya(boolean[] rule)
	{
		for (int i = 0; i < 7; ++i)
			if (rule[i])
				penyakit[i] = false;

		return penyakit;
	}
}
