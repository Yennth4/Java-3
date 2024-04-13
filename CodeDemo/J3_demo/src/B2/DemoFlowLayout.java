package B2;

import com.sun.source.tree.LambdaExpressionTree;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class DemoFlowLayout extends JFrame {

    public static void main(String[] args) {
        DemoFlowLayout frame = new DemoFlowLayout(); // khởi tạo hàm Layout

        frame.setVisible(true);  // hien thi JFrame va set kich thuoc
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null); // căn giữa 

        JButton bt1 = new JButton("Button 1"), // tao ra 9 button 
                bt2 = new JButton("Button 2"),
                bt3 = new JButton("Button 3"),
                bt4 = new JButton("Button 4"),
                bt5 = new JButton("Button 5"),
                bt6 = new JButton("Button 6"),
                bt7 = new JButton("Button 7"),
                bt8 = new JButton("Button 8"),
                bt9 = new JButton("Button 9");
        /*
        frame.setLayout(new FlowLayout());  // FlowLayout : tự căn chỉnh từ trái sang và từ trên xuống 
        frame.add(bt1);
        frame.add(bt2);
        frame.add(bt3);
        frame.add(bt4);
        frame.add(bt5);
        frame.add(bt6);
        frame.add(bt7);
        frame.add(bt8);
        frame.add(bt9);
         */
        frame.setLayout(new BorderLayout());  // 
        frame.add(bt1, BorderLayout.CENTER);
        frame.add(bt2, BorderLayout.SOUTH);
        frame.add(bt3, BorderLayout.NORTH);
        frame.add(bt4, BorderLayout.EAST);
        frame.add(bt5, BorderLayout.WEST);
    }
}
