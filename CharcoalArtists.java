
import javax.swing.*;
import java.awt.*;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.event.*;

public class CharcoalArtists extends JPanel  implements ActionListener {
 
    
    private JPanel[] panels = new JPanel[2];
    private JPanel[] gridDigitalProfile = new JPanel[6];
    private String[] artists =
    {
        "Zyne Adjijil",
        "Charlyn Mira",
        "Bea Dulce",
        "Loid Avelino",
        "Wheya Rose",
        "Dean Ross"
    };
    private JButton[] sendCommission = new JButton[6];

    public CharcoalArtists()
    {
        setBackground(Color.decode("#17224d"));
        setLayout(new BorderLayout());
        
        for(int i = 0; i < panels.length; ++i)
        {
            if(i == 0)
            {
                JLabel labelHeader = new JLabel();
                labelHeader.setText("Charcoal Artists");
                labelHeader.setFont(new Font("Monospace",Font.BOLD,30));
                labelHeader.setForeground(Color.WHITE);
                
                panels[i] = new JPanel();
                panels[i].setLayout(new FlowLayout(FlowLayout.LEFT));
                panels[i].setBackground(Color.decode("#17224d"));
                panels[i].add(labelHeader);

                add(panels[i],BorderLayout.NORTH);
            }else
            {
                panels[i] = new JPanel();
                panels[i].setBackground(Color.decode("#17224d"));
                panels[i].setLayout(new GridLayout(2,3,20,20));      
                add(panels[i],BorderLayout.CENTER);   

            }
            
        }

        for (int i = 0; i < gridDigitalProfile.length; ++i) {
            gridDigitalProfile[i] = new JPanel();
            gridDigitalProfile[i].setLayout(new BorderLayout());
        
            ImageIcon image = new ImageIcon("Artstrem-13-main\\ArtStream13-main\\profile.jpg");
            Image getIconForResizing = image.getImage();
            Image resizeIcon = getIconForResizing.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            image = new ImageIcon(resizeIcon);
            JLabel profile = new JLabel(image);
            profile.setText(artists[i]);
            profile.setVerticalTextPosition(SwingConstants.BOTTOM);
            profile.setHorizontalTextPosition(SwingConstants.CENTER);
        
            gridDigitalProfile[i].add(profile, BorderLayout.CENTER);
        
           
            sendCommission[i] = new JButton("Request Commission");
            sendCommission[i].addActionListener(this);
            gridDigitalProfile[i].add(sendCommission[i], BorderLayout.SOUTH);
            gridDigitalProfile[i].setPreferredSize(new Dimension(500, 500));
        
            panels[1].setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            panels[1].add(gridDigitalProfile[i]);
        }

        
        setVisible(true);

         
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < sendCommission.length; i++) {
            if (e.getSource() == sendCommission[i]) {                       
                JOptionPane.showMessageDialog(this, "Requesting commission for " + artists[i]);
                new CommissionCharcoal(artists[i]);
            }
        }
    }
    


    
}
