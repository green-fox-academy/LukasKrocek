public class Sharpie {

    String color;
    public float width;
    float inkAmount = 100;

    public Sharpie(String color, float width) {

        this.color = color;
        this.width = width;
    }

    public void setWidth(float width) {
        width = Math.abs(width);
        this.width = width;
    }

    public void use() {
        inkAmount--;
    }

}