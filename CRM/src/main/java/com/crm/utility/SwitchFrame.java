package com.crm.utility;

import com.crm.base.Baseclass;

public class SwitchFrame extends Baseclass {

	public void switchFrame(String name)
	{
		
		driver.switchTo().frame(name);
		
	}
}
