/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agriculturalsupplyinventory;

/**
 *
 * @author biaap
 */
public class Products {

    private String productId;
    private String productName;
    private String category;
    private int quantity;
    private String unit;

    // Constructor
    public Products(String productId, String productName,
                   String category, int quantity, String unit) {

        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.quantity = quantity;
        this.unit = unit;
    }

    // Getters
    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    // Setters
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
