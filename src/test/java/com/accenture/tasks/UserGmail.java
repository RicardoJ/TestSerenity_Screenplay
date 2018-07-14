package com.accenture.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

import com.accenture.ui.Box_LoginGmail;
import com.accenture.ui.SearchBox;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class UserGmail  implements Task{
	
    private final String user;

    protected UserGmail(String searchTerm) {
        this.user = searchTerm;
    }

    @Step("Search for usuario")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(user)
                     .into(Box_LoginGmail.USER_FIELD)
                     .thenHit(ENTER)
        );
    }
    


    public static UserGmail forTheTerm(String searchTerm) {
        return instrumented(UserGmail.class, searchTerm);
    
    }
}
