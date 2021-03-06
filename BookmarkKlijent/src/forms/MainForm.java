/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import FormKupac.FormDetaljiKupca;
import FormKupac.FormNoviKupac;
import FormKupac.FormPretragaKupca;
import FormPorudzbina.FormPretragaPorudzbine;
import com.sun.glass.events.KeyEvent;
import controller.ClientController;
import domain.Administrator;
import domain.Knjiga;
import domain.Kupac;
import domain.Porudzbina;
import domain.StavkaPorudzbine;
import domain.Zanr;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import models.TableModelStavkePorudzbine;
import session.Session;

/**
 *
 * @author PC
 */
public class MainForm extends javax.swing.JFrame implements Runnable {

    Administrator a;

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        setLocationRelativeTo(null);
        this.a = Session.getInstance().getTrenutnoUlogovani();
        lblUlogovani.setText("Trenutno ulogovani administrator: " + a);
        setTitle("Klijentska forma");
        Thread th = new Thread(this);
        th.start();
        srediFormu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUlogovani = new javax.swing.JLabel();
        lblDatumVreme = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnDodaj = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStavkePorudzbine = new javax.swing.JTable();
        cmbZanr = new javax.swing.JComboBox();
        cmbKnjiga = new javax.swing.JComboBox();
        txtKolicina = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCenaStavke = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        btnSacuvaj = new javax.swing.JButton();
        cmbKupac = new javax.swing.JComboBox();
        cmbGrad = new javax.swing.JComboBox<String>();
        txtAdresa = new javax.swing.JTextField();
        txtDatumIsporuke = new javax.swing.JFormattedTextField();
        txtCena = new javax.swing.JFormattedTextField();
        txtPopust = new javax.swing.JFormattedTextField();
        txtKonacnaCena = new javax.swing.JFormattedTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        miNoviKupac = new javax.swing.JMenuItem();
        miPretragaKupca = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        miPretragaPorudzbine = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblUlogovani.setText("Ulogovani");

        lblDatumVreme.setText("DatumVreme");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Unos porudzbine"));

        jLabel1.setText("Grad:");

        jLabel2.setText("Adresa:");

        jLabel3.setText("Datum isporuke:");

        jLabel4.setText("Cena:");

        jLabel5.setText("Popust na osnovu statusa:");

