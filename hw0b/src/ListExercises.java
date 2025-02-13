import edu.princeton.cs.algs4.In;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

public class ListExercises {

    /** Returns the total sum in a list of integers */
	public static int sum(List<Integer> L) {
        // TODO: Fill in this function.
        int sum = 0;
        for(int i = 0, len = L.size(); i < len; i ++)sum += L.get(i);
        return sum;
    }

    /** Returns a list containing the even numbers of the given list */
    public static List<Integer> evens(List<Integer> L) {
        // TODO: Fill in this function.
        List<Integer>even = new ArrayList<>();

        for(int i = 0, len = L.size(); i < len; i ++){
            int number = L.get(i);
            if(number % 2 == 0)even.add(number);
        }
        return even;
    }

    /** Returns a list containing the common item of the two given lists */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        // TODO: Fill in this function.
        List<Integer>common_number = new ArrayList<>();
        for(int i = 0, len1 = L1.size(); i < len1; i ++){
            int number1 = L1.get(i);
            for(int j = 0, len2 = L2.size(); j < len2; j ++){
                if(L2.get(j) == number1)common_number.add(number1);
            }
        }
        return common_number;
    }


    /** Returns the number of occurrences of the given character in a list of strings. */
    public static int countOccurrencesOfC(List<String> words, char c) {
        // TODO: Fill in this function.
        int cnt = 0;
        for(int i = 0, len1 = words.size(); i < len1; i ++){
            String word = words.get(i);
            for(int j = 0, len2 = word.length(); j < len2; j ++){
                if(word.charAt(j) == c)cnt ++;
            }
        }
        return cnt;
    }
}
