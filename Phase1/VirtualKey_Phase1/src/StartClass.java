import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class StartClass {

    // main method - starting point of the application/program
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("           WELCOME TO VIRTUAL KEY PROGRAM !!");
        System.out.println("-------------------------------------------------------");
        System.out.println("Application: Virtual Key for your repositories, Phase 1");
        System.out.println("Developer: Srilekha Vinjamara");
        System.out.println("-------------------------------------------------------");
        System.out.println();

        int choice;
        do{
            System.out.println("###############");
            System.out.println("   MAIN MENU");
            System.out.println("###############");
            System.out.println("1. List existing file names");
            System.out.println("2. Perform file input output operations");
            System.out.println("3. Exit");
            System.out.println();
            System.out.println("Enter your choice, from 1 to 3: ");

            // accepting input as char and then implicit typecasting to accept non-integer values
            // and redirect to default case for retry instead of throwing exception
            choice = sc.next().charAt(0);
            choice = Character.getNumericValue(choice);

            switch(choice){
                case 1:
                    // current directory
                    File directory = new File(".");
                    File[] files = directory.listFiles((dir, name) -> {
                        // match file names with .txt extension, lambda expression
                        return name.endsWith(".txt");
                    });

                    System.out.println("The number of files present in the current directory are: " + files.length);
                    if(files.length > 0){
                        List<String> fileNames = Arrays.asList(files)
                                .stream().map(x->x.getName())
                                .collect(Collectors.toList());
                        // sorting file names in ascending order
                        Collections.sort(fileNames);

                        System.out.println("\nThe list of files in ascending order are as follows: ");
                        for (int i = 0; i < fileNames.size(); i++) {
                            System.out.println("filename " + (i + 1) + ": " + fileNames.get(i));
                        }
                    }
                    else{
                        System.out.println("No files present to list, in the current directory.");
                    }
                    System.out.println("\nGoing back to the Main Menu!");
                    System.out.println();
                    break;

                case 2:
                    int ch;
                    do{
                        System.out.println("###############");
                        System.out.println(" File Sub-Menu");
                        System.out.println("###############");
                        System.out.println("1. Add a text File");
                        System.out.println("2. Delete a text File");
                        System.out.println("3. Search for a text File");
                        System.out.println("4. Back to Main Menu");
                        System.out.println();
                        System.out.println("Enter your choice, from 1 to 4: ");

                        ch = sc.next().charAt(0);
                        ch = Character.getNumericValue(ch);

                        String fileName = "";

                        // nested switch for File Sub-Menu options
                        switch(ch){
                            case 1:
                                System.out.println("Enter the name of the file to be Added (without extension): ");
                                fileName = sc.next();
                                FileOperations.addFile(fileName);
                                System.out.println();
                                break;
                            case 2:
                                System.out.println("Enter the name of the file to be Deleted (without extension): ");
                                fileName = sc.next();
                                FileOperations.deleteFile(fileName);
                                System.out.println();
                                break;
                            case 3:
                                System.out.println("Enter the name of the file to be Searched (without extension): ");
                                fileName = sc.next();
                                FileOperations.searchFile(fileName);
                                System.out.println();
                                break;
                            case 4:
                                System.out.println("Going back to the Main Menu of the application ...");
                                System.out.println();
                                break;
                            default:
                                System.out.println("Invalid input. To try again, please select either of options from 1 to 4.");
                                System.out.println("\nGoing back to the File Sub-Menu!");
                                System.out.println();
                                break;
                        }
                    }while(ch != 4);
                    System.out.println();
                    break;

                case 3:
                    System.out.println("Exiting now from the application ...");
                    System.out.println();
                    break;

                default:
                    System.out.println("Invalid input. To try again, please select either of options from 1 to 3.");
                    System.out.println("\nGoing back to the Main Menu!");
                    System.out.println();
                    break;
            }
        }while(choice != 3);
        System.out.println("THANK YOU FOR TRYING OUT VIRTUAL KEY APPLICATION! :)");
    }
}
