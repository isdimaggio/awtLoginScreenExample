import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PaginaRegistrazione extends JFrame {
    LoginDataPersister loginDataPersister = new LoginDataPersister();

    //LABELS
    JLabel titoloBluLbl = new JLabel("Sign-in", SwingConstants.LEFT);
    JLabel idAgenziaLbl = new JLabel("Id Agenzia", SwingConstants.LEFT);
    JLabel cognomeLbl = new JLabel("Nome Utente", SwingConstants.LEFT);
    JLabel passwordLbl = new JLabel("Password", SwingConstants.LEFT);
    JLabel err = new JLabel("", SwingConstants.CENTER);

    //TEXT FIELDS
    JTextField idAgenziaTextBox = new JTextField(20);
    JTextField nomeTextBox = new JTextField(20);
    JPasswordField passwordTextBox = new JPasswordField(20);

    //FONTS
    Font f1 = new Font("Calibri", Font.BOLD, 25);
    Font f2 = new Font("Liberation Sans", Font.PLAIN, 15);
    Font f3 = new Font("Liberation Sans", Font.PLAIN, 15);

    //BUTTONS
    JButton pulsanteRichiediPass = new JButton("Suggerisci Password");
    JButton pulsanteRegistrati = new JButton("REGISTRATI");
    JButton pulsanteLogin = new JButton("Login");

    public PaginaRegistrazione() {
        super("Finestra Registrazione");

        //IMPOSTAZIONI INIZIALI
        setSize(400, 400);
        setLocation(600, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        //DEFINZIONE PANNELLO
        JPanel pannelloLogin = new JPanel();
        pannelloLogin.setLayout(new GridLayout(11, 1));
        pannelloLogin.setBorder(BorderFactory.createEmptyBorder(20, 60, 0, 60));

        pulsanteRichiediPass.addActionListener(new clickBottone());
        pulsanteRegistrati.addActionListener(new clickBottone());
        pulsanteLogin.addActionListener(new clickBottone());

        titoloBluLbl.setFont(f1);
        titoloBluLbl.setForeground(Color.black);
        passwordLbl.setFont(f2);
        passwordLbl.setForeground(Color.gray);
        idAgenziaLbl.setFont(f2);
        idAgenziaLbl.setForeground(Color.gray);
        cognomeLbl.setFont(f2);
        cognomeLbl.setForeground(Color.gray);

        idAgenziaTextBox.setEditable(true);
        nomeTextBox.setEditable(true);
        passwordTextBox.setEditable(true);
        passwordTextBox.setEchoChar('*');

        pannelloLogin.add(titoloBluLbl);
        pannelloLogin.add(new JLabel(""));
        pannelloLogin.add(idAgenziaLbl);
        pannelloLogin.add(idAgenziaTextBox);
        pannelloLogin.add(cognomeLbl);
        pannelloLogin.add(nomeTextBox);
        pannelloLogin.add(passwordLbl);
        pannelloLogin.add(passwordTextBox);
        pannelloLogin.add(new JLabel(""));
        pulsanteRegistrati.setPreferredSize(new Dimension(160, 40));
        pulsanteRegistrati.setBackground(Color.blue);
        pulsanteRegistrati.setForeground(Color.white);
        pannelloLogin.add(pulsanteRegistrati);
        pannelloLogin.setBackground(Color.lightGray);

        //DEFINIZIONE PANNELLO 2
        JPanel pannelloExtra = new JPanel();
        pannelloExtra.setLayout(new FlowLayout());
        pannelloExtra.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));

        pulsanteRichiediPass.setPreferredSize(new Dimension(160, 40));
        pulsanteRichiediPass.setBackground(Color.blue);
        pulsanteRichiediPass.setForeground(Color.white);
        pannelloExtra.add(pulsanteRichiediPass);

        pulsanteLogin.setPreferredSize(new Dimension(160, 40));
        pulsanteLogin.setBackground(Color.blue);
        pulsanteLogin.setForeground(Color.white);
        pannelloExtra.add(pulsanteLogin);
        pannelloExtra.add(err);
        pannelloExtra.setSize(new Dimension(400, 30));
        pannelloExtra.setBackground(Color.gray);

        //DEFINIZIONE PANNELLO PADRE
        JSplitPane pannelloPadre = new JSplitPane(SwingConstants.HORIZONTAL, pannelloLogin, pannelloExtra);
        pannelloPadre.setResizeWeight(1.0);
        pannelloPadre.setDividerLocation(350);
        setContentPane(pannelloPadre);
        setMinimumSize(new Dimension(400, 500));
        setContentPane(pannelloPadre);
    }

    private class clickBottone implements ActionListener {
        public void actionPerformed(ActionEvent evento) {
            if (evento.getActionCommand().equals("REGISTRATI")) {
                if (idAgenziaTextBox.getText().equals("") || passwordTextBox.getText().equals("") || nomeTextBox.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "ERRORE: CAMPI OBBLIGATORI MANCANTI");
                    err.setFont(f3);
                    err.setForeground(Color.red);
                    err.setText("ERRORE");
                } else {
                    LoginData ld = new LoginData();
                    ld.idAgenzia = idAgenziaTextBox.getText();
                    ld.username = nomeTextBox.getText();
                    ld.password = passwordTextBox.getText();
                    try {
                        loginDataPersister.saveLoginData(ld, false);
                        JOptionPane.showMessageDialog(null, "BENVENUTO");
                        setVisible(false);
                        dispose();
                        PaginaInterna p = new PaginaInterna();
                    } catch (IOException e) {
                        System.out.println("Impossibile salvare dati di persistenza.");
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "ERRORE: Impossibile salvare i dati di persistenza.");
                        err.setFont(f3);
                        err.setForeground(Color.red);
                        err.setText("ERRORE");
                    }
                }
            } else if (evento.getActionCommand().equals("Suggerisci Password")) {
                String passConsigliata = new LoginData().setRandomPassword(8);
                passwordTextBox.setText(passConsigliata);
                JOptionPane.showMessageDialog(null, "PASSWORD CONSIGLIATA: " + passConsigliata);
            } else {
                setVisible(false);
                dispose();
                PaginaLogin p = new PaginaLogin();
            }
        }
    }
}