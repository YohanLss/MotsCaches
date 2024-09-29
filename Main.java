

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        // Define the file path containing all the grids
        String filePath = args[0];

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            int gridNumber = 1;

            while ((line = reader.readLine()) != null) {
                if (line.matches("\\d+ \\d+")) {
                    // Create a new instance of the Grille class for each grid
                    Grille grille = new Grille(filePath);
                    
                    System.out.println("Querry" + gridNumber + ":");
                    grille.trouveChemin();
                    
                    gridNumber++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
}
