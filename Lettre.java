public class Lettre{

    public int line ;
    public int column;
    public char data;

    public Lettre(int line,int column, char data){
        this.line=line;
        this.column=column;
        this.data=data;
    }

    public Lettre(){
        this.line=0;
        this.column=0;
        this.data=0;
    }

    int j = 0;
    // Cette fonction prend en paramètre un tableau de String et retourne
    //un tableau de Lettres

    public Lettre[] conversionLettres(char[] tab){
        Lettre[] Lettres = new Lettre[tab.length];

        //i représente la colonne et j la ligne

        for(int i=0;i<tab.length;i++){
            //J'ai interchangé i et j
            Lettres[i]=new Lettre(j,i,tab[i]);
        }
        j++;

        return Lettres;
    }


}