package com.accenture.ui;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class Box_LoginGmail {
	
	public static Target USER_FIELD = Target.the("user").located(By.xpath("//*[@id='identifierId']"));
	 public static Target PASS_FIELD = Target.the("password").located(By.xpath("//*[@id=\'password\']/div[1]/div/div[1]/input"));

}
