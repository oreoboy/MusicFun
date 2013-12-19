package rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

@SuppressWarnings("serial")
public class ServeurServicesImpl extends UnicastRemoteObject implements
		ServeurServices {
	private HashMap<String, Service> listeServices;

	protected ServeurServicesImpl() throws RemoteException {
		installerServices();
	}

	private void installerServices() {
		listeServices = new HashMap<String, Service>();
		listeServices.put("Vidéo musique", new ServiceLecteur());
	}

	@Override
	public Object[] getListeServices() throws RemoteException {
		System.out.println("à distance");
		return listeServices.keySet().toArray();
	}

	@Override
	public Service getService(Object cleService) throws RemoteException {
		Service leService = (Service) listeServices.get(cleService);
		return leService;
	}

	public static void main(String[] args) {
		/*
		 * les lignes suivantes permettent de lancer le registre rmi par programme
		 */
		try {
			LocateRegistry.createRegistry(1099);
			System.out.println("Le RMI registry est pret.");
		} catch (Exception e) {
			System.out.println("Le RMI registry n'a pas démmaré correctement.");
		}
		
		/*
		 * Il faut enregistrer le service (le lier au registre RMI) : c'est en
		 * réalité la souche que RMI place dans le registre puisque c'est d'elle
		 * dont les clients ont vraiment besoin. Donner au service un nom
		 * permettra aux clients de le chercher dans le registre le registre
		 * doit déjà s'exécuter sinon cette ligne échoue "Naming.rebind..."
		 */
		try {

			Naming.rebind("ServeurServices", new ServeurServicesImpl());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("Le service distant s'exécute");
	}
}
