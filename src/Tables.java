import java.util.Scanner;
import java.util.Arrays;

public class Tables {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Sample Inputs:
        // 20
        // 60 23 98 45 56 17 62 50 80 90 20 58 09 40 35 29 32 49 57 69

        System.out.print("Please enter the number of students: ");
        int userInput = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please enter the marks for the "+userInput+" number of students (separated by spaces): ");
        int[] array = readIntoArray(userInput);
        printArray(array);
        System.out.println(maxMark(array));
        System.out.println(minMark(array));
        System.out.println(avgMark(array));
        printArray(scores(array));

        drawGraph(scores(array));
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

    public static double avgMark(int[] array){
        double sum = 0;
        for(int i = 0; i< array.length;i++){
                sum += array[i];
        }
        return sum/array.length;
    }

    public static int[] scores(int[] array){
        int[] scores = new int[5];

        for(int i = 0; i<array.length; i++){
            if(array[i]>0 && array[i] <=20){
                scores[0]++;
            }
            else if(array[i]>20 && array[i] <=40){
                scores[1]++;
            }
            else if(array[i]>40 && array[i] <=60){
                scores[2]++;
            }
            else if(array[i]>60 && array[i] <=80){
                scores[3]++;
            }
            else{
                scores[4]++;
            }
        }
        return scores;
    }

    public static void drawGraph(int[] scores){
        int maxY = maxMark(scores);
        int minY = 0;
        int maxX = 100;
        int minX = 0;

        // This prints the y-axis and the data
        String hash = "#######";
        String empty ="       ";
        for(int y = maxY; y> 0; y--){
            System.out.printf("%5d >  ",y);
            for(int i =0; i<scores.length;i++) {
                if (i == 0 && y <= scores[0]) {
                    System.out.printf("%s ", hash);
                }
                else if(i == 1 && y <= scores[1]){
                    System.out.printf("%s ",hash);
                }

                else if(i == 2 && y <= scores[2]){
                    System.out.printf("%s ",hash);
                }
                else if(i == 3 && y <= scores[3]){
                    System.out.printf("%s ",hash);
                }
                else if(i == 4 && y <= scores[4]){
                    System.out.printf("%s ",hash);
                }
                else{
                    System.out.printf("%s ", empty);
                }
            }
            System.out.println();
        }

        // This prints the X-axis for the graph
        System.out.print("\t+");
        for(int x = 0; x <= maxX-1; x += 20){
            System.out.print("-------+");
        }

        System.out.print("\n");
        System.out.print("\t"+ minX+ "\t");
        for(int x = 21; x <= maxX; x += 20){
            System.out.print("\t"+x+"\t");
        }
        System.out.print("\t"+maxX);

    }

    public static void printArray(int[] array){
        System.out.println(Arrays.toString(array));
    }
}
