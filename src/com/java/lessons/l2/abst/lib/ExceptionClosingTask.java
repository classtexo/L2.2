package com.java.lessons.l2.abst.lib;

//Revize 20150426 1400

import com.java.lessons.l2.abst.lib.Issue.StateVals;

/**
 * Handler pro pripad, ze pri uzavirani tasku dojde k chybe. Napriklad
 * ...co ??
 * 
 * Handler zajisti zobrazeni zamyslene chybove hlasky definovane
 * programatorem v konstruktoru (zprava + povoleny stav ze ktereho je mozne ukol uzavirat),
 * 
 * @author Main_User
 * 
 */

public class ExceptionClosingTask extends Exception{
	
	/**
	 * Kontruktor handleru pro zobrazeni chyby pri uzavirani ukolu
	 * ktery neni ve stavu SOLVED
	 * 
	 * @param messageException - zprava uzivateli
	 * @param eStatus = ??? k cemu to je, co to zas posilam za balast?
	 */
	ExceptionClosingTask(String messageException, StateVals eStatus) {
		System.out.println("ERROR : " + messageException);
		System.out.println("Chyba uzavirani tasku - nelze provest z predchoziho stavu :" + eStatus.name());
		System.out.println("Povoleny predchozi stav  :" + EnumStatus.SOLVED.name() );
	}

}
