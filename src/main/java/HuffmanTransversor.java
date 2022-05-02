class HuffmanTransversor {
    public Node rootNode;
    public char c;
    public char charArray[];
    public int i = 0;
    public String finalBitPattern = "";

    public HuffmanTransversor(Node myNode, char[] charArray) {
        String temp;
        int i;
        rootNode = myNode;

        this.charArray = charArray;
        for (i = 0; i < charArray.length; i++) {
            temp = search(rootNode, "", charArray[i]);
            finalBitPattern += temp + " ";
            System.out.println("Mis valores: " + charArray[i] + " = " + temp);
        }
    }

    public String search(Node rootNode, String value, char myChar) {
        String valueL = "";
        if (rootNode != null) {
            if (rootNode.left != null) valueL = search(rootNode.left, value + "0", myChar);
            if (rootNode.c == myChar) return value;

            else {
                if (valueL == "") {
                    return search(rootNode.right, value + "1", myChar);
                } else {
                    return valueL;
                }
            }
        } else {
            return "";
        }
    }
}
