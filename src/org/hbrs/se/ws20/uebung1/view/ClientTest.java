package org.hbrs.se.ws20.uebung1.view;

public class ClientTest {
    public static void main(String[] args){
        /*
        Simpler Test der Klasse Client
        ClientTest sollte vielleicht eher im Ordner test liegen, doch es muss hier direkt mit dem Test interagiert werden.
        Die Klasse Client war vorher nicht public und ich wollte für den Test auch keine Änderungen am eigentlichen Code vornehmen.
         */
        Client client = new Client();
        System.out.println("Zu Erwarten: Das Ergebnis der Berechnung: fünf");
        client.display(5);
        System.out.println("Zu Erwarten: Das Ergebnis der Berechnung: Übersetzung der Zahl -1 nicht möglich (1.0)");
        client.display(-1);
    }
}
