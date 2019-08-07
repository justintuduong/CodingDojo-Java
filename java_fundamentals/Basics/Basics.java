import java.util.ArrayList;

public class Basics {
    public void printRange() {
        for (int i = 1; i <= 255; i++) {
            System.out.println(i);
        }
    }

    public void printOddRange() {
        for (int i = 1; i <= 255; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }

    public void printSum() {
        int sum = 0;
        for (int i = 1; i <= 255; i++) {
            sum += i;
            System.out.println(String.format("New Number: %d, Sum: %d", i, sum));
        }
    }

    public void iteratingThroughAnArray(int[] arr) {
        for (int i = 1; i <= arr.length - 1; i++) {
            System.out.println(arr[i]);
        }
    }

    public void findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i <= arr.length - 1; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println(max);
    }

    public void getAverage(int[] arr) {
        int total = 0;
        for (int i = 0; i <= arr.length - 1; i++) {
            total += arr[i];
        }
        System.out.println(total / arr.length);
    }

    public void arrayWithOddNumbers() {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 1; i <= 255; i++) {
            if (i % 2 != 0) {
                arr.add(i);
            }
        }
        System.out.println(arr);
    }

    public void greaterThanY(int[] arr, int y) {
        int count = 0;
        for (int i = 0; i <= arr.length - 1; i++) {
            if (arr[i] > y) {
                count++;
            }
        }
        System.out.println(count);
    }

    public void squareTheValues(int[] arr) {
        for (int i = 0; i <= arr.length - 1; i++) {
            arr[i] = arr[i] * arr[i];
            System.out.println(arr[i]);
        }
    }

    public void eliminateNegativeNumbers(int[] arr) {
        for (int i = 0; i <= arr.length - 1; i++) {
            if (arr[i] < 0) {
                arr[i] = 0;
            }
            System.out.print(arr[i]);
        }
    }

    public void maxMinAverage(int[] arr) {
        int[] results = { arr[0], arr[0], arr[0] };

        for (int i = 1; i <= arr.length - 1; i++) {
            if (arr[i] > results[0]) { // max
                results[0] = arr[i];
            } else if (arr[i] < results[1]) { // min
                results[1] = arr[i];
            } else {
                System.out.println("nothing changed.");
            }
            results[2] += arr[i]; // total;
            System.out.println(results[2]);

        }
        results[2] = results[2] / arr.length;   // average
        for (int i = 0; i <= results.length - 1; i++) { 
            System.out.println(results[i]);
        }
    }

    public void shiftValuesInArray(int[] arr) {
        for (int i = 1; i <= arr.length-1; i++) {
            int temp = arr[i];
            arr[i-1] = temp;
            System.out.println(arr[i]);
        }
        arr[arr.length-1] = 0;
        System.out.println(arr[(arr.length-1)]);
    }
}
