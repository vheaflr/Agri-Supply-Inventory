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
 
    private Products[] products;
    private int count;

    // Constructor
    public Inventory() {
        products = new Products[100];
        count = 0;
    }
    // Add Product
    public boolean addProduct(String name, String category,
                              int quantity, String unit) {

        if (count >= products.length) {
            return false;
        }

       String prefix;

switch (category.toLowerCase()) {
    case "seeds":
        prefix = "S";
        break;
    case "fertilizer":
        prefix = "F";
        break;
    case "pesticides":
        prefix = "P";
        break;
    case "tools":
        prefix = "T";
        break;
    case "equipment":
        prefix = "E";
        break;
    default:
        return false;
}

int nextNumber = 1;

for (int i = 0; i < count; i++) {
    if (products[i].getProductId().startsWith(prefix)) {
        int existingNumber = Integer.parseInt(
                products[i].getProductId().substring(1)
        );

        if (existingNumber >= nextNumber) {
            nextNumber = existingNumber + 1;
        }
    }
}

String id = String.format("%s%03d", prefix, nextNumber);

        products[count] = new Products(
            id, name, category, quantity, unit
        );

        count++;

        return true;
    }
    

    // Get Products
    public Products[] getProducts() {
        return products;
    }

    // Get Count
    public int getCount() {
        return count;
    }

    // Search Product (Linear Search)
    public Products searchProduct(String name) {

        for (int i = 0; i < count; i++) {

            if (products[i].getProductName()
                    .equalsIgnoreCase(name)) {

                return products[i];
            }
        }

        return null;
    }

    // Update Stock
    public boolean updateStock(String id, int quantity) {

        if (quantity < 0) {
            return false;
        }

        for (int i = 0; i < count; i++) {

            if (products[i].getProductId()
                    .equalsIgnoreCase(id)) {

                products[i].setQuantity(quantity);

                return true;
            }
        }

        return false;
    }

    // Delete Product
    public boolean deleteProduct(String id) {

    int index = -1;

    // Find the product
    for (int i = 0; i < count; i++) {
        if (products[i].getProductId().equalsIgnoreCase(id)) {
            index = i;
            break;
        }
    }

    if (index == -1) {
        return false;
    }

    // Remember the category prefix
    String prefix = products[index].getProductId().substring(0, 1);

    // Remove the product by shifting the array
    for (int i = index; i < count - 1; i++) {
        products[i] = products[i + 1];
    }

    products[count - 1] = null;
    count--;

    // Renumber only products with the same prefix
    int number = 1;

    for (int i = 0; i < count; i++) {

        if (products[i].getProductId().startsWith(prefix)) {

            String newId = String.format("%s%03d", prefix, number);

            products[i].setProductId(newId);

            number++;
        }
    }

    return true;
}
    public void sortByCategory() {

        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {

                if (products[j].getCategory().compareToIgnoreCase(
                        products[j + 1].getCategory()) > 0) {

                    Products temp = products[j];
                    products[j] = products[j + 1];
                    products[j + 1] = temp;

}
            }
        }
    }
}