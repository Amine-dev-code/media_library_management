
import java.time.LocalDate;
import java.util.Scanner;


public class Bibliotheque {

    static void addMember(String nom,String prenom,LocalDate dateN,int matA){
        Adherent a = new Adherent(nom,prenom,dateN,matA);
        if (Adherent.rechAdh(matA) == -1){
            a.ajouter();
            System.out.println("Ajout reussi");
        }
        else{
            System.out.println("Adherent existant!");
        }
            
    }
    static boolean editMember(int matA){
        Scanner in = new Scanner(System.in);
        int x;
        int r = Adherent.rechAdh(matA);
        if( r != -1){
            do{
            System.out.println("voulez-vous modifier:\n1- Le nom\n2- Le prenom\n3- Le matricule\n4-La date de naissance\n(entrez 1,2,3 ou 4 (0 pour quiter))");
            x = in.nextInt();
            if (x == 1){
                System.out.println("Entrez le nouveau nom deux fois:");
                Adherent.listAdherents.get(r).setNom(in.next());
            }
            if (x == 2){
                System.out.println("Entrez le nouveau prenom:");
                Adherent.listAdherents.get(r).setPrenom(in.next());
            }
            if (x == 3){
                System.out.println("Entrez le nouveau matricule:");
                Adherent.listAdherents.get(r).setMatA(in.nextInt());
                for(int i=0;i<LivreE.count;i++){
                    if(LivreE.listLivresE.get(i).matA==matA){
                        LivreE.listLivresE.get(i).setmatA(matA);
                    }
                }
                for(int i=0;i<MemoireE.count;i++){
                    if(MemoireE.listMemoiresE.get(i).matA==matA){
                        MemoireE.listMemoiresE.get(i).setmatA(matA);
                    }
                }
                for(int i=0;i<CdE.count;i++){
                    if(CdE.listCdsE.get(i).matA==matA){
                        CdE.listCdsE.get(i).setmatA(matA);
                    }
                }
            }
            if (x == 4){
                System.out.println("Entrez la nouvelle date de naissance:");
                Adherent.listAdherents.get(r).setDateN(scanDate());
            }
            }while(x != 0);  
        }
        else{
            System.out.println("Adherent introuvee");
            return false;
        }
        System.out.println("Modification reussi");
        return true;
    }
    static boolean deleteMember(int matA){
        int r = Adherent.rechAdh(matA);
        if( r != -1){
            Adherent.listAdherents.remove(r);
            Adherent.count --;
        }
        else{
            System.out.println("Adherent introuvee");
            return false;
            
        }
        System.out.println("Suppression reussi");
        return true;
        
    }
    static void addMedia(char c,int quantite, String titre, String cote){
        Media m = null;

        if (c == 'l'){
            m = new Livre(quantite, titre, cote); 
            if (Media.rechMedia(m) != -1){ 
                Livre.listLivres.get(Media.rechMedia(m)).quantite += quantite; 
                System.out.println("Livre existant, quantité ajoutée"); 
                return;
            }
        }
        if (c == 'm'){
            m = new Memoire(quantite, titre, cote); 
            if (Media.rechMedia(m) != -1){ 
                Memoire.listMemoires.get(Media.rechMedia(m)).quantite += quantite;  
                System.out.println("Memoire existant, quantité ajoutée"); 
                return;
            }  
        }
        if (c == 'c'){
            m = new Cd(quantite, titre, cote); 
            if (Media.rechMedia(m) != -1){ 
                Cd.listCds.get(Media.rechMedia(m)).quantite += quantite; 
                System.out.println("Cd existant, quantité ajoutée"); 
                return; 
            }   
        }
        Media.addMedia(m);    
        System.out.println("Ajout reussi");
    }
    static boolean editMedia(char c, String cote) {
        int x;
        Scanner in = new Scanner(System.in);
        Media m = null;
        if (c == 'l'){
            m = new Livre(0,"",cote); 
        }
        if (c == 'm'){
            m = new Memoire(0,"",cote);
        }
        if (c == 'c'){
            m = new Cd(0,"",cote);
        }
        if (m != null){
            int r = Media.rechMedia(m);
            if ( r != -1){
                do{
                    System.out.println("voulez-vous modifier:\n1- La quantite\n2- Le titre\n3- la cote\n(entrez 1,2 ou 3 (0 pour quiter))");
                    x = in.nextInt();
                    if (x == 1){
                        System.out.println("Entrez la nouvelle quantite:");
                        if (m instanceof Livre){Livre.listLivres.get(r).setQuantite(in.nextInt());}
                        if (m instanceof Memoire){Memoire.listMemoires.get(r).setQuantite(in.nextInt());}
                        if (m instanceof Cd){Cd.listCds.get(r).setQuantite(in.nextInt());}
                    }
                    if (x == 2){
                        System.out.println("Entrez le nouveau titre:");
                        if (m instanceof Livre){Livre.listLivres.get(r).setTitre(in.next() );}
                        if (m instanceof Memoire){Memoire.listMemoires.get(r).setTitre(in.next() );}
                        if (m instanceof Cd){Cd.listCds.get(r).setTitre(in.next() );}
                    }
                    if (x == 3){
                        System.out.println("Entrez  la nouvelle cote:");
                        if (m instanceof Livre){Livre.listLivres.get(r).setCote(in.next() );
                            for(int i=0;i<LivreE.count;i++){
                                if(LivreE.listLivresE.get(i).cote==cote){
                                    LivreE.listLivresE.get(i).setCote(cote);
                                }
                            }}
                        if (m instanceof Memoire){Memoire.listMemoires.get(r).setCote(in.next() );
                            for(int i=0;i<MemoireE.count;i++){
                                if(MemoireE.listMemoiresE.get(i).cote==cote){
                                    MemoireE.listMemoiresE.get(i).setCote(cote);
                                }
                            }}
                        if (m instanceof Cd){Cd.listCds.get(r).setCote(in.next() );
                            for(int i=0;i<CdE.count;i++){
                                if(CdE.listCdsE.get(i).cote==cote){
                                    CdE.listCdsE.get(i).setCote(cote);
                                }
                            }}
                        
                    }
                    }while(x != 0);
            }else{
                System.out.println("Media introuvee");
                return false;    
            }
        }
        System.out.println("Modification reussi");
        return true;
    }
    static boolean deleteMedia(char c, String cote) {
        Media m = null;
        if (c == 'l'){
            m = new Livre(0,"",cote); 
        }
        if (c == 'm'){
            m = new Memoire(0,"",cote);
        }
        if (c == 'c'){
            m = new Cd(0,"",cote);
        }
        if (m != null){
            int r = Media.rechMedia(m);
            if( r != -1){
                if (m instanceof Livre){
                    Livre.listLivres.remove(r);
                    Livre.count --;
                }
                if (m instanceof Memoire){
                    Memoire.listMemoires.remove(r);
                    Memoire.count --;
                }
                if (m instanceof Cd){
                    Cd.listCds.remove(r);
                    Cd.count --;
                }   
            }
            else{
                System.out.println("Media introuvee");
                return false;
            }
        }
        System.out.println("Suppression reussi");
        return true;
    }
    static void Emprunter(char c,LocalDate dateE,int matA,String cote){
        Media m = null;
        Emprunt e = null;
        int rm,ra;
        ra = Adherent.rechAdh(matA);
        if (ra != -1){
            if (c == 'l'){
                m = new Livre( 0," ", cote);
                rm=Media.rechMedia(m);
                if(rm!=-1){
                    if (Media.dispo(m) == true){//y a quantite suffisante?
                        Livre.listLivres.get(rm).quantite--;//soustraction de la quantite que j'ai emprunte
                        e = new LivreE(dateE, matA, cote);//creation de l'objet pour que je peut ajouter
                        if(Emprunt.checkBlacklist(e) == -1){Emprunt.addMediaE(e);}    
                        else{System.out.println("cet Adherant est en blacklist!");}
                    }
                } 
                else{System.out.println("Desole ce livre n'est pas disponible");}
            }
            if (c == 'm'){
                m = new Memoire(0," ", cote);
                rm=Media.rechMedia(m);
                if(rm!=-1){
                    if (Media.dispo(m)==true){
                        Memoire.listMemoires.get(rm).quantite--;
                        e = new MemoireE(dateE, matA, cote);
                        if(Emprunt.checkBlacklist(e)==-1){Emprunt.addMediaE(e);}
                        else{System.out.println("cet Adherant est en blacklist!");}
                    } 
                }
                else{System.out.println("Desole cette Memoire n'est pas disponible");}
            }
            if (c == 'c'){
                m = new Cd(0,"", cote);
                rm=Cd.rechMedia(m);
                if(rm!=-1){
                    if(Cd.dispo(m)==true){
                        Cd.listCds.get(rm).quantite--;
                        e= new MemoireE(dateE, matA, cote);
                        if(Emprunt.checkBlacklist(e)==-1){Emprunt.addMediaE(e);}
                        else{System.out.println("cet Adherant est en blacklist!");}
                    }
                }
                else{System.out.println("Desole ce CD n'est pas disponible");} 
            } 
        }
        else{System.out.println("Adherant inexistant");}
    }
        
