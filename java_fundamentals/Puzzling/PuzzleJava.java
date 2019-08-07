import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

public class PuzzleJava {
    public static ArrayList printSum(int[] arr) {
        ArrayList<Integer> newList = new ArrayList<Integer>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (arr[i] > 10) {
                newList.add(arr[i]);
            }
        }
        System.out.println(sum);
        // System.out.println(newList);
        return newList;
    }

    public static ArrayList shuffleAndGreaterThan5() {
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("Nancy");
        arr.add("Jinichi");
        arr.add("Fujibayashi");
        arr.add("Momochi");
        arr.add("Ishikawa");

        Collections.shuffle(arr);
        System.out.println(arr);

        arr.removeIf(name -> (name.length() <= 5));
        return arr;
    }

    public void shuffleAlphabet() {
        ArrayList<String> alphaArr = new ArrayList<String>();
        for (char alpha = 'A'; alpha <= 'Z'; alpha++) {
            alphaArr.add(Character.toString(alpha));
        }
        System.out.println(alphaArr);
        Collections.shuffle(alphaArr);
        System.out.println(alphaArr);

        System.out.println("First letter of shuffled array: " + alphaArr.get(0));
        System.out.println("Last letter of shuffled array: " + alphaArr.get(25));
        String sample = alphaArr.get(0);

        if ("AEIOU".indexOf(sample) > 0) {
            System.out.println("The first letter happens to be a vowel!");
        }
    }

    public static ArrayList generateTenRandomNums() {
        ArrayList<Integer> intArr = new ArrayList<Integer>();
        for (int i = 1; i <= 10; i++) {
            intArr.add(ThreadLocalRandom.current().nextInt(55, 100));
        }
        return intArr;
    }

    public static ArrayList sortTenRandomNums() {
        ArrayList<Integer> intArr = new ArrayList<Integer>();
        int min = 100;
        int max = 55;
        for (int i = 1; i <= 10; i++) {
            int newNum = ThreadLocalRandom.current().nextInt(55, 100);
            intArr.add(newNum);
            if (newNum < min) {
                min = newNum;
            } else if (newNum > max) {
                max = newNum;
            }
        }
        Collections.sort(intArr);
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
        return intArr;
    }

    public static String randomString() {
        Random rand = new Random();
        StringBuilder randString = new StringBuilder();
        String alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i = 0; i < 5; i++){
            randString.append(alpha.charAt(rand.nextInt(alpha.length())));
        }
        String finalString = randString.toString();
        return finalString;
    }
    public static ArrayList randomStringOfStrings(){
        Random rand = new Random();
        StringBuilder randString = new StringBuilder();
        ArrayList<String> randList = new ArrayList<String>();
        String alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i = 0; i <10; i++){
            for(int j = 0; j < 5; j++){
                randString.append(alpha.charAt(rand.nextInt(alpha.length())));
            }
            String finalString = randString.toString();
            randList.add(finalString);
            randString.setLength(0);
        }
        return randList;    
        }
}
