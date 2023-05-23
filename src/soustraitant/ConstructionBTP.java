package soustraitant;

import java.util.HashSet;
import java.util.Set;

public class ConstructionBTP {


    private String code;

    private Set<ConstructionBTP> clients = new HashSet<>();
    private Set<ConstructionBTP> listSousTraitant = new HashSet<>();


    public ConstructionBTP(String pCode) {
        this.code = pCode;
    }


    public void addSousTraitant(ConstructionBTP pSoustraitant) throws Exception {

        if(!ifExiste(pSoustraitant)) {
            pSoustraitant.clients.add(this);
            this.listSousTraitant.add(pSoustraitant);
        }else {
            throw new Exception("Impossible d'ajouter le sous traitant "+pSoustraitant.code);
        }
    }

    public boolean ifExiste(ConstructionBTP pSoustraitant) throws Exception {

        if(this.clients.contains(pSoustraitant)){
            return true;
        }

        if(ifExisteSousTraitant(pSoustraitant)){
            return true;
        }

        for(ConstructionBTP sousTr: this.clients) {
            if(sousTr.ifExisteSousTraitant(pSoustraitant)){
                return true;
            }
            return sousTr.ifExiste(pSoustraitant);
        }

        return false;
    }

    public boolean ifExisteSousTraitant(ConstructionBTP pSoustraitant) throws Exception {

        if(this.listSousTraitant.contains(pSoustraitant)){
            return true;
        }

        for(ConstructionBTP sousTr: this.listSousTraitant) {
            return sousTr.ifExisteSousTraitant(pSoustraitant);
        }

        return false;
    }



}
