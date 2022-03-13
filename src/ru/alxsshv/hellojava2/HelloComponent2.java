package ru.alxsshv.hellojava2;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

class HelloComponent2 extends JComponent
implements MouseMotionListener, ActionListener, Runnable 
{
String theMessage;

int messageX = 125, messageY = 95 ;//координаты сообщения

JButton theButton;

int colorIndex; // текущий указатель в объекте someColors

static Color[] someColors = {
		
		Color.black, Color.red, Color.white, Color.green, Color.blue, Color.magenta
}; // массив цветов

boolean blinkState;

public HelloComponent2 (String message) {
	
	theMessage = message;
	
	theButton = new JButton ("Change color");
	
	setLayout (new FlowLayout() );
	
	add(theButton );
	
	theButton.addActionListener(this);
	
	addMouseMotionListener (this);
	
	Thread t = new Thread (this);
	
	t.start();
}	
public void paintComponent (Graphics g) {
	
	g.setColor( blinkState ? getBackground () : currentColor () );
	
	g.drawString (theMessage, messageX, messageY);
	
}
public void mouseDragged (MouseEvent e) {
	// сохранить координаты мыши и нарисовать сообщение
	messageX = e.getX();
	
	messageY = e.getY();
	
	repaint();

}
public void mouseMoved (MouseEvent e) {
	
}
public void actionPerformed (ActionEvent e) {
	// кто-то нажимал нашу кнопку
	
	if  (e.getSource() == theButton) {
		
		changeColor();
		
	}
}

synchronized private Color currentColor(  ) {
    return someColors[colorIndex];
  }

synchronized private void  changeColor () {
	
	if (++colorIndex == someColors.length) 
		
		colorIndex = 0;
	
		setForeground ( currentColor() ); // использовать новый цвет
	
		repaint ();
}
	
public void run() {
	
	try {
		
		while (true) {
			
			blinkState =!blinkState; // переключиить состояние
			
			repaint (); // показать изменения
			
			Thread.sleep (300);
		}
	} catch (InterruptedException ie) { }
}

}
