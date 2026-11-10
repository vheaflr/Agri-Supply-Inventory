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

    int index = -1;

    // Find the product using its ID
    for (int i = 0; i < count; i++) {
        if (products[i].getProductId().equals(productId)) {
            index = i;
            break;
        }
    }

    // Product not found
    if (index == -1) {
        return false;
    }

    // Remove product and shift remaining products
    for (int i = index; i < count - 1; i++) {
        products[i] = products[i + 1];
    }

    products[count - 1] = null;
    count--;

    // Automatically renumber IDs
    for (int i = 0; i < count; i++) {
        products[i].setProductId(
            String.format("P%03d", i + 1)
        );
    }

    nextProductId = count + 1;

    return true;
}
}