        //consulter un de les media disponible
        static void consulterM(char c, String cote){
            Media m=null;
            int r=0;
            if (c == 'l'){
                 m = new Livre (0, "", cote);
                 r = Media.rechMedia(m);
                 if(r !=-1 && m instanceof Livre ){
                    System.out.println(Livre.listLivres.get(r).titre +" "+ Livre.listLivres.get(r).cote + " " +Livre.listLivres.get(r).quantite);
                }
                else{
                    System.out.println("ce Livre n'existe pas");
                }
            }
            if (c == 'm'){
                 m = new Memoire( 0, "", cote);
                 r=Media.rechMedia(m);
                 if(r !=-1 && m instanceof Memoire ){
                    System.out.println(Memoire.listMemoires.get(r).titre +" "+ Memoire.listMemoires.get(r).cote + " " +Memoire.listMemoires.get(r).quantite);
                }
                else{
                    System.out.println("cette Memoire n'existe pas");
                }
            }
            if (c == 'c'){
                 m = new Cd( 0, "", cote);
                 r=Media.rechMedia(m);
                 if(r !=-1 && m instanceof Cd ){
                    System.out.println(Cd.listCds.get(r).titre +" "+ Cd.listCds.get(r).cote + " " +Cd.listCds.get(r).quantite);
                }
                else{
                    System.out.println("ce Cd n'existe pas");
                }
            }
         }
        static void restituerEmprunt (char c, String cote,int mat) {
            Emprunt e = null;
            Media m = null;
            LocalDate k = null;
            if (c == 'l'){
                e = new LivreE(k,0, cote); 
                m = new Livre(0," ", cote);
            }
            if (c == 'm'){
                e = new MemoireE( k ,mat,cote="");
                m = new Memoire(0," ", cote);
            }
            if (c == 'c'){
                e = new CdE(k,0, cote);
                m = new Cd(0," ", cote);;
            }
            if (m != null){ 
                int r = Media.rechMedia(m);
                int t = Emprunt.rechMediaE(e);
                if( r != -1 && t!=-1){
                    if (m instanceof Livre){
                        Livre.listLivres.get(r).quantite++;
                        LivreE.listLivresE.remove(t);
                        LivreE.count--;
                        if(Emprunt.checkBlacklist(e)!=-1){
                            int n=Emprunt.checkBlacklist(e);
                            Emprunt.blackList.remove(n);
                        }
                    }
                    if (m instanceof Memoire){
                        Memoire.listMemoires.get(r).quantite++;
                        MemoireE.listMemoiresE.remove(t);
                        MemoireE.count--;
                        if(Emprunt.checkBlacklist(e)!=-1){
                            int n=Emprunt.checkBlacklist(e);
                            Emprunt.blackList.remove(n);
                        }
                   }
                    if (m instanceof Cd){
                        Cd.listCds.get(r).quantite++;
                        CdE.listCdsE.remove(t);
                        CdE.count--;
                        if(Emprunt.checkBlacklist(e)!=-1){
                            int n=Emprunt.checkBlacklist(e);
                            Emprunt.blackList.remove(n);
                        }
                    }
                }
            }
        }
        static LocalDate scanDate(){
            Scanner in = new Scanner(System.in);
            System.out.println("Entrez le jour:");
            int j = in.nextInt();
            System.out.println("Entrez le Mois:");
            int m = in.nextInt();
            System.out.println("Entrez l'anne:");
            int a = in.nextInt();
            return LocalDate.of(a, m, j);
        }


