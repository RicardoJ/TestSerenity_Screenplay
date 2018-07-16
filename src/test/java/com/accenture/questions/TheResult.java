package com.accenture.questions;

import com.accenture.ui.AsuntoEnviado;
import com.accenture.ui.Box_SendEmail;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.UIStateReaderBuilder;

public class TheResult implements Question<String>  {
 
	@Override
    public String answeredBy(Actor actor) {
                   // TODO Auto-generated method stub
                   return Text.of(AsuntoEnviado.ASUNTOS_ENVIADOS_BTN).viewedBy(actor).asString();
    }

    public static TheResult is() {
                   // TODO Auto-generated method stub
                   return new TheResult();
    }

}
