import java.rmi.Naming;
import java.util.Date;

import com.sid.entities.Compte;
import com.sid.entities.CompteCourant;
import com.sid.rmi.IBanqueRmiRemote;

public class ClientRMI {

	public static void main(String[] args) {
		try {
			IBanqueRmiRemote proxy= (IBanqueRmiRemote) Naming.lookup("rmi://localhost:1099/BK");
			Compte cp=proxy.getCompte("CE2");
			System.out.println(cp.getSolde());
			System.out.println(cp.getDateCreation());
			System.out.println(cp.getClient().getNomClient());
			
			proxy.saveCompte(new CompteCourant("RMICC99", new Date(), 99999, 1000));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
