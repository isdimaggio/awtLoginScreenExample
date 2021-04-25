import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PaginaLogin extends JFrame {

    LoginDataPersister loginDataPersister = new LoginDataPersister();

    //LABELS
    JLabel titoloBluLbl = new JLabel("Login", SwingConstants.LEFT);
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
    JButton pulsanteLogin = new JButton("ACCEDI");
    JButton pulsanteRichiediPass = new JButton("Richiedi Password");
    JButton pulsanteRegistrati = new JButton("Registrati");

    public PaginaLogin() {
        super("Finestra Accesso");

        //IMPOSTAZIONI INIZIALI
        setSize(400, 400);
        setLocation(600, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        //DEFINZIONE PANNELLO 1
        JPanel pannelloLogin = new JPanel();
        pannelloLogin.setLayout(new GridLayout(11, 1));
        pannelloLogin.setBorder(BorderFactory.createEmptyBorder(20, 60, 0, 60));

        pulsanteLogin.addActionListener(new clickBottone());
        pulsanteRichiediPass.addActionListener(new clickBottone());
        pulsanteRegistrati.addActionListener(new clickBottone());

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
        pulsanteLogin.setPreferredSize(new Dimension(40, 160));
        pulsanteLogin.setBackground(Color.blue);
        pulsanteLogin.setForeground(Color.white);
        pannelloLogin.add(pulsanteLogin);
        pannelloLogin.setBackground(Color.lightGray);

        //DEFINIZIONE PANNELLO 2
        JPanel pannelloExtra = new JPanel();
        pannelloExtra.setLayout(new FlowLayout());
        pannelloExtra.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));

        pulsanteRichiediPass.setPreferredSize(new Dimension(160, 40));
        pulsanteRichiediPass.setBackground(Color.blue);
        pulsanteRichiediPass.setForeground(Color.white);
        pannelloExtra.add(pulsanteRichiediPass);

        pulsanteRegistrati.setPreferredSize(new Dimension(160, 40));
        pulsanteRegistrati.setBackground(Color.blue);
        pulsanteRegistrati.setForeground(Color.white);
        pannelloExtra.add(pulsanteRegistrati);
        pannelloExtra.add(err);
        pannelloExtra.setSize(new Dimension(400, 30));
        pannelloExtra.setBackground(Color.gray);

        //DEFINIZIONE PANNELLO PADRE
        JSplitPane pannelloPadre = new JSplitPane(SwingConstants.HORIZONTAL, pannelloLogin, pannelloExtra);
        pannelloPadre.setResizeWeight(1.0);
        pannelloPadre.setDividerLocation(350);
        setContentPane(pannelloPadre);
        setMinimumSize(new Dimension(400, 500));

    }

    private class clickBottone implements ActionListener {
        public void actionPerformed(ActionEvent evento) {
            if (evento.getActionCommand().equals("ACCEDI")) {
                if (idAgenziaTextBox.getText().equals("") || passwordTextBox.getText().equals("") || nomeTextBox.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "ERRORE: IMPOSSIBILE ACCEDERE");
                    err.setFont(f3);
                    err.setForeground(Color.red);
                    err.setText("ERRORE");
                } else {
                    LoginData ld = null;
                    try {
                        ld = loginDataPersister.retrieveLoginData();
                    } catch (IOException e) {
                        System.out.println("err");
                        e.printStackTrace();
                    }
                    if (ld != null && ld.checkLogin(idAgenziaTextBox.getText(), nomeTextBox.getText(), passwordTextBox.getText())) {
                        JOptionPane.showMessageDialog(null, "BENVENUTO");
                        setVisible(false);
                        dispose();
                        PaginaInterna p = new PaginaInterna();
                    } else {
                        JOptionPane.showMessageDialog(null, "ERRORE: IMPOSSIBILE ACCEDERE");
                        err.setFont(f3);
                        err.setForeground(Color.red);
                        err.setText("ERRORE");
                    }
                }
            } else if (evento.getActionCommand().equals("Richiedi Password")) {
                String pass = new LoginData().setRandomPassword(8);
                try {
                    loginDataPersister.changePassword(pass);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "ERRORE: Impossibile cambiare la password. " + e.getMessage());
                    err.setFont(f3);
                    err.setForeground(Color.red);
                    err.setText("ERRORE");
                    e.printStackTrace();
                } finally {
                    JOptionPane.showMessageDialog(null, "NUOVA PASSWORD: " + pass);
                }
            } else {
                setVisible(false);
                dispose();
                PaginaRegistrazione p = new PaginaRegistrazione();
            }
        }
    }
}