import javax.swing.*;
import java.awt.*;

public class Pagina_Interna extends JFrame {
    public Pagina_Interna() {
        super("Pagina interna");

        //IMPOSTAZIONI INIZIALI
        setSize(400, 400);
        setLocation(600, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        //def. pan.1
        JLabel titolo = new JLabel("Pagina interna!", SwingConstants.LEFT);
        Font f1 = new Font("Calibri", Font.BOLD, 25);
        JPanel pannelloInterno = new JPanel();
        pannelloInterno.setLayout(new GridLayout(1, 1));
        pannelloInterno.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 0));
        titolo.setFont(f1);
        pannelloInterno.add(titolo);
        setContentPane(pannelloInterno);
    }
}

