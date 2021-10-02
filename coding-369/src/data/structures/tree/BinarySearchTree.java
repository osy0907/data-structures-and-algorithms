package data.structures.tree;

public class BinarySearchTree {
    Node head = null;

    public boolean insertNode(int data) {
        if (this.head == null) {
            this.head = new Node(data);
        } else {
            Node findNode = this.head;
            while (true) {

                if (data < findNode.value) {
                    if (findNode.left != null) {
                        findNode = findNode.left;
                    } else {
                        findNode.left = new Node(data);
                        break;
                    }
                } else {
                    if (findNode.right != null) {
                        findNode = findNode.right;
                    } else {
                        findNode.right = new Node(data);
                        break;
                    }
                }
            }
        }
        return true;
    }

    public Node search(int data) {
        if (head != null) {
            Node findNode = this.head;
            while (findNode != null) {
                if (findNode.value == data) {
                    return findNode;
                } else if (data < findNode.value) {
                    findNode = findNode.left;
                } else {
                    findNode = findNode.right;
                }
            }
        }
        return null;
    }

    public boolean delete(int value) {
        boolean searched = false;
        Node currParentNode = this.head;
        Node currNode = this.head;

        if (this.head == null) {
            return false;
        } else {
            if (this.head.value == value && this.head.left == null && this.head.right == null) {
                this.head = null;
                return true;
            }

            while (currNode != null) {
                if (currNode.value == value) {
                    searched = true;
                    break;
                } else if (value < currNode.value) {
                    currParentNode = currNode;
                    currNode = currNode.left;
                } else {
                    currParentNode = currNode;
                    currNode = currNode.right;
                }
            }

            if (!searched) {
                return false;
            }
        }

        if (currNode.left == null && currNode.right == null) {
            if (value < currParentNode.value) {
                currParentNode.left = null;
            } else {
                currParentNode.right = null;
            }
            currNode = null;
            return true;
        } else if (currNode.left != null && currNode.right == null) {
            if (value < currParentNode.value) {
                currParentNode.left = currNode.left;
            } else {
                currParentNode.right = currNode.left;
            }
            currNode = null;
            return true;
        } else if (currNode.left == null && currNode.right != null) {
            if (value < currParentNode.value) {
                currParentNode.left = currNode.right;
            } else {
                currParentNode.right = currNode.right;
            }
            currNode = null;
            return true;
        } else {
            if (value < currParentNode.value) {
                Node changeNode = currNode.right;
                Node changeParentNode = currNode.right;
                while (currNode.left != null) {
                    changeParentNode = currNode;
                    changeNode = currNode.left;
                }
                if (changeNode.right != null) {
                    changeParentNode.left = changeNode.right;
                } else {
                    changeParentNode.left = null;
                }
                currParentNode.left = changeNode;
                changeNode.right = currNode.right;
                changeNode.left = currNode.left;

                currNode = null;
            } else {
                Node changeNode = currNode.right;
                Node changeParentNode = currNode.right;
                while (changeNode.left != null) {
                    changeParentNode = changeNode;
                    changeNode = changeNode.left;
                }

                if (changeNode.right != null) {
                    changeParentNode.left = changeNode.right;
                } else {
                    changeParentNode.left = null;
                }

                currParentNode.right = changeNode;
                changeNode.right = currNode.right;
                changeNode.left = currNode.left;

                currNode = null;
            }
            return true;
        }
    }

    public static class Node {
        Node left;
        Node right;
        int value;

        Node(int data) {
            this.value = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree myTree = new BinarySearchTree();
        insertNodes(myTree);
        deleteNodes(myTree);

        System.out.println("HEAD: " + myTree.head.value);
        System.out.println("HEAD LEFT: " + myTree.head.left.value);
        System.out.println("HEAD LEFT LEFT: " + myTree.head.left.left.value);
        System.out.println("HEAD LEFT RIGHT: " + myTree.head.left.right.value);

        System.out.println("HEAD RIGHT: " + myTree.head.right.value);
        System.out.println("HEAD RIGHT LEFT: " + myTree.head.right.left.value);
        System.out.println("HEAD RIGHT RIGHT: " + myTree.head.right.right.value);

        System.out.println("HEAD RIGHT RIGHT LEFT: " + myTree.head.right.right.left.value);
        System.out.println("HEAD RIGHT RIGHT RIGHT: " + myTree.head.right.right.right.value);
    }

    private static void deleteNodes(BinarySearchTree myTree) {
        System.out.println(myTree.delete(15));
    }

    private static void insertNodes(BinarySearchTree myTree) {
        System.out.println(myTree.insertNode(10));
        System.out.println(myTree.insertNode(15));
        System.out.println(myTree.insertNode(13));
        System.out.println(myTree.insertNode(11));
        System.out.println(myTree.insertNode(14));
        System.out.println(myTree.insertNode(18));
        System.out.println(myTree.insertNode(16));
        System.out.println(myTree.insertNode(19));
        System.out.println(myTree.insertNode(17));
        System.out.println(myTree.insertNode(7));
        System.out.println(myTree.insertNode(8));
        System.out.println(myTree.insertNode(6));
    }
}
