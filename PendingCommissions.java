
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;

public class PendingCommissions extends JPanel{

    public PendingCommissions()
    {
        setBackground(Color.decode("#17224d"));
        setLayout(new BorderLayout());
        JPanel[] panels = new JPanel[2];

        for(int i = 0; i < panels.length; ++i)
        {
            if(i == 0)
            {
                JLabel labelHeader = new JLabel();
                labelHeader.setText("Pending Commissions");
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
                add(panels[i],BorderLayout.CENTER);
                
            }
            
        }
      





        setVisible(true);
    }

    
    
    // public static ArrayList <JPanel> panels = new ArrayList<>();
    // private JButton cancel = new JButton("Cancel"); 
    
    // public PendingCommissions()
    // {
    //     label.setText("Pending Commissions");
    //     contents.removeAll();   
    //     contents.setLayout(new FlowLayout(FlowLayout.LEADING));
    //     for(int i = 0; i < panels.size(); ++i)
    //     {
    //         contents.add(panels.get(i));
    //     }            
    //     setVisible(true);
    // }
  
    // public PendingCommissions(String typeOfArt, String name, String email, String contact, String subject, String medium, String size, double totalSummary)
    // {
    //     label.setText("Pending Commissions");
    //     contents.removeAll();
    //     contents.setLayout(new FlowLayout(FlowLayout.LEADING));
        
    //     JLabel type = new JLabel(typeOfArt);
    //     JLabel nameLabel = new JLabel(name);
    //     JLabel emailLabel = new JLabel(email);
    //     JLabel contactLabel = new JLabel(contact);
    //     JLabel subjectLabel = new JLabel(subject);
    //     JLabel mediumLabel = new JLabel(medium);
    //     JLabel sizeLabel = new JLabel(size);
    //     JLabel totalLabel = new JLabel(Double.toString(totalSummary));
        
    //     type.setForeground(Color.white);
    //     nameLabel.setForeground(Color.white);
    //     emailLabel.setForeground(Color.white);
    //     contactLabel.setForeground(Color.white);
    //     subjectLabel.setForeground(Color.white);
    //     mediumLabel.setForeground(Color.white);
    //     sizeLabel.setForeground(Color.white);
    //     mediumLabel.setForeground(Color.white);
    //     sizeLabel.setForeground(Color.white);
    //     totalLabel.setForeground(Color.white);
       
    //     JPanel panel = new JPanel();
    //     panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    //     panel.add(Box.createRigidArea(new Dimension(0, 10)));
    //     panel.add(type);
    //     panel.add(Box.createRigidArea(new Dimension(0, 10)));
    //     panel.add(nameLabel);
    //     panel.add(Box.createRigidArea(new Dimension(0, 10)));
    //     panel.add(emailLabel);
    //     panel.add(Box.createRigidArea(new Dimension(0, 10)));
    //     panel.add(contactLabel);
    //     panel.add(Box.createRigidArea(new Dimension(0, 10)));
    //     panel.add(subjectLabel);
    //     panel.add(Box.createRigidArea(new Dimension(0, 10)));
    //     panel.add(mediumLabel);
    //     panel.add(Box.createRigidArea(new Dimension(0, 10)));
    //     panel.add(sizeLabel);
    //     panel.add(Box.createRigidArea(new Dimension(0, 10)));
    //     panel.add(totalLabel);
    //     panel.add(Box.createRigidArea(new Dimension(0, 10)));   
    //     cancel.setPreferredSize(new Dimension(200, 50));
    //     panel.add(cancel);
    //     panel.add(Box.createRigidArea(new Dimension(0, 10)));  
    //     panel.setPreferredSize(new Dimension(400, 400));
    //     panel.setBackground(Color.decode("#303765"));
    //     panels.add(panel);      
    //     panel.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
        
    //     for(int i = 0; i < panels.size(); ++i)
    //     {
    //         contents.add(panels.get(i));
    //         requestsClients.add(panels.get(i)); // Fix: Adding the panel correctly
    //     }       
    //     mainPanel.add(contents, BorderLayout.CENTER);
        
    //     setVisible(false);
    // }
    
    // @Override 
    // public void actionPerformed(ActionEvent e)
    // {
    //    Object source = e.getSource();
       
    //    if(source == back)
    //    {
    //        new DashboardClient();
    //        setVisible(false);
    //    }
    // }
}