package ru.alxsshv.hellojava2;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

class HelloComponent2 extends JComponent
implements MouseMotionListener 
{
String theMessage;

int messageX = 125, messageY = 95 ;//координаты сообщения

public HelloComponent2 (String message) {
	theMessage = message;
	addMouseMotionListener (this);
}	
public void paintComponent (Graphics g) {
	
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

}
