import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CommissionDigital extends JFrame implements ActionListener, ValidateCommission, ItemListener , Static{

    private Container con = getContentPane();
    private JPanel[] panelsBorder = new JPanel[2];
    private JLabel header = new JLabel("Art Commission Request Form");
    private JLabel name = new JLabel("Name");
    private JTextField nameField = new JTextField();
    private JLabel email = new JLabel("Email");
    private JTextField emailField = new JTextField();
    private JLabel contact = new JLabel("Contact");
    private JTextField contactField = new JTextField();
    private JLabel artDescription = new JLabel("Describe what you want");
    private JTextArea artDescriptionText = new JTextArea();

    private String[] sizes = {
        "Select",
        "Small - 1000.00",
        "Medium - 1200.00",
        "Large - 1500.00"
    };
    private JLabel sizeLabel = new JLabel("Select Size");
    private JComboBox<String> sizeOfArt = new JComboBox<>(sizes);

    protected String[] medium = {
        "Select",
        "Adobe Photoshop - 1000.00",
        "Corel Painter - 1900.00",
        "Procreate - 2500.00"
    };
    private JLabel mediumLabel = new JLabel("Select Medium");
    protected JComboBox<String> mediumBox = new JComboBox<>(medium);

    private ButtonGroup frameOrNot = new ButtonGroup();
    private JLabel frame = new JLabel("I would like it");
    private JRadioButton frameButton = new JRadioButton("Frame-500");
    private JRadioButton notFrameButton = new JRadioButton("Unframed-No Charge");

    private JLabel artistMessage = new JLabel("Message the artist");
    private JTextArea artistMessageText = new JTextArea();
    private JButton submit = new JButton("Submit");
    private JLabel totalLabel = new JLabel();
    private String artistName;
    private double total = 0;
    private String selectOption = "";

    public CommissionDigital(String artistName) {
        super("Commission Details");
        setSize(500, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.artistName = artistName;
        con.setLayout(new BorderLayout());

        frameOrNot.add(frameButton);
        frameOrNot.add(notFrameButton);

        for (int i = 0; i < panelsBorder.length; ++i) {
            if (i == 0) {
                panelsBorder[i] = new JPanel();
                panelsBorder[i].setLayout(new FlowLayout(FlowLayout.CENTER)); // Align to left
                panelsBorder[i].add(header);
                con.add(panelsBorder[i], BorderLayout.NORTH);
            } else {

                panelsBorder[i] = new JPanel();
                panelsBorder[i].setLayout(new BoxLayout(panelsBorder[i], BoxLayout.Y_AXIS));

                // Align all components to the left
                panelsBorder[i].add(createLeftAlignedLabel("Request Commission To: " + artistName));
                panelsBorder[i].add(Box.createRigidArea(new Dimension(10, 10)));
                panelsBorder[i].add(createLeftAlignedComponent(name));
                panelsBorder[i].add(Box.createRigidArea(new Dimension(10, 10)));
                nameField.setMaximumSize(new Dimension(200, 30));
                panelsBorder[i].add(createLeftAlignedComponent(nameField));
                panelsBorder[i].add(Box.createRigidArea(new Dimension(10, 10)));
                panelsBorder[i].add(createLeftAlignedComponent(email));
                panelsBorder[i].add(Box.createRigidArea(new Dimension(10, 10)));
                emailField.setMaximumSize(new Dimension(200, 30));
                panelsBorder[i].add(createLeftAlignedComponent(emailField));
                panelsBorder[i].add(Box.createRigidArea(new Dimension(10, 10)));
                panelsBorder[i].add(createLeftAlignedComponent(contact));
                panelsBorder[i].add(Box.createRigidArea(new Dimension(10, 10)));
                contactField.setMaximumSize(new Dimension(200, 30));
                panelsBorder[i].add(createLeftAlignedComponent(contactField));
                panelsBorder[i].add(Box.createRigidArea(new Dimension(10, 10)));
                panelsBorder[i].add(createLeftAlignedComponent(artDescription));
                panelsBorder[i].add(Box.createRigidArea(new Dimension(10, 10)));
                artDescriptionText.setMaximumSize(new Dimension(200, 30));
                panelsBorder[i].add(createLeftAlignedComponent(artDescriptionText));
                panelsBorder[i].add(Box.createRigidArea(new Dimension(10, 10)));
                panelsBorder[i].add(createLeftAlignedComponent(sizeLabel));
                panelsBorder[i].add(Box.createRigidArea(new Dimension(10, 10)));
                sizeOfArt.setMaximumSize(new Dimension(200, 30));
                panelsBorder[i].add(createLeftAlignedComponent(sizeOfArt));
                panelsBorder[i].add(Box.createRigidArea(new Dimension(10, 10)));
                panelsBorder[i].add(createLeftAlignedComponent(mediumLabel));
                panelsBorder[i].add(Box.createRigidArea(new Dimension(10, 10)));
                mediumBox.setMaximumSize(new Dimension(200, 30));
                panelsBorder[i].add(createLeftAlignedComponent(mediumBox));
                panelsBorder[i].add(Box.createRigidArea(new Dimension(10, 10)));
                panelsBorder[i].add(createLeftAlignedComponent(frame));
                panelsBorder[i].add(Box.createRigidArea(new Dimension(10, 10)));
                panelsBorder[i].add(createLeftAlignedComponent(frameButton));
                panelsBorder[i].add(Box.createRigidArea(new Dimension(10, 10)));
                panelsBorder[i].add(createLeftAlignedComponent(notFrameButton));
                panelsBorder[i].add(Box.createRigidArea(new Dimension(10, 10)));
                panelsBorder[i].add(createLeftAlignedComponent(artistMessage));
                panelsBorder[i].add(Box.createRigidArea(new Dimension(10, 10)));
                artistMessageText.setMaximumSize(new Dimension(200, 30));
                panelsBorder[i].add(createLeftAlignedComponent(artistMessageText));
                panelsBorder[i].add(Box.createRigidArea(new Dimension(10, 10)));
                submit.setMaximumSize(new Dimension(200, 30));
                panelsBorder[i].add(createLeftAlignedComponent(submit));
                panelsBorder[i].add(Box.createRigidArea(new Dimension(10, 10)));
                panelsBorder[i].add(createLeftAlignedComponent(totalLabel));

                JPanel main = new JPanel(new FlowLayout());
                main.add(panelsBorder[i]);
                
                submit.addActionListener(this);
                sizeOfArt.addItemListener(this);
                mediumBox.addItemListener(this);
                frameButton.addItemListener(this);
                notFrameButton.addItemListener(this);

                con.add(main, BorderLayout.CENTER);
            }
        }

        setVisible(true);
    }

    private JComponent createLeftAlignedComponent(JComponent component) {
        component.setAlignmentX(Component.LEFT_ALIGNMENT);
        return component;
    }


    private JLabel createLeftAlignedLabel(String text) {
        JLabel label = new JLabel(text);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        return label;
    }

    public String[] getSetMedium() {
        return medium;
    }


    public boolean validateEmail(String email)
    {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        
        Pattern pattern = Pattern.compile(emailRegex);
        
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public boolean validateContact() {
        String contact = contactField.getText().trim();
        return contact.matches("\\d{11}"); // Matches exactly 11 digits
    }
    public boolean isNotNumeric(String str) {
        try {
            Integer.parseInt(str); 
            return false; 
        } catch (NumberFormatException e) {
            return true; 
        }
    }

    public boolean isEmpty()
    {
        boolean isEmpty = false;
            if(nameField.getText().isEmpty() || emailField.getText().isEmpty() || contactField.getText().isEmpty() || artDescriptionText.getText().isEmpty() || (!frameButton.isSelected() && !notFrameButton.isSelected()) || artistMessageText.getText().isEmpty())
        isEmpty = true;

        return isEmpty;
    }
    public void setThemEmpty()
    {
        nameField.setText("");
        emailField.setText("");
        contactField.setText("");
        artDescriptionText.setText("");
        sizeOfArt.setSelectedItem("Select");
        mediumBox.setSelectedItem("Select");
        artistMessageText.setText("");
        frameOrNot.clearSelection();
        totalLabel.setText("");

    }

    @Override

 public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();  
    
    if (source == submit) {
        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in the required fields");
        } else if (!validateEmail(emailField.getText())) {
            JOptionPane.showMessageDialog(null, "Please enter a valid email");
        } else if (!validateContact()) {
            JOptionPane.showMessageDialog(null, "Please enter a valid contact (11 digits)");
        } else {          
            int select = JOptionPane.showConfirmDialog(null,
                "Send to: " + artistName + "\nType of art: Digital" + 
                "\nName: " + nameField.getText() + 
                "\nEmail: " + emailField.getText() + 
                "\nContact: " + contactField.getText() + 
                "\nDescribe art: " + artDescriptionText.getText() + 
                "\nSize: " + sizeOfArt.getSelectedItem() + 
                "\nMedium: " + mediumBox.getSelectedItem() + 
                "\nFrame or not: " + selectOption + 
                "\nMessage: "+ artistMessageText.getText() +
                "\nTotal: " + total,
                "Commission Summary",
                JOptionPane.YES_NO_OPTION);
             if (select == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Request sent successfully!");

                String details =        
                "\nSend to: " + artistName + 
                "\nType of art: Digital" + 
                "\nName: " + nameField.getText() + 
                "\nEmail: " + emailField.getText() + 
                "\nContact: " + contactField.getText() + 
                "\nDescribe art: " + artDescriptionText.getText() + 
                "\nSize: " + sizeOfArt.getSelectedItem() + 
                "\nMedium: " + mediumBox.getSelectedItem() + 
                "\nFrame or not: " + selectOption + 
                "\nMessage: "+ artistMessageText.getText() +
                "\nTotal: " + total;
                
                new Mytag(nameField.getText(), "Digital Artist", details);
               
                
                
                dispose();
                setThemEmpty();
             }
        }
    }
}

    @Override
    public void itemStateChanged(ItemEvent e)
    {
        Object source = e.getSource();
        if(source == sizeOfArt)
        {
            if(e.getStateChange() == ItemEvent.SELECTED)
            {
                String selected = (String) e.getItem();
                switch (selected) {
                    case "Small - 1000.00":
                        total += 1000.00;
                    break;
                    case "Medium - 1200.00":
                        total += 1200.00;
                    break;
                    case "Large - 1500.00":
                        total += 1500.00;
                    break;
                    default:
                        break;
                }
                
            }else if(e.getStateChange() == ItemEvent.DESELECTED)
            {
                String selected = (String) e.getItem();
                switch (selected) {
                    case "Small - 1000.00":
                        total -= 1000.00;
                    break;
                    case "Medium - 1200.00":
                        total -= 1200.00;
                    break;
                    case "Large - 1500.00":
                        total -= 1500.00;
                    break;
                    default:
                        break;
                }
            }

        }else if(source == mediumBox)
        {
            if(e.getStateChange() == ItemEvent.SELECTED)
            {
                String selected = (String) e.getItem();
                
                switch (selected) {
                    case "Adobe Photoshop - 1000.00":
                        total += 1000.00;
                    break;
                    case "Corel Painter - 1900.00":
                        total += 1900.00;
                    break;
                    case "Procreate - 2500.00":
                        total += 2500.00;
                    break;
                    default:
                        break;
                }


            }else if(e.getStateChange() == ItemEvent.DESELECTED)
            {
                String selected = (String) e.getItem();
                switch (selected) {
                    case "Adobe Photoshop - 1000.00":
                        total -= 1000.00;
                    break;
                    case "Corel Painter - 1900.00":
                        total -= 1900.00;
                    break;
                    case "Procreate - 2500.00":
                        total -= 2500.00;
                    break;
                    default:
                        break;
                }
            }
        }else if(source == frameButton)
        {
            if(e.getStateChange() == ItemEvent.SELECTED)
            {   
                selectOption = frameButton.getText();
                total += 500;
            }else
            {
                selectOption = "";
                total -= 500;
            }

        }else if(source == notFrameButton)
        {
            if(e.getStateChange() == ItemEvent.SELECTED)
            {
                selectOption = notFrameButton.getText();
                total += 0;
            }else if(e.getStateChange() == ItemEvent.DESELECTED)
            {
                selectOption = "";
                total -= 0;
            }
        }


        
    }
    







}

