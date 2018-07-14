package com.accenture.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

import com.accenture.ui.Box_LoginGmail;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class PassGmail implements Task{
	private final String password;
	
	 protected PassGmail(String searchTerm) {
	        this.password = searchTerm;
	    }
    @Step("Search for password")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(password)
                     .into(Box_LoginGmail.PASS_FIELD)
                     .thenHit(ENTER)
        );
    }
    
    public static PassGmail forTheTerm(String searchTerm) {
        return instrumented(PassGmail.class, searchTerm);
    
    }
}
