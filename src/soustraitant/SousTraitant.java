package soustraitant;

import java.util.HashSet;
import java.util.Set;

public class SousTraitant {
	
	String code;  
	
	Set<SousTraitant> lesSousTraitants = new HashSet<SousTraitant>();
	
	
	public SousTraitant(String pCode) {
		this.code = pCode;
	}
	
	
	public void addSousTraitant(SousTraitant pSoustraitant) throws Exception {
		
		if(!existe(this.lesSousTraitants, pSoustraitant)
				&& !existe(pSoustraitant)) {
			this.lesSousTraitants.add(pSoustraitant);
		}else {
			throw new Exception("Impossible d'ajouter le sous traitant "+pSoustraitant.code);
		}
	}
	
	
	public boolean existe(Set<SousTraitant> pLesSousTraitants, SousTraitant pSoustraitant) throws Exception {
		
		if(pLesSousTraitants.contains(pSoustraitant)){
			return true;
		}
		
		for(SousTraitant sousTr: pLesSousTraitants) {
			return existe(sousTr.lesSousTraitants, pSoustraitant);
		}
		
		return false;
	}
	
	
	public boolean existe(SousTraitant pSoustraitant) throws Exception {
		if(pSoustraitant.lesSousTraitants.contains(this)) {
			return true;
		}
		
		for(SousTraitant sousTr: pSoustraitant.lesSousTraitants) {
			return existe(sousTr.lesSousTraitants, this);
		}

		return false;
	}

}
