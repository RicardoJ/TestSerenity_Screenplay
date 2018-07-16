package com.accenture.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

import com.accenture.ui.viewGmail;
import com.accenture.ui.Box_LoginGmail;
import com.accenture.ui.Box_SendEmail;
import com.accenture.ui.SearchBox;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class LoginGmail  implements Task{
	
    private final String user;
    private final String password;
 

    protected LoginGmail(String user ,String password) {
        this.user = user;
        this.password = password;
    }

    @Step("Search for usuario")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
        		
                Enter.theValue(user)
                     .into(Box_LoginGmail.USER_FIELD)
                     .thenHit(ENTER),
                     
                     Enter.theValue(password)
                     .into(Box_LoginGmail.PASS_FIELD)
                     .thenHit(ENTER)
                
        );
    }
    


    public static LoginGmail forTheTerm(String user , String password) {
        return instrumented(LoginGmail.class, user , password);
    
    }
}
