import java.util.Scanner;

public class Penjualan { 
	private Produk[] produkToko;
	private Produk[] produkPesanan;
	public static byte id = -1;
	public static byte index = -1;
	private double harga_total;
	private int quantity;
	
	Scanner in = new Scanner(System.in);
	
	public Penjualan () {
		produkToko = new Produk [10];
		produkPesanan = new Produk [20];
	}
	
	
	public void tambahProdukMakanan(String nama, double harga, int qty) {
		nextId();
		produkToko[id] = new Produk();
		produkToko[id].setNama_produk(nama);
		produkToko[id].setHarga(harga);
		produkToko[id].setQty(qty);
	}
	
	
	public void tampilMenuProduk() {
		for (int i =0; i<=id; i++) {
			if(!isOutOfStock(i)) { 
				System.out.println((i+1)+". "+produkToko[i].getNama_produk()+"["+produkToko[i].getQty()+"]"+"\t\tRp. "+produkToko[i].getHarga());
			}else {
				System.out.println((i+1)+". "+produkToko[i].getNama_produk()+"\t\t\t---habis---");
			}
		}
	}
	
	
	public static void nextId() {
		id++;
	}
	
	
	public boolean isOutOfStock(int id) {
		if(produkToko[id].getQty() == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public void pesanProduk() {
		String namaMakanan;

		do {
			System.out.println("\nSilahkan masukkan produk yang akan dipesan : ");
			namaMakanan = in.nextLine(); 
			for (int i =0; i <= id;i++) {
				if (namaMakanan.equals(produkToko[i].getNama_produk())) {
					System.out.println("Silahkan masukkan jumlah produk yang akan dipesan : ");
					String jmlPesan= in.nextLine();
					quantity = Integer.parseInt(jmlPesan);
					if(quantity == 0){
						System.out.println("-------Anda belum memasukkan jumlah pesanan-------");
						this.pesanProduk();
						break;
					}else if(quantity < 0){
						System.out.println("-------Jumlah pesanan tidak valid-------");
						this.pesanProduk();
						break;
					}else {
						this.Order(namaMakanan, quantity, produkToko[i].getHarga());
						kurangiStok(i, quantity);
					}
				}
			}
		}while(this.orderRepeat().equals("y"));	
	}
	
	
	public String orderRepeat() {
		String pesanLagi;
	
		System.out.println("\nApakah ingin memesan produk lain (y/n) : ");
		pesanLagi = in.nextLine();

		return  pesanLagi;
	}
				
	
	public void kurangiStok(int id, int qtyOrder) {
		int sisa;
		if (!isOutOfStock(id)) {
			sisa = produkToko[id].getQty() - qtyOrder; 
			if (sisa < 0) {
				System.out.println("-------Stok tidak mencukupi-------");
				System.out.println("-------Masukkan jumlah pesanan sesuai stok yang tersedia-------");
				this.pesanProduk();
			}else {
				produkToko[id].setQty(((produkToko[id].getQty()) - qtyOrder));
			}
		}else {
			System.out.println("\nBarang habis");
		}
	}
	
	
	public void Order(String namaProduk, int qtyOrder, double hargaSatuan) {
		index++;	
		produkPesanan[index] = new Produk();
		produkPesanan[index].setNama_produk(namaProduk);
		produkPesanan[index].setQty(qtyOrder);
		produkPesanan[index].setHarga(hargaSatuan);		
	}
	
	
	public void displayStruk() {
		System.out.println("\n=================================================================");
		System.out.println("\t\t\tStruk Pesanan");
		System.out.println("=================================================================");
		System.out.println("Nama Produk\tJumlah\t     Harga Satuan\t     Harga Total");
		for (int i =0; i<=index; i++) {
			System.out.println((i+1)+". "+produkPesanan[i].getNama_produk()+"\t["+produkPesanan[i].getQty()+"]"+"\t     Rp. "+produkPesanan[i].getHarga()+"\t\t     Rp. "+produkPesanan[i].getHarga()*produkPesanan[i].getQty());
		}
		double total = this.payAble();
		System.out.println("\t\t\t\t=================================");
		System.out.println("\t\t\t\tTotal Pembelian :    Rp. "+total);
		System.out.println("\n=================================================================");
	}
	
	public double payAble() {
		harga_total = 0;
		for (int i =0; i<=index; i++) {
			harga_total += produkPesanan[i].getHarga()*produkPesanan[i].getQty();
		}
		return harga_total;
	}
}
