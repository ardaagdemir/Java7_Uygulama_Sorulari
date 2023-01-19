package jdbc_example2.entity;

public class Product {

    private Integer id;
   //category
    private Category category;
    private String name;
    private double price;
    private int unitInStock;
    private String description;

    public Product(Integer id) {
        this.id = id;
    }

    public Product(Category category, String name, double price) {
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public Product(Category category, String name, double price, int unitInStock, String description) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.unitInStock = unitInStock;
        this.description = description;
    }

    public Product(Integer id, Category category, String name, double price, int unitInStock, String description) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.price = price;
        this.unitInStock = unitInStock;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(int unitInStock) {
        this.unitInStock = unitInStock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "category=" + category +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", unitInStock=" + unitInStock +
                ", description='" + description + '\'' +
                '}';
    }
}
