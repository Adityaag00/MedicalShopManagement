
import java.awt.Color;


public class newColor {
    
    public static int r;
    public static int g;
    public static int b;

    
    public static int getR() {
        return r;
    }

    
    public static int getG() {
        return g;
    }

    
    public static int getB() {
        return b;
    }
    
    
    public static void setColor(Color col) {
        r=col.getRed();
        b=col.getBlue();
        g=col.getGreen();
    }
    
    
    public static Color getColor() {
        return new Color(r,g,b);
    }
    
    
    public static void setDefaultColor() {
        r=93;
        g=140;
        b=160;
    }
}