        jLabel6.setText("Konacna cena:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Unos stavki porudzbine"));

        jLabel8.setText("Zanr:");

        jLabel9.setText("Knjiga:");

        jLabel10.setText("Kolicina:");

        btnDodaj.setText("Dodaj stavku");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obrisi stavku");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        tblStavkePorudzbine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblStavkePorudzbine);

        cmbZanr.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbZanr.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbZanrItemStateChanged(evt);
            }
        });

        cmbKnjiga.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbKnjiga.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbKnjigaItemStateChanged(evt);
            }
        });

        txtKolicina.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtKolicina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKolicinaActionPerformed(evt);
            }
        });
        txtKolicina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKolicinaKeyReleased(evt);
            }
        });

        jLabel11.setText("Cena stavke:");

        txtCenaStavke.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtCenaStavke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCenaStavkeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtKolicina)
                                    .addComponent(cmbKnjiga, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbZanr, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCenaStavke))))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbZanr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cmbKnjiga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtCenaStavke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodaj)
                    .addComponent(btnObrisi))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel7.setText("Kupac:");

        btnSacuvaj.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnSacuvaj.setText("Sacuvaj porudzbinu");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        cmbKupac.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbKupac.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbKupacItemStateChanged(evt);
            }
        });

        cmbGrad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Beograd", "Nis", "Valjevo", "Smederevo", "Pozarevac" }));

        txtAdresa.setText("Bulevar oslobodjenja 153");
        txtAdresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdresaActionPerformed(evt);
            }
        });

        txtDatumIsporuke.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy"))));
        txtDatumIsporuke.setText("10.10.2020");

        txtCena.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        txtPopust.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        txtKonacnaCena.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbKupac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbGrad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAdresa)
                            .addComponent(txtDatumIsporuke)
                            .addComponent(txtCena)
                            .addComponent(txtPopust)
                            .addComponent(txtKonacnaCena))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(166, 166, 166))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbKupac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbGrad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDatumIsporuke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPopust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKonacnaCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSacuvaj)
                .addGap(14, 14, 14))
        );

        jMenu6.setText("Kupac");

        miNoviKupac.setText("Novi kupac");
        miNoviKupac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNoviKupacActionPerformed(evt);
            }
        });
        jMenu6.add(miNoviKupac);

        miPretragaKupca.setText("Pretraga kupca");
        miPretragaKupca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPretragaKupcaActionPerformed(evt);
            }
        });
        jMenu6.add(miPretragaKupca);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Porudzbine");

        miPretragaPorudzbine.setText("Pretraga porudzbina");
        miPretragaPorudzbine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPretragaPorudzbineActionPerformed(evt);
            }
        });
        jMenu7.add(miPretragaPorudzbine);

        jMenuBar1.add(jMenu7);

        jMenu8.setText("Izloguj se");
        jMenu8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu8ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Izloguj se");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem1);

        jMenuBar1.add(jMenu8);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUlogovani)
                            .addComponent(lblDatumVreme))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUlogovani)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDatumVreme)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miNoviKupacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNoviKupacActionPerformed
        new FormNoviKupac(this, true).setVisible(true);
    }//GEN-LAST:event_miNoviKupacActionPerformed

    private void miPretragaKupcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPretragaKupcaActionPerformed
        new FormPretragaKupca(this, true).setVisible(true);
    }//GEN-LAST:event_miPretragaKupcaActionPerformed

    private void miPretragaPorudzbineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPretragaPorudzbineActionPerformed
        new FormPretragaPorudzbine(this, true).setVisible(true);
    }//GEN-LAST:event_miPretragaPorudzbineActionPerformed

    private void jMenu8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu8ActionPerformed

    }//GEN-LAST:event_jMenu8ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        int result = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da zelite da "
                + "se izlogujete sa sistema?", "Konfirmacija", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.NO_OPTION) {
            return;
        }

        if (result == JOptionPane.YES_OPTION) {
            new Login().setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void cmbZanrItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbZanrItemStateChanged

        if (cmbZanr.getSelectedItem() != null) {

            Zanr z = (Zanr) cmbZanr.getSelectedItem();
            popuniKnjige(z);

        }

    }//GEN-LAST:event_cmbZanrItemStateChanged

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed

        if (txtKolicina.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Kolicina mora biti popunjena!");
            return;
        }

        Knjiga k = (Knjiga) cmbKnjiga.getSelectedItem();
        int kolicina = Integer.parseInt(txtKolicina.getText());
        double cenaStavke = Double.parseDouble(txtCenaStavke.getText());

        StavkaPorudzbine sp = new StavkaPorudzbine(null, -1, kolicina, cenaStavke, k);

        TableModelStavkePorudzbine tm = (TableModelStavkePorudzbine) tblStavkePorudzbine.getModel();
        tm.dodajStavku(sp);

        double cena = Double.parseDouble(txtCena.getText());

        cena += cenaStavke;

        txtCena.setText(String.valueOf(cena));

        cena = Double.parseDouble(txtCena.getText());

        double popust = Double.parseDouble(txtPopust.getText());

        txtKonacnaCena.setText(String.valueOf(cena * (100 - popust) / 100));

    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed

        int row = tblStavkePorudzbine.getSelectedRow();

        if (row >= 0) {
            TableModelStavkePorudzbine tm = (TableModelStavkePorudzbine) tblStavkePorudzbine.getModel();

            StavkaPorudzbine sp = tm.getStavka(row);

            double cena = Double.parseDouble(txtCena.getText());

            cena -= sp.getCenaStavke();

            txtCena.setText(String.valueOf(cena));

            cena = Double.parseDouble(txtCena.getText());

            double popust = Double.parseDouble(txtPopust.getText());

            txtKonacnaCena.setText(String.valueOf(cena * (100 - popust) / 100));

            tm.obrisiStavku(row);

        }

    }//GEN-LAST:event_btnObrisiActionPerformed

    private void txtKolicinaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKolicinaKeyReleased

        if ((evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9')
                || evt.getKeyCode() == KeyEvent.VK_BACKSPACE
                || evt.getKeyChar() == KeyEvent.VK_DELETE) {

            try {
               
                if (!txtKolicina.getText().isEmpty()) {
                    int kolicina = Integer.parseInt(txtKolicina.getText());
                    Knjiga k = (Knjiga) cmbKnjiga.getSelectedItem();

                    txtCenaStavke.setText(String.valueOf(k.getCenaKnjige() * kolicina));
                }
                if (txtKolicina.getText().isEmpty()) {
                    txtCenaStavke.setText("0.00");
                }
               
            } catch (Exception e) {
                System.out.println("U kolicini moraju biti uneti samo brojevi!");
            }

        }

    }//GEN-LAST:event_txtKolicinaKeyReleased

    private void cmbKupacItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbKupacItemStateChanged

        if (cmbKupac.getSelectedItem() != null) {

            Kupac k = (Kupac) cmbKupac.getSelectedItem();

            if (k.getTipKupca().equals("FREE")) {
                txtPopust.setText("0.00");
            }
            if (k.getTipKupca().equals("PREMIUM")) {
                txtPopust.setText("10.00");
            }
            if (k.getTipKupca().equals("PREMIUM PLUS")) {
                txtPopust.setText("20.00");
            }

            double cena = Double.parseDouble(txtCena.getText());

            double popust = Double.parseDouble(txtPopust.getText());

            txtKonacnaCena.setText(String.valueOf(cena * (100 - popust) / 100));

        }

    }//GEN-LAST:event_cmbKupacItemStateChanged

    private void cmbKnjigaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbKnjigaItemStateChanged

        if (cmbKnjiga.getSelectedItem() != null) {

            try {
                if (!txtKolicina.getText().isEmpty()) {
                    int kolicina = Integer.parseInt(txtKolicina.getText());
                    Knjiga k = (Knjiga) cmbKnjiga.getSelectedItem();

                    txtCenaStavke.setText(String.valueOf(k.getCenaKnjige() * kolicina));
                }

                if (txtKolicina.getText().isEmpty()) {
                    txtCenaStavke.setText("0.00");
                }
            } catch (Exception e) {
                System.out.println("U kolicini moraju biti uneti samo brojevi!");
            }

        }

    }//GEN-LAST:event_cmbKnjigaItemStateChanged

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed

        if (txtAdresa.getText().isEmpty() || txtDatumIsporuke.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Sva polja moraju biti popunjena!");
            return;
        }

        try {
            Kupac k = (Kupac) cmbKupac.getSelectedItem();
            String grad = (String) cmbGrad.getSelectedItem();
            String adresa = txtAdresa.getText();

            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            Date datumIsporuke = sdf.parse(txtDatumIsporuke.getText());

            double cena = Double.parseDouble(txtCena.getText());
            double popust = Double.parseDouble(txtPopust.getText());
            double konacnaCena = Double.parseDouble(txtKonacnaCena.getText());

            TableModelStavkePorudzbine tm = (TableModelStavkePorudzbine) tblStavkePorudzbine.getModel();

            Porudzbina p = new Porudzbina(null, new Date(),
                    datumIsporuke, grad, adresa, cena, popust, konacnaCena, k, a, tm.getLista());

            ClientController.getInstance().addPorudzbina(p);
            JOptionPane.showMessageDialog(this, "Uspesno sacuvana porudzbina!");
            srediFormu();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void txtCenaStavkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCenaStavkeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCenaStavkeActionPerformed

    private void txtKolicinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKolicinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKolicinaActionPerformed

    private void txtAdresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdresaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox<String> cmbGrad;
    private javax.swing.JComboBox cmbKnjiga;
    private javax.swing.JComboBox cmbKupac;
    private javax.swing.JComboBox cmbZanr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDatumVreme;
    private javax.swing.JLabel lblUlogovani;
    private javax.swing.JMenuItem miNoviKupac;
    private javax.swing.JMenuItem miPretragaKupca;
    private javax.swing.JMenuItem miPretragaPorudzbine;
    private javax.swing.JTable tblStavkePorudzbine;
    private javax.swing.JTextField txtAdresa;
    private javax.swing.JFormattedTextField txtCena;
    private javax.swing.JFormattedTextField txtCenaStavke;
    private javax.swing.JFormattedTextField txtDatumIsporuke;
    private javax.swing.JFormattedTextField txtKolicina;
    private javax.swing.JFormattedTextField txtKonacnaCena;
    private javax.swing.JFormattedTextField txtPopust;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        while (true) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            lblDatumVreme.setText("Datum i vreme: " + sdf.format(new Date()));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void srediFormu() {
        txtCena.setEnabled(false);
        txtPopust.setEnabled(false);
        txtKonacnaCena.setEnabled(false);
        txtCenaStavke.setEnabled(false);
        txtCena.setText("0.00");
        txtPopust.setText("0.00");
        txtKonacnaCena.setText("0.00");
        txtCenaStavke.setText("0.00");
        popuniKupce();
        popuniZanrove();
        tblStavkePorudzbine.setModel(new TableModelStavkePorudzbine());
    }

    public void popuniKupce() {

        try {
            ArrayList<Kupac> kupci = ClientController.getInstance().getAllKupac();

            cmbKupac.removeAllItems();

            for (Kupac kupac : kupci) {
                cmbKupac.addItem(kupac);
            }

        } catch (Exception ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void popuniZanrove() {

        try {
            ArrayList<Zanr> zanrovi = ClientController.getInstance().getAllZanr();

            cmbZanr.removeAllItems();

            for (Zanr zanr : zanrovi) {
                cmbZanr.addItem(zanr);
            }

            popuniKnjige(zanrovi.get(0));

        } catch (Exception ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void popuniKnjige(Zanr zanr) {

        try {
            ArrayList<Knjiga> knjige = ClientController.getInstance().getAllKnjiga(zanr);

            cmbKnjiga.removeAllItems();

            for (Knjiga knjiga : knjige) {
                cmbKnjiga.addItem(knjiga);
            }

        } catch (Exception ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
