package thaphanoi;

//This is the towers of Hanoi problem
//using recursion

import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
* A helper class to hold the disks
*/
class TowerStack extends Stack<Integer> {
 
 public void display(int x, int y, int a, int b, Graphics g) {
     for(int i = 0; i < size(); i++) {
         int width = 20*((Integer)get(i)).intValue();
         g.setColor(Color.blue);
         g.fillRoundRect(x-width/2,y-10*(i+1),width+1,10,10,100);
         g.setColor(Color.red);
         g.drawRoundRect(x-width/2,y-10*(i+1),width+1,10,10,100);
     } // end for
 } // end display
 
} // end TowerStack


/**
* This program show the moves of the Towers of Hanoi puzzle
* @author Bill Kraynek
*/
public class TowersOfHanoi {
 JFrame theFrame;
 JLabel promptN;
 private int oneX = 0;
 private int oneY = 0;

 boolean up = false;
 boolean down = true;
 boolean left = false;
 boolean right = true;
 int n;
 int moves;
 JTextField inputN;
 JPanel one;
 JScrollPane inputPane;
 final int WIDTH = 650;
 final int HEIGHT = 500;
 final int XLEFT = 110;
 final int XMIDDLE = 320;
 final int XRIGHT = 520;
 final int YDOWN = 280;
 final int YUP = 170;
 final int WIDTHINC = 110;
 final int HEIGHTINC = 220;//day ngang
 Graphics g;
 TowerStack peg1 = new TowerStack();
 TowerStack peg2 = new TowerStack();
 TowerStack peg3 = new TowerStack();
 
 public TowersOfHanoi() {
     theFrame = new JFrame("Towers of Hanoi");
     Toolkit tk = Toolkit.getDefaultToolkit();
     theFrame.setSize(WIDTH,HEIGHT);
     theFrame.setLocation(tk.getScreenSize().width/4,tk.getScreenSize().height/4);
     theFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
     Container content = theFrame.getContentPane();
     content.setBackground(Color.darkGray);
     content.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
     theFrame.setVisible(true);
     theFrame.setResizable(false);
     one = new JPanel();
     promptN= new JLabel("Enter the number of disks (1-10) > ");
     one.add(promptN);
     inputN= new JTextField(5);
     inputN.addActionListener(new inputNAction());
     one.add(inputN);
     one.setBackground(Color.green);
     inputPane = new JScrollPane(one);
     content.add(inputPane);
     theFrame.setVisible(true);
 }// end constructor
 
 public static void main(String[] args) {
     new TowersOfHanoi();
 } // end main
 
 
 
 
 
 
 
 
 public void moveDisks(int n, TowerStack start, TowerStack finish, TowerStack aux){
     if ( n == 0 ) return;
     moveDisks(n-1,start,aux,finish);
     finish.push(start.pop());//////////
     moves++;
     drawTowers(g);
     moveDisks(n-1,aux,finish,start);
 } // end moveDisks
 
 public void drawLines(Graphics g) {
     g.drawLine(XLEFT,YDOWN,XLEFT,YUP);
     g.drawLine(XMIDDLE,YDOWN,XMIDDLE,YUP);
     g.drawLine(XRIGHT,YDOWN,XRIGHT,YUP);
     g.drawLine(10,YDOWN,HEIGHTINC,YDOWN);
     g.drawLine(10+WIDTHINC,YDOWN,2*HEIGHTINC,YDOWN);
     g.drawLine(10+2*WIDTHINC,YDOWN,3*HEIGHTINC,YDOWN);
 }
 
 public void drawTowers(Graphics g) {
     g.setColor(Color.white);
     g.fillRect(0,75,WIDTH,HEIGHT-75);
     g.setColor(Color.darkGray);
     drawLines(g);
     peg1.display(XLEFT,YDOWN,oneX,oneY,g);
     peg2.display(XMIDDLE,YDOWN,oneX,oneY,g);
     peg3.display(XRIGHT,YDOWN,oneX,oneY,g);
     /*
     while(true){
         if(oneX >= 0){
             right = false;
             left = true;
         }
         if(oneX <= 7){
             right = true;
             left = false;
         }
         if(oneY >= 259){
             up = true;
             down = false;
         }
         if(oneY <= 7){
             up = false;
             down = true;
         }
         if(up){
             oneY--;
         }
         if(down){
             oneY++;
         }
         if(left){
             oneX--;
         }
         if(right){
             oneX++;
         }
         try{Thread.sleep(10);}catch(Exception exc){}
         theFrame.repaint();
     }*/
     
     
    try{Thread.sleep(500);}catch(Exception e){}
 } // end drawTowers
 
 class inputNAction implements ActionListener {
     
     public void actionPerformed(ActionEvent A){
         try{
             n=Integer.parseInt(inputN.getText());
         } catch(NumberFormatException e){
             inputN.setText("1 to 10");
             inputN.selectAll();
             return;
         } // end try/catch
         if( n < 1 || n > 10 ){
             inputN.setText("1 to 10");
             inputN.selectAll();
             return;
         }
         inputN.setText("");
         moves = 0;
         peg1.setSize(0);
         for(int i = n; i > 0; i--) {
             peg1.push(i);
         }
         peg2.setSize(0);
         peg3.setSize(0);
         g = theFrame.getGraphics();
         drawTowers(g);
         moveDisks(n,peg1,peg2,peg3);
         g.drawString("**********"+n+" disks took "+moves+" move"+(moves>1?"s":"")+"***********",100,100);
     } // end actionPerformed
     
 } // end inputNAction
 
 
} // end TowersOfHanoi
