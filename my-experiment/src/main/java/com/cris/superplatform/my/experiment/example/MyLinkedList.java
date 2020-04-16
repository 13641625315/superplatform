package com.cris.superplatform.my.experiment.example;

public class MyLinkedList {
    public static void main(String[] args) {
        Node node = new Node(6);
        node.add(5);
        node.add(4);
        node.add(3);
        node.add(2);
        node.add(1);
        node.add(100, 3);
        System.out.println(node.toString());
        node.delete(3);
        System.out.println(node.toString());
        node.printNodeReversely(node);
        node = node.reverse();
        System.out.println(node.toString());
    }

    static class Node {
        Node next = null;
        Object data;

        public Node(Object data) {
            this.data = data;
        }

        private boolean hasNext() {
            if (null == this.next) {
                return false;
            }
            return true;
        }

        private Node get(int index) {
            if (!goodIndex(index)) {
                return null;
            }

            Node currNode = null;
            for (int i = 0; i <= index; i++) {
                if (null == currNode) {
                    currNode = this;
                } else {
                    currNode = currNode.next;
                }
            }

            return currNode;
        }

        private boolean add(Object data) {
            if (null == this.data) {
                this.data = data;
            } else {
                Node newNode = new Node(data);
                Node currNode = this;
                if (null == this.next) {
                    this.next = newNode;
                } else {
                    while (currNode.hasNext()) {
                        currNode = currNode.next;
                    }
                    currNode.next = newNode;
                }
            }
            return true;
        }

        private boolean add(Object data, int index) {
            if (!goodIndex(index)) {
                return false;
            }

            Node newNode = new Node(data);
            Node currNode = get(index - 1);
            boolean beforeLastIndex = beforeLastIndex(index);

            Node tmpNode = currNode.next;
            currNode.next = newNode;
            if (beforeLastIndex) {
                newNode.next = tmpNode;
            }
            return true;
        }

        private boolean delete(int index) {
            if (index < 1 || index > this.length()) {
                return false;
            }
            Node preNode = get(index - 1);
            Node followNode = get(index + 1);
            preNode.next = followNode;
            return true;
        }

        private int length() {
            Node currNode = this;
            int length = 1;
            while (currNode.hasNext()) {
                length++;
                currNode = currNode.next;
            }
            return length;
        }

        private Node orderList() {
            Node nextNode = null;
            int temp = 0;
            Node currNode = this;
            while (currNode.next != null) {
                nextNode = currNode.next;
                while (nextNode != null) {
                    if ((Integer) currNode.data > (Integer) nextNode.data) {
                        temp = (Integer) currNode.data;
                        currNode.data = nextNode.data;
                        nextNode.data = temp;
                    }
                    nextNode = nextNode.next;
                    System.out.println(this.toString());
                }
                currNode = currNode.next;
            }
            return this;
        }

        private boolean goodIndex(int index) {
            return index >= 0 && index < this.length();
        }

        private boolean beforeLastIndex(int index) {
            return index < this.length();
        }

        private Node reverse() {
            Node currNode = this;
            Node preNode = null;
            Node followNode = this;
            while (null != currNode) {
                if (followNode.hasNext()) {
                    followNode = followNode.next;
                } else if (null != preNode) {
                    followNode = null;
                }
                currNode.next = preNode;
                preNode = currNode;
                currNode = followNode;
            }
            return preNode;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("Node:");
            Node currNode = this;
            stringBuilder.append(currNode.data.toString());
            while (currNode.hasNext()) {
                stringBuilder.append(",");
                stringBuilder.append(currNode.next.data.toString());
                currNode = currNode.next;
            }
            return stringBuilder.toString();
        }

        private void printNodeReversely(Node head) {
            printNodeReversely(head.next);
            System.out.println(head.data);
        }
    }
}