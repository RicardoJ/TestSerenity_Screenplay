package com.accenture.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

import com.accenture.ui.Boton_Redactar;
import com.accenture.ui.Box_LoginGmail;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class Open_boton_redactar  implements Task{
	
	
   @Step("click Redactar")
   public <T extends Actor> void performAs(T actor) {
       actor.wasAbleTo(
               Click.on(Boton_Redactar.REDACTAR_BTN)
       );
   }
   
  
}
