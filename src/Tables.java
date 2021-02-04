import java.util.Scanner;
import java.util.Arrays;

public class Tables {
    private static Scanner scanner = new Scanner(System.in);





    public static void main(String[] args) {
        int userInput = scanner.nextInt();
        scanner.nextLine();

        int[] array = readIntoArray(userInput);
        printArray(array);

    }

    public static int[] readIntoArray(int sizeOfArray){
        if(sizeOfArray > 100 || sizeOfArray <0){
            System.out.println("Please you entered an invalid number of students");
            return null;
        }

        int[] userArray = new int[sizeOfArray];
        for(int i = 0; i < sizeOfArray; i++){
            int mark = scanner.nextInt();
            userArray[i] = mark;
        }
        return userArray;
    }

    public static void printArray(int[] array){
        System.out.println(Arrays.toString(array));
    }
}
