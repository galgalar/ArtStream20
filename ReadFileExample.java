import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileExample {
    public static void main(String[] args) {

        String filePath = "Artstrem-13-main\\ArtStream13-main\\DashboardAdmin.txt"; // Replace with your file path

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            StringBuilder dataBlock = new StringBuilder();
            StringBuilder details = new StringBuilder(); // To accumulate the details lines

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    // Process the collected data when an empty line is encountered
                    if (dataBlock.length() > 0) {
                        // Split the dataBlock into name, type, and details
                        String[] parts = dataBlock.toString().split("\n");

                        if (parts.length >= 2) { // At least name and type should exist
                            String name = parts[0].trim(); // First line for Name
                            String type = parts[1].trim(); // Second line for Type

                            // If there are any accumulated details, join them into one string
                            String fullDetails = details.toString().trim();

                            // Print out the processed data
                            System.out.println("Name: " + name);
                            System.out.println("Type: " + type);
                            System.out.println("Details: " + fullDetails);
                            System.out.println("---------------");

                            // Clear the StringBuilder for the next data block
                            dataBlock.setLength(0);
                            details.setLength(0); // Clear the details StringBuilder
                        }
                    }
                } else {
                    // If the line is part of the name or type, add it to dataBlock
                    if (dataBlock.length() == 0 || dataBlock.toString().split("\n").length < 2) {
                        dataBlock.append(line).append("\n");
                    } else {
                        // Otherwise, append the line to details
                        details.append(line).append("\n");
                    }
                }
            }

            // Process any remaining data (in case the file does not end with an empty line)
            if (dataBlock.length() > 0) {
                String[] parts = dataBlock.toString().split("\n");
                if (parts.length >= 2) {
                    String name = parts[0].trim();
                    String type = parts[1].trim();
                    String fullDetails = details.toString().trim();

                    System.out.println("Name: " + name);
                    System.out.println("Type: " + type);
                    System.out.println("Details: " + fullDetails);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }




        
    }






}
