package thaphanoi;

import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class ActionListenerExample {
    public static void main(String[] args) {
        Frame frame = new Frame("VD ActionListener trong Java AWT");
        final TextField textField = new TextField();
        textField.setBounds(50, 50, 150, 20);
        Button button = new Button("Click Here");
        button.setBounds(50, 100, 60, 30);
 
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("Welcome to Vn");
            }
        });
        frame.add(button);
        frame.add(textField);
        frame.setSize(450, 200);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
