// 4.	WAP in java which will read the data from two files simultaneously using SequenceInputStream and display on the monitor as well write the data to the third file.

import java.io.*;

public class SequenceInputStreamExample {
    public static void main(String[] args) {
        String fileName1 = "input1.txt";
        String fileName2 = "input2.txt";
        String outputFile = "output.txt";
        File inputFile1 = new File(fileName1);
        File inputFile2 = new File(fileName2);
        File outputFileFile = new File(outputFile);

        try {
            // Open input files for reading
            FileInputStream inputStream1 = new FileInputStream(inputFile1);
            FileInputStream inputStream2 = new FileInputStream(inputFile2);

            // Open output file for writing
            FileOutputStream outputStream = new FileOutputStream(outputFileFile);

            // Create a sequence input stream to read from both files simultaneously
            SequenceInputStream sequenceInputStream = new SequenceInputStream(inputStream1, inputStream2);

            // Read and display data from sequence input stream and write to output file
            int data;
            while ((data = sequenceInputStream.read()) != -1) {
                System.out.print((char) data); // display on monitor
                outputStream.write(data); // write to output file
            }

            // Close input and output streams
            sequenceInputStream.close();
            inputStream1.close();
            inputStream2.close();
            outputStream.close();

            System.out.println("File copy operation completed successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
