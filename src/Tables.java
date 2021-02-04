import java.util.Scanner;
import java.util.Arrays;

public class Tables {
    private static Scanner scanner = new Scanner(System.in);





    public static void main(String[] args) {
        int userInput = scanner.nextInt();
        scanner.nextLine();

        int[] array = readIntoArray(userInput);
        printArray(array);
        System.out.println(maxMark(array));

    }

    public static int[] readIntoArray(int sizeOfArray){
        if(sizeOfArray > 100 || sizeOfArray <0){
            System.out.println("Please you entered an invalid number of students");
            return null;
        }

        int[] userArray = new int[sizeOfArray];
        for(int i = 0; i < sizeOfArray; i++){
            int mark = scanner.nextInt();
            if(mark < 0 || mark > 100){
                mark = 0;
            }
            userArray[i] = mark;
        }
        return userArray;
    }

    public static int maxMark(int[] array){
        int temp = Integer.MIN_VALUE;
        for(int i = 0; i< array.length;i++){
            if(array[i]>temp){
                temp = array[i];
            }
        }
        return temp;
    }

    public static int minMark(int[] array){
        int temp = Integer.MAX_VALUE;
        for(int i = 0; i< array.length;i++){
            if(array[i]<temp){
                temp = array[i];
            }
        }
        return temp;
    }

    public static int avgMark(int[] array){
        int sum = 0;
        for(int i = 0; i< array.length;i++){
                sum += array[i];
        }
        return sum/array.length;
    }

    public static void printArray(int[] array){
        System.out.println(Arrays.toString(array));
    }
}
