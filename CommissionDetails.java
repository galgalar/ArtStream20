

import javax.swing.*;
import java.awt.*;

public class CommissionDetails extends JFrame {
    
    protected JLabel artistNameLabel;
    protected JLabel commissionTypeLabel;
    protected JLabel priceLabel;
    protected JLabel statusLabel;

    public CommissionDetails(String artistName, String commissionType, double price, String status) 
    {
        setTitle("Commission Details");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout());

        JPanel detailsPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        
        artistNameLabel = new JLabel("Artist Name: " + artistName);
        commissionTypeLabel = new JLabel("Commission Type: " + commissionType);
        priceLabel = new JLabel("Price: $" + price);
        statusLabel = new JLabel("Status: " + status);

        detailsPanel.add(artistNameLabel);
        detailsPanel.add(commissionTypeLabel);
        detailsPanel.add(priceLabel);
        detailsPanel.add(statusLabel);

        add(detailsPanel, BorderLayout.CENTER);

       
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dispose());
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(closeButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    
    protected void customizeDetails() {
        
    }


    


}