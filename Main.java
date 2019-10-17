import java.util.Scanner;

class Main
{
	static Scanner sc = new Scanner(System.in);
	static boolean[] penyakit = new boolean[7];
	static boolean[] gejalaDitemukan = new boolean[7];

	public static void main(String[] args)
	{
		exsysTembakau();
	}

	public static void exsysTembakau()
	{
		for (int i = 0; i < 7; ++i) {
			penyakit[i] = true;
			gejalaDitemukan[i] = false;
		}

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
			System.out.println(
				"penyakit:\nDamping Off" +
				"\n\tTidak bisa disembuhkan, tetapi bisa dicegah dengan cara menjaga sirkulasi udara di tempat pembibitan selalu baik. Supaya sirkulasi udara bagus, bisa diberi kipas angin kecil, atau pastikan tempat pembibitan tidak tergenang air."
			);
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
		cekBatangHitamBusuk();
		cekBatangKecoklatan();
		cekBatangLunakTidakKokoh();
		cekLukaPadaBatang();

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
			if (penyakit[i] && gejalaDitemukan[i])
				return true;
		return false;
	}

	public static void tampilkanPenyakit()
	{
		System.out.println("Berikut penyakitnya:");
		for (int i = 0; i < 7; ++i)
			if (penyakit[i] && gejalaDitemukan[i])
				if (i == 0)
					System.out.println(
						"\nDamping Off" +
						"\n\tTidak bisa disembuhkan, tetapi bisa dicegah dengan cara menjaga sirkulasi udara di tempat pembibitan selalu baik. Supaya sirkulasi udara bagus, bisa diberi kipas angin kecil, atau pastikan tempat pembibitan tidak tergenang air."
					);
				else if (i == 1)
					System.out.println(
						"\nFrog Eye Leaf" +
						"\n\t- Daun yang telah terinfeksi harus dipotong agar tidak menyebar ke daun lainnya." +
						"\n\t- Pemberian pupuk harus seimbang, karena pemberian pupuk yang berlebihan juga meningkatkan probabilitas terkena penyakit ini." +
						"\n\t- Jika diperlukan gunakan fungisida seperti mancozeb, copper atau chlorothanonil."
					);
				else if (i == 2)
					System.out.println(
						"\nLeaf Blight" +
						"\n\t- Fungsida yang digunakan perpaduan dari Orondis Gold 200 +  Oxathiapiprolin 18.7%" +
						"\n\t- Pemupukan dan irigasi haruslah dikelola dengan baik." +
						"\n\t- Peralatan kebun yg digunakan pada tumbuhan yang terinfeksi harus dibersihkan terlebih dahulu sebelum digunakan ke tumbuhan yang sehat."
					);
				else if (i == 3)
					System.out.println(
						"\nAnthracnose" +
						"\n\t- Singkirkan tumbuhan yang terinfeksi." +
						"\n\t- Semprotkan cooper-based fungisida." +
						"\n\t- Tanam tumbuhan di tanah yang pengairan nya bagus."
					);
				else if (i == 4)
					System.out.println(
						"\nFusarium Wilz" +
						"\n\t- Hilangkan bagian yang terinfeksi, tools yang digunakan harus steril." +
						"\n\t- Gunakan pupuk yang kadar nitrogennya tidak terlalu tinggi." +
						"\n\t- Gunakan fungisida Mycostop."
					);
				else if (i == 5)
					System.out.println(
						"\nTobacco Mosaic" +
						"\n\t- Menghindari lahan bekas tanaman inang yang terserang penyakit tmv." +
						"\n\t- Melakukan sanitasi, bertujuan membersihkan inokulan dengan mencabut tanaman yg sakit, tanamam inang lain dan membersihkan peralatan." +
						"\n\t- Rotasi dengan tanamam bukan inang, Penyemprotan vektor dengan insektisida." +
						"\n\t- Pembersihan gulma juga mampu menekan tmv."
					);
				else if (i == 6)
					System.out.println(
						"\nTobacco Leaf Curl" +
						"\n\t- Mengendalikan serangga vektor, misalnya dengan asefat atau imidakloprit 2x (saat tanam dan 45 hari setelah tanam)." +
						"\n\t- Menanam bunga matahari atau jarak kepyar sebagai pagar pembatas di sekitar bedengan untuk mencegah B. tabaci." +
						"\n\t- Memilih varietas-varietas yang tahan akan penyakit TLCV." +
						"\n\t- Pemberian abu sekam, abu tomang atau tepung sisa bakaran arang pada lahan pembibitan atau lahan tanam dimaksudkan untuk menghambat penyebaran penyakit ini."
					);
	}

	public static void tanya(boolean[] rule, String pertanyaan)
	{
		if (adaYangTrue(rule)) {
			System.out.println(pertanyaan);
			System.out.println("1. ya\n2. tidak");
			int jawaban = mintaPilihan(1, 2);
			if (jawaban == 2)
				penyakit = eliminasiYangIya(rule);
			else
				tandaiGejalaDitemukan(rule);
		}
	}

	public static void tandaiGejalaDitemukan(boolean[] rule)
	{
		for (int i = 0; i < 7; ++i)
			if (rule[i])
				gejalaDitemukan[i] = true;
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
