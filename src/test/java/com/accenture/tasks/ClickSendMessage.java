package com.accenture.tasks;

import com.accenture.ui.Boton_Redactar;
import com.accenture.ui.Box_Send;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class ClickSendMessage  implements Task{

	 @Step("click Enviarr")
	   public <T extends Actor> void performAs(T actor) {
	       actor.wasAbleTo(
	               Click.on(Box_Send.ENVIAR_FIELD)
	       );
	   }
	   
}