    public static void main(String[] args) {
        int tache,tache2,tache3,tache4;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Se connecter en tant que: \n1- un bibliothecaire\n2- un adherent");
            System.out.println("(Entrez 1 ou 2 (0 pour quiter))");
            tache = in.nextInt();
            if (tache == 1){
                do{
                    System.out.println("1- Modifier les medias\n2- Modifier les adherants");
                    System.out.println("(Entrez 1 ou 2 (0 pour quiter))");
                    tache2 = in.nextInt();
                    if (tache2 == 0){
                        continue;
                    }
                    if (tache2 != 0){
                        do{
                            System.out.println("1- Afficher\n2- Ajouter\n3- Modifier\n4- Supprimer");
                            if (tache2 == 2){
                                System.out.println("5- Afficher la blackList");
                                System.out.println("(Entrez 1,2,3,4 ou 5 (0 pour quiter))");
                            }
                            else{System.out.println("(Entrez 1,2,3 ou 4 (0 pour quiter))");}
                            tache3 = in.nextInt();
                            if (tache3 == 0){
                                continue;
                            }
                            if (tache2 == 1){
                                if (tache3 != 0){
                                    if (tache3 == 1){
                                        Media.affichtab();
                                        continue;
                                    }
                                    do{ 
                                        String s ="";
                                        if (tache3 == 2){s = "Ajouter des";}
                                        if (tache3 == 3){s = "Modifier les";}
                                        if (tache3 == 4){s = "supprimer des";}
                                        System.out.println("1- "+s+" Livres\n2- "+s+" mermoires\n3- "+s+" cds");
                                        System.out.println("(Entrez 1,2 ou 3 (0 pour quiter))");
                                        tache4 = in.nextInt();
                                        if (tache4 == 0){
                                            continue;
                                        }
                                        if (tache3 == 2){
                                            if (tache4 != 0){
                                                System.out.println("Entrez le titre:");
                                                String t = in.next();
                                                System.out.println("Entrez la cote:");
                                                String c = in.next();
                                                System.out.println("Entrez la quantite:");
                                                int q = in.nextInt();                                               
                                                if (tache4 == 1){addMedia('l', q,t ,c);}
                                                if (tache4 == 2){addMedia('m', q,t ,c);}
                                                if (tache4 == 3){addMedia('c', q,t ,c);}
                                            }
                                        }
                                        if (tache3 == 3){
                                            System.out.println("Entrez la cote a modifier:");
                                            String c = in.next();
                                            if (tache4 == 1){editMedia('l', c);}
                                            if (tache4 == 2){editMedia('m', c);}
                                            if (tache4 == 3){editMedia('c', c);}
                                        }
                                        if (tache3 == 4){
                                            System.out.println("Entrez la cote a supprimer:");
                                            String c = in.next();
                                            if (tache4 == 1){deleteMedia('l', c);}
                                            if (tache4 == 2){deleteMedia('m', c);}
                                            if (tache4 == 3){deleteMedia('c', c);}
                                        }
                                        
                                    }while(tache4 != 0);
                                }
                            }
                            if (tache2 == 2){
                                
                                if (tache3 == 1){Adherent.afichTab();}
                                if (tache3 == 2){
                                    System.out.println("Entrez le nom:");
                                    String n = in.next();
                                    System.out.println("Entrez le prenom:");
                                    String p = in.next();
                                    System.out.println("Entrez le matricule:");
                                    int m = in.nextInt(); 
                                    System.out.println("Entrez la date de naissance:");
                                    LocalDate d = scanDate();
                                    addMember(n,p,d,m);
                                }
                                if (tache3 == 3){
                                    System.out.println("Entrez le matricule d'adherent a modifier:");
                                    editMember(in.nextInt());
                                }
                                if (tache3 == 4){
                                    System.out.println("Entrez le matricule d'adherent a supprimer:");
                                    deleteMember(in.nextInt());
                                }
                                if (tache3 == 5){Emprunt.Blacklist();} 
                            }   
                        }while(tache3 != 0);
                    }  
                }while(tache2 !=0 );
            }
            if (tache == 2){
                do{
                    System.out.println("1- Consulter\n2- Emprunter\n3- Restituer");
                    System.out.println("(Entrez 1,2 ou 3 (0 pour quiter))");
                    tache2 = in.nextInt();
                    if (tache2 == 0){
                        continue;
                    }
                    do{
                        System.out.println("1- Les Livres\n2- Les mermoires\n3- Les cds");
                        System.out.println("(Entrez 1,2 ou 3 (0 pour quiter))");
                        tache3 = in.nextInt();
                        if (tache3 == 0){
                            continue;
                        }
                        if (tache2 == 1){
                            System.out.println("Donner la cote svp ");
                                String q =in.next();
                            if(tache3==1){consulterM('l',q);}
                            if(tache3==2){consulterM('m',q);}
                            if(tache3==2){consulterM('c',q);}
                        }
                        if (tache2 == 2){
                            LocalDate dateh = LocalDate.now();
                            System.out.println("Donner la matricule");
                            int matA=in.nextInt();
                            System.out.println("Donner la cote");
                            String cote=in.next();
                            if(tache3==1){Emprunter('l',dateh,matA,cote);}
                            if(tache3==2){Emprunter('m',dateh,matA,cote);}
                            if(tache3==3){Emprunter('c',dateh,matA,cote);}
                        }
                        if(tache2 == 3){
                            System.out.println("Donner la matricule");
                            int matA=in.nextInt();
                            System.out.println("Donner la cote");
                            String cote=in.next();
                            if(tache3==1){restituerEmprunt('l', cote, matA);}
                            if(tache3==2){restituerEmprunt('m', cote, matA);}
                            if(tache3==3){restituerEmprunt('m', cote, matA);}
                        }
                    }while(tache3 != 0);
                    
                }while(tache2!=0);
            }   
        }while(tache != 0); 
        System.out.println("Au revoir!");
    }
}
            


