import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Grille {

    public int ligne;
    public int colonne;
    public String File;

    public Lettre lettres[][] ;

    public boolean trouve = false;
    List<String> lettreTrouve=new ArrayList<>();
    List<char[] >echantillon= new ArrayList<>();
    


    public void trouveChemin(){

        //Grille de Lettre type Lettre
        //matrice contenant tous les éléments de la grille dans des tableaux


        //contient les mots à rechercher dans la grille
        String[] mots = getMots(File);

        //une bouclde de chaque mot a rechercher
        for (int m = 0; m < mots.length; m++){
            
            //System.out.println(mots[m]);

            for(int y = 0; y < ligne; y++){

                for (int x = 0; x < colonne; x++){
                    trouve = false;

                    checker(lettres[y][x], lettres, mots[m], 0,"");

                }
            }
        }

        for (String motTrouve : lettreTrouve) {

            char[] validSoluce= extractLetters(motTrouve);
            String solution =new String(validSoluce);
            
            for (int i = 0; i < mots.length; i++){
                String cherche=mots[i];
            
                if(solution.equals(cherche)){
                    //retirer les lettres de la chaîne de charactère
                    String result = motTrouve.replaceAll("[a-zA-Z]", "");
                    //juste pour retirer la dernière flèche
                    String realResult= result.substring(0, result.length() - 2);

                    System.out.println(solution+ " " + realResult);
    
                }
                
            }

        }
            
        
    }

    public char[] extractLetters(String input) {
        // Supprime les caractères non alphabétiques
        String cleanInput = input.replaceAll("[^a-zA-Z]", "");
        
        // Convertit la chaîne en un tableau de caractères
        char[] letters = cleanInput.toCharArray();

        return letters;
    }


    
    //Fonction récursive qui nous permet de valider les lettres de la grille
    public void checker(Lettre cur, Lettre[][] lettres, String mot, int i, String chemin) {
        
        chemin += cur.data + "(" + cur.line + "," + cur.column + ")" +"->";
        
        
        
    
        if (i == mot.length() - 1) {
            lettreTrouve.add(chemin);
            
            return;
        }
    
        int[] directionsX = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] directionsY = {1, 1, 0, -1, -1, -1, 0, 1};
    
        for (int dir = 0; dir < 8; dir++) {
            int nextX = cur.column + directionsX[dir];
            int nextY = cur.line + directionsY[dir];
            
    
            if (nextX >= 0 && nextX < colonne && nextY >= 0 && nextY < ligne) {
                if (cur.data == mot.charAt(i)) {
                    checker(lettres[nextY][nextX], lettres, mot, i + 1, chemin);
                    
                }
            }
        }

    
    }
    




    // Définie les dimensions de la grille
    public Grille(String File) {
        this.File = File;
        SetDimension();
        lettres = TraverserMatrice();

    }
    public void SetDimension(){

        //Pour pouvoir stocker les dimensions de la grille
        List<Integer> entier= new ArrayList<>();
        try{


            Path Fichier = Paths.get(File);

            BufferedReader Lecteur= Files.newBufferedReader(Fichier);

            String contenu=Lecteur.readLine();

            String[] Dimensions=contenu.split(" ");


            try {

                //Le nombre de lignes de la grille
                ligne = Integer.parseInt(Dimensions[0]);

                //Le nombre de colonnes de la grille
                colonne = Integer.parseInt(Dimensions[1]);

                //Ajout des dimensions dans la liste
                entier.add(ligne);
                entier.add(colonne);


            }

            catch (NumberFormatException e) {
                System.err.println("Erreur de conversion en entier : " + contenu);
            }

            int i=0;

        }

        catch(IOException e){
            e.printStackTrace();
        }
    }


    //Je veux lire la grille du fichier
    public Lettre[][] TraverserMatrice(){
        try {

            Lettre[][] grille = new Lettre[ligne][colonne];

            //Stocke les coordonnées des lettres

            Path Fichier = Paths.get(File);
            BufferedReader Lecteur = Files.newBufferedReader(Fichier);

            // Ignorer la première ligne (car les dimensions ont déjà été lues)
            Lecteur.readLine();

            for (int i = 0; i < ligne; i++) {
                String ligneGrille = Lecteur.readLine();

                // stocker les éléments de la ligne dans un tableau
                String[] tab= ligneGrille.split(" ") ;
                //les éléments du tableau sont ainsi stockés dans une liste
                for(int a = 0; a < tab.length; a++){

                    grille[i][a] = new Lettre(i, a, tab[a].charAt(0));
                    grille[i][a].data = tab[a].charAt(0);

                    grille[i][a].line = i;
                    grille[i][a].column = a;

                }

            }

            return grille;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    //récupère les mots à rechercher dans la grille
    public String[] getMots(String File) {
        try {
            Path Fichier = Paths.get(File);
            BufferedReader Lecteur = Files.newBufferedReader(Fichier);

            //Ici je mets ligne+1 , pour sauter la première ligne qui contient les dimensions
            //de la grille
            for (int i = 0; i < ligne+1; i++) {
                Lecteur.readLine(); // Lire la ligne, mais ne rien faire avec son contenu
            }


            // On suppose que la ligne contenant les mots à chercher est la première ligne après la grille.
            String ligneMots = Lecteur.readLine();


            String[] mots = ligneMots.split(" ");

            return mots;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void sautLigne(){

        try{
            Path Fichier = Paths.get(File);
            BufferedReader Lecteur = Files.newBufferedReader(Fichier);
            String contenu=Lecteur.readLine();

            //Ici je mets ligne+1 , pour sauter la première ligne qui contient les dimensions
            //de la grille
            for (int i = 0; i < ligne+2; i++) {
                Lecteur.readLine(); // Lire la ligne, mais ne rien faire avec son contenu

            
        }
        }

        catch(IOException e){
            e.printStackTrace();
        }
    }



}




