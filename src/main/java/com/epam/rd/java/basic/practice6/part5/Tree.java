package com.epam.rd.java.basic.practice6.part5;

public class Tree<E extends Comparable<E>> {

    Node<E> root;
    private boolean flag;

    public Tree() {
        this.root = null;
    }

    public boolean add(E element) {
        flag = false;
        root = addRecursive(root, element);
        return flag;
    }

    private Node<E> addRecursive(Node<E> node, E element) {
        if (node == null) {
            flag = true;
            return new Node<>(element);
        }

        if (element.compareTo(node.value) < 0) {
            node.left = addRecursive(node.left, element);
        } else if (element.compareTo(node.value) > 0) {
            node.right = addRecursive(node.right, element);
        } else {
            return node;
        }

        return node;
    }

    public void add(E[] elements) {
        for (int i = 0; i < elements.length; i++) {
            add(elements[i]);
        }

    }

    public boolean remove(E element) {
        flag = true;
        root = removeRecursive(root, element);
        return flag;
    }

    private Node<E> removeRecursive(Node<E> node, E element) {
        if (node == null) {
            flag = false;
            return null;
        }

        if (element == node.value) {
            if (node.left == null && node.right == null) {
                return null;
            }

            if (node.right == null) {
                return node.left;
            }

            if (node.left == null) {
                return node.right;
            }

            E smallestValue = findSmallestValue(node.right);
            node.value = smallestValue;
            node.right = removeRecursive(node.right, smallestValue);
            return node;
        }

        if (element.compareTo(node.value) < 0) {
            node.left = removeRecursive(node.left, element);
            return node;
        }

        node.right = removeRecursive(node.right, element);
        return node;
    }

    private E findSmallestValue(Node<E> root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    public void print() {
        goThroughTree(root, "");
    }

    public void goThroughTree(Node<E> node, String string) {
        if (node != null) {
            goThroughTree(node.left, string + " ");
            System.out.println(string + node.value);
            goThroughTree(node.right, string + " ");
        }
    }

    private static final class Node<E> {
        E value;
        Node<E> right;
        Node<E> left;

        Node(E value) {
            this.value = value;
            this.right = this.left = null;
        }


    }

}
