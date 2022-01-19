 /*NOTES
    
    Entrer dans l'ordre:

    -"Montant de l'emprunt immobilier : "
    -"Taux de l'emprunt : "
    -"Durée de possession "
    -"Durée de l'emprunt : "
    
    */
	/* System.out.println("Montant mensualités : ");
    int mensualite = dd.nextInt();
    System.out.println( mensualite+ "  Euros");*/


/*USER INPUT CKECK
 * 
 * 
 * 
 * do  {
    
    try {
    	
    	System.out.println("Phrase intro\n");
    	VARIABLE = dd.next.....();
        break;
        
        } catch (Exception e) {
        	
         userInput=false;
         System.out.println("Merci de rentrer le montant sous forme de ....");
         dd = new Scanner(System.in);
         
     }
    }while (!userInput);
    
    System.out.println(VALEUR);*/





    //IMPORTS


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;


public class CalcImmo{

   
public static void main(String args[]){

    
    //CLASS/fonctions

    Scanner dd = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("###.##");
    
     

    //VARIABLES
    
    int capitalDepart = 0;
    int amount=0;
    double rate=0;
    int loanTime=0;
   /*int pvInput=0;*/
    int holdingTime=0;
    
     
    boolean userInput=true;
    
      
    //USER INPUT
    
    
    do  {
        
        try {
        	
        	System.out.println("Entrez le montant de votre emprunt immobilier: ...... Euros");
        	amount = dd.nextInt();
            break;
            
            } catch (Exception e) {
            	
             userInput=false;
             System.out.println("Merci de rentrer le montant sous forme de chiffres sans virgule");
             dd = new Scanner(System.in);
             
         }
       }while (!userInput);
    
        
        System.out.println("Euros\n");
    
   
    
    do  {
    
    try {
    	
    	System.out.println("Entrez votre capital de départ: ...... Euros");
    	capitalDepart = dd.nextInt();
        break;
        
        } catch (Exception e) {
        	
         userInput=false;
         System.out.println("Merci de rentrer le montant sous forme de chiffres sans virgule");
         dd = new Scanner(System.in);
         
     }
    }while (!userInput);
    
    
    
    System.out.println("Euros\n");
    
        
        
     do  {
            
         try {
            	
            System.out.println("Quel est le taux de votre emprunt: ...... %");
            rate = dd.nextDouble();
            break;
                
             } catch (Exception e) {
                	
              userInput=false;
              System.out.println("Merci de rentrer le montant sous forme de chiffres, avec ou sans virgules et sans caratères spéciaux");
              dd = new Scanner(System.in);
                 
          }
        }while (!userInput);
         
         
         System.out.println("%\n");
            
            
            
      do  {
            
           try {
            	
             System.out.println("Sur combien d'années avez vous emprunté ? ...... Années : ");
            	loanTime = dd.nextInt();
                break;
                
                } catch (Exception e) {
                	
                 userInput=false;
                 System.out.println("Merci de rentrer le montant sous forme de chiffres sans virgule");
                 dd = new Scanner(System.in);
                 
             }
            }while (!userInput);
      
            System.out.println("Ans\n"); 
            
            
           /* do  {
                
                try {
                	
                	System.out.println("Entrez le montant de la plus value que vous souhaitez obtenir:..... Euros");
                	pvInput = dd.nextInt();
                    break;
                    
                    } catch (Exception e) {
                    	
                     userInput=false;
                     System.out.println("Merci de rentrer le montant sous forme de ....");
                     dd = new Scanner(System.in);
                     
                 }
                }while (!userInput);
            System.out.println(pvInput); 
            System.out.println("Euros\n");*/
            
            
            do  {
                
                try {
                	
                	System.out.println("Combien de temps souhaitez vous rester propriétaire de votre bien? ...... Années :");
                	holdingTime = dd.nextInt();
                    break;
                    
                    } catch (Exception e) {
                    	
                     userInput=false;
                     System.out.println("Merci de rentrer le montant sous forme de chiffres sans virgule");
                     dd = new Scanner(System.in);
                     
                 }
                }while (!userInput);
               
            System.out.println( "Ans\n");
           
     
   
   
    //CALCUL  MENSUALITE
    NumberFormat nf = NumberFormat.getInstance(Locale.FRENCH);
    String NumberFormat
    double montantM = 0;//Mensualité       
    double tdouze = (rate/100)/12;// taux/12
    double myExposant = -12*loanTime;

    montantM = (amount*tdouze)/(1 - (Math.pow((1+tdouze),myExposant)));

    System.out.println("Vos mensualités sont de : " + nf.NumberFormat(df.format(montantM)) + "  Euros\n\n");
    
  
    //Calcul montant total prêt et part interet banque
    // Nouvelles variables
    double prBanque = 0;
    double coutEmprunt = 0;//Cout Final de l'emprunt
    //Code
    coutEmprunt = 12* loanTime * montantM - coutEmprunt;
    prBanque = coutEmprunt - amount;
    
    //Output
    System.out.println("Le coût de votre emprunt sur  " + loanTime + " Ans, vous reviens à :" + df.format(coutEmprunt) + "  Euros, "
    + "cela comprend le total de vos mensualités ainsi que les interets versés à la banque; \rdont le montant s'élève à  " + df.format(prBanque) + "  Euros.\n\n" );
    
    
    //CAPITAL AVANCE DURANT ANNES DE POSSESSION
    //Nouvelles Variables
    double capitalAvancé = 0;
    //Code
    capitalAvancé = montantM * holdingTime * 12 + capitalDepart;
    //Output
    System.out.println("Capital avancé sur " + holdingTime + "  Ans :  "+ df.format(capitalAvancé) + "  Euros\n\n");
            
    
    
    
        
    // CALCUL VALEUR DU BIEN A LA VENTE EN TENAT COMPTE DE L'INFLATION
    // Nouvelles variables 	
    double amount3 = amount + capitalDepart;
    int anVente = 0;
    int year = Calendar.getInstance().get(Calendar.YEAR);
    double inflation = 4.5;
    double plusValue = 0; 
    //Code
    for(int an = 1; an <=holdingTime; an++){

            
            amount3 = (amount3+(amount3*inflation)/100);

            plusValue = amount3-coutEmprunt-capitalDepart;
            
            anVente = year + holdingTime;
              
		}
    //output
    System.out.println("Si vous restez proprietaire de votre bien durant  " + holdingTime + " Ans,  la valeur de votre bien sur le marché immobilier en  " + anVente + "  seras de:  "+ df.format(amount3) + "  Euros\n\n");
    System.out.println("Si vous vendez votre bien dans " + holdingTime + "  Ans , votre plus-value seras de :  "+ df.format(plusValue) + "  Euros\n\n");
    
          
    //CALCUL DATE DE VENTE POUR PLUS VALUE D'INPUT
    //Nouvelles variables
    /* double x = 0;
    int prixAchat= amount + capitalDepart;
    int prixCession = prixAchat + pvInput;
    System.out.println(prixAchat);
    System.out.println(prixCession);
    
    // Code
    
    do {
    	x = prixAchat+((prixAchat*inflation)/100);
    	System.out.println(x);
    	x++;//counts the loops
    	
    } while (x <= prixCession);
    
    
    //Output
    System.out.println("Pour atteindre une plus value de  " + pvInput + " ,Il vous faudra vendre le biens dans  " + df.format(x) +"  Ans\n\n"); */
    
    
    
    
        dd.close();  
        
  
  }
}