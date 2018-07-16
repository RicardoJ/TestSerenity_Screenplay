package com.accenture.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

import com.accenture.ui.viewGmail;
import com.accenture.ui.Box_LoginGmail;
import com.accenture.ui.Box_SendEmail;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class SendEmail implements Task{
	
	
	 private final String to;
	 private final String subjetc;
	 private final String description ;

	    protected SendEmail(String to,String subject, String description) {
	        this.to = to;
	        this.subjetc = subject;
	        this.description = description;
	    }

	    @Step("Send email")
	    public <T extends Actor> void performAs(T actor) {
	        actor.attemptsTo(
	        		Click.on(viewGmail.REDACTAR_BTN),
	                Enter.theValue(to)
	                     .into(Box_SendEmail.PARA_FIELD)
	                     .thenHit(ENTER),
	                     
	                     Enter.theValue(subjetc)
	                     .into(Box_SendEmail.ASUNTO_FIELD)
	                     .thenHit(ENTER),
	                     
	                     Enter.theValue(description)
	                     .into(Box_SendEmail.DESCRIPCION_FIELD)
	                     .thenHit(ENTER),
	                     
	                     Click.on(Box_SendEmail.ENVIAR_FIELD)
	        );
	    }
	    


	    public static SendEmail forTheTerm(String to, String subject, String description) {
	        return instrumented(SendEmail.class, to, subject, description);
	    
	    }

}
