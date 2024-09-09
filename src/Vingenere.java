import java.util.Scanner;

public class Vingenere {

    private static String encrypt(String Plain, String Key){
        String encrypted = "";
        int n = Plain.length();
        int m = Key.length();

        for (int i = 0; i < n; i++) {
            //i: i-th character on Plain message
            //i%m: corresponding position on Key message
            char PlainChar = Plain.charAt(i);
            char KeyChar = Key.charAt(i%m);

            //KeyChar's position on the alphabet
            int KeyPos = KeyChar - 'a';
            //Push PlainChar up *KeyPos* characters on the alphabet
            PlainChar += KeyPos;
            if (PlainChar > 'z')
                PlainChar -= 26;
            encrypted += PlainChar;
        }
        return encrypted;
    }

    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        System.out.print("input Plain message: ");
        String Plain = sc.nextLine();
        System.out.print("input key: ");
        String Key = sc.nextLine();

        //encrypt and decrypt
        String encrypted = encrypt(Plain, Key);
        System.out.println("Encrypted message: " + encrypted);
    }
}
