package org.hbrs.se.ws20.uebung3.persistence;

import java.io.*;
import java.util.List;

public class PersistenceStrategyStream<Member> implements PersistenceStrategy<Member> {

    ObjectInputStream ois = null;
    FileInputStream fis = null;
    ObjectOutputStream oos = null;
    FileOutputStream fos = null;
    List<Member> newListe =  null;


    @Override
    public void openConnection() throws PersistenceException, IOException {
        fis = new FileInputStream( "data.txt" );
        ois = new ObjectInputStream(fis);
        fos = new FileOutputStream("data.txt");
        oos = new ObjectOutputStream(fos);
    }

    @Override
    public void closeConnection() throws PersistenceException, IOException {
        ois.close();
        fis.close();
        fos.close();
        oos.close();
    }

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     */
    public void save(List<Member> member) throws PersistenceException, IOException {

        openConnection();
        oos.writeObject(member);
        closeConnection();
    }

    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     */
    public List<Member> load() throws PersistenceException, IOException {
        // Some Coding hints ;-)
        // ObjectInputStream ois = null;
        // FileInputStream fis = null;
        // List<...> newListe =  null;
        //
        // Initiating the Stream (can also be moved to method openConnection()... ;-)
        // fis = new FileInputStream( " a location to a file" );
        // ois = new ObjectInputStream(fis);

        // Reading and extracting the list (try .. catch ommitted here)
        // Object obj = ois.readObject();

        // if (obj instanceof List<?>) {
        //       newListe = (List) obj;
        // return newListe

        // and finally close the streams (guess where this could be...?)
        Object obj = null;
        openConnection();
        try{
            obj = ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (obj instanceof List<?>) {
            newListe = (List) obj;
            return newListe;
        }

        closeConnection();

        return null;
    }
}
