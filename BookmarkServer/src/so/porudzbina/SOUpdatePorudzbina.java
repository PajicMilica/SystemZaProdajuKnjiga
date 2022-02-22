/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.porudzbina;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Porudzbina;
import domain.StavkaPorudzbine;
import java.sql.SQLException;
import java.util.Date;
import so.AbstractSO;

/**
 *
 * @author PC
 */
public class SOUpdatePorudzbina extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Porudzbina)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Porudzbina!");
        }
        
        Porudzbina p = (Porudzbina) ado;
        
        if(p.getDatumIsporuke().before(new Date())
                || p.getDatumIsporuke().equals(new Date())){
            throw new Exception("Datum isporuke mora biti posle danasnjeg datuma!");
        }
        
        if(p.getStavkePorudzbine().isEmpty()){
            throw new Exception("Porudzbina mora imati barem jednu stavku!");
        }
        
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        
        // prvo updateujemo porudzbinu
        DBBroker.getInstance().update(ado);
        
        Porudzbina p = (Porudzbina) ado;
        
        // nakon toga brisemo sve stare stavke
        DBBroker.getInstance().delete(p.getStavkePorudzbine().get(0));
        
        // dodajemo nove stavke
        for (StavkaPorudzbine stavkaPorudzbine : p.getStavkePorudzbine()) {
            DBBroker.getInstance().insert(stavkaPorudzbine);
        }
        
    }

}
