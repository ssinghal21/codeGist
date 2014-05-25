package com.leapmotion.codeGist;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.leapmotion.leap.*;
import java.awt.AWTException;
import java.awt.Robot;
public class LeapFrame extends JFrame
{
	private JPanel panelLeap;
	public static final int winWidth = 800;
	public static final int winDepth = 600;
	
	private LeapListener panelListener;
	private Controller controller;
	
	public LeapFrame()	/*---constructor defining the window characteristics---*/
	{
		//JFrame mainWindow = new JFrame();
		panelLeap = new JPanel();
		
		panelListener = new LeapListener(this);
		controller = new Controller();
		controller.addListener(panelListener);
		
		this.setSize(winWidth, winDepth);
		panelLeap.setBackground(Color.WHITE);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		//mainWindow.setLocation(winWidth/2, winDepth/2);
		this.getContentPane().add(panelLeap);
		
		theHandler handler = new theHandler();
		panelLeap.addMouseMotionListener(handler);
		
		
	}//end of LeapFrame
	
	
	
	/*class to handle the mouse motion events*/

	private class theHandler implements MouseMotionListener
	{
		public void mouseMoved(MouseEvent event)
		{
/*
			if((event.getSource() == panelLeap) && (event.equals(controller))) /*TODO: to pass a new frame when the event happens on the object*/
//			{
//				panelLeap.setBackground(Color.BLACK);
				
//			}	
		}
		public void mouseDragged(MouseEvent event)
		{
//			panelLeap.setBackground(Color.BLUE);
		}
	}
		
	
	public static void main(String args[])
	{
		new LeapFrame();
	}
}
