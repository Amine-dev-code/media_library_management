import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;


abstract class Personne {
    String nom;  
    String prenom;
    LocalDate dateN;
    Personne(String nom,String prenom,LocalDate dateN){à
        this.nom = nom;
        this.prenom = prenom;
        this.dateN = dateN;
    }   
}
class Bibliothecaire extends Personne{
    Bibliothecaire(String nom,String prenom,LocalDate dateN){
        super( nom, prenom, dateN);
    }
}

class Adherent extends Personne{
    int matA;
    Adherent(String nom,String prenom,LocalDate dateN,int matA){
        super( nom, prenom, dateN);
        this.matA = matA;
    }
    
    public void setDateN(LocalDate dateN) {

        this.dateN = dateN;
    }
    public void setMatA(int matA) {
        this.matA = matA;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    static int count = 0;
    static LinkedList<Adherent> listAdherents = new LinkedList<Adherent>();

    void ajouter(){
        listAdherents.add(this);
        count++;
    }
    static int rechAdh(int matA){
        int i=0;
        boolean found=false;
        while (i<Adherent.count && found==false) {
            if (listAdherents.get(i).matA == matA){
                return i;
            }
            i++;
        }
        return -1;
    }

    
    static void afichTab(){
        if (count > 0){
            for (int i = 0; i < count; i++) {
                System.out.println("Nom: "+ listAdherents.get(i).nom + " Prenom: " + listAdherents.get(i).prenom + " Matricule: " +listAdherents.get(i).matA);
            }  
        }else{
            System.out.println("Aucun Adherant trouvee");
        }
    }
    void copy(Adherent a){
        this.nom = a.nom;
        this.prenom = a.prenom;
        this.dateN = a.dateN;
        this.matA = a.matA;
    }
}
    
abstract class Media{

    int quantite;
    String titre;
    String cote;

