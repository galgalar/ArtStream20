import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

public class Requests extends JPanel {

    private JPanel detailsContainer;

    public Requests() {
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());

        // Header panel
        JLabel headerLabel = new JLabel("Request Commissions");
        headerLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        headerLabel.setForeground(Color.WHITE);
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.BLACK);
        headerPanel.add(headerLabel);

        // Details container panel
        detailsContainer = new JPanel();
        detailsContainer.setLayout(new GridLayout(0, 1, 10, 10)); // Vertical layout with spacing
        detailsContainer.setBackground(Color.GRAY);

        // Add panels to the main layout
        add(headerPanel, BorderLayout.NORTH);
        add(new JScrollPane(detailsContainer), BorderLayout.CENTER); // Scrollable area
    }

    // Method to add a new DigitalCommissionDetails panel
    public void addCommissionDetails(DigitalCommissionDetails details) {
        details.setPreferredSize(new java.awt.Dimension(500, 300)); // Ensure size is set
        detailsContainer.add(details);
        detailsContainer.revalidate(); // Refresh layout
        detailsContainer.repaint();    // Redraw components
    }
}
