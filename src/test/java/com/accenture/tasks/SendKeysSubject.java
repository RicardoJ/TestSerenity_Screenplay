package com.accenture.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

import com.accenture.ui.Box_Send;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class SendKeysSubject implements Task {
	
	private final String subject;

    protected SendKeysSubject(String searchTerm) {
        this.subject = searchTerm;
    }

    @Step("Send keys subject")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(subject)
                     .into(Box_Send.ASUNTO_FIELD)
                     .thenHit(ENTER)
        );
    }
    


    public static SendKeysSubject forTheTerm(String searchTerm) {
        return instrumented(SendKeysSubject.class, searchTerm);
    
    }

}
