package com.company.my.poc.linkedList;

public class Node {

    public int data;
    public Node next;

    public void displayNode(){
        System.out.println("{ "+ data + " } ");
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node() {
    }
}
