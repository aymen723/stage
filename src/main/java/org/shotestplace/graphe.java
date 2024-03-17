package org.shotestplace;

import java.util.LinkedList;

public class graphe {

    LinkedList<node> allnode = new LinkedList<node>();
    node firstnode;
    String name;
    LinkedList<node> listpath = new LinkedList<node>();

    public graphe(String name) {
        this.name = name;
    }

    public LinkedList<node> getallnodes() {
        return allnode;
    }

    public LinkedList<node> getpath() {
        return listpath;
    }

    public void addnode(node node) {
        listpath.add(node);
    }

    public node getFirstnode() {
        return firstnode;
    }

    public void setFirstnode(node firstnode) {
        this.firstnode = firstnode;
    }

}
