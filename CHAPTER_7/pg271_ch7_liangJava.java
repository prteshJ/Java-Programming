import static java.util.Arrays.*;

public class pg271_ch7_liangJava{
    
    public static void main(String []args){
        double[] numbers = {6.0, 4.4, 1.9, 2.9, 3.4, 3.5};
        sort(numbers);
        for(double k: numbers) {
            System.out.print(k + " ");
        }
        System.out.println();
        
        char[] chars = {'a', 'A', '4', 'F', 'D' , 'P'};
        sort(chars, 1, 3);
        for(char k: chars) {
            System.out.print("[" + k + "=>" + (int)k + "] ");
        }
        System.out.println();
        
        int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
        System.out.println("1. Index is " + binarySearch(list, 11));
        System.out.println("2. Index is " + binarySearch(list, 12));
        
        char[] charS = {'a', 'c', 'g', 'x', 'y', 'z'};
        System.out.println("3. Index is " + binarySearch(charS, 'a'));
        System.out.println("4. Index is " + binarySearch(charS, 't'));
        
        int[] list1 = {2, 4, 7, 10};
        int[] list2 = {2, 4, 7, 10};
        int[] list3 = {4, 2, 7, 10};
        System.out.println(java.util.Arrays.equals(list1, list2));
        System.out.println(java.util.Arrays.equals(list2, list3));
        
        int[] list4 = {2, 4, 7, 10};
        int[] list5 = {2, 4, 7, 7, 7, 10};
        java.util.Arrays.fill(list4, 5);
        for(int k: list4) {
            System.out.print(k + " ");
        }
        System.out.println();
        
        java.util.Arrays.fill(list5, 1, 5, 8);
        for(int k: list5) {
            System.out.print(k + " ");
        }
        System.out.println();
        
        int[] list6 = {2, 4, 7, 10};
        System.out.println(java.util.Arrays.toString(list6));
    }
}