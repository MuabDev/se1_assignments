package org.hbrs.se.ws20.uebung2;

import java.util.ArrayList;
import java.util.List;

public class Container {

    private List<Member> memberList = new ArrayList<>();


    public void addMember(Member member) throws ContainerException {
        if (containsMember(member)){
            ContainerException toThrow = new ContainerException();
            toThrow.addId(member.getID());
            throw toThrow;
        }
        else {
            memberList.add(member);
        }
    }

    private boolean containsMember(Member toCompare) {
        Integer ID = toCompare.getID();
        for (Member memberInList:memberList) {
            if(memberInList.getID().equals(ID)){
                return true;
            }
        }
        return false;
    }

    public String deleteMember(Integer id) {
        Member toDelete = null;
        for (Member memberInList:memberList) {
            if (id.equals(memberInList.getID()))
                toDelete = memberInList;
        }
        if (toDelete==null){
            return "member with id: "+id +" not found";
        }
        else {
            memberList.remove(toDelete);
            return "member with id: "+ id + " deleted";
        }
    }

    public void dump() {
        System.out.println("Member Objekte in Container:");
        for (Member memberInList:memberList) {
            System.out.println(memberInList.toString());
        }

    }

    public int size() {
        return memberList.size();
    }
}
