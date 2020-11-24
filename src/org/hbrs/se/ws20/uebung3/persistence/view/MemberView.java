package org.hbrs.se.ws20.uebung3.persistence.view;

import org.hbrs.se.ws20.uebung2.Container;
import org.hbrs.se.ws20.uebung2.Member;

import java.util.List;

public class MemberView {

    public void dump(List<Member> liste) {
        System.out.println("Member Objekte in Container:");

        for (Member memberInList: liste) {
            System.out.println(memberInList.toString());
        }
    }
}
