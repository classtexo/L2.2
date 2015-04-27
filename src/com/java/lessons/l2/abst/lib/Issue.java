package com.java.lessons.l2.abst.lib;

//Revize 20150426 1400

/*Trida Issue: Id, Name, State, severenity

Podtrida ProgrammersTask: dedi od TaskAbstract
atributy isSolved
Issues - obsahuje vazby na Issue (agreguje do sebe Issues)
metoda getIssuesCount*/

/**
 * Trida pro Issue, vlastni atributy name,state a severity
 * obsahuje metody  ??? neni jak je vylistovat automaticky?
 * 
 * Preddefinovane konstruktory
 *  - Issue()
 *  - Issue(String name, int severity)
 *  
 * Metody : Get/Set + getIssuesCount() 
 *  
 * @author Main_User
 *
 */

public class Issue {
  int id = -1;
  String name ;
  StateVals state ;                //<< stavy Created, Accepted, Solved, Reopen
  int severity = 0;             //Pokud vse Solved => 
  static int issueIdIndex= -1;   //nove issue dostane prirazenou tuto hodnotu

@Override
public String  toString() {
	String sOut = "(" + this.id + ") " + name + "[" + state + "/" + severity + "]"; 
	return sOut; 
}
  
 /**
 * 
 */

public Issue() {
	 issueIdIndex ++;
	  this.id = issueIdIndex;
	  this.state = StateVals.CREATED;
  }
  
  /**
 * @param name
 * @param severity
 */
public Issue(String name, int severity) {
	  issueIdIndex ++;
	  this.id = issueIdIndex;
	  this.name = name;
	  this.state = StateVals.CREATED;
  }  
  
/**
 * @return
 */
public static int getIssuesCount(){
	return issueIdIndex;
}

public enum StateVals {   //Je to trida, tzn ze se jsmenuje StateVals ne stateVals a ma byt separe soubor.
	CREATED,
	ACCEPTED,
	SOLVED,
	REOPEN,
	FIXED
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public StateVals getState() {
	return state;
}

public void setState(StateVals stat) {
	this.state = stat;
}

public int getSeverity() {
	return severity;
}

public void setSeverity(int severity) {
	this.severity = severity;
}





}

