import java.io.*;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
      @param args
      @throws IOException
     */
    public static void main(String[] args) throws IOException {
        challengeOne("inputOneTwo.txt");
        challengeTwo("inputOneTwo.txt");
        challengeThree("inputThreeFour.txt");
        challengeFour("inputThreeFour.txt");
    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        int numberOfLines = countLinesInFile(fileName);
        int[] fileData = readFile(fileName);
        int count = 0;

        for (int i = 1; i < numberOfLines-1; i++) {
            if (fileData[i] < fileData[i+1]) count ++;
        }

        System.out.println(count);
        return count;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int numberOfLines = countLinesInFile(fileName);
        int[] fileData = readFile(fileName);
        int[] newSums = new int[numberOfLines - 2];

        for (int i = 0; i < newSums.length; i++) {
            newSums[i] = fileData[i] + fileData[i+1] + fileData[i+2];
        }

        int count = 0;
        for (int j = 1; j < newSums.length-1; j++) {
            if (newSums[j] < newSums[j + 1]) count++;
        }

        System.out.println(count);
        return count;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        int numberOfLines = countLinesInFile(fileName);
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        String[] fileData = new String[numberOfLines];
        int index = 0;
        while (scanner.hasNextLine()) {
            fileData[index++] = scanner.nextLine();
        }
        scanner.close();

        int depth = 0;
        int horizontal = 0;

        for(int i = 0; i < numberOfLines; i++) {
            int tempLen = fileData[i].length();
            int tempNo = Integer.parseInt(fileData[i].substring(tempLen-1));
            String tempSubStr = fileData[i].substring(0, tempLen-2);

            // for testing purposes
            //System.out.println(tempLen);
            //System.out.println(tempNo);
            //System.out.println(tempSubStr);

            if (tempSubStr.equals("forward")) horizontal += tempNo;
            else if (tempSubStr.equals("down")) depth += tempNo;
            else if (tempSubStr.equals("up")) depth -= tempNo;

            // for testing purposes
            //System.out.println(horizontal);
            //System.out.println(depth);
        }

        System.out.println(depth * horizontal);
        return depth * horizontal;
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        int numberOfLines = countLinesInFile(filename);
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        String[] fileData = new String[numberOfLines];
        int index = 0;
        while (scanner.hasNextLine()) {
            fileData[index++] = scanner.nextLine();
        }
        scanner.close();

        int depth = 0;
        int horizontal = 0;
        int aim = 0;

        for(int i = 0; i < numberOfLines; i++) {
            int tempLen = fileData[i].length();
            int tempNo = Integer.parseInt(fileData[i].substring(tempLen-1));
            String tempSubStr = fileData[i].substring(0, 1);

            // for testing purposes
            //System.out.println(tempLen);
            //System.out.println(tempNo);
            //System.out.println(tempSubStr);

            if (tempSubStr.equals("f")) {
                horizontal += tempNo;
                depth = aim * tempNo;
            }
            else if (tempSubStr.equals("d")) {
                aim += tempNo;
            }
            else if (tempSubStr.equals("u")) {
                aim -= tempNo;
            };

            // for testing purposes
            //System.out.println(horizontal);
            //System.out.println(depth);
        }

        System.out.println(depth * horizontal);
        return depth * horizontal;
        // return 0;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}