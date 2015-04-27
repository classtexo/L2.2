package com.java.lessons.l2.abst.lib;

//Revize 20150426 1400

import java.util.Date;
import com.java.lessons.l2.abst.lib.Issue;

/*Ukol:
 Podtrida ProgrammersTask: dedi od TaskAbstract
     atributy isSolved
     Issues - obsahuje vazby na Issue (agreguje do sebe Issues)
                ????? Jak implementovat "agregaco" - jakym mechanismem <List> ?
                      Udelat nekolik instanci????
     metoda getIssuesCount

Trida Issue: 
      Id, Name, State, severenity

Podtrida PersonalTask: dedi od TaskAbstract
      attributy: timeSolved

pro ciselne typy pouzivej primitivni datove typy.*/
       //>>>??? A co stringy???

public class ProgrammersTask extends TaskAbstract{

	boolean isSolved = false;
	private Issue[] issues;    //list by byl pro programovani efektivnejsi
	
	//kdyz vsechny issues splneny tak getIsSolved vratie true; Specialitka Overridingu

    /**
     * ProgrammersTask je potomek TaskAbstract.  Agreguje do sebe Issues
     * 
     * @param description
     * @param length
     * @param dueTo
     * @param name
     * @param Issue[] issues
     */	
	
	public ProgrammersTask( String description, String length,
			Date dueTo, String name,Issue[] issues) {
		super(description, length, dueTo, name);
		this.issues = issues; 
		this.isClosed = false;
	}

	 @Override
	 public String toString() {
		 String sOut = super.toString() + "\nIs solved (all issues) :" +  this.isSolved ;
		 for (Issue tIss : this.issues) {
			 sOut = sOut + "\n issue:" + tIss.toString();
		 }
		 return sOut;
	 }	
	
	/**
	 * @return vrati pocet issues
	 */
	public int getIssuesCount() {
		return issues.length;
	}
	
	/** Pokusi se uzavrit Issues. Pokud nejsou vsechy FIXED hodi to chybu
	 * v opacnem pripade to i nastavi Issue na SOLVED
	 * @throws ExceptionClosingTask
	 */
	public void closeIssues() throws ExceptionClosingTask {
	  for (Issue iSsue: this.issues) {
		         if (iSsue.getState() != Issue.StateVals.FIXED) {
		        	 throw new  ExceptionClosingTask("Chyba uzavirani tasku", iSsue.getState());
		         }
		         iSsue.setState(Issue.StateVals.SOLVED);
		         this.isSolved = true;
		         // jaktoze mi to pri exception shodi vechno a dalsi task uz to nezprocesuje?
	  }
	}

	@Override
	public boolean getIsSolved() {
		  boolean retVal = true;
		  for (Issue iSsue: this.issues) {
			  if ( ! iSsue.state.equals(Issue.StateVals.SOLVED) ) {
				  retVal = false;
			  }
		  }		
		return retVal;
	}

	@Override
	public void close() {
		this.isClosed = true;
		
	}
	
	

}
