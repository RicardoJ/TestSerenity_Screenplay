package com.accenture.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

import com.accenture.ui.Box_Send;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class SendKeysDescription implements Task {
	
	private final String description;

    protected SendKeysDescription(String searchTerm) {
        this.description = searchTerm;
    }

    @Step("Send keys subject")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(description)
                     .into(Box_Send.DESCRIPCION_FIELD)
                     .thenHit(ENTER)
        );
    }
    


    public static SendKeysDescription forTheTerm(String searchTerm) {
        return instrumented(SendKeysDescription.class, searchTerm);
    
    }


}
