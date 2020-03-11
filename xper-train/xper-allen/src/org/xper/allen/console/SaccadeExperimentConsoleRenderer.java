package org.xper.allen.console;

import org.xper.Dependency;
import org.xper.classic.TrialExperimentConsoleRenderer;
import org.xper.drawing.Context;
import org.xper.drawing.Coordinates2D;
import org.xper.drawing.GLUtil;

public class SaccadeExperimentConsoleRenderer extends TrialExperimentConsoleRenderer{
	@Dependency 
	SaccadeExperimentMessageHandler messageHandler;
	@Dependency
	boolean xperMonkeyScreenInverted;
	
	double targetIndicatorSize = 2.5;
	int invert;
	
	public void drawCanvas(Context context, String devId) {
		super.drawCanvas(context, devId);
		if(getMessageHandler().isInTrial()) {
			drawTarget();
		}	
		
	}
	
	void drawTarget() {
		if (xperMonkeyScreenInverted) {
			invert = -1;
		}
		else {
			invert = 1;
		}
		if(messageHandler.isTargetOn()) {
			Coordinates2D targetLocation = messageHandler.getTargetPosition();
			double targetEyeWindowSize = messageHandler.getTargetEyeWindowSize();
			GLUtil.drawCircle(circle, targetEyeWindowSize, false, invert*targetLocation.getX(), targetLocation.getY(), 0);
			GLUtil.drawSquare(square, targetIndicatorSize, true, invert*targetLocation.getX(), targetLocation.getY(), 0);
		}
	}
	
	public void setSaccadeMessageHandler(SaccadeExperimentMessageHandler messageHandler) {
		this.messageHandler = messageHandler;
	}

	public void setXperMonkeyScreenInverted(boolean xperMonkeyScreenInverted) {
		this.xperMonkeyScreenInverted = xperMonkeyScreenInverted;
	}
}