package ra.model.entity;

public class size {
    private int sizeId;
    private float sizeNumber;
    private boolean sizeStatus;

    public size() {
    }

    public size(int sizeId, float sizeNumber, boolean sizeStatus) {
        this.sizeId = sizeId;
        this.sizeNumber = sizeNumber;
        this.sizeStatus = sizeStatus;
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public float getSizeNumber() {
        return sizeNumber;
    }

    public void setSizeNumber(float sizeNumber) {
        this.sizeNumber = sizeNumber;
    }

    public boolean isSizeStatus() {
        return sizeStatus;
    }

    public void setSizeStatus(boolean sizeStatus) {
        this.sizeStatus = sizeStatus;
    }
}
