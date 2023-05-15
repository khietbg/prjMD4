package ra.model.entity;

public class Product {
    private int productId;
    private String productName;
    private String image;
    private int sizeId;
    private float price;
    private int catalogId;
    private int productQuantity;
    private boolean productStatus;

    public Product() {
    }

    public Product(int productId, String productName, String image, int sizeId, float price, int catalogId, int productQuantity, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.image = image;
        this.sizeId = sizeId;
        this.price = price;
        this.catalogId = catalogId;
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

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
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
