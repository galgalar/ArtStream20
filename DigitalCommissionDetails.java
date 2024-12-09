import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DigitalCommissionDetails extends JPanel {

    public DigitalCommissionDetails(String artistName, String nameOfClient, String email, String contact, String artDescription, String size, String medium, String frameOrNot, double total) {
        setBackground(Color.YELLOW);
        setLayout(null);
        setPreferredSize(new java.awt.Dimension(500, 300)); // Set a fixed size for visibility

        // Create and set bounds for all labels
        JLabel artistLabel = new JLabel("Artist:");
        artistLabel.setBounds(20, 20, 100, 20);
        add(artistLabel);

        JLabel artistNameLabel = new JLabel(artistName);
        artistNameLabel.setBounds(150, 20, 300, 20);
        add(artistNameLabel);

        JLabel clientLabel = new JLabel("Name of Client:");
        clientLabel.setBounds(20, 50, 120, 20);
        add(clientLabel);

        JLabel clientNameLabel = new JLabel(nameOfClient);
        clientNameLabel.setBounds(150, 50, 300, 20);
        add(clientNameLabel);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(20, 80, 100, 20);
        add(emailLabel);

        JLabel emailValueLabel = new JLabel(email);
        emailValueLabel.setBounds(150, 80, 300, 20);
        add(emailValueLabel);

        JLabel contactLabel = new JLabel("Contact:");
        contactLabel.setBounds(20, 110, 100, 20);
        add(contactLabel);

        JLabel contactValueLabel = new JLabel(contact);
        contactValueLabel.setBounds(150, 110, 300, 20);
        add(contactValueLabel);

        JLabel descriptionLabel = new JLabel("Description:");
        descriptionLabel.setBounds(20, 140, 100, 20);
        add(descriptionLabel);

        JLabel descriptionValueLabel = new JLabel(artDescription);
        descriptionValueLabel.setBounds(150, 140, 300, 20);
        add(descriptionValueLabel);

        JLabel sizeLabel = new JLabel("Size:");
        sizeLabel.setBounds(20, 170, 100, 20);
        add(sizeLabel);

        JLabel sizeValueLabel = new JLabel(size);
        sizeValueLabel.setBounds(150, 170, 300, 20);
        add(sizeValueLabel);

        JLabel mediumLabel = new JLabel("Medium:");
        mediumLabel.setBounds(20, 200, 100, 20);
        add(mediumLabel);

        JLabel mediumValueLabel = new JLabel(medium);
        mediumValueLabel.setBounds(150, 200, 300, 20);
        add(mediumValueLabel);

        JLabel frameLabel = new JLabel("Frame or not:");
        frameLabel.setBounds(20, 230, 100, 20);
        add(frameLabel);

        JLabel frameValueLabel = new JLabel(frameOrNot);
        frameValueLabel.setBounds(150, 230, 300, 20);
        add(frameValueLabel);

        JLabel totalLabel = new JLabel("Total:");
        totalLabel.setBounds(20, 260, 100, 20);
        add(totalLabel);

        JLabel totalValueLabel = new JLabel(Double.toString(total));
        totalValueLabel.setBounds(150, 260, 300, 20);
        add(totalValueLabel);

    }
    
}
