public class FizzBuzz {
    public String fizzbuzz(int number) {
        if (number % 15 == 0) {
            return "FizzBuzz";
        } else if (number % 5 == 0) {
            return "buzz";
        } else if (number % 3 == 0) {
            return "fizz";
        } else {
            String result = Integer.toString(number);
            return result;
        }
    } 
}
