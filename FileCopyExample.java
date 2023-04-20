//3.	WAP in java which will read the data from a file and copy to another file in char by char 	format and byte by byute format

import java.io.*;

public class FileCopyExample {
    public static void main(String[] args) {
        String fileName = "input.txt";
        String outputFileChar = "outputChar.txt";
        String outputFileByte = "outputByte.txt";
        File inputFile = new File(fileName);
        File outputFileCharFile = new File(outputFileChar);
        File outputFileByteFile = new File(outputFileByte);

        try {
            // Open input file for reading
            FileInputStream inputStream = new FileInputStream(inputFile);

            // Open output files for writing
            FileWriter outputStreamChar = new FileWriter(outputFileCharFile);
            FileOutputStream outputStreamByte = new FileOutputStream(outputFileByteFile);

            // Read and write char-by-char
            int c;
            while ((c = inputStream.read()) != -1) {
                char character = (char) c;
                outputStreamChar.write(character);
            }

            // Reset input stream
            inputStream = new FileInputStream(inputFile);

            // Read and write byte-by-byte
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStreamByte.write(buffer, 0, length);
            }

            // Close input and output streams
            inputStream.close();
            outputStreamChar.close();
            outputStreamByte.close();

            System.out.println("File copy operation completed successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
