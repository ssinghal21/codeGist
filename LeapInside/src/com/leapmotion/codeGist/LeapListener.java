package com.leapmotion.codeGist;

import java.awt.AWTException;
import java.awt.Robot;

import com.leapmotion.leap.*;
import com.leapmotion.leap.Gesture.*;

public class LeapListener extends Listener
{
	private LeapFrame pane;
	//float Xnorm=0, Ynorm=0;
	String clockwiseness;
	int count;
	private MusicPane musicChann;
	private static final int MAX_FRAME_COUNT = 20;
	public LeapListener(LeapFrame windowLeap)
	{
		super();
		musicChann = new MusicPane();
		pane = windowLeap;
	}
	public void onConnect(Controller controller)
	{
		System.out.println("controller has been connected");
		controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
	}
	public void onExit(Controller controller)
	{
		System.out.println("exited");
	}
	public void onFrame(Controller controller)
	{
		Frame currFrame = controller.frame();
		Frame prevFrame = controller.frame(1);
		
		InteractionBox ibox = currFrame.interactionBox();
		
		if(!currFrame.hands().isEmpty())
		{
			int handsCount = currFrame.hands().count();
			if(handsCount == 1)
			{
				Hand handValue = currFrame.hands().get(0);
				int fingerCount = currFrame.fingers().count();
				if(fingerCount == 1)
				{
					Finger fingers = currFrame.fingers().frontmost();
					Vector stabilizedPosition = fingers.stabilizedTipPosition();
					//InteractionBox ibox = new InteractionBox();
					Vector normalizedPosition = ibox.normalizePoint(stabilizedPosition);
					System.out.println("The normalized position is:" + normalizedPosition); //check for the vector position					
					float Xnorm = normalizedPosition.getX() * pane.winWidth;//pane.getWidth();
					float Ynorm = pane.winDepth * (1 - normalizedPosition.getY());
					//System.out.println(pane.winWidth);
					System.out.println(Xnorm + "," + Ynorm);					
				}
				//count = MAX_FRAME_COUNT;
				//while(count != 0)
			//	{
					GestureRecog(currFrame.gestures(), controller);
				//	count--;
			//	}	
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public void GestureRecog(GestureList gestures, Controller controller)
	{
		for (Gesture gesture : gestures)
		{
			//count = 0;
			//while(count < MAX_FRAME_COUNT)
			//{
				switch(gesture.type())
				{
				case TYPE_CIRCLE:
					CircleGesture circle = new CircleGesture(gesture);
					//String clockwiseness;

					if(circle.pointable().direction().angleTo(circle.normal()) <= Math.PI/2)
					{
						clockwiseness = "clockwise";
						System.out.println(clockwiseness);
						//new MusicPane();
					}
					else
					{
						clockwiseness = "counterclockwise";
						System.out.println(clockwiseness);
					}
					break;
				default:
					System.out.println("Unknown gesture type.");
					break;
				}
				//count++;
			//}			
		}

		if(clockwiseness == "clockwise")
		{
			/*----generate a new frame consisting of music panel----*/
			//new MusicPane();
			musicChann.setVisible(true);
		}
	}
	

/*	
	public void moveMouse(float x, float y)
	{
		Robot mouseHandler;
		if((Xnorm!=x) ||(Ynorm!=y))
		{
			Xnorm = x;
			Ynorm = y;
			
			try
			{
				mouseHandler = new Robot();
				mouseHandler.mouseMove((int)x, (int)y);
			}
			catch (AWTException e)
			{
				e.printStackTrace();
			}
		}
		
	}
*/	
}