    Media(int quantite, String titre, String cote){
        this.titre = titre;
        this.quantite = quantite;
        this.cote = cote;
    }
    public void setCote(String cote) {
        this.cote = cote;
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    static void addMedia(Media m){
        if (m instanceof Livre){
            Livre.listLivres.add((Livre)m);
            Livre.count++;
        }
        if (m instanceof Memoire){
            Memoire.listMemoires.add((Memoire)m);
            Memoire.count ++;
        }
        if (m instanceof Cd){
            Cd.listCds.add((Cd)m) ;
            Cd.count ++;
        }
    }
    static void affichtab(){
        System.out.println("Les Livres:");
        for (int i = 0; i < Livre.count; i++) {
            System.out.println(" Titre: " + Livre.listLivres.get(i).titre +" Cote: "+ Livre.listLivres.get(i).cote + " Quantite: " +Livre.listLivres.get(i).quantite);
        }
        System.out.println("Les Memoires:");
        for (int i = 0; i < Memoire.count; i++) {
            System.out.println(Memoire.listMemoires.get(i).titre +" "+ Memoire.listMemoires.get(i).cote + " " +Memoire.listMemoires.get(i).quantite);
        }
        System.out.println("Les Cds:");
        for (int i = 0; i < Cd.count; i++) {
            System.out.println(Cd.listCds.get(i).titre +" "+ Cd.listCds.get(i).cote + " " +Cd.listCds.get(i).quantite);
        }  
    }
    static int rechMedia(Media m){
        if (m instanceof Livre){
            for (int i = 0; i < Livre.count; i++) {
                if(Livre.listLivres.get(i).cote.equals(m.cote)){
                    return i;
                }
            }
        }
        if (m instanceof Memoire){
            for (int i = 0; i < Memoire.count; i++) {
                if(Memoire.listMemoires.get(i).cote.equals(m.cote)){
                    return i;
                }
            }
        }
        if (m instanceof Cd){
            for (int i = 0; i < Cd.count; i++) {
                if(Cd.listCds.get(i).cote.equals(m.cote)){
                    return i;
                }
            }
        }
        
        return -1;
    }
    public void copy(Media m) {
        this.cote = m.cote;
        this.quantite = m.quantite;
        this.titre = m.titre;
    }
    static boolean dispo(Media m){
        int i=0;
        boolean found=false;
        if (m instanceof Livre){
            while(i < Livre.count && found==false ) {
                if(Livre.listLivres.get(i).cote.equals(m.cote)){
                    
                    if(Livre.listLivres.get(i).quantite>0){
                        found=true;
                        return true;
                    }
                    else{
                        return false;
                    }
                }
                i++;
            }
        }
        if (m instanceof Memoire){
            
            while(i < Memoire.count && found==false) {
                if(Memoire.listMemoires.get(i).cote.equals(m.cote)){
                    if(Memoire.listMemoires.get(i).quantite>0){
                        found=true;
                        return true;
                    }
                    else{
                        return false;
                    }
                }
                i++;
            }
        }
        if (m instanceof Cd){
            while(i < Cd.count && found==false ) {
                if(Cd.listCds.get(i).cote.equals(m.cote)){
                    if(Cd.listCds.get(i).quantite>0){
                        found=true;
                        return true;
                    }
                    else{
                        return false;
                    }
                }
                i++;
            }
        }
        return false;
    }
}

class Livre extends Media{ 
    Livre (int quantite, String titre, String cote){
        super(quantite, titre, cote);
    }
    static LinkedList<Livre> listLivres= new LinkedList<Livre>();
    static int count = 0;
}

class Memoire extends Media{
    Memoire (int quantite, String titre, String cote){
        super(quantite, titre, cote);
    }
    static LinkedList<Memoire> listMemoires= new LinkedList<Memoire>();
    static int count = 0;
        
}

class Cd extends Media{
    Cd (int quantite, String titre, String cote){
        super(quantite, titre, cote);
    }
    static LinkedList<Cd> listCds= new LinkedList<Cd>();
    static int count = 0;
}

abstract class Emprunt {
    LocalDate dateE;
    int matA;
    String cote;
    Emprunt ( LocalDate dateE,int matA,String cote){
        this.dateE=dateE;
        this.matA=matA;
        this.cote=cote;
    }
    public void setdateE (LocalDate dateE){
        this.dateE=dateE;
    }
    public void setmatA (int matA){
        this.matA=matA;
    }
    public void setCote(String cote) {
        this.cote = cote;
    }
    static void addMediaE(Emprunt e){
        if (e instanceof LivreE){
            LivreE.listLivresE.add((LivreE)e);
            LivreE.count++;
        }
        if (e instanceof MemoireE){
            MemoireE.listMemoiresE.add((MemoireE)e);
            MemoireE.count++;
        }
        if (e instanceof CdE){
            CdE.listCdsE.add((CdE)e) ;
            CdE.count ++;
        }
    }
    static void affichtabE(){
        System.out.println("Les Livres:");
        for (int i = 0; i < LivreE.count; i++) {
            System.out.println( LivreE.listLivresE.get(i).cote + " " +LivreE.listLivresE.get(i).matA + LivreE.listLivresE.get(i).dateE);
        }
        System.out.println("Les Memoires:");
        for (int i = 0; i < MemoireE.count; i++) {
            System.out.println( MemoireE.listMemoiresE.get(i).cote + " " +MemoireE.listMemoiresE.get(i).matA + MemoireE.listMemoiresE.get(i).dateE);
        }
        System.out.println("Les Cds:");
        for (int i = 0; i < Cd.count; i++) {
            System.out.println( CdE.listCdsE.get(i).cote + " "  +CdE.listCdsE.get(i).matA + CdE.listCdsE.get(i).dateE);
        }
        
    }
    static int rechMediaE(Emprunt e){
        int i=0;
        boolean found=false;
        if (e instanceof LivreE){
            while(i<LivreE.count && found==false ) {
                if(LivreE.listLivresE.get(i).cote.equals(e.cote) && LivreE.listLivresE.get(i).matA==(e.matA) ){
                    found=true;
                    return i;
                }
                i++;
            }
        }
        if (e instanceof MemoireE){
            while(i<MemoireE.count && found==false ) {
                if(MemoireE.listMemoiresE.get(i).cote.equals(e.cote) && MemoireE.listMemoiresE.get(i).matA==(e.matA) ){
                    found=true;
                    return i;
                }
                i++;
            }
        }
        if (e instanceof CdE){
            {while(i<CdE.count && found==false )
                if(Cd.listCds.get(i).cote.equals(e.cote)&& CdE.listCdsE.get(i).matA==(e.matA)){
                    found=true;
                    return i;
                }
                i++;
            }
        }
        
        return -1;
    }
    static int countB = 0;
    static LinkedList<Emprunt> blackList= new LinkedList<Emprunt>();
    static int checkBlacklist(Emprunt t){
        int i=0;
        boolean found=false;
         while(i<countB && found==false); {
            if(t.matA==Emprunt.blackList.get(i).matA){
                found=true;
                return i;
            }
            i++;
        }
        return -1;
    }

