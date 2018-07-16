package com.accenture.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.accenture.tasks.LoginGmail;
import com.accenture.ui.viewGmail;

import cucumber.api.Result;

import com.accenture.Excel.LecturaArchivoExcel;

import com.accenture.dato.Dato;
import com.accenture.questions.TheResult;

import com.accenture.tasks.OpenTheApplication;

import com.accenture.tasks.Open_enviados;

import com.accenture.tasks.Search;

import com.accenture.tasks.SendEmail;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

import java.sql.ResultSet;
import java.util.ResourceBundle;

@RunWith(SerenityRunner.class)
public class SearchByKeywordStory {

    Actor anna = Actor.named("Anna");
    ResourceBundle rb = ResourceBundle.getBundle("com/accenture/dato/configuracion");
    LecturaArchivoExcel lectura = new LecturaArchivoExcel();
   
   
    
    
    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Steps
    OpenTheApplication openTheApplication;
    
  
    
 
    @Steps
    Open_enviados clickEnviados;


    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void search_results_should_show_the_search_term_in_the_title() {

        givenThat(anna).wasAbleTo(openTheApplication);//precondicion

        
        	
        when(anna).attemptsTo(LoginGmail.forTheTerm(rb.getString("user"),rb.getString("password"))); //accion
             

        
        for (Dato informacion :lectura.leer()) {
        
        and(anna).attemptsTo(SendEmail.forTheTerm(informacion.getCorreo(),informacion.getAsunto(), informacion.getDescripcion()));
        }
        and(anna).attemptsTo(clickEnviados);
        
        then(anna).should(seeThat(TheResult.is(), containsString("selenium y serenity")));//resultado
//GoTo.theElement
    }
}
