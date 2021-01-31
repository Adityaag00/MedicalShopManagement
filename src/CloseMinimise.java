
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.JFrame;


public class CloseMinimise {
    static ArrayList<JFrame> lst=new ArrayList<>();
    
    public static void close(JFrame frame) {
        frame.dispose();
    }
    
    public static void minimise(JFrame frame) {
        frame.setState(Frame.ICONIFIED);
    }
    
    public static void addFrameObject(JFrame frm) {
        lst.add(frm);
    }
    
    public static void closeAll(){
        for(JFrame frm : lst) {
            frm.dispose();
        }
    }
}
