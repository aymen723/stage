package org.shotestplace;

import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * shortestpalce
 */
public class shortestpalce {

    public static void main(String[] args) {

        node n1 = new node("a");
        node n2 = new node("b");
        node n3 = new node("c");
        node n4 = new node("d");
        node n5 = new node("f");
        node n6 = new node("e");

        n1.adddestionation(n2, 10);
        n1.adddestionation(n3, 15);
        n2.adddestionation(n4, 12);
        n2.adddestionation(n5, 15);
        n3.adddestionation(n6, 10);
        n4.adddestionation(n5, 1);
        n4.adddestionation(n6, 2);
        n5.adddestionation(n6, 5);

        graphe g = new graphe("test");

        g.addnode(n2);
        g.addnode(n3);
        g.addnode(n4);
        g.addnode(n5);
        g.addnode(n6);
        g.setFirstnode(n1);

        LinkedList<node> test = shortestpalce.getshrotestpath(g, n1);

        for (node node : test) {
            System.out.println(node.name);
        }
    }

    public static LinkedList<node> getshrotestpath(graphe g, node start) {
        start.setDistance(0);

        LinkedList<node> settled = new LinkedList<node>();
        LinkedList<node> unsettled = new LinkedList<node>();

        unsettled.add(start);

        while (unsettled.size() != 0) {
            node currentNode = shortestpalce.getLowestDistanceNode(unsettled);
            System.out.println("here in main " + unsettled.size());
            unsettled.remove(currentNode);
            // System.out.println("here in big function " + currentNode.name);
            System.out.println("test");
            for (Map.Entry<node, Integer> adjacencyPair : currentNode.getAdjacentNodes().entrySet()) {
                node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settled.contains(adjacentNode)) {
                    shortestpalce.CalculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettled.add(adjacentNode);
                }
            }

            settled.add(currentNode);

        }
        return settled;
    }

    public static void CalculateMinimumDistance(node evaluationNode,
            Integer edgeWeigh, node sourceNode) {
        System.out.println("here in CalculateMinimumDistance " + evaluationNode.name);
        Integer sourceDistance = sourceNode.getDistance();
        System.out.println("here in CalculateMinimumDistance " + sourceDistance);

        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            System.out
                    .println("am here in CalculateMinimumDistance fro evaluationNode " + evaluationNode.getDistance());
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

    public static node getLowestDistanceNode(LinkedList<node> unsettledNodes) {
        node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        System.out.println(unsettledNodes.size());
        for (node node : unsettledNodes) {
            System.out.println("here in function " + node.name);
            int nodeDistance = node.getDistance();
            System.out.println("here in function " + nodeDistance);
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

}