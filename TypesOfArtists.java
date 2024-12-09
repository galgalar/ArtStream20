import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;

public class TypesOfArtists extends JPanel implements ActionListener {

    private JPanel main = new JPanel();
    private ImageIcon[] imagesOfTypeOfArtists = 
    {
        new ImageIcon("Artstrem-13-main\\ArtStream13-main\\digitalarts.jpg"),
        new ImageIcon("Artstrem-13-main\\ArtStream13-main\\charcoal.jpg"),
        new ImageIcon("Artstrem-13-main\\ArtStream13-main\\landscape.jpg"),
        new ImageIcon("Artstrem-13-main\\ArtStream13-main\\portrait.jpg")
    };
    private JPanel[] gridPanels = new JPanel[4];
    private JButton[] viewArtistsButton = new JButton[4];

    public TypesOfArtists()
    {    
        setBackground(Color.decode("#17224d"));
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        JPanel artistPanel = new JPanel();
        JLabel artists = new JLabel("Artists");
        artistPanel.add(artists);
        artistPanel.setBorder(BorderFactory.createEmptyBorder(150,150,150,150));
        artistPanel.setBackground(Color.decode("#484e7e"));
        artists.setFont(new Font("Monospaces",Font.PLAIN,30));
        artists.setForeground(Color.WHITE);

        add(main,BorderLayout.CENTER);
        add(artists,BorderLayout.NORTH);
        main.setLayout(new GridLayout(0,4,20,20));
        main.setBorder(BorderFactory.createEmptyBorder(50,10,50,10));
        main.setBackground(Color.decode("#17224d"));
  
        for(int i = 0; i < imagesOfTypeOfArtists.length; ++i)
        {
            Image icon = imagesOfTypeOfArtists[i].getImage();
            Image iconResize = icon.getScaledInstance(300,300, Image.SCALE_SMOOTH);
            imagesOfTypeOfArtists[i] = new ImageIcon(iconResize);
            
            if(i == 0)
            {
                JLabel labelWithIcon = new JLabel(imagesOfTypeOfArtists[i]);
                labelWithIcon.setText("Digital Artists");
                labelWithIcon.setVerticalTextPosition(SwingConstants.BOTTOM);
                labelWithIcon.setHorizontalTextPosition(SwingConstants.CENTER);
                labelWithIcon.setForeground(Color.WHITE);
                labelWithIcon.setIconTextGap(20);
                gridPanels[i] = new JPanel();
                gridPanels[i].setLayout(new BorderLayout());
                gridPanels[i].add(labelWithIcon,BorderLayout.CENTER);
                viewArtistsButton[i] = new JButton("View Details");
                viewArtistsButton[i].addActionListener(this);
                viewArtistsButton[i].setBackground(Color.decode("#303765"));
                gridPanels[i].add(viewArtistsButton[i],BorderLayout.SOUTH);
                gridPanels[i].setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
                main.add(gridPanels[i]);

            }else if(i == 1)
            {
                JLabel labelWithIcon = new JLabel(imagesOfTypeOfArtists[i]);
                labelWithIcon.setText("Charcoal Artists");
                labelWithIcon.setVerticalTextPosition(SwingConstants.BOTTOM);
                labelWithIcon.setHorizontalTextPosition(SwingConstants.CENTER);
                labelWithIcon.setIconTextGap(20);
                labelWithIcon.setForeground(Color.WHITE);
                gridPanels[i] = new JPanel();
                gridPanels[i].setLayout(new BorderLayout());
                gridPanels[i].add(labelWithIcon,BorderLayout.CENTER);
                viewArtistsButton[i] = new JButton("View Details");
                viewArtistsButton[i].addActionListener(this);
                viewArtistsButton[i].setBackground(Color.decode("#303765"));
                gridPanels[i].add(viewArtistsButton[i],BorderLayout.SOUTH);
                gridPanels[i].setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
                main.add(gridPanels[i]);

            }else if(i == 2)
            {
                JLabel labelWithIcon = new JLabel(imagesOfTypeOfArtists[i]);
                labelWithIcon.setText("Landscape Artists");
                labelWithIcon.setVerticalTextPosition(SwingConstants.BOTTOM);
                labelWithIcon.setHorizontalTextPosition(SwingConstants.CENTER);
                labelWithIcon.setIconTextGap(20);
                labelWithIcon.setForeground(Color.WHITE);

                gridPanels[i] = new JPanel();
                gridPanels[i].setLayout(new BorderLayout());
                gridPanels[i].add(labelWithIcon,BorderLayout.CENTER);
                viewArtistsButton[i] = new JButton("View Details");
                viewArtistsButton[i].addActionListener(this);
                viewArtistsButton[i].setBackground(Color.decode("#303765"));
                gridPanels[i].setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
                gridPanels[i].add(viewArtistsButton[i],BorderLayout.SOUTH);
                main.add(gridPanels[i]);
            }else
            {
                JLabel labelWithIcon = new JLabel(imagesOfTypeOfArtists[i]);
                labelWithIcon.setText("Portrait Artists");
                labelWithIcon.setVerticalTextPosition(SwingConstants.BOTTOM);
                labelWithIcon.setHorizontalTextPosition(SwingConstants.CENTER);
                labelWithIcon.setIconTextGap(20);
                labelWithIcon.setForeground(Color.WHITE);

                gridPanels[i] = new JPanel();
                gridPanels[i].setLayout(new BorderLayout());
                gridPanels[i].add(labelWithIcon,BorderLayout.CENTER);
                viewArtistsButton[i] = new JButton("View Details");
                viewArtistsButton[i].addActionListener(this);
                viewArtistsButton[i].setBackground(Color.decode("#303765"));
                gridPanels[i].setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
                gridPanels[i].add(viewArtistsButton[i],BorderLayout.SOUTH);
                main.add(gridPanels[i]);
            }
            
            viewArtistsButton[i].setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
            viewArtistsButton[i].setForeground(Color.white);
            viewArtistsButton[i].setFont(new Font("Monospaced",Font.PLAIN,13));
            gridPanels[i].setBackground(Color.decode("#484e7e"));
           

        }
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();


        if(source == viewArtistsButton[0])
        {
            JOptionPane.showMessageDialog(null,"Digital art is work made with digital technology or presented on digital technology. ");
            new DigitalArtists();
        }else if(source == viewArtistsButton[1])
        {
            JOptionPane.showMessageDialog(null," Charcoal has remained a popular medium for drawing since the Renaissance.");
        }else if(source == viewArtistsButton[2])
        {
            JOptionPane.showMessageDialog(null,"Art focusing on natural scenery.");
        }else if(source == viewArtistsButton[3])
        {
            JOptionPane.showMessageDialog(null,"A portrait is a portrayal of a person, usually showing the person's face (but not always).");
        }



    }




}
