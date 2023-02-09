
public class Restaurant {
	private Menu[] menuRestoA;
	public static byte id = -1;
	
	public Restaurant () {
		menuRestoA = new Menu [10];
	}
	
	public void tambahMenuMakanan(String nama, double harga, int stok) {
		nextId();
		menuRestoA[id] = new Menu();
		menuRestoA[id].setNama_makanan(nama);
		menuRestoA[id].setHarga_makanan(harga);
		menuRestoA[id].setStok(stok);
	}
	
	public void tampilMenuMakanan() {
		for (int i =0; i<=id; i++) {
			if(!isOutOfStock(i)) { 
				System.out.println(i+"."+menuRestoA[i].getNama_makanan()+"["+menuRestoA[i].getStok()+"]"+"\tRp. "+menuRestoA[i].getHarga_makanan());
			}else {
				System.out.println(i+"."+menuRestoA[i].getNama_makanan()+"\t\t---habis---");
			}
		}
	}
	
	public static void nextId() {
		id++;
	}
	
	public boolean isOutOfStock(int id) {
		if(menuRestoA[id].getStok() == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public void pesanMakanan(String namaMakanan, int jumlahPesan) {
		for (int i =0; i <= id; i++) {
			if (namaMakanan.equals(menuRestoA[i].getNama_makanan())) {
				this.kurangiStok(i, jumlahPesan); 
			}
		}
	}
	
	public void kurangiStok(int id, int qtyOrder) {
		int sisa;
		if (!isOutOfStock(id)) {
			sisa = menuRestoA[id].getStok() - qtyOrder; 
			if (sisa < 0) {
				System.out.println("\nStok tidak mencukupi");
			}else {
				menuRestoA[id].setStok(((menuRestoA[id].getStok()) - qtyOrder));
			}
		}else {
			System.out.println("\nBarang habis");
		}
	}
	
	
	
}
