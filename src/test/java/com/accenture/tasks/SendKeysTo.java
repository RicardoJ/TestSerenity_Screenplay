package com.accenture.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

import com.accenture.ui.Box_LoginGmail;
import com.accenture.ui.Box_Send;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class SendKeysTo implements Task{
	
	
	 private final String to;

	    protected SendKeysTo(String searchTerm) {
	        this.to = searchTerm;
	    }

	    @Step("Send keys to")
	    public <T extends Actor> void performAs(T actor) {
	        actor.attemptsTo(
	                Enter.theValue(to)
	                     .into(Box_Send.PARA_FIELD)
	                     .thenHit(ENTER)
	        );
	    }
	    


	    public static SendKeysTo forTheTerm(String searchTerm) {
	        return instrumented(SendKeysTo.class, searchTerm);
	    
	    }

}
