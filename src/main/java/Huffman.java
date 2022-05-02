class Huffman {
    private static String value;
    private static char charArray[];
    private static int table[] = new int[0x7f];
    private static Node myNode[];
    private static int lengthOfTable = 0;
    private static tree myTree;
    private static int lengthOfNode = 0;
    public static HuffmanTransversor hC;

    public Huffman(String value) {
        frequencyTable(value);
        nodeArrange();
        Node x = createTree();
        hC = new HuffmanTransversor(x, charArray);
    }

    //Encuentra los valores que se repiten
    public static void frequencyTable(String value) {
        charArray = value.toCharArray();
        for (int i = 0; i < charArray.length; i++)
            table[getAscii(charArray[i])] += 1;
    }

    public static int getAscii(char substringValue) {
        return substringValue & 0x7f;
    }

    //Asigna un nodo a cada valor
    public static void nodeArrange() {
        int counter = 0;
        for (int i = 0; i < table.length; i++) {
            if (table[i] != 0) counter++;
        }
        lengthOfTable = counter;
        counter = 0;
        myNode = new Node[lengthOfTable];
        for (int i = 0; i < table.length; i++) {
            if (table[i] != 0) {
                myNode[counter] = new Node(table[i], (char) i, null, null);
                System.out.println("fecuencia de: "+ (char) i+ " = "+table[i] );
                counter++;
            }
        }
        System.out.println("\n");
        lengthOfNode = myNode.length;
        sort();
    }

    public static Node createTree() {
        for (int i = 1; i < lengthOfNode; i++) {
            try {
                if (myNode[1].frequency >= myNode[0].frequency) {
                    myTree = new tree(myNode[0], myNode[i]);
                    myNode[0] = myTree;
                    moveItems(i, lengthOfNode);
                    lengthOfNode -= 1;
                    i -= 1;
                    sort();
                } else {
                    if (i + 1 < lengthOfNode) {
                        myTree = new tree(myNode[i], myNode[i + 1]);
                        myNode[1] = myTree;
                        moveItems(i + 1, lengthOfNode);
                        sort();
                        lengthOfNode -= 1;
                        i -= 1;
                    } else {
                        myNode[1] = myNode[1];
                        myNode[0] = new tree(myNode[0], myNode[1]);
                    }
                }
            } catch (Exception e) {
            }
        }
        return myNode[0];

    }

    private static void moveItems(int index, int length) {
        try {
            for (int i = index; i < length; i++) myNode[i] = myNode[i + 1];

        } catch (Exception e) {
        }
    }

    //organiza los nodos en orden alfabetico
    private static void sort() {
        Node temp;
        for (int i = lengthOfNode - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (myNode[j].c < myNode[j + 1].c) {
                    temp = myNode[j + 1];
                    myNode[j + 1] = myNode[j];
                    myNode[j] = temp;
                }

                if (myNode[j].c == myNode[j + 1].c && myNode[j].left != null) {
                    temp = myNode[j + 1];
                    myNode[j + 1] = myNode[j];
                    myNode[j] = temp;
                }

            }
        }
    }
}
