import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame
{
    //LABELS
    JLabel titoloBluLbl=new JLabel("LOGIN", SwingConstants.LEFT);
    JLabel idAgenziaLbl=new JLabel("Id Agenzia", SwingConstants.LEFT);
    JLabel cognomeLbl=new JLabel("Nome Utente", SwingConstants.LEFT);
    JLabel passwordLbl=new JLabel("Password", SwingConstants.LEFT);

    //TEXT FIELDS
    JTextField idAgenziaTextBox= new JTextField(20);
    JTextField nomeTextBox= new JTextField(20);
    JPasswordField passwordTextBox = new JPasswordField(20);

    //FONTS
    Font f1= new Font("Calibri", Font.PLAIN, 25);
    Font f2= new Font("Liberation Sans", Font.PLAIN, 15);

    //BUTTONS
    JButton pulsanteLogin= new JButton("ACCEDI");
    JButton pulsanteRichiediPass= new JButton("Richiedi Password");
    JButton pulsanteRegistrati= new JButton("Registrati");

    public Gui() {
        super("Finestra Accesso");

        //IMPOSTAZIONI INIZIALI
        setSize(400, 605);
        setLocation(600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);

        //DEFINZIONE PANNELLO 1
        JPanel pannelloLogin = new JPanel();
        pannelloLogin.setLayout(new GridLayout(11, 1));
        pannelloLogin.setBorder(BorderFactory.createEmptyBorder(20, 60, 0, 60));

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
        pannelloExtra.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        pulsanteRichiediPass.setPreferredSize(new Dimension(160, 40));
        pulsanteRichiediPass.setBackground(Color.blue);
        pulsanteRichiediPass.setForeground(Color.white);
        pannelloExtra.add(pulsanteRichiediPass);

        pulsanteRegistrati.setPreferredSize(new Dimension(160, 40));
        pulsanteRegistrati.setBackground(Color.blue);
        pulsanteRegistrati.setForeground(Color.white);
        pannelloExtra.add(pulsanteRegistrati);

        pannelloExtra.setMinimumSize(new Dimension(400, 60));
        pannelloExtra.setBackground(Color.gray);

        //DEFINIZIONE PANNELLO PADRE
        JSplitPane pannelloPadre = new JSplitPane(SwingConstants.HORIZONTAL, pannelloLogin, pannelloExtra);
        pannelloPadre.setResizeWeight(1.0);
        pannelloPadre.setDividerLocation(460);
        setContentPane(pannelloPadre);
        setMinimumSize(new Dimension(400, 500));
    }
}
