package org.hbrs.se.ws20.uebung2;

import org.hbrs.se.ws20.uebung3.persistence.PersistenceException;
import org.hbrs.se.ws20.uebung3.persistence.PersistenceStrategy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Container {

    private static Container instance = null;
    private List<Member> memberList = new ArrayList<>();
    private PersistenceStrategy strategy = null;

    private void Container(){
    }

    public static synchronized Container getInstance() {
        if (instance==null){
            instance = new Container();
        }
        return instance;
    }


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
            if (memberInList.getID().equals(ID)){
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


    public List<Member> getCurrentList() {
        return this.memberList;
    }

    public int size() {
        return memberList.size();
    }

    public void store() throws PersistenceException, IOException {
        strategy.save(memberList);

    }

    public void load() throws PersistenceException, IOException {
        memberList =strategy.load();

    }

    public void setStrategy(PersistenceStrategy strategy) {
        this.strategy = strategy;
    }
}
