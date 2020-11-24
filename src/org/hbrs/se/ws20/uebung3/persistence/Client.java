package org.hbrs.se.ws20.uebung3.persistence;

import org.hbrs.se.ws20.solutions.uebung2.MemberKonkret;
import org.hbrs.se.ws20.uebung2.ConcreteMember;
import org.hbrs.se.ws20.uebung2.Container;
import org.hbrs.se.ws20.uebung2.ContainerException;
import org.hbrs.se.ws20.uebung3.persistence.view.MemberView;

import java.io.IOException;

public class Client {

    public Client(Container container, MemberView view) throws ContainerException, IOException, PersistenceException {
        ConcreteMember member1 = new ConcreteMember(5);
        ConcreteMember member2 = new ConcreteMember(6);
        ConcreteMember member3 = new ConcreteMember(8);

        container.addMember(member1);
        container.addMember(member2);
        container.addMember(member3);

        container.store();
        container.load();

        view.dump(container.getCurrentList());
    }

}
