import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Hospital {
    private Doctor[] doctors;
    public Hospital(String filePath) {
        readDoctorsDataFromFile(filePath);
    }
    private void readDoctorsDataFromFile(String fileName) {
        Scanner scanner = null;
        try {
            File file = new File(fileName);
            scanner = new Scanner(file);

            int numDoctors = Integer.parseInt(scanner.nextLine());
            this.doctors = new Doctor[numDoctors];

            for (int i = 0; i < numDoctors; i++) {
                String[] doctorData = scanner.nextLine().split(",");
                String id = doctorData[0];
                String name = doctorData[1];
                int numSlots = Integer.parseInt(doctorData[2]);
                this.doctors[i] = new Doctor(id, name, numSlots);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
