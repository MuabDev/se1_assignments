package org.hbrs.se.ws20.uebung3.persistence;

import org.hbrs.se.ws20.uebung2.Container;
import org.hbrs.se.ws20.uebung2.ContainerException;
import org.hbrs.se.ws20.uebung3.persistence.view.MemberView;

import java.io.IOException;

public class Main {
    public static void main(String args[]) throws ContainerException, IOException, PersistenceException {

        Container container = Container.getInstance();
        container.setStrategy( new PersistenceStrategyStream());
        MemberView view = new MemberView();
        Client client = new Client(container,view);
    }
}
