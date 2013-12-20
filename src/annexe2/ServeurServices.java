package annexe2;


/**
 * @author Kathy Sierra, Bert Bates : "Java Tête la Première"  * 
 * Mise en forme des commentaires Françoise PERRIN
 */


import java.rmi.Remote;
import java.rmi.RemoteException;

/* Votre interface doit indiquer qu'elle sert aux appels distants
 * avec "extends Remote"
 * 
 * Chaque appel de méthode distante est considéré comme risqué :
 * déclarer "RemoteException" dans chaque méthode oblige le client
 * à faire attention et à reconnaitre qu'un incident peut se produire
 * 
 * Comme le serveur va utiliser le réseau pour renvoyer les valeurs de retour 
 * et récupérer les valeurs des arguments des méthodes
 * il faut vérifier que argument et types de retour sont sérialisables
 */
public interface ServeurServices extends Remote {

    Object[] getListeServices() throws RemoteException;

    Service getService(Object cleService) throws RemoteException;
}
