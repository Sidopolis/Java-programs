// 2.	The system will ask you to enter the name of the file to read from. If the file will not exist, the system will ask you, do you want to create – if you press 1 than system will automatically create 	the file and ask to enter the data in the file. Then the system will ask you – do you want to copy the data to another file – if you press 1 than the system will ask you where you want to copy. If your entered file is there in the drive, than the program will append the data in that file otherwise the program will create the new file with that name and copy the data accordingly.

import java.io.*;

public class FileHandlingExample {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Enter the name of the file to read from: ");
        String sourceFileName = br.readLine();

        File sourceFile = new File(sourceFileName);

        // check if file exists
        if (!sourceFile.exists()) {
            System.out.println("File does not exist. Do you want to create it? (1 for Yes, 0 for No)");
            int createFileChoice = Integer.parseInt(br.readLine());

            if (createFileChoice == 1) {
                sourceFile.createNewFile();
                System.out.println("File created successfully!");
                
                // ask user to enter data into the newly created file
                System.out.println("Enter data to write to file:");
                FileWriter fw = new FileWriter(sourceFile);
                BufferedWriter bw = new BufferedWriter(fw);

                String data = br.readLine();
                bw.write(data);
                bw.newLine();
                bw.close();
                fw.close();
                
                System.out.println("Data written to file successfully!");
            } else {
                System.out.println("Exiting program.");
                System.exit(0);
            }
        }

        // check if user wants to copy data to another file
        System.out.println("Do you want to copy the data to another file? (1 for Yes, 0 for No)");
        int copyDataChoice = Integer.parseInt(br.readLine());

        if (copyDataChoice == 1) {
            System.out.print("Enter the name of the file to copy to: ");
            String destFileName = br.readLine();

            File destFile = new File(destFileName);

            FileWriter fw = new FileWriter(destFile, true);
            BufferedWriter bw = new BufferedWriter(fw);

            BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
            String line = reader.readLine();

            while (line != null) {
                bw.write(line);
                bw.newLine();
                line = reader.readLine();
            }

            reader.close();
            bw.close();
            fw.close();

            System.out.println("Data copied to file successfully!");
        }
    }
}
