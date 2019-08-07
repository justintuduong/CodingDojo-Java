public class StringManipulator {
    public String trimAndConcat(String a, String b){
        String c = a.trim();
        String d = b.trim();
        String concatted = c.concat(d);
        return concatted;
    } 
    public int getIndexOrNull(String a, char b){
        int output = a.indexOf(b);
        return output;
    }
    public int getIndexOrNull(String a, String b){
        int output = a.indexOf(b);
        return output;
    }
    public String concatSubstring(String a, int b, int c, String d){
        String output = a.substring(b,c) + d;
        return output;
    }
}

