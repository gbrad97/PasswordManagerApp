import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //System.out.println("\n\nHello, PasswordManagerApp!\n");
        System.out.println("\n\nWelcome to the PasswordManager!!\n");

        /*
         ArrayList<String> alphabet = new ArrayList<String>();
        alphabet.add("A");
        alphabet.add("B");
        alphabet.add("C");
        alphabet.add("D");
        alphabet.add("E");
        alphabet.add("F");
        alphabet.add("G");
        alphabet.add("H");
        alphabet.add("I");
        alphabet.add("J");
        alphabet.add("K");
        alphabet.add("L");
        alphabet.add("M");
        alphabet.add("N");
        alphabet.add("O");
        alphabet.add("P");
        alphabet.add("Q");
        alphabet.add("R");
        alphabet.add("S");
        alphabet.add("T");
        alphabet.add("U");
        alphabet.add("V");
        alphabet.add("W");
        alphabet.add("X");
        alphabet.add("Y");
        */
        ArrayList<String> passwordList = new ArrayList<String>();
        passwordList.add("123456");
        passwordList.add("Password");
        passwordList.add("12345678");
        passwordList.add("qwerty");
        passwordList.add("12345");
        passwordList.add("123456789");
        passwordList.add("letmein");
        passwordList.add("1234567");
        passwordList.add("football");
        passwordList.add("iloveyou");
        passwordList.add("admin");
        passwordList.add("welcome");
        passwordList.add("monkey");
        passwordList.add("login");
        passwordList.add("abc123");
        passwordList.add("starwars");
        passwordList.add("123123");
        passwordList.add("dragon");
        passwordList.add("passw0rd");
        passwordList.add("master");
        passwordList.add("hello");
        passwordList.add("freedom");
        passwordList.add("whatever");
        passwordList.add("qazwsx");
        passwordList.add("trustno1");



        // Generates a list of subsequences of length 3, from the list of top 25 passwords of 2017
        System.out.println("SubSequence List: " + generateSubSequenceList(3, passwordList));

        // Generates a map that contains all of the options for passwords based on each password subsequence
        Map<String, ArrayList<String>> passwordCycleMap = generatePasswordCycleMap(3, passwordList);
        System.out.println("\nPassword Cycle Map: " + passwordCycleMap);




    }


    public static String concatenateListIntoString (ArrayList<String> listOfPermittedPasswords) {
        StringBuilder str = new StringBuilder();
        // move consecutively through every index
        for (int i = 0; i < listOfPermittedPasswords.size(); i++) {
            str.append(listOfPermittedPasswords.get(i));
        }
        return str.toString();
    }


    public static ArrayList<String> generateSubSequenceList(int num, ArrayList<String> passwordList) {
        ArrayList<String> subSequenceList = new ArrayList<String>();
        String strOfPasswords = concatenateListIntoString(passwordList);
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < strOfPasswords.length() - num; i++) {
            CharSequence subSequence = strOfPasswords.subSequence(i, i + num);
            subSequenceList.add(subSequence.toString());
        }
        return subSequenceList;
    }


    public static Map<String, ArrayList<String>> generatePasswordCycleMap(int num, ArrayList<String> passwordList) {
        Map<String, ArrayList<String>> passwordCycleMap = new HashMap<String, ArrayList<String>>();
        ArrayList<String> subSequenceList = generateSubSequenceList(num, passwordList);
        // for each element in the list, split each string and place it in an arraylist
        // place that list as a value in the map, with the key being the element
        for (String subSequence : subSequenceList) {
            ArrayList<String> separatedSubSequenceList = new ArrayList<String>();
            for (int i = 0; i < subSequence.length(); i++) {
                String password = String.valueOf(subSequence.charAt(i));
                separatedSubSequenceList.add(password);
            }
            passwordCycleMap.put(subSequence, separatedSubSequenceList);
        }
        return passwordCycleMap;
    }
    /*

    public static void whatsTheNextPassword(Map<String, ArrayList<String>> passwordCycleMap) {
        //if current password is in a value of the map and it's index is not size - 1, return the next elememt
        Scanner scan = new Scanner(System.in);
        System.out.print("What's your current password?: ");
        String currentPassword = scan.next();
        //String nextPassword = "";
        for (String mapKey : passwordCycleMap.keySet()) {
            ArrayList<String> mapValue = passwordCycleMap.get(mapKey);
            for (int i = 0; i < mapValue.size() - 1; i++) {
                if (mapValue.get(i) == currentPassword && i != mapValue.size() - 1) {
                    String nextPassword = mapValue.get(i + 1);
                }
            }
            System.out.println("Your next password is: " + nextPassword);
        }

        //return nextPassword;
    }
    */
}
