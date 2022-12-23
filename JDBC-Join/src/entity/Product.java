package entity;

public class Product {

    private Integer productId;
    private Category category;
    private String productName;
    private Integer price;
    private String description;

    public Product(Integer productId, Category category, String productName, Integer price, String description) {
        this.productId = productId;
        this.category = category;
        this.productName = productName;
        this.price = price;
        this.description = description;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", categoryId=" + category.getCategoryId() +
                ", categoryName='" + category.getCategoryName() + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
