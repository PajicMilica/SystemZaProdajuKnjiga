/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class StavkaPorudzbine extends AbstractDomainObject implements Serializable {

    private Porudzbina porudzbina;
    private int rbStavke;
    private int kolicina;
    private double cenaStavke;
    private Knjiga knjiga;

    public StavkaPorudzbine(Porudzbina porudzbina, int rbStavke, int kolicina, double cenaStavke, Knjiga knjiga) {
        this.porudzbina = porudzbina;
        this.rbStavke = rbStavke;
        this.kolicina = kolicina;
        this.cenaStavke = cenaStavke;
        this.knjiga = knjiga;
    }

    public StavkaPorudzbine() {
    }

    @Override
    public String nazivTabele() {
        return " stavkaPorudzbine ";
    }

    @Override
    public String alijas() {
        return " sp ";
    }

    @Override
    public String join() {
        return " JOIN porudzbina p ON (p.porudzbinaid = sp.porudzbinaid) "
                + "JOIN knjiga knj ON (knj.knjigaid = sp.knjigaid) "
                + "JOIN zanr z ON (z.zanrid = knj.zanrid) "
                + "JOIN kupac k ON (k.kupacid = p.kupacid) "
                + "JOIN administrator a ON (a.administratorid =  p.administratorid) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            
            Kupac k = new Kupac(rs.getLong("KupacID"),
                    rs.getString("ImeKupca"), rs.getString("PrezimeKupca"),
                    rs.getString("Email"), rs.getString("TipKupca"));
            
            Administrator a = new Administrator(rs.getLong("AdministratorID"),
                    rs.getString("Ime"), rs.getString("Prezime"),
                    rs.getString("Username"), rs.getString("Password"));
            
            Porudzbina p = new Porudzbina(rs.getLong("PorudzbinaID"),
                    rs.getTimestamp("DatumVreme"), rs.getDate("DatumIsporuke"),
                    rs.getString("Grad"), rs.getString("Adresa"),
                    rs.getDouble("Cena"), rs.getDouble("Popust"), rs.getDouble("KonacnaCena"),
                    k, a, null);
            
            Zanr z = new Zanr(rs.getLong("ZanrID"), rs.getString("NazivZanra"));
            
            Knjiga knj = new Knjiga(rs.getLong("KnjigaID"),
                    rs.getString("NazivKnjige"), rs.getString("Pisac"),
                    rs.getString("Opis"), rs.getDouble("CenaKnjige"),
                    rs.getInt("Izdanje"), z);
            
            StavkaPorudzbine sp = new StavkaPorudzbine(p, rs.getInt("RbStavke"),
                    rs.getInt("Kolicina"), rs.getDouble("CenaStavke"), knj);

            lista.add(sp);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (PorudzbinaID, RbStavke, Kolicina, CenaStavke, KnjigaID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " PorudzbinaID = " + porudzbina.getPorudzbinaID();
    }

    @Override
    public String vrednostiZaInsert() {
        return porudzbina.getPorudzbinaID() + ", " + rbStavke + ", "
                + kolicina + ", " + cenaStavke + ", " + knjiga.getKnjigaID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String getByID() {
        return " WHERE P.PORUDZBINAID = " + porudzbina.getPorudzbinaID();
    }

    public Porudzbina getPorudzbina() {
        return porudzbina;
    }

    public void setPorudzbina(Porudzbina porudzbina) {
        this.porudzbina = porudzbina;
    }

    public int getRbStavke() {
        return rbStavke;
    }

    public void setRbStavke(int rbStavke) {
        this.rbStavke = rbStavke;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public double getCenaStavke() {
        return cenaStavke;
    }

    public void setCenaStavke(double cenaStavke) {
        this.cenaStavke = cenaStavke;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }
}
