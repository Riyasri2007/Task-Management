import java.util.Scanner;
class InventoryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] product = new String[3];
        int[] quantity = new int[3];
        // Input
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter product name: ");
            product[i] = sc.next();
        System.out.print("Enter quantity: ");
            quantity[i] = sc.nextInt();
        }
        // Display inventory
        System.out.println("\nInventory Details");
        System.out.println("------------------");
        for (int i = 0; i < 3; i++) {
            System.out.println("Product: " + product[i] +
                               " | Quantity: " + quantity[i]);
        }
    }
}
