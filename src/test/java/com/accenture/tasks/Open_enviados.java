package com.accenture.tasks;

import com.accenture.ui.viewGmail;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class Open_enviados implements Task{
	 @Step("click Enviadosr")
	   public <T extends Actor> void performAs(T actor) {
	       actor.wasAbleTo(
	               Click.on(viewGmail.ENVIADOS_BTN)
	       );
	   }
}
