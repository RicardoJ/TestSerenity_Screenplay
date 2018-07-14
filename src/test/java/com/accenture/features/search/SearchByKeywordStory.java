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

import com.accenture.tasks.UserGmail;
import com.accenture.ui.Boton_Redactar;

import cucumber.api.Result;

import com.accenture.Excel.LecturaArchivoExcel;

import com.accenture.dato.Dato;
import com.accenture.questions.TheResult;
import com.accenture.tasks.ClickSendMessage;
import com.accenture.tasks.OpenTheApplication;
import com.accenture.tasks.Open_boton_redactar;
import com.accenture.tasks.Open_enviados;
import com.accenture.tasks.PassGmail;
import com.accenture.tasks.Search;
import com.accenture.tasks.SendKeysDescription;
import com.accenture.tasks.SendKeysSubject;
import com.accenture.tasks.SendKeysTo;

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
    Open_boton_redactar open_boton_redactar;
    
    @Steps
    ClickSendMessage clickSendMessage;
    
    @Steps
    Open_enviados clickEnviados;


    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void search_results_should_show_the_search_term_in_the_title() {

        givenThat(anna).wasAbleTo(openTheApplication);//precondicion

        
        	
        	 when(anna).attemptsTo(UserGmail.forTheTerm(rb.getString("user"))); //accion
             
             and(anna).attemptsTo(PassGmail.forTheTerm(rb.getString("password")));
        	
        
       
        
        for (Dato informacion :lectura.leer()) {
        and(anna).wasAbleTo(open_boton_redactar);
        and(anna).attemptsTo(SendKeysTo.forTheTerm(informacion.getCorreo()));
        and(anna).attemptsTo(SendKeysSubject.forTheTerm(informacion.getAsunto()));
        and(anna).attemptsTo(SendKeysDescription.forTheTerm(informacion.getDescripcion()));
        and(anna).wasAbleTo(clickSendMessage);
        }
        and(anna).wasAbleTo(clickEnviados);
        
        then(anna).should(seeThat(TheResult.is(), containsString("selenium y serenity")));//resultado
//GoTo.theElement
    }
}