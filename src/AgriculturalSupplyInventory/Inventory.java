/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agriculturalsupplyinventory;

/**
 *
 * @author biaap
 */
public class Inventory {
    
    private Product[] products;
    private int count;

    public Inventory() {
        products = new Product[100];
        count = 0;
    }

    public boolean addProduct(String name, String category,
                              int quantity, String unit) {

        if (count >= products.length) {
            return false;
        }

        String productId = String.format("P%03d", count + 1);

        products[count] = new Product(
            productId, name, category, quantity, unit
        );

        count++;
        return true;
    
    }
    public Product[] getProducts() {
        return products;
    }

    public int getCount() {
        return count;
    }
    public Product searchProduct(String name) {

    for (int i = 0; i < count; i++) {

        if (products[i].getProductName().equalsIgnoreCase(name)) {
            return products[i];
        }
    }

    return null;
}
}
