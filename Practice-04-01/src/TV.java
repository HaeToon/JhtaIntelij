public class TV {
    private int size;
    public TV(int size) {
        this.size = size;
    }
    public TV() {
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public String toString() {
        return "TV [size=" + size + ", getSize()=" + getSize() + "]";
    }
}
