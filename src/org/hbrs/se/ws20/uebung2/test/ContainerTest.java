package org.hbrs.se.ws20.uebung2.test;

import org.hbrs.se.ws20.uebung2.ConcreteMember;
import org.hbrs.se.ws20.uebung2.Container;
import org.hbrs.se.ws20.uebung2.ContainerException;
import org.hbrs.se.ws20.uebung2.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {
    Container container = Container.getInstance();
    Member member1,member2,member3;

    @BeforeEach
    void setUp() {

        member1 = new ConcreteMember(25);
        member2 = new ConcreteMember(32);
        member3 = new ConcreteMember(25);
    }

    //container.size() wird impliziert in addMember() und deleteMember() getestet
    @Test
    void addMember() throws ContainerException {
        assertEquals(0,container.size());
        container.addMember(member1);
        assertEquals(1,container.size());
        container.addMember(member2);
        assertEquals(2,container.size());

        try {
            container.addMember(member3);
        } catch (ContainerException toPrint) {
            toPrint.printStackTrace();
        }
        assertEquals(2,container.size());
    }

    @Test
    void deleteMember() throws ContainerException {
        container.addMember(member1);
        container.addMember(member2);
        assertEquals(2,container.size());

        container.deleteMember(25);
        assertEquals(1,container.size());



        String error = container.deleteMember(64);
        System.out.println(error);
        assertEquals(1,container.size());
    }

    @Test
    void dump() throws ContainerException {
        container.addMember(member1);
        container.addMember(member2);

        //alter Test container.dump();
    }

}