import java.util.ArrayList;

public class StringOperationsWithCollections {
    public static ArrayList<String> performStringOperations(String S1, String S2) {
        ArrayList<String> results = new ArrayList<>();
        
        StringBuilder op1 = new StringBuilder();
        for (int i = 0; i < S1.length(); i++) {
            if (i % 2 == 0) {
                op1.append(S2);
            } else {
                op1.append(S1.charAt(i));
            }
        }
        results.add(op1.toString());
        
        int lastIndex = S1.lastIndexOf(S2);
        if (lastIndex != -1 && S1.indexOf(S2, S1.indexOf(S2) + 1) != -1) {
            StringBuilder reversedS2 = new StringBuilder(S2).reverse();
            String result = S1.substring(0, lastIndex) + reversedS2 + 
                           S1.substring(lastIndex + S2.length());
            results.add(result);
        } else {
            results.add(S1 + S2);
        }
        
        int firstIndex = S1.indexOf(S2);
        if (firstIndex != -1 && S1.indexOf(S2, firstIndex + 1) != -1) {
            String result = S1.substring(0, firstIndex) + 
                           S1.substring(firstIndex + S2.length());
            results.add(result);
        } else {
            results.add(S1);
        }
        
        int mid = (S2.length() + 1) / 2;
        String firstHalf = S2.substring(0, mid);
        String secondHalf = S2.substring(mid);
        results.add(firstHalf + S1 + secondHalf);
        
        StringBuilder op5 = new StringBuilder(S1);
        for (int i = 0; i < S1.length(); i++) {
            if (S2.indexOf(S1.charAt(i)) != -1) {
                op5.setCharAt(i, '*');
            }
        }
        results.add(op5.toString());
        
        return results;
    }

    public static void main(String[] args) {
        String S1 = "javajava";
        String S2 = "va";
        ArrayList<String> results = performStringOperations(S1, S2);
        
        // Print results
        for (int i = 0; i < results.size(); i++) {
            System.out.println("Operation " + (i + 1) + ": " + results.get(i));
        }
    }
}