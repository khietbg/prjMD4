package ra.model.entity;

public class Product {
    private int catalogId;
    private int productId;
    private String productName;
    private String image;
    private float price;
    private int productQuantity;
    private boolean productStatus;

    public Product(int catalogId, String productName, String image, float price) {
        this.catalogId = catalogId;
        this.productName = productName;
        this.image = image;
        this.price = price;
    }

    public Product() {

    }

    public Product(int catalogId, int productId, String productName, String image, float price, int productQuantity, boolean productStatus) {
        this.catalogId = catalogId;
        this.productId = productId;
        this.productName = productName;
        this.image = image;
        this.price = price;
        this.productQuantity = productQuantity;
        this.productStatus = productStatus;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }
}
