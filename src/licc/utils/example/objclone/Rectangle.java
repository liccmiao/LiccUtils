package licc.utils.example.objclone;

/**
 * Created by user on 2015/3/30.
 */
public class Rectangle implements Cloneable {
    int width;
    int height;

    public Rectangle(int w, int h) {
        width = w;
        height = h;
    }

    public void setWidth(int w) {
        width = w;
    }

    public void setHeight(int h) {
        height = h;
    }

    public int area() {
        return width * height;
    }

    @Override
    protected Rectangle clone() throws CloneNotSupportedException {
        return (Rectangle)super.clone();
        /*
         * Rectangle c = (Rectangle)super.clone();
         * modify c field-by-field if Rectangle contains any mutable field
         */
    }

    @Override
    public String toString() {
        return "Rectangle Format [width=" + this.width + ",height=" + this.height + ",area=" + this.area() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

        Rectangle r = (Rectangle) obj;
        if (this.width != r.width) return false;
        if (this.height != r.height) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 37;
        hash = hash * 47 + width;
        hash = hash * 47 + height;
        return hash;
    }
}
