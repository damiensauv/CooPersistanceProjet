package Frames;

import Entity.IPersonne;
import Persistance.Mapper.PersonneMapper;
import Persistance.UOW.UnitOfWork;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MaFrameConnexion extends JFrame {

    private JPanel panelco, panelmetier, cardpanels;
    private JButton boutonOK, boutonAnnuler, boutonValider;
    private JLabel label;
    private JTextField champtexte, champeval;
    private JList<DefaultListModel> listenoms;
    private java.util.List<IPersonne> pchild;
    private Integer current = null;
    private IPersonne p;

    public void createListe(final JLabel labeleval, IPersonne p) {
        DefaultListModel listModel = new DefaultListModel();
        pchild = p.getFils();

        for (IPersonne pc : pchild) {
            String n = "";
            try {
                n = pc.getPrenom();
            } catch (Exception e) {
            }

            listModel.addElement(n);
        }

        listenoms = new JList(listModel);

        listenoms.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                current = listenoms.getSelectedIndex();


                labeleval.setText("Evaluation de : " + listenoms.getSelectedValue());

            }
        });
    }

    public MaFrameConnexion() {

        // CardLayout Panel permettant d'alterner entre les différents panels.
        cardpanels = new JPanel();
        cardpanels.setLayout(new CardLayout());

        // Panel de connexion
        panelco = new JPanel();
        panelmetier = new JPanel();

        panelco.setLayout(new FlowLayout());
        panelmetier.setLayout(new GridBagLayout());

        // Variables pannel de connexion
        label = new JLabel("Votre identifiant :");
        champtexte = new IntegerField(25);
        champeval = new JTextField(25);
        boutonOK = new JButton();
        boutonAnnuler = new JButton();
        boutonValider = new JButton();

        boutonValider.setText("Valider");
        boutonOK.setText("OK");
        boutonAnnuler.setText("Annuler");

        setTitle("Connexion utilisateur");
        panelco.add(label);
        panelco.add(champtexte);
        panelco.add(boutonAnnuler);
        panelco.add(boutonOK);
        panelco.setVisible(true);

        boutonOK.setEnabled(false);

        final JLabel labeleval = new JLabel();
        // GridBagConstraints pour organiser les composants de la fenêtre
        // d'évaluation
        final GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;

        // On ajoute les panels au CardLayout
        cardpanels.add(panelco, "1");
        cardpanels.add(panelmetier, "2");

        add(cardpanels);


        // Test qui constate le bon remplissage de la zone de saisie pour
        // déverrouiller le bouton OK

        champtexte.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                changed();
            }

            public void removeUpdate(DocumentEvent e) {
                changed();
            }

            public void insertUpdate(DocumentEvent e) {
                changed();
            }

            public void changed() {
                if (champtexte.getText().isEmpty()) {
                    boutonOK.setEnabled(false);
                } else {
                    boutonOK.setEnabled(true);
                }

            }
        });

        // ActionListener du bouton valider
        boutonValider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            	if (current != null)
            	{
                System.out.println("VAlidation ==> " + champeval.getText() + " Sur ==> " + current);

                IPersonne fils = p.getFils().get(current);

                fils.setEvaluation(champeval.getText());

                try {
                    PersonneMapper.getInstance().update(fils);
                    UnitOfWork.getInstance().commit();
                    JOptionPane.showMessageDialog(panelmetier, "Commit OK !");

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            	}else
            		JOptionPane.showMessageDialog(panelmetier, "Selectionnez un nom dans la liste.");

            }
        });

        // ActionListener du bouton annuler
        boutonAnnuler.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Ferme la fenêtre.
                dispose();

            }
        });

        // ActionListener du bouton OK
        boutonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Ferme la fenêtre.
                // dispose();
                ((CardLayout) cardpanels.getLayout()).show(cardpanels, "2");

                setTitle("Page d'évaluation");

                String idUser = champtexte.getText();

                p = PersonneMapper.getInstance().find(Integer.parseInt(idUser));
                if (p == null) {
                    System.out.println("Not IN DATABASE, So close");
                    dispose();
                    return;
                }
                createListe(labeleval, p);

                String nom = "";
                String prenom = "";
                try {
                    nom = p.getNom();
                    prenom = p.getPrenom();

                    if (nom == null)
                        nom = "";
                    if (prenom == null)
                        prenom = "";
                } catch (Exception ignored) {

                }

                // LABEL VOUS
                gbc.gridx = 0;
                gbc.gridwidth = 2;
                gbc.gridheight = 2;
                gbc.gridy = 0;
                gbc.fill = GridBagConstraints.BOTH;
                panelmetier.add(new JLabel("Vous : " + nom + " " + prenom), gbc);

                // LABEL VOTRE PERE
                gbc.gridx = 0;
                gbc.gridwidth = 2;
                gbc.gridheight = 2;
                gbc.gridy = 5;
                gbc.fill = GridBagConstraints.BOTH;

                nom = "";
                prenom = "";
                try {
                    if (p.getPere() != null) {
                        nom = p.getPere().getNom();
                        prenom = p.getPere().getPrenom();

                        if (nom == null)
                            nom = "";
                        if (prenom == null)
                            prenom = "";
                    }
                } catch (Exception ignored) {

                }

                panelmetier.add(new JLabel("Votre père : " + nom + " " + prenom), gbc);


                String eval = "";
                try {
                    eval = p.getEvaluation();
                } catch (Exception ignored) {

                }

                // LABEL VOTRE EVALUATION
                gbc.gridx = 0;
                gbc.gridwidth = 2;
                gbc.gridheight = 2;
                gbc.gridy = 10;
                gbc.fill = GridBagConstraints.BOTH;
                panelmetier.add(new JLabel("Votre évaluation :  " + eval), gbc);

                // BOUTON ANNULER
                gbc.gridx = 5;
                gbc.gridwidth = 7;
                gbc.gridheight = 7;
                gbc.gridy = 5;
                gbc.fill = GridBagConstraints.BOTH;
                panelmetier.add(boutonAnnuler, gbc);

                // LABEL VOS FILS
                gbc.gridx = 0;
                gbc.gridwidth = 2;
                gbc.gridheight = 2;
                gbc.gridy = 15;
                gbc.fill = GridBagConstraints.BOTH;
                panelmetier.add(new JLabel("Vos fils :          "), gbc);

                // LISTE NOM
                gbc.gridx = 0;
                gbc.gridwidth = 2;
                gbc.gridheight = 2;
                gbc.gridy = 20;
                gbc.fill = GridBagConstraints.BOTH;
                panelmetier.add(listenoms, gbc);

                // LABEL EVALUATION DU FILS
                gbc.gridx = 5;
                gbc.gridwidth = 2;
                gbc.gridheight = 2;
                gbc.gridy = 15;
                gbc.fill = GridBagConstraints.BOTH;
                panelmetier.add(labeleval, gbc);

                // ZONE DE SAISIE DE L'EVALUATION
                gbc.gridx = 5;
                gbc.gridwidth = 2;
                gbc.gridheight = 2;
                gbc.gridy = 20;
                gbc.fill = GridBagConstraints.BOTH;
                panelmetier.add(champeval, gbc);

                // BOUTON VALIDER
                gbc.gridx = 5;
                gbc.gridwidth = 2;
                gbc.gridheight = 2;
                gbc.gridy = 25;
                gbc.fill = GridBagConstraints.BOTH;
                panelmetier.add(boutonValider, gbc);

            }
        });

    }

}
