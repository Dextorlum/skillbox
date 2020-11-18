public class Main {
    public static void main(String[] args) {
        String alphabet = "abcdefgehijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUWXYZ";

        for (int i= 0; i <= alphabet.length()-1; i++){
            System.out.println(alphabet.charAt(i)+" - "+(int)alphabet.charAt(i));

        }
    }
}
