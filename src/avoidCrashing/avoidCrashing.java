package avoidCrashing;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.security.SecureRandom;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.Timer;


public class avoidCrashing extends JPanel implements ActionListener, KeyListener{

	static JFrame frame;
	private JFrame log;
	Timer tm = new Timer (10,this);
	
int xPaddle = 400;
int yPaddle=50;
int velPaddle = 1;
int lengthPaddle=100;
int heightPaddle=30;
int xBall=225;
int yBall=300;
int velBall = 0;
int diamBall = 30;
int score = 0;
SecureRandom rand= new SecureRandom();

	
public void paint(Graphics g){
	super.paint(g);
	g.setColor(Color.BLUE);
	g.fillOval(xBall,yBall,diamBall,diamBall);
	
	g.setColor(Color.RED);
	g.fillRect(xPaddle,yPaddle,lengthPaddle,heightPaddle);
	
	//g.setColor(Color.RED);
	//g.fillRect(xPaddle2,yPaddle2,lengthPaddle2,heightPaddle2);
	
	

if(xPaddle<0) {
	xPaddle =400;
	yPaddle=rand.nextInt(600);
	velPaddle=velPaddle+1;
//	xPaddle2 =400;
//	yPaddle2=rand.nextInt(600);
//	velPaddle2=velPaddle2+1;
	score++;

}else if((yBall<=yPaddle+heightPaddle)&&(yBall+diamBall>=yPaddle)&&(xBall+diamBall>=xPaddle)&&(xBall<=xPaddle+lengthPaddle)) {
		//||(yBall<=yPaddle2+heightPaddle2)&&(yBall+diamBall>=yPaddle2)&&(xBall+diamBall>=xPaddle2)&&(xBall<=xPaddle2+lengthPaddle2)){
	
	//else if((yBall<=yPaddle+heightPaddle)&&(yBall+diamBall>=yPaddle)&&(xBall>=xPaddle)&&(xBall<=xPaddle+lengthPaddle)){
	tm.stop();
	log = new JFrame("GAME OVER");
	if(JOptionPane.showConfirmDialog(log, "Score: "+score+"\n"+" Exit", "GAME OVER",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
		System.exit(0);
	}
}

}
public avoidCrashing() {
	initialize();
	tm.start();
	addKeyListener(this);
	setFocusable(true);
	setFocusTraversalKeysEnabled(false);
}
private void initialize() {
	frame = new JFrame();
	frame.setBounds(100, 100, 450, 300);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	
}
public void actionPerformed(ActionEvent e) {
xPaddle = xPaddle - velPaddle;
//xPaddle2 = xPaddle2 - velPaddle2;
yBall = yBall + velBall;
	repaint();
}

public void keyPressed(KeyEvent e) {
	int c=e.getKeyCode();
	
	if(c==KeyEvent.VK_UP){
		velBall = -4;
	}
int a=e.getKeyCode();
	
	if(a==KeyEvent.VK_DOWN){
		velBall = -4;
	}
int d=e.getKeyCode();
	
	if(d==KeyEvent.VK_LEFT){
		velBall = -4;
	}
	
}

public void keyReleased(KeyEvent e) {
int c=e.getKeyCode();
	
velBall=2;
}

public void keyTyped(KeyEvent e) {



}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					avoidCrashing t = new avoidCrashing();
					JFrame jframe =new JFrame("Avoid Crashing Game");
					jframe.setSize(400,400);
					jframe.setVisible(true);
					jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					jframe.add(t);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
