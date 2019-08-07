public class StringManipulatorTest {
    public static void main(String[] args) {
        // -----------------------------------------------------------------
        // concat
        // -----------------------------------------------------------------
        StringManipulator concat = new StringManipulator();
        String output = concat.trimAndConcat("   Hello    ", "   World   ");
        System.out.println(output);
        StringManipulator index = new StringManipulator();
        // -----------------------------------------------------------------
        // getIndexOrNull(string, char)
        // -----------------------------------------------------------------
        char letter = 'o';
        Integer a = index.getIndexOrNull("Coding", letter);
        Integer b = index.getIndexOrNull("Hello World", letter);
        Integer c = index.getIndexOrNull("Hi", letter);
        System.out.println(a); // 1
        System.out.println(b); // 4
        System.out.println(c); // null
        // -----------------------------------------------------------------
        // getIndexOrNull(string, string)
        // -----------------------------------------------------------------
        StringManipulator index2 = new StringManipulator();
        String word = "Hello";
        String subString = "llo";
        String notSubString = "world";
        Integer d = index2.getIndexOrNull(word, subString);
        Integer e = index2.getIndexOrNull(word, notSubString);
        System.out.println(d); // 2
        System.out.println(e); // null
        // -----------------------------------------------------------------
        // String concatSubstring(String, int, int, String)
        // -----------------------------------------------------------------
        StringManipulator concatSubstring = new StringManipulator();
        String result = concatSubstring.concatSubstring("Hello", 1, 2, "world");
        System.out.println(result); // eworld

    }
}
