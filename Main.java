import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        switch (sc.nextLine()) {
            case "1":
                System.out.println(Arrays.toString(twoSum(sc)));
                break;
            case "9":
                System.out.println(isPalindrome(sc));
                break;
            case "13":
                System.out.println(romanToInt(sc));
                break;
            case "14":
                System.out.println(longestCommonPrefix(sc));
                break;
            case "20":
                System.out.println(isValid(sc));
                break;
            case "217":
                System.out.println(containsDuplicate(sc));
                break;
            case "2309":
                System.out.println(greatestLetterCorrectVersion(sc));
            default:
                System.out.println("TBC");
        }
    }

    private static int[] twoSum(Scanner sc) {
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        int[] nums = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter the target: ");
        int target = sc.nextInt();

        // logic
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static boolean isPalindrome(Scanner sc) {
        System.out.print("Enter integer: ");
        int x = sc.nextInt();

        // logic
        String str = Integer.toString(x);
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static int romanToInt(Scanner sc) {
        System.out.print("Enter roman string: ");
        String s = sc.nextLine();

        // logic
        int result = 0;
        int n1 = roman(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int n2 = roman(s.charAt(i));
            if (n1 < n2) {
                result -= n1;
            } else {
                result += n1;
            }
            n1 = n2;
        }
        result += n1;
        return result;
    }

    public static int roman(char r) {
        return switch (r) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

    public static String longestCommonPrefix(Scanner sc) {
        System.out.print("Enter the number of strings: ");
        int size = sc.nextInt();
        sc.nextLine();

        String[] strs = new String[size];

        System.out.println("Enter the strings:");
        for (int i = 0; i < size; i++) {
            System.out.print("String " + (i + 1) + ": ");
            strs[i] = sc.nextLine();
        }

        // logic
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length - 1];
        int n = 0;
        while (n < s1.length() && n < s2.length()) {
            if (s1.charAt(n) == s2.charAt(n)) {
                n++;
            } else {
                break;
            }
        }
        return s1.substring(0, n);
    }

    private static final Map<Character, Character> mapParentheses = Map.of(
        '(', ')',
        '[', ']',
        '{', '}'
    );

    public static boolean isValid(Scanner sc) {
        System.out.print("Enter the strings: ");
        String s = sc.nextLine();

        //logic
        char[] sArray = new char[s.length()];

        for (int i = 0; i < sArray.length; i++) {
            sArray[i] = s.charAt(i);
        }

        Stack<Character> stack = new Stack<>();
        for (char c : sArray) {
            if (mapParentheses.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char popOpenParenthesis = stack.pop();
                if (mapParentheses.get(popOpenParenthesis) != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean containsDuplicate(Scanner sc) {
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        int[] nums = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }

        // logic
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static String greatestLetter(Scanner sc) {
        System.out.print("Enter the strings: "); // lEeTcOdE
        String s = sc.nextLine();

        // logic

        char[] sArray = new char[s.length()];
        String upperCaseStr = s.toUpperCase();
        for (int i = 0; i < sArray.length; i++) {
            sArray[i] = upperCaseStr.charAt(i);

        }

        Map<Character, Integer> map = new TreeMap<>(Collections.reverseOrder());

        for (char c : sArray) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Character greatestLetter = null;
        int maxFrequency = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1 && entry.getValue() >= maxFrequency) {
                greatestLetter = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }

        // Return the result
        return greatestLetter != null ? String.valueOf(greatestLetter) : "";
    }

    public static String greatestLetterCorrectVersion(Scanner sc) {
        System.out.print("Enter the strings: "); // lEeTcOdE
        String s = sc.nextLine();

        // logic

        char[] sArray = new char[s.length()];
        for (int i = 0; i < sArray.length; i++) {
            sArray[i] = s.charAt(i);
        }

        Set<Character> charSet = new HashSet<>();
        for (char c : sArray) {
            charSet.add(c);
        }

        for (char c = 'Z'; c >= 'A'; c--) {
            if (charSet.contains(c) && charSet.contains(Character.toLowerCase(c))) {
                return String.valueOf(c);
            }
        }

        return "";
    }
}
