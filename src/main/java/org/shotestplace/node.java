package org.shotestplace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class node {

    public String name;

    private int distance = Integer.MAX_VALUE;

    private List<node> shortestPath = new LinkedList<>();

    public List<node> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<node> shortestPath) {
        this.shortestPath = shortestPath;
    }

    Map<node, Integer> adjacentNodes = new HashMap<>();

    public node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Map<node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void adddestionation(node n, int nbr) {
        adjacentNodes.put(n, nbr);
    }

}
