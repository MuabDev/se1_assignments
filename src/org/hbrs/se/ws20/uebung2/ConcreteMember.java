package org.hbrs.se.ws20.uebung2;

public class ConcreteMember implements Member{

    private Integer id;

    public ConcreteMember(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getID() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Member (ID = "+ id +")";
    }
}
