/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.Porudzbina;
import domain.StavkaPorudzbine;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC
 */
public class TableModelStavkePorudzbine extends AbstractTableModel {

    private ArrayList<StavkaPorudzbine> lista;
    private String[] kolone = {"RbStavke", "Knjiga", "Kolicina", "Cena"};
    int rb = 0;

    public TableModelStavkePorudzbine() {
        lista = new ArrayList<>();
    }
    
    public TableModelStavkePorudzbine(Porudzbina p) {
        try {
            lista = ClientController.getInstance().getAllStavkaPorudzbine(p);
        } catch (Exception ex) {
            Logger.getLogger(TableModelStavkePorudzbine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }

    @Override
    public Object getValueAt(int row, int column) {
        StavkaPorudzbine sp = lista.get(row);

        switch (column) {
            case 0:
                return sp.getRbStavke();
            case 1:
                return sp.getKnjiga().getNazivKnjige();
            case 2:
                return sp.getKolicina();
            case 3:
                return sp.getCenaStavke();

            default:
                return null;
        }
    }

    public void dodajStavku(StavkaPorudzbine sp) {
        
        for (StavkaPorudzbine stavkaPorudzbine : lista) {
            if(stavkaPorudzbine.getKnjiga().getKnjigaID().equals(sp.getKnjiga().getKnjigaID())){
                
                stavkaPorudzbine.setKolicina(stavkaPorudzbine.getKolicina() + sp.getKolicina());
                stavkaPorudzbine.setCenaStavke(stavkaPorudzbine.getCenaStavke() + sp.getCenaStavke());
                fireTableDataChanged();
                return;
            }
        }
        
        rb = 0;
        for (StavkaPorudzbine stavkaPorudzbine : lista) {
            stavkaPorudzbine.setRbStavke(++rb);
        }
        
        sp.setRbStavke(++rb);
        lista.add(sp);
        fireTableDataChanged();
    }

    public void obrisiStavku(int row) {
        lista.remove(row);
        
        rb = 0;
        for (StavkaPorudzbine stavkaPorudzbine : lista) {
            stavkaPorudzbine.setRbStavke(++rb);
        }
        
        fireTableDataChanged();
        
    }

    public StavkaPorudzbine getStavka(int row) {
        return lista.get(row);
    }

    public ArrayList<StavkaPorudzbine> getLista() {
        return lista;
    }

}
