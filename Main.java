import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }

    public static boolean isPalindrome(Scanner sc) {
        System.out.print("Enter integer: ");
        int x = sc.nextInt();

        // logic
        String str = Integer.toString(x);
        int n = str.length();
        for (int i=0;i<n/2;i++) {
            if (str.charAt(i) != str.charAt(n-i-1)) {
                return false;
            }
        }
        return true;
    }
}
