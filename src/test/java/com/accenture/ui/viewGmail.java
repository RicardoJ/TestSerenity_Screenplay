package com.accenture.ui;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class viewGmail {
	public static Target REDACTAR_BTN = Target.the("redactar").located(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']"));
	public static Target ENVIADOS_BTN = Target.the("enviados").located(By.xpath("//*[@id=\":i6\"]/div/div[2]/span/a"));
}
