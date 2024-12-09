

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class DashboardClient extends JFrame implements ActionListener, ItemListener
{
    private String name;
    private Container con = getContentPane();
    private JPanel[] panelBorder = new JPanel[3];
    private JLabel title = new JLabel("ARTSTREAM");

    private ImageIcon[] imageIcons = 
    {
        new ImageIcon("Artstrem-13-main\\ArtStream13-main\\artistlogo.png"),
        new ImageIcon("Artstrem-13-main\\ArtStream13-main\\pending-removebg-preview.png"),
        new ImageIcon("Artstrem-13-main\\ArtStream13-main\\accepted-removebg-preview.png"),
        new ImageIcon("Artstrem-13-main\\ArtStream13-main\\profile-removebg-preview.png")
    };
    private JButton[] buttons = new JButton[4];
    private CardLayout card = new CardLayout();

    // private String[] artists = 
    // {
    //     "Select",
    //     "Digital Artists",
    //     "Charcoal Artists",
    //     "Landscape Artists",
    //     "Portrait Artists"
    // };
   // private JComboBox <String> typeOfArtists = new JComboBox<>(artists);
    private JButton[] typeOfArtists = new JButton[4];

    public DashboardClient()
    {

    }
    public DashboardClient(String name)
    {
        super("ArtStream");
        setSize(1600,1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.name = name;  
        con.setLayout(new BorderLayout());
        con.setBackground(Color.decode("#303765"));
        

        for(int i = 0; i < imageIcons.length; ++i)
        {
            Image icon = imageIcons[i].getImage();
            Image resizeIcon = icon.getScaledInstance(30,30,Image.SCALE_SMOOTH);
            imageIcons[i] = new ImageIcon(resizeIcon);
            buttons[i] = new JButton(imageIcons[i]);
            buttons[i].setBackground(Color.decode("#303765"));
            buttons[i].addActionListener(this);
           

        }
        for(int i = 0; i < buttons.length; ++i)
        {
            switch (i) {
                case 0:
                    buttons[0].setToolTipText("Artists");
                    buttons[0].setActionCommand("typeArtist");
                    typeOfArtists[0] = new JButton("Digital Artists");
                    typeOfArtists[0].setActionCommand("digital");
                    typeOfArtists[i].addActionListener(this);
                    break;
                case 1:
                    buttons[1].setToolTipText("Pending Commissions");
                    buttons[1].setActionCommand("pending");
                    typeOfArtists[1] = new JButton("Charcoal Artists");
                    typeOfArtists[1].setActionCommand("charcoal");
                    typeOfArtists[i].addActionListener(this);
                    break;
                case 2:
                    buttons[2].setToolTipText("Accepted Commissions");
                    buttons[2].setActionCommand("accepted");
                    typeOfArtists[2] = new JButton("Landscape Artists");
                    typeOfArtists[2].setActionCommand("landscape");
                    typeOfArtists[i].addActionListener(this);
                    break;
                case 3:
                    buttons[3].setToolTipText(name);
                    buttons[3].setActionCommand("logout");
                    typeOfArtists[3] = new JButton("Portrait Artists");
                    typeOfArtists[3].setActionCommand("portrait");
                    typeOfArtists[i].addActionListener(this);
                    break;        
                default:
                    break;
            }
        }


        for(int i = 0; i < panelBorder.length; ++i)
        {
            if(i == 0)
            {
                panelBorder[i] = new JPanel();
                panelBorder[i].setLayout(new BorderLayout());
                title.setForeground(Color.WHITE);
                title.setFont(new Font("Monospaced",Font.BOLD,30));
                JPanel panelTitle = new JPanel();
                panelTitle.add(title);
                panelTitle.setBackground(Color.decode("#303765"));
                panelTitle.setBorder(BorderFactory.createEmptyBorder(0,20,0,20));
                panelBorder[i].add(panelTitle,BorderLayout.WEST);             
                
                JPanel buttonsPanel = new JPanel();
                buttonsPanel.setLayout(new FlowLayout());
                buttonsPanel.add(buttons[0]);
                buttonsPanel.add(buttons[1]);
                buttonsPanel.add(buttons[2]);
                buttonsPanel.add(buttons[3]);
                buttonsPanel.setBackground(Color.decode("#303765"));
                panelBorder[i].add(buttonsPanel,BorderLayout.EAST);
                panelBorder[i].setBackground(Color.decode("#303765"));

                con.add(panelBorder[i],BorderLayout.NORTH);
                

            }else if(i == 1)
            {
                panelBorder[i] = new JPanel();
                
                // panelBorder[i].setLayout(new FlowLayout());
                panelBorder[i].setBackground(Color.decode("#17224d"));
                con.add(panelBorder[i],BorderLayout.CENTER);

            }else
            {
                ImageIcon profileOfClient = new ImageIcon("Artstrem-13-main\\ArtStream13-main\\profile.jpg");
                Image getProfileOfClient = profileOfClient.getImage();
                Image setProfileOfClient = getProfileOfClient.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                profileOfClient = new ImageIcon(setProfileOfClient);

                JLabel clientName = new JLabel(profileOfClient);
                clientName.setText(name);
                clientName.setVerticalTextPosition(SwingConstants.BOTTOM);
                clientName.setHorizontalTextPosition(SwingConstants.CENTER);
                clientName.setForeground(Color.WHITE);
                clientName.setFont(new Font("Monospaced",Font.BOLD,20));

                // JPanel picOfClient = new JPanel();
                // picOfClient.setLayout(new BoxLayout(picOfClient, BoxLayout.Y_AXIS));
                // picOfClient.add(clientName);

                panelBorder[i] = new JPanel();
                panelBorder[i].setLayout(new BoxLayout(panelBorder[i], BoxLayout.Y_AXIS));
                panelBorder[i].setBackground(Color.decode("#484e7e"));
                panelBorder[i].setBorder(BorderFactory.createEmptyBorder(100,50,100,50));
                // typeOfArtists.setMaximumSize(new Dimension(200,20));

                panelBorder[i].add(clientName);
                clientName.setAlignmentX(CENTER_ALIGNMENT);

                JLabel artistLabel = new JLabel("View Available Artists");
                artistLabel.setForeground(Color.WHITE);
                artistLabel.setFont(new Font("Monospaced",Font.BOLD,15));

                panelBorder[i].add(Box.createRigidArea(new Dimension(0,20)));
                panelBorder[i].add(artistLabel);
                artistLabel.setAlignmentX(CENTER_ALIGNMENT);

                panelBorder[i].add(Box.createRigidArea(new Dimension(0,20)));

                // typeOfArtists.setAlignmentX(CENTER_ALIGNMENT);
                panelBorder[i].add(typeOfArtists[0]);
                typeOfArtists[0].setMaximumSize(new Dimension(400,50));
                typeOfArtists[0].setAlignmentX(CENTER_ALIGNMENT);
                panelBorder[i].add(Box.createRigidArea(new Dimension(0,20)));

                panelBorder[i].add(typeOfArtists[1]);
                typeOfArtists[1].setMaximumSize(new Dimension(400,50));
                typeOfArtists[1].setAlignmentX(CENTER_ALIGNMENT);
                panelBorder[i].add(Box.createRigidArea(new Dimension(0,20)));

                panelBorder[i].add(typeOfArtists[2]);
                typeOfArtists[2].setMaximumSize(new Dimension(400,50));
                typeOfArtists[2].setAlignmentX(CENTER_ALIGNMENT);
                panelBorder[i].add(Box.createRigidArea(new Dimension(0,20)));

                panelBorder[i].add(typeOfArtists[3]);
                typeOfArtists[3].setMaximumSize(new Dimension(400,50));
                typeOfArtists[3].setAlignmentX(CENTER_ALIGNMENT);
                panelBorder[i].add(Box.createRigidArea(new Dimension(0,20)));

                con.add(panelBorder[i],BorderLayout.WEST);

            }
                
        }


        
            panelBorder[1].setLayout(card);
            panelBorder[1].add("typeArtist",new TypesOfArtists());
            panelBorder[1].add("pending",new PendingCommissions());
            panelBorder[1].add("accepted",new AcceptedCommissions());
    
            
          
            panelBorder[1].add("digital",new DigitalArtists());
            panelBorder[1].add("charcoal",new CharcoalArtists());
            panelBorder[1].add("landscape",new LandscapeArtists());
            panelBorder[1].add("portrait",new PortraitArtists());

    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();

        switch (command) {
            case "typeArtist":
                card.show(panelBorder[1], command);
                break;
             case "pending":
                card.show(panelBorder[1], command);
                break;
            case "accepted":
                card.show(panelBorder[1], command);
                break;
            case "digital":
                    card.show(panelBorder[1], command);
                break;
             case "charcoal":
                    card.show(panelBorder[1], command);
                break;
            case "landscape":
                   card.show(panelBorder[1], command);
                break;
            case "portrait":
                card.show(panelBorder[1], command);
                break;        
            case "logout":
                int i = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?","System",JOptionPane.YES_NO_OPTION);
                if(i == 0)
                {
                    new SetupAccountClient();
                    dispose();
                } 
                break;
            default:
                break;
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e)
    {
        // String command = e.getActionCommand();

        // switch (command) {
        //     case "typeArtist":
        //         card.show(panelBorder[1], command);
        //         break;
        //      case "pending":
        //         card.show(panelBorder[1], command);
        //         break;
        //     case "accepted":
        //         card.show(panelBorder[1], command);
        //         break;
        //     case "logout":
        //         int i = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?","System",JOptionPane.YES_NO_OPTION);
        //         if(i == 0)
        //         {
        //             new SetupAccountClient();
        //             dispose();
        //         } 
        //         break;
        //     default:
        //         break;
        // }
    


    }
    



    
    
}
