package testEvent1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SimpleExample extends JFrame {
    JButton jButton1 = new JButton();
    public SimpleExample() {
        try {
            jbInit();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        SimpleExample simpleExample = new SimpleExample();
    }
    private void jbInit() throws Exception {
        jButton1.setText("jButton1");
        jButton1.addActionListener(new SimpleExample_jButton1_actionAdapter(this));
        jButton1.addActionListener(new SimpleExample_jButton1_actionAdapter(this));
        this.getContentPane().add(jButton1, BorderLayout.CENTER);
        this.setVisible(true);
    }
    void jButton1_actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
class SimpleExample_jButton1_actionAdapter implements java.awt.event.ActionListener {
    SimpleExample adaptee;
    SimpleExample_jButton1_actionAdapter(SimpleExample adaptee) {
        this.adaptee = adaptee;
    }
    public void actionPerformed(ActionEvent e) {
        adaptee.jButton1_actionPerformed(e);
    }
}