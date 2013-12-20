package annexe2;
/**
 * @author Kathy Sierra, Bert Bates : "Java Tête la Première" 
 * Mise en forme des commentaires Françoise PERRIN
 */

import java.rmi.*;
import java.util.*;
import java.rmi.server.*;
import java.rmi.registry.LocateRegistry;


/*
 * Pour pouvoir fonctionner comme service distant, 
 * votre objet doit étendre "UnicastRemoteObject"
 * et implémenter votre interface distante
 */
public class ServeurServicesImpl extends UnicastRemoteObject implements ServeurServices  {

    HashMap <String, Service> listeServices;




    public ServeurServicesImpl() throws RemoteException {
       //installer et démarrer les services
       installerServices();
    }

    private void installerServices() {
       listeServices = new HashMap<String, Service>();
       /*  ------  Autres services possibles    --------
       listeServices.put("Jouer aux dés", new ServiceDes());
       listeServices.put("Quel jour ?", new ServiceQuelJour());
       */
       listeServices.put("Vidéo musique", new ServiceMusique());
    }



    public Object[] getListeServices() {
       System.out.println("à distance");
       return listeServices.keySet().toArray();

    }


    public Service getService(Object cleService) throws RemoteException {
       Service leService = (Service) listeServices.get(cleService);
       return leService;
    }


    public static void main (String[] args) {
    	/*
    	 * les lignes suivantes permettent de lancer le registre rmi
    	 * par programme 
    	 */
    	try {
			LocateRegistry.createRegistry(1099);
			System.out.println("Le RMI registry est pret.");
			} catch (Exception e) {
			System.out.println("Le RMI registry n'a pas démmaré correctement.");
			}
		/*
		 * Il faut enregistrer le service (le lier au registre RMI) : 
		 * c'est en réalité la souche que RMI place dans le registre
		 * puisque c'est d'elle dont les clients ont vraiment besoin.
		 * Donner au service un nom permettra aux clients de le chercher dans le registre
		 * le registre doit déjà s'exécuter sinon cette ligne échoue "Naming.rebind..."
		 * 
		 */
       try {
    	   
         Naming.rebind("ServeurServices", new ServeurServicesImpl());
       } catch(Exception ex) { }
       System.out.println("Le service distant s'exécute");
    }
}