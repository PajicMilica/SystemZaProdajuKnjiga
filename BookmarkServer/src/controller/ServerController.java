/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Administrator;
import domain.Knjiga;
import domain.Kupac;
import domain.Porudzbina;
import domain.StavkaPorudzbine;
import domain.Zanr;
import java.util.ArrayList;
import so.AbstractSO;
import so.administrator.SOGetAllAdministrator;
import so.knjiga.SOGetAllKnjiga;
import so.kupac.SOAddKupac;
import so.kupac.SODeleteKupac;
import so.kupac.SOGetAllKupac;
import so.kupac.SOUpdateKupac;
import so.porudzbina.SOAddPorudzbina;
import so.porudzbina.SODeletePorudzbina;
import so.porudzbina.SOGetAllPorudzbina;
import so.porudzbina.SOUpdatePorudzbina;
import so.stavkaPorudzbine.SOAddStavkaPorudzbine;
import so.stavkaPorudzbine.SODeleteStavkaPorudzbine;
import so.stavkaPorudzbine.SOGetAllStavkaPorudzbine;
import so.zanr.SOGetAllZanr;

/**
 *
 * @author PC
 */
public class ServerController {

    private static ServerController instance;

    public ServerController() {
    }

    public static ServerController getInstance() {
        if (instance == null) {
            instance = new ServerController();
        }
        return instance;
    }

    public void addKupac(Kupac kupac) throws Exception {
        AbstractSO aso = new SOAddKupac();
        aso.templateExecute(kupac);
    }

    public void addPorudzbina(Porudzbina porudzbina) throws Exception {
        AbstractSO aso = new SOAddPorudzbina();
        aso.templateExecute(porudzbina);
    }

    public void addStavkaPorudzbine(StavkaPorudzbine stavkaPorudzbine) throws Exception {
        AbstractSO aso = new SOAddStavkaPorudzbine();
        aso.templateExecute(stavkaPorudzbine);
    }

    public void deleteKupac(Kupac kupac) throws Exception {
        AbstractSO aso = new SODeleteKupac();
        aso.templateExecute(kupac);
    }

    public void deletePorudzbina(Porudzbina porudzbina) throws Exception {
        AbstractSO aso = new SODeletePorudzbina();
        aso.templateExecute(porudzbina);
    }

    public void deleteStavkaPorudzbine(StavkaPorudzbine stavkaPorudzbine) throws Exception {
        AbstractSO aso = new SODeleteStavkaPorudzbine();
        aso.templateExecute(stavkaPorudzbine);
    }

    public void updateKupac(Kupac kupac) throws Exception {
        AbstractSO aso = new SOUpdateKupac();
        aso.templateExecute(kupac);
    }

    public void updatePorudzbina(Porudzbina porudzbina) throws Exception {
        AbstractSO aso = new SOUpdatePorudzbina();
        aso.templateExecute(porudzbina);
    }

    public ArrayList<Administrator> getAllAdministrator() throws Exception {
        SOGetAllAdministrator so = new SOGetAllAdministrator();
        so.templateExecute(new Administrator());
        return so.getLista();
    }

    public ArrayList<Knjiga> getAllKnjiga(Zanr zanr) throws Exception {
        SOGetAllKnjiga so = new SOGetAllKnjiga();
        
        Knjiga k = new Knjiga();
        k.setZanr(zanr);
        
        so.templateExecute(k);
        return so.getLista();
    }

    public ArrayList<Kupac> getAllKupac() throws Exception {
        SOGetAllKupac so = new SOGetAllKupac();
        so.templateExecute(new Kupac());
        return so.getLista();
    }

    public ArrayList<Porudzbina> getAllPorudzbina() throws Exception {
        SOGetAllPorudzbina so = new SOGetAllPorudzbina();
        so.templateExecute(new Porudzbina());
        return so.getLista();
    }

    public ArrayList<StavkaPorudzbine> getAllStavkaPorudzbine(Porudzbina p) throws Exception {
        SOGetAllStavkaPorudzbine so = new SOGetAllStavkaPorudzbine();
        
        StavkaPorudzbine sp = new StavkaPorudzbine();
        sp.setPorudzbina(p);
        
        so.templateExecute(sp);
        return so.getLista();
    }

    public ArrayList<Zanr> getAllZanr() throws Exception {
        SOGetAllZanr so = new SOGetAllZanr();
        so.templateExecute(new Zanr());
        return so.getLista();
    }

}
