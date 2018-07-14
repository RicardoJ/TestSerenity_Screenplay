package com.accenture.ui;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class Box_Send {
	 public static Target PARA_FIELD = Target.the("destinatario").located(By.xpath("//textarea[@name='to']"));
	 public static Target ASUNTO_FIELD = Target.the("asunto").located(By.xpath("//input[@name='subjectbox']"));
	 public static Target DESCRIPCION_FIELD = Target.the("descripcion").located(By.xpath("//div[@class='Am Al editable LW-avf']"));
	 public static Target ENVIAR_FIELD = Target.the("btn_enviar").located(By.xpath("//div[text()='Enviar']"));
}
