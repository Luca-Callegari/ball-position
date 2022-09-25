import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

public class Palla extends JFrame {
    private JTextField x;
    private JTextField y;
    private JButton b;
    private schermo pannello;
    private JPanel sfondo;
    Font f = new Font(Font.SERIF, Font.BOLD, 36);

    public Palla() {
        finestra();
        sfondo();
        pannello();
        xy();
        b();
    }

    public void finestra() {
        super.setTitle("Finestra");
        super.setSize(1800, 1800);
        super.setLocation(0, 0);
        super.setVisible(true);
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void sfondo() {
        this.sfondo = new JPanel();
        this.sfondo.setSize(1800, 1800);
        this.sfondo.setLocation(0, 0);
        this.sfondo.setLayout(null);
        setContentPane(this.sfondo);
    }
    public void b() {
        this.b = new JButton("Clicca!");
        this.sfondo.add(this.b);
        this.b.setSize(250, 100);
        this.b.setLocation(70, 300);
        this.b.setFont(f);
        this.b.setBackground(Color.GREEN);

        Cliccato c = new Cliccato();
        this.b.addActionListener(c);

    }
    public void pannello() {
        this.pannello = new schermo();
        this.sfondo.add(this.pannello);
        this.pannello.setSize(800, 700);
        this.pannello.setLocation(400, 0);
        this.pannello.setBackground(Color.BLACK);

    }
    public void xy() {
        this.x = new JTextField();
        this.sfondo.add(this.x);
        this.x.setFont(f);
        this.x.setSize(100, 50);
        this.x.setLocation(150, 50);

        this.y = new JTextField();
        this.sfondo.add(this.y);
        this.y.setFont(f);
        this.y.setSize(100, 50);
        this.y.setLocation(150, 150);

    }

    class Cliccato implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            float x1 = Float.parseFloat(Palla.this.x.getText());
            float y1 = Float.parseFloat(Palla.this.y.getText());
            pannello.x = x1;
            pannello.y = y1;
            pannello.r = 50;
        }
    }

    class schermo extends JPanel {
        float x;
        float y;
        float r;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.YELLOW);
            Ellipse2D.Double e = new Ellipse2D.Double(x, y, r, r);
            g2.fill(e);
            repaint();
        }
    }


    public static void main(String[] args) {
        /*
         *  scrivere una finestra grafica che contiene due textfield,
         *  un bottone ed un pannello di disegno (800x800). L’utente inserisce nelle textfield due coordinate
         *  (x ed y) e alla pressione del pulsante (con scritta disegna) disegna una pallina gialla di raggio 50 nelle coordinate indicate.
         *
         */
        Palla p = new Palla();
    }
}
