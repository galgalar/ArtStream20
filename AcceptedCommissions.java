

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;

public class AcceptedCommissions extends JPanel {
    
    public AcceptedCommissions()
    {
        setBackground(Color.decode("#17224d"));
        setLayout(new BorderLayout());
        JPanel[] panels = new JPanel[2];

        for(int i = 0; i < panels.length; ++i)
        {
            if(i == 0)
            {
                JLabel labelHeader = new JLabel();
                labelHeader.setText("Accepted Commissions");
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
    
    
    
    
}
