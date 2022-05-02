class Node {
    public int frequency;
    public char c;
    public Node left;
    public Node right;

    public Node(int frequency, char c, Node left, Node right) {
        this.frequency = frequency;
        this.c = c;
        this.left = left;
        this.right = right;
    }

    public Node() {
    }

    public Node addNode(Node node1, Node node2) {
        if (node1.frequency < node2.frequency) {
            left = node1;
            right = node2;
        } else {
            right = node1;
            left = node2;
        }
        frequency = node1.frequency + node2.frequency;
        return this;
    }
}