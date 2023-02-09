
public class MainPenjualan {
	public static void main(String[] args) {
		Penjualan tokoA = new Penjualan();
		
		tokoA.tambahProdukMakanan("Bengbeng", 2_000, 50);
		tokoA.tambahProdukMakanan("Chocopie", 2_500, 20);
		tokoA.tambahProdukMakanan("Permen", 1_000, 100);
		tokoA.tambahProdukMakanan("Kuaci", 1_500, 25);
		tokoA.tambahProdukMakanan("Basreng", 5_000, 30);
		tokoA.tambahProdukMakanan("Waffles", 3_000, 15);
		tokoA.tambahProdukMakanan("Air Aqua", 3_000, 80);
		tokoA.tambahProdukMakanan("Seblak", 9_000, 60);
		tokoA.tambahProdukMakanan("Pop Mie", 6_000, 40);
		tokoA.tambahProdukMakanan("Pop Ice", 4_000, 70);

		System.out.println("\t  Daftar Produk");
		System.out.println("==================================");
		tokoA.tampilMenuProduk();
		
		tokoA.pesanProduk();
		
		tokoA.displayStruk();
		
		System.out.println("\n\n\t  Daftar Produk");
		System.out.println("==================================");
		tokoA.tampilMenuProduk();
		

	}
}
