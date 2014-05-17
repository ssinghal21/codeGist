package com.leapmotion.codeGist;

import com.leapmotion.leap.Listener;
import com.leapmotion.leap.*;
import com.leapmotion.leap.Gesture.*;

public class LeapListener extends Listener
{
	private LeapFrame pane;
	
	public LeapListener(LeapFrame windowLeap)
	{
		super();
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
		
		InteractionBox ibox = new InteractionBox();
		
		if(!currFrame.hands().isEmpty())
		{
			int handsCount = currFrame.hands().count();
			if(handsCount == 1)
			{
				Hand handValue = currFrame.hands().get(0);
				
			}
		}
	}
	
}