    static void Blacklist(){
        int n = LivreE.count;
        int m = MemoireE.count;
        int j = CdE.count;
        LocalDate nowDate = LocalDate.now();

        for (int i=0; i<n;i++){
            LocalDate d = LivreE.listLivresE.get(i).dateE;
            LivreE o = LivreE.listLivresE.get(i);
            if(ChronoUnit.DAYS.between(d,nowDate)>10){
                if(checkBlacklist(o) == -1){
                    Emprunt.blackList.add(o);
                    Emprunt.countB++;
                }
            } 
        }
        for (int i=0; i<m;i++){
            LocalDate d =MemoireE.listMemoiresE.get(i).dateE;
            MemoireE o =MemoireE.listMemoiresE.get(i);
            if(ChronoUnit.DAYS.between(d,nowDate)>10){
                if(checkBlacklist(o) == -1){
                    Emprunt.blackList.add(o);
                    Emprunt.countB++;
                }
            } 
        }
        for (int i=0; i<j;i++){
            LocalDate d =CdE.listCdsE.get(i).dateE;
            CdE o =CdE.listCdsE.get(i);
            if(ChronoUnit.DAYS.between(d,nowDate)>10){
                if(checkBlacklist(o) == -1){
                    Emprunt.blackList.add(o);
                    Emprunt.countB++;
                }
            } 
        }
        if(countB > 0){
            for(int i=0; i<countB;i++){
                System.out.println("Adherant : " + Emprunt.blackList.get(i).matA);
            }
        }
        else{
            System.out.println("Aucun adherant trouvee");
        }
        
    }
}
class LivreE extends Emprunt{ 
    LivreE ( LocalDate dateE,int matA,String cote) {
        super(  dateE, matA, cote);
    }
    static LinkedList<LivreE> listLivresE= new LinkedList<LivreE>();
    
    static int count = 0;
    public void setdateE (LocalDate dateE){
        this.dateE=dateE;
    }
    public void setmatA (int matA){
        this.matA=matA;
    }
    public void setCote(String cote) {
        this.cote = cote;
    }

}
class MemoireE extends Emprunt{
    MemoireE (LocalDate dateE,int matA,String cote){
        super(  dateE,matA, cote);
    }
    static LinkedList<MemoireE> listMemoiresE= new LinkedList<MemoireE>();
    
    static int count = 0;
    public void setdateE (LocalDate dateE){
        this.dateE=dateE;
    }
    public void setmatA (int matA){
        this.matA=matA;
    }
    public void setCote(String cote) {
        this.cote = cote;
    }
        
}
class CdE extends Emprunt{
    CdE ( LocalDate dateE,int matA,String cote){
        super( dateE, matA, cote);
    }
    static LinkedList<CdE> listCdsE= new LinkedList<CdE>();
    static int count = 0;
    public void setdateE (LocalDate dateE){
        this.dateE=dateE;
    }
    public void setmatA (int matA){
        this.matA=matA;
    }
    public void setCote(String cote) {
        this.cote = cote;
    }
}




