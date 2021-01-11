package org.xper.allen.experiment.twoac;

import java.sql.Timestamp;

import org.xper.Dependency;
import org.xper.allen.console.TargetEventListener;
import org.xper.classic.TrialEventListener;
import org.xper.classic.vo.TrialContext;
import org.xper.juice.Juice;


public class TwoACJuiceController implements ChoiceEventListener {
	
	@Dependency
	Juice juice;

	public Juice getJuice() {
		return juice;
	}

	public void setJuice(Juice juice) {
		this.juice = juice;
	}

	
	@Override
	public void targetSelectionCorrect(long timestamp) {
		juice.deliver();
		System.out.println("Juice delivered @ " + new Timestamp(timestamp/1000).toString() + "because animal correctly chose.");
		
	}

	@Override
	public void targetSelectionIncorrect(long timestamp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void targetSelectionNull(long timestamp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void targetSelectionDefaultCorrect(long timestamp) {
		juice.deliver();
		System.out.println("Juice delivered @ " + new Timestamp(timestamp/1000).toString() + "because animal is correct by default.");
	}


}
