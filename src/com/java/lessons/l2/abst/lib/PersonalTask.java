package com.java.lessons.l2.abst.lib;

//Revize 20150426 1400

import java.util.Date;

/*Podtrida PersonalTask: dedi od TaskAbstract
attributy: timeSolved

datesolved() //if <due_to tak getissolved vyreseno ontime.
automaticky se to uzavre Closed();

*/


/**
 * 
 * @author Main_User
 *
 */

/**
 * @author Main_User
 *
 */
public class PersonalTask extends TaskAbstract{
	
    /**
     * PersonalTask je potomek TaskAbstract. Oproti programatorovi
     * kdyz vyprsi cas dueDate tak se uzavira automaticky
     * 
     * @param description
     * @param length
     * @param dueTo
     * @param name
     */
    public PersonalTask(String description, String length, Date dueTo,
			String name) {
		super( description, length, dueTo, name);
		this.isClosed = false;
	}

	/**
	 * onTimeSolved true kdyz???
	 */
	private boolean onTimeSolved = false;
	
	
	
    /**
     * Po instancializaci je null (pocita se s tim). Az pokud je task Solved, nastavi se i tento datum 
     */
    private Date dateSolved;
    
    /**
     * Zde zkousim je ze zachytim vyjimku
     * pri deleni nulou
     * 
     * Dale nastavim PersonalTask.dateSolved a pokud je to drive nez
     * dueTo tak soucasne nastavim ze onTimeSolved = true
     * 
     * @param dSolved - datum vyreseni
     */
    public void setDateSolved(Date dSolved)  {
      
    try {	
      int dTest = 0;	
      System.out.println(3/dTest);}    //<<<< Pokus o RunTime chybu
    catch(Exception e) {
    	System.out.println("Tisk StackTrace vyjimky");
    	// Tady sireni exception konci a dal se pokracuje
    	e.printStackTrace();
    	//System.exit(111);
    }
    finally{
    	System.out.println("Konec vyjimky");
    }
      
      this.dateSolved = dSolved;
      if (this.dueTo.after(dSolved) ) {
    	  onTimeSolved = true;
    	  this.isClosed = true;
      }
    }
    
    
    
    
	/**
	 * @return boolean zda je/byl reseny ukol vyreseny pred dueTo
	 */
	public boolean getIsSolvedOnTime() {
		return this.onTimeSolved;
	}

	/** (non-Javadoc)
	 * @see com.java.lessons.l2.abst.lib.TaskAbstract#getIsSolved()
	 * 
	 * Pokud je dateSolved uz nastaveny (neni null), vrati true
	 * podobny attribut je i attribut onTimeSolved
	 */
	@Override
	public boolean getIsSolved() {
		boolean retVal = false;
		if ( this.dateSolved != null) { retVal = true;
		}
		return retVal;
	}	
	
	
	/** (non-Javadoc)
	 * @see com.java.lessons.l2.abst.lib.TaskAbstract#close()
	 * 
	 * Nastavi attribut isClosed na true
	 * 
	 */
	@Override
	public void close() {
		this.isClosed = true;
	}
	
@Override 
public String toString() {
	String sOut = super.toString() + "\n Solved onTime:" +  getIsSolvedOnTime() + "\n Solved:" +  getIsSolved();
	return sOut;
}
	
}
