package soustraitant;

import java.util.HashSet;
import java.util.Set;

public class SousTraitant {
	
	private String code;

	private Set<String> clients = new HashSet<>();
	private Set<SousTraitant> listSousTraitant = new HashSet<SousTraitant>();
	
	
	public SousTraitant(String pCode) {
		this.code = pCode;
	}
	
	
	public void addSousTraitant(SousTraitant pSoustraitant) throws Exception {

		if(!existe(this.listSousTraitant, pSoustraitant)
				&& !ifExisteInStEnParam(pSoustraitant)) {
			this.listSousTraitant.add(pSoustraitant);
		}else {
			throw new Exception("Impossible d'ajouter le sous traitant "+pSoustraitant.code);
		}
	}
	
	/**
	 * v�rifie si pSoustraitant n'existe pas d�j� comme soustraintant dans pLesSousTraitants ou dans l'un des enfants de pLesSousTraitants
	 * @param pLesSousTraitants
	 * @param pSoustraitant
	 * @return
	 * @throws Exception
	 */
	
	public boolean existe(Set<SousTraitant> pLesSousTraitants, SousTraitant pSoustraitant) throws Exception {
		
		if(pLesSousTraitants.contains(pSoustraitant)){
			return true;
		}
		
		for(SousTraitant sousTr: pLesSousTraitants) {
			return existe(sousTr.listSousTraitant, pSoustraitant);
		}
		
		return false;
	}
	
	/**
	 * v�rifie si le courant soustraintant n'existe pas d�j� comme soustraitant de pSoustraitant
	 * @param pSoustraitant
	 * @return
	 * @throws Exception
	 */
	
	public boolean ifExisteInStEnParam(SousTraitant pSoustraitant) throws Exception {
		if(pSoustraitant.listSousTraitant.contains(this)) {
			return true;
		}
		
		for(SousTraitant sousTr: pSoustraitant.listSousTraitant) {
			return existe(sousTr.listSousTraitant, this);
		}

		return false;
	}



}
