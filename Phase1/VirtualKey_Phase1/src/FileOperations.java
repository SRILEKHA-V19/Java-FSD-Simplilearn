import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileOperations {

    // add a new file to the current directory
    public static void addFile(String fileName){
        Scanner sc = new Scanner(System.in);
        boolean flag = false;

        // ignoring case sensitivity of the user specified file name for add operation
        fileName = fileName.toLowerCase();

        // create File object
        File addNewFile = new File(fileName + ".txt");

        try {
            flag = addNewFile.createNewFile();
        } catch (IOException ioe) {
            System.out.println("Exception occurred while Creating File: " + ioe);
            ioe.printStackTrace();
            System.out.println("Could not create file named: " + fileName);
        }

        if(flag){
            System.out.println("New Added File " + addNewFile.getPath() + " Added Successfully!");

            // adding contents when New File is successfully added
            System.out.println("\nEnter the contents of the file " + fileName + ".txt: ");
            String fileContents = sc.next();
            BufferedOutputStream stream = null;
            try {
                stream = new BufferedOutputStream(new FileOutputStream(fileName + ".txt"));
                stream.write(fileContents.getBytes());
                System.out.println("Data Successfully Written to file " + fileName + ".txt");
            } catch (IOException e) {
                System.out.println("Exception occurred while Writing to the File: " + e);
                e.printStackTrace();
                System.out.println("New file added but could not add contents to " + fileName + ".txt");
            }
            finally {
                if(stream != null) {
                    try {
                        stream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        else
        {
            System.out.println("File Already Exists!");
            System.out.println("Could not create file named: " + fileName);
        }
    }

    // delete a specified file from the current directory
    public static void deleteFile(String fileName){
        File file = new File(fileName + ".txt");
        if(file.delete())
            System.out.println("File Deletion Successful for file: " + fileName + ".txt");
        else{
            System.out.println("File " + fileName + ".txt Not Found");
            System.out.println("File Deletion Failed for file: " + fileName + ".txt");
        }
    }

    // search for a specified file in the current directory
    public static void searchFile(String fileName){
        // current directory
        File directory = new File(".");
        File[] files = directory.listFiles((dir, name) -> {
            // match file names with .txt extension, lambda expression
            return name.endsWith(".txt");
        });

        int flag = 0;
        if (files.length > 0) {
            List<String> fNames = Arrays.asList(files)
                    .stream().map(x->x.getName())
                    .collect(Collectors.toList());
            // Linear search in the array
            for (String fName: fNames) {
                if (fName.equals(fileName + ".txt")) {
                    System.out.println("File with filename " + fileName + ".txt Found Successfully");
                    flag = 1;
                    break;
                }
            }
        }
        else {
            System.out.println("Empty directory, so could not find file " + fileName + ".txt");
        }

        if (flag == 0) {
            System.out.println("File with filename " + fileName + ".txt Not Found");
        }
    }

}
