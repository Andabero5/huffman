import java.util.Scanner;

class Main {
    static Huffman huffman;
    private static Scanner input = new Scanner(System.in);
    private static String value;

    public static void main(String args[]) {
        System.out.print("ingrese palabra: ");
        value = input.nextLine();
        value = value.replace(" ", "");
        System.out.println("el valor introducido es: " + value + "\n");
        huffman = new Huffman(value);
        System.out.println("La representación de bits de la cadena que has escrito es: " + huffman.hC.finalBitPattern);
    }
}