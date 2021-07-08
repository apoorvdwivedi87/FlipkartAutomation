package org.flipkart.listeners;

import org.flipkart.envSetUp.EnviornmentSetUp;
import org.testng.IExecutionListener;

public class ExecutionListener implements IExecutionListener{

	@Override
	public void onExecutionStart() {
		EnviornmentSetUp envSetUp = new EnviornmentSetUp();
		envSetUp.setUp();
	}
}
