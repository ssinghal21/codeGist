package com.leapmotion.codeGist;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

//import com.leapmotion.codeGist.LeapFrame.theHandler;
import com.leapmotion.leap.*;

public class MusicPane extends JFrame 
{
	private JPanel panelMusic;
	private static final int MusicPaneWidth = 800;
	private static final int MusicPaneHeight = 600;
	
	private LeapListener MusicPaneListener;
	private Controller controller;
	
	public MusicPane()
	{
		JFrame musicWindow = new JFrame();
		panelMusic = new JPanel();
		
		MusicPaneListener = new LeapListener(this); //TODO:define a constructor for music pane in the leap motion listener class
		controller = new Controller();
		controller.addListener(MusicPaneListener);
		
		musicWindow.setSize(MusicPaneWidth, MusicPaneHeight);
		panelMusic.setBackground(Color.CYAN);
		musicWindow.setVisible(true);
		musicWindow.setResizable(false);
		musicWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		musicWindow.setLocationRelativeTo(null);
		musicWindow.getContentPane().add(panelMusic);
		
		musicHandler mHandle = new musicHandler();
		panelMusic.addMouseMotionListener(mHandle);
	}
	
	private class musicHandler implements MouseMotionListener
	{
		public void mouseMoved(MouseEvent event)
		{
	
		}
		public void mouseDragged(MouseEvent event)
		{

		}
	}
}
