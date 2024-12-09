import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SetupAccountAdmin extends JFrame implements ActionListener {

    private Container con = getContentPane();
    private ImageIcon icon = new ImageIcon("ArtSTREAM-removebg-preview.png");
    private JLabel image = new JLabel(icon);

    private JLabel setupLabel = new JLabel("Sign in to your account as an Admin");
    private JLabel usernameLabelSignin = new JLabel("Username:");
    private JTextField usernameFieldSignin = new JTextField();
    private JLabel passwordLabelSignin = new JLabel("Password:");
    private JPasswordField passwordFieldSignin = new JPasswordField();
    private JButton signinButton = new JButton("Sign In");
    private JButton goBack = new JButton("Return");

    private String adminName = "admin", adminPass = "12345";

    public SetupAccountAdmin() {

        super("ArtStream Admin");
        setSize(600, 400); // Adjusted size for a cleaner layout
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        JPanel main = new JPanel();
        main.setLayout(null);
        setupComponents();
        addComponentsToPanel(main);
        con.setBackground(Color.decode("#000e37"));
        main.setBackground(Color.decode("#000e37"));
        con.add(main);

        signinButton.addActionListener(this);
        goBack.addActionListener(this);

        setVisible(true);
    }

    private void setupComponents() {
   
        Image iconImage = icon.getImage();
        icon = new ImageIcon(iconImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        image.setIcon(icon);

        setupLabel.setFont(new Font("Monospaced", Font.BOLD, 18));
        setupLabel.setForeground(Color.WHITE);
        usernameLabelSignin.setFont(new Font("Monospaced", Font.PLAIN, 16));
        usernameLabelSignin.setForeground(Color.WHITE);
        passwordLabelSignin.setFont(new Font("Monospaced", Font.PLAIN, 16));
        passwordLabelSignin.setForeground(Color.WHITE);
        signinButton.setFont(new Font("Monospaced", Font.BOLD, 12));
        signinButton.setForeground(Color.WHITE);
        goBack.setFont(new Font("Monospaced", Font.PLAIN, 12));
        goBack.setForeground(Color.black);

        signinButton.setBackground(Color.decode("#89CFF0"));
        signinButton.setForeground(Color.black);
        goBack.setBackground(Color.decode("#89CFF0"));
        
    }

    private void addComponentsToPanel(JPanel main) {

        image.setBounds(250, 20, 100, 100);
        setupLabel.setBounds(80, 100, 400, 30);
        usernameLabelSignin.setBounds(100, 190, 100, 25);
        usernameFieldSignin.setBounds(220, 190, 200, 25);
        passwordLabelSignin.setBounds(100, 230, 100, 25);
        passwordFieldSignin.setBounds(220, 230, 200, 25);
        signinButton.setBounds(150, 280, 100, 30);
        goBack.setBounds(280, 280, 100, 30);

        // Add to panel
        main.add(image);
        main.add(setupLabel);
        main.add(usernameLabelSignin);
        main.add(usernameFieldSignin);
        main.add(passwordLabelSignin);
        main.add(passwordFieldSignin);
        main.add(signinButton);
        main.add(goBack);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == signinButton) {
            String password = new String(passwordFieldSignin.getPassword());
            if (usernameFieldSignin.getText().equals(adminName) && password.equals(adminPass)) {
                JOptionPane.showMessageDialog(this, "Login Successfully!");
                new DashboardAdmin();
                dispose(); 
            } else if (usernameFieldSignin.getText().isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in the empty fields");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials");
            }
        } else if (source == goBack) {
            
            new FirstFrame();
            dispose();
        }
    }


}
