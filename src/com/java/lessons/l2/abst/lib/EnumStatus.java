package com.java.lessons.l2.abst.lib;

//Revize 20150426 1400

/**
 * Enumeracni statusy pro stav jednotlivych ukolu.
 * BACHA Uz zase nechapu jak to funguje!
 *
 */

public enum EnumStatus {
		CREATED(0),
		REJECTED(1),
		ACCEPTED(2),
		INPROGRESS(3),
		SOLVED(4),
		REOPEN(5),
		FIXED(6);

	private int enumIndex;
	
	/**
	 * 
	 * @param enumIndex <<< co to ma za vyznam??
	 * 
	 * 
	 */
	
	EnumStatus(int enumIndex) {
		       this.enumIndex = enumIndex;
	}
	
	/**
	 * 
	 * @return  <<< co to ma za vyznam??
	 * 
	 * 
	 */
	
	public int getStatus() {
	  return this.enumIndex;	
	}
		
}
