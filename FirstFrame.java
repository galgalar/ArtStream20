
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FirstFrame extends JFrame implements ActionListener {
    
    private Container con = getContentPane();
    private JPanel header = new JPanel();
    private JPanel main = new JPanel();
    private JPanel footer = new JPanel();
    private JPanel[] typeOfUser = new JPanel[2];
    private JLabel[] users = new JLabel[2];
    private JButton client = new JButton("Get Started");
    private JButton artist = new JButton("Get Started");
    private ImageIcon[] icons = new ImageIcon[3];

    public FirstFrame() {
        super("FirstFrame");
        setSize(1200,900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        con.setBackground(Color.WHITE);
        con.setLayout(new BorderLayout());
        con.setBackground(Color.decode("#000e37"));
        // Header
        con.add(header, BorderLayout.NORTH);
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
        Font font = new Font("Monospaced", Font.PLAIN, 20);
        JLabel para1 = new JLabel("Who\'s using ArtStream?");
        JLabel para2 = new JLabel("Create your profile here.");
        para1.setFont(font.deriveFont(Font.BOLD, 40));
        para1.setForeground(Color.WHITE);
        para2.setFont(font);
        para2.setForeground(Color.WHITE);
        header.add(Box.createRigidArea(new Dimension(0, 50)));
        header.add(para1);
        header.add(Box.createRigidArea(new Dimension(0, 15)));
        para1.setAlignmentX(CENTER_ALIGNMENT);
        header.add(para2);
        header.add(Box.createRigidArea(new Dimension(0, 50)));
        para2.setAlignmentX(CENTER_ALIGNMENT);
        
        header.setBackground(Color.decode("#000e37"));
        main.setBackground(Color.decode("#000e37"));
        
        con.add(main, BorderLayout.CENTER);
        main.setLayout(new GridLayout(0, 2, 10, 10));

        
        String[] g = {"Admin","Client"};
        String[] iconPaths = {
            "Artstrem-13-main\\ArtStream13-main\\3-removebg-preview (1).png",
            "Artstrem-13-main\\ArtStream13-main\\2-removebg-preview.png",
    
        };
        
        client.setFont(new Font("Monospaced", Font.PLAIN, 15));
        artist.setFont(new Font("Monospaced", Font.PLAIN, 15));
        
        client.setBackground(Color.decode("#89CFF0"));
        artist.setBackground(Color.decode("#89CFF0"));

        
        client.setForeground(Color.BLACK);
        artist.setForeground(Color.BLACK);
        
       
        client.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        artist.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        for (int i = 0; i < users.length; ++i) {

            ImageIcon icon = new ImageIcon(iconPaths[i]);

            Image img = icon.getImage();
            Image scaledImg = img.getScaledInstance(200,200 , Image.SCALE_SMOOTH);
            icons[i] = new ImageIcon(scaledImg);

            users[i] = new JLabel(icons[i]);
            users[i].setText(g[i]);
            users[i].setVerticalTextPosition(SwingConstants.BOTTOM);
            users[i].setHorizontalTextPosition(SwingConstants.CENTER);

            typeOfUser[i] = new JPanel();
            typeOfUser[i].setLayout(new BorderLayout());
            typeOfUser[i].setBackground(Color.WHITE);
            typeOfUser[i].add(users[i], BorderLayout.CENTER);
            typeOfUser[i].setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));

            if (i == 0) {
                typeOfUser[0].add(artist, BorderLayout.SOUTH);
            } else if (i == 1) {
                typeOfUser[1].add(client, BorderLayout.SOUTH);
            } 
        }

        for (int i = 0; i < typeOfUser.length; ++i) {
            main.add(typeOfUser[i]);
        }
        main.setBorder(BorderFactory.createEmptyBorder(50,100,200,100));
        con.add(footer, BorderLayout.SOUTH);
    
        
        client.addActionListener(this);
        artist.addActionListener(this);

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == client) {
            new SetupAccountClient();
            dispose();
        }else if(source == artist)
        {
            new SetupAccountAdmin();
            dispose();
        }
    }
    



}
