
public class RestaurantMain {

	public static void main(String[] args) {
		Restaurant resto = new Restaurant();
		
		System.out.println("Makanan yang tersedia :");
		resto.tambahMenuMakanan("Bala-Bala", 1_000, 20);
		resto.tambahMenuMakanan("Gehu", 1_000, 20);
		resto.tambahMenuMakanan("Tahu", 1_000, 0);
		resto.tambahMenuMakanan("Molen", 1_000, 20);
		
		resto.tampilMenuMakanan();
		
		resto.pesanMakanan("Molen", 5); 
		System.out.println("\nMenu makanan setelah dilakukan pemesanan");
		resto.tampilMenuMakanan();
	}

}
