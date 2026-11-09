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


    private int nextProductId;

    public Inventory() {
        products = new Product[100];
        count = 0;

        nextProductId = 1;
        
        
    public boolean addProduct(String name, String category,
                              int quantity, String unit) {

        if (count >= products.length) {
            return false;
        }

        String productId = String.format("P%03d", nextProductId);

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
    public boolean updateStock(String productId, int newQuantity) {

        for (int i = 0; i < count; i++) {

            if (products[i].getProductId().equalsIgnoreCase(productId)) {

                if (newQuantity < 0) {
                    return false;
                }

                products[i].setQuantity(newQuantity);
                return true;
            }
        }

        return false;
    }
    public boolean deleteProduct(String productId) {

    for (int i = 0; i < count; i++) {

        if (products[i].getProductId().equalsIgnoreCase(productId)) {

            // Shift remaining products to the left
            for (int j = i; j < count - 1; j++) {
                products[j] = products[j + 1];
            }

            products[count - 1] = null;
            count--;

            return true;
        }
    }

    return false;
}
}

