package org.hbrs.se.ws20.uebung1.control;

public class GermanTranslator implements Translator {

	public String date = "Okt/2020"; // Default-Wert

	/**
	 * Methode zur Übersetzung einer Zahl in eine String-Repraesentation
	 */
	public String translateNumber( int number ) { 
		// [ihr Source Code aus Übung 1-2]
		String uebersetzung="";

		String[] deutscheZahlen = {"eins","zwei","drei","vier","fünf","sechs","sieben","acht","neuen","zehn"};
		try{
			return deutscheZahlen[number-1];
		}
		catch (ArrayIndexOutOfBoundsException e){
			return "Übersetzung der Zahl "+ number +" nicht möglich ("+Translator.version+")";

		}
	}
		
	/**
	 * Objektmethode der Klasse GermanTranslator zur Ausgabe einer Info.
	 */
	public void printInfo() {
		System.out.println( "GermanTranslator v1.9, erzeugt am " + this.date );
	}

	/**
	 * Setzen des Datums, wann der Uebersetzer erzeugt wurde (Format: Monat/Jahr (Beispiel: Nov/2020))
	 * Das Datum sollte system-intern gesetzt werden und nicht von externen View-Klassen
	 */
	public void setDate( String date ) {
		this.date = date;
	}

}
