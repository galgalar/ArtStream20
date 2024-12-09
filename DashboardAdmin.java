// import javax.swing.*;
// import javax.swing.table.DefaultTableModel;
// import javax.swing.table.TableCellRenderer;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// public class DashboardAdmin extends JFrame {

//     private JTable requestsTable;
//     private JTable acceptedTable;
//     private JTable doneTable;
//     private String lol;

//     public DashboardAdmin() {
//         initComponents();
//         setVisible(true);
//     }

//     private void initComponents() {
        
//         JButton deleteRequestButton = new JButton("Delete Request");
//         JButton acceptRequestButton = new JButton("Accept Request");

       
//         JButton moveToDoneButton = new JButton("Move to Done");

      
//         JButton deleteDoneButton = new JButton("Delete Done");

//         JButton logoutButton = new JButton("Logout");
//         JTabbedPane tabbedPane = new JTabbedPane();

        
//         requestsTable = new JTable(new DefaultTableModel(new Object[][] {}, new String[] {"Name", "Type of Art", "Commission Summary"})) {
//             @Override
//             public boolean isCellEditable(int row, int column) {
//                 return column == 2; 
//             }
//         };

        
//         requestsTable.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
//         requestsTable.getColumnModel().getColumn(2).setCellEditor(new ButtonEditor(new JCheckBox(), requestsTable));

//         JScrollPane requestsScrollPane = new JScrollPane(requestsTable);

//         JPanel requestsPanel = new JPanel();
//         requestsPanel.setLayout(new BorderLayout());
//         requestsPanel.add(requestsScrollPane, BorderLayout.CENTER);

//         JPanel requestsButtonPanel = new JPanel();
//         requestsButtonPanel.add(deleteRequestButton);
//         requestsButtonPanel.add(acceptRequestButton);
//         requestsPanel.add(requestsButtonPanel, BorderLayout.SOUTH);

//         tabbedPane.addTab("Requests", requestsPanel);

       
//         acceptedTable = new JTable(new DefaultTableModel(new Object[][] {}, new String[] {"Name", "Type of Art", "Commission Summary"})) {
//             @Override
//             public boolean isCellEditable(int row, int column) {
//                 return column == 2; 
//             }
//         };

       
//         acceptedTable.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
//         acceptedTable.getColumnModel().getColumn(2).setCellEditor(new ButtonEditor(new JCheckBox(), acceptedTable));

//         JScrollPane acceptedScrollPane = new JScrollPane(acceptedTable);

//         JPanel acceptedPanel = new JPanel();
//         acceptedPanel.setLayout(new BorderLayout());
//         acceptedPanel.add(acceptedScrollPane, BorderLayout.CENTER);

//         JPanel acceptedButtonPanel = new JPanel();
//         acceptedButtonPanel.add(moveToDoneButton);
//         acceptedPanel.add(acceptedButtonPanel, BorderLayout.SOUTH);

//         tabbedPane.addTab("Accepted", acceptedPanel);

//         doneTable = new JTable(new DefaultTableModel(new Object[][] {}, new String[] {"Name", "Type of Art", "Commission Summary"}));
//         JScrollPane doneScrollPane = new JScrollPane(doneTable);

//         JPanel donePanel = new JPanel();
//         donePanel.setLayout(new BorderLayout());
//         donePanel.add(doneScrollPane, BorderLayout.CENTER);

//         JPanel doneButtonPanel = new JPanel();
//         doneButtonPanel.add(deleteDoneButton);
//         donePanel.add(doneButtonPanel, BorderLayout.SOUTH);

//         tabbedPane.addTab("Done", donePanel);

//         JLabel adminLabel = new JLabel("Admin Dashboard");

//         logoutButton.addActionListener(evt -> logoutActionPerformed());
//         deleteRequestButton.addActionListener(evt -> deleteRequestActionPerformed());
//         acceptRequestButton.addActionListener(evt -> acceptRequestActionPerformed());
//         moveToDoneButton.addActionListener(evt -> moveToDoneActionPerformed());
//         deleteDoneButton.addActionListener(evt -> deleteDoneActionPerformed());

//         setLayout(new BorderLayout());
//         add(adminLabel, BorderLayout.NORTH);
//         add(tabbedPane, BorderLayout.CENTER);
//         add(logoutButton, BorderLayout.SOUTH);

//         setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//         setSize(800, 600);
//     }

//     private void deleteRequestActionPerformed() {
//         int selectedRow = requestsTable.getSelectedRow();
//         if (selectedRow >= 0) {
//             DefaultTableModel model = (DefaultTableModel) requestsTable.getModel();
//             model.removeRow(selectedRow);
//         } else {
//             JOptionPane.showMessageDialog(this, "Please select a row to delete.");
//         }
//     }

//     private void acceptRequestActionPerformed() {
//         int selectedRow = requestsTable.getSelectedRow();
//         if (selectedRow >= 0) {
//             DefaultTableModel requestsModel = (DefaultTableModel) requestsTable.getModel();
//             DefaultTableModel acceptedModel = (DefaultTableModel) acceptedTable.getModel();

//             Object[] rowData = new Object[requestsModel.getColumnCount()];
//             for (int i = 0; i < requestsModel.getColumnCount(); i++) {
//                 rowData[i] = requestsModel.getValueAt(selectedRow, i);
//             }

//             acceptedModel.addRow(rowData);
//             requestsModel.removeRow(selectedRow);
//         } else {
//             JOptionPane.showMessageDialog(this, "Please select a row to accept.");
//         }
//     }

//     private void moveToDoneActionPerformed() {
//         int selectedRow = acceptedTable.getSelectedRow();
//         if (selectedRow >= 0) {
//             DefaultTableModel acceptedModel = (DefaultTableModel) acceptedTable.getModel();
//             DefaultTableModel doneModel = (DefaultTableModel) doneTable.getModel();

//             Object[] rowData = new Object[acceptedModel.getColumnCount()];
//             for (int i = 0; i < acceptedModel.getColumnCount(); i++) {
//                 rowData[i] = acceptedModel.getValueAt(selectedRow, i);
//             }

//             doneModel.addRow(rowData);
//             acceptedModel.removeRow(selectedRow);
//         } else {
//             JOptionPane.showMessageDialog(this, "Please select a row to mark as done.");
//         }
//     }

//     private void deleteDoneActionPerformed() {
//         int selectedRow = doneTable.getSelectedRow();
//         if (selectedRow >= 0) {
//             DefaultTableModel model = (DefaultTableModel) doneTable.getModel();
//             model.removeRow(selectedRow);
//         } else {
//             JOptionPane.showMessageDialog(this, "Please select a row to delete.");
//         }
//     }
//     private void logoutActionPerformed() {
        
//         JOptionPane.showMessageDialog(this, "Logging out.");
//         dispose();
//         new SetupAccountAdmin();
//     }

//     public void addData(String name, String type, String commission) {
//         DefaultTableModel model = (DefaultTableModel) requestsTable.getModel();
//         model.addRow(new Object[]{name, type, "View Details"});
//         lol = commission;
        
//     }

//     // Custom Renderer for Button in Table
//     class ButtonRenderer extends JButton implements TableCellRenderer {

//         public ButtonRenderer() {
//             setOpaque(true);
//         }

//         @Override
//         public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//             setText((value == null) ? "View Details" : value.toString());
//             return this;
//         }
//     }


//     class ButtonEditor extends DefaultCellEditor {
//         private JButton button;
//         private String label;
//         private boolean clicked;
//         private JTable parentTable;

//         public ButtonEditor(JCheckBox checkBox, JTable parentTable) {
//             super(checkBox);
//             this.parentTable = parentTable;
//             button = new JButton();
//             button.setOpaque(true);

//             button.addActionListener(new ActionListener() {
//                 @Override
//                 public void actionPerformed(ActionEvent e) {
//                     fireEditingStopped();
//                 }
//             });
//         }

//         @Override
//         public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
//             label = (value == null) ? "View Details" : value.toString();
//             button.setText(label);
//             clicked = true;
//             return button;
//         }

//         @Override
//         public Object getCellEditorValue() {
//             if (clicked) {
         
//                 int row = parentTable.getSelectedRow();
//                 if (row >= 0) {
//                     JOptionPane.showMessageDialog(button, "Commission Details: " + lol);
//                 }
//             }
//             clicked = false;
//             return label;
//         }

//         @Override
//         public boolean stopCellEditing() {
//             clicked = false;
//             return super.stopCellEditing();
//         }

//         @Override
//         protected void fireEditingStopped() {
//             super.fireEditingStopped();
//         }
//     }
// }
// import javax.swing.*;
// import javax.swing.table.DefaultTableModel;
// import javax.swing.table.TableCellRenderer;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// public class DashboardAdmin extends JFrame {

//     private JTable requestsTable;
//     private JTable acceptedTable;
//     private JTable doneTable;
//     private String lol;

//     public DashboardAdmin() {
//         initComponents();
//         setVisible(true);
//     }

//     private void initComponents() {
       
//         JButton deleteRequestButton = new JButton("Delete Request");
//         JButton acceptRequestButton = new JButton("Accept Request");

    
//         JButton moveToDoneButton = new JButton("Move to Done");

        
//         JButton deleteDoneButton = new JButton("Delete Done");

//         JButton logoutButton = new JButton("Logout");
//         JTabbedPane tabbedPane = new JTabbedPane();

       
//         requestsTable = new JTable(new DefaultTableModel(new Object[][] {}, new String[] {"Name", "Type of Art", "Commission Summary"})) {
//             @Override
//             public boolean isCellEditable(int row, int column) {
//                 return column == 2; 
//             }
//         };

        
//         requestsTable.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
//         requestsTable.getColumnModel().getColumn(2).setCellEditor(new ButtonEditor(new JCheckBox(), requestsTable));

//         JScrollPane requestsScrollPane = new JScrollPane(requestsTable);

//         JPanel requestsPanel = new JPanel();
//         requestsPanel.setLayout(new BorderLayout());
//         requestsPanel.add(requestsScrollPane, BorderLayout.CENTER);

//         JPanel requestsButtonPanel = new JPanel();
//         requestsButtonPanel.add(deleteRequestButton);
//         requestsButtonPanel.add(acceptRequestButton);
//         requestsPanel.add(requestsButtonPanel, BorderLayout.SOUTH);

//         tabbedPane.addTab("Requests", requestsPanel);

        
//         acceptedTable = new JTable(new DefaultTableModel(new Object[][] {}, new String[] {"Name", "Type of Art", "Commission Summary"})) {
//             @Override
//             public boolean isCellEditable(int row, int column) {
//                 return column == 2; 
//             }
//         };

        
//         acceptedTable.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
//         acceptedTable.getColumnModel().getColumn(2).setCellEditor(new ButtonEditor(new JCheckBox(), acceptedTable));

//         JScrollPane acceptedScrollPane = new JScrollPane(acceptedTable);

//         JPanel acceptedPanel = new JPanel();
//         acceptedPanel.setLayout(new BorderLayout());
//         acceptedPanel.add(acceptedScrollPane, BorderLayout.CENTER);

//         JPanel acceptedButtonPanel = new JPanel();
//         acceptedButtonPanel.add(moveToDoneButton);
//         acceptedPanel.add(acceptedButtonPanel, BorderLayout.SOUTH);

//         tabbedPane.addTab("Accepted", acceptedPanel);

        
//         doneTable = new JTable(new DefaultTableModel(new Object[][] {}, new String[] {"Name", "Type of Art", "Commission Summary"})) {
//             @Override
//             public boolean isCellEditable(int row, int column) {
//                 return column == 2;
//             }
//         };

       
//         doneTable.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
//         doneTable.getColumnModel().getColumn(2).setCellEditor(new ButtonEditor(new JCheckBox(), doneTable));

//         JScrollPane doneScrollPane = new JScrollPane(doneTable);

//         JPanel donePanel = new JPanel();
//         donePanel.setLayout(new BorderLayout());
//         donePanel.add(doneScrollPane, BorderLayout.CENTER);

//         JPanel doneButtonPanel = new JPanel();
//         doneButtonPanel.add(deleteDoneButton);
//         donePanel.add(doneButtonPanel, BorderLayout.SOUTH);

//         tabbedPane.addTab("Done", donePanel);

//         // Layout setup
//         JLabel adminLabel = new JLabel("Admin Dashboard");

//         logoutButton.addActionListener(evt -> logoutActionPerformed());
//         deleteRequestButton.addActionListener(evt -> deleteRequestActionPerformed());
//         acceptRequestButton.addActionListener(evt -> acceptRequestActionPerformed());
//         moveToDoneButton.addActionListener(evt -> moveToDoneActionPerformed());
//         deleteDoneButton.addActionListener(evt -> deleteDoneActionPerformed());

//         setLayout(new BorderLayout());
//         add(adminLabel, BorderLayout.NORTH);
//         add(tabbedPane, BorderLayout.CENTER);
//         add(logoutButton, BorderLayout.SOUTH);

//         setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//         setSize(800, 600);
//     }

//     private void deleteRequestActionPerformed() {
//         int selectedRow = requestsTable.getSelectedRow();
//         if (selectedRow >= 0) {
//             DefaultTableModel model = (DefaultTableModel) requestsTable.getModel();
//             model.removeRow(selectedRow);
//         } else {
//             JOptionPane.showMessageDialog(this, "Please select a row to delete.");
//         }
//     }

//     private void acceptRequestActionPerformed() {
//         int selectedRow = requestsTable.getSelectedRow();
//         if (selectedRow >= 0) {
//             DefaultTableModel requestsModel = (DefaultTableModel) requestsTable.getModel();
//             DefaultTableModel acceptedModel = (DefaultTableModel) acceptedTable.getModel();

//             Object[] rowData = new Object[requestsModel.getColumnCount()];
//             for (int i = 0; i < requestsModel.getColumnCount(); i++) {
//                 rowData[i] = requestsModel.getValueAt(selectedRow, i);
//             }

//             acceptedModel.addRow(rowData);
//             requestsModel.removeRow(selectedRow);
//         } else {
//             JOptionPane.showMessageDialog(this, "Please select a row to accept.");
//         }
//     }

//     private void moveToDoneActionPerformed() {
//         int selectedRow = acceptedTable.getSelectedRow();
//         if (selectedRow >= 0) {
//             DefaultTableModel acceptedModel = (DefaultTableModel) acceptedTable.getModel();
//             DefaultTableModel doneModel = (DefaultTableModel) doneTable.getModel();

//             Object[] rowData = new Object[acceptedModel.getColumnCount()];
//             for (int i = 0; i < acceptedModel.getColumnCount(); i++) {
//                 rowData[i] = acceptedModel.getValueAt(selectedRow, i);
//             }

//             doneModel.addRow(rowData);
//             acceptedModel.removeRow(selectedRow);
//         } else {
//             JOptionPane.showMessageDialog(this, "Please select a row to mark as done.");
//         }
//     }

//     private void deleteDoneActionPerformed() {
//         int selectedRow = doneTable.getSelectedRow();
//         if (selectedRow >= 0) {
//             DefaultTableModel model = (DefaultTableModel) doneTable.getModel();
//             model.removeRow(selectedRow);
//         } else {
//             JOptionPane.showMessageDialog(this, "Please select a row to delete.");
//         }
//     }

//     private void logoutActionPerformed() {
//         // Logic to log out (close the frame or navigate to a login screen)
//         JOptionPane.showMessageDialog(this, "Logging out.");
//         dispose();
//     }

//     public void addData(String name, String type, String commission) {
//         DefaultTableModel model = (DefaultTableModel) requestsTable.getModel();
//         model.addRow(new Object[]{name, type, "View Details"});
//         lol = commission;
//     }
//     // Custom Renderer for Button in Table
//     class ButtonRenderer extends JButton implements TableCellRenderer {

//         public ButtonRenderer() {
//             setOpaque(true);
//         }

//         @Override
//         public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//             setText((value == null) ? "View Details" : value.toString());
//             return this;
//         }
//     }

//     // Custom Editor for Button in Table
//     class ButtonEditor extends DefaultCellEditor {
//         private JButton button;
//         private String label;
//         private boolean clicked;
//         private JTable parentTable;

//         public ButtonEditor(JCheckBox checkBox, JTable parentTable) {
//             super(checkBox);
//             this.parentTable = parentTable;
//             button = new JButton();
//             button.setOpaque(true);

//             button.addActionListener(new ActionListener() {
//                 @Override
//                 public void actionPerformed(ActionEvent e) {
//                     fireEditingStopped();
//                 }
//             });
//         }

//         @Override
//         public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
//             label = (value == null) ? "View Details" : value.toString();
//             button.setText(label);
//             clicked = true;
//             return button;
//         }

//         @Override
//         public Object getCellEditorValue() {
//             if (clicked) {
//                 // Show details in a dialog box
//                 int row = parentTable.getSelectedRow();
//                 if (row >= 0) {
                
//                     JOptionPane.showMessageDialog(button, "Commission Details: " + lol);
//                 }
//             }
//             clicked = false;
//             return label;
//         }

//         @Override
//         public boolean stopCellEditing() {
//             clicked = false;
//             return super.stopCellEditing();
//         }

//         @Override
//         protected void fireEditingStopped() {
//             super.fireEditingStopped();
//         }
//     }
// }
// import javax.swing.*;
// import javax.swing.table.DefaultTableModel;
// import javax.swing.table.TableCellRenderer;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// public class DashboardAdmin extends JFrame {

//     private JTable requestsTable;
//     private JTable acceptedTable;
//     private JTable doneTable;
//     private String lol;

//     public DashboardAdmin() {
//         initComponents();
//         setVisible(true);
//     }

//     private void initComponents() {
        
//         JButton deleteRequestButton = new JButton("Delete Request");
//         JButton acceptRequestButton = new JButton("Accept Request");

       
//         JButton moveToDoneButton = new JButton("Move to Done");

      
//         JButton deleteDoneButton = new JButton("Delete Done");

//         JButton logoutButton = new JButton("Logout");
//         JTabbedPane tabbedPane = new JTabbedPane();

        
//         requestsTable = new JTable(new DefaultTableModel(new Object[][] {}, new String[] {"Name", "Type of Art", "Commission Summary"})) {
//             @Override
//             public boolean isCellEditable(int row, int column) {
//                 return column == 2; 
//             }
//         };

        
//         requestsTable.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
//         requestsTable.getColumnModel().getColumn(2).setCellEditor(new ButtonEditor(new JCheckBox(), requestsTable));

//         JScrollPane requestsScrollPane = new JScrollPane(requestsTable);

//         JPanel requestsPanel = new JPanel();
//         requestsPanel.setLayout(new BorderLayout());
//         requestsPanel.add(requestsScrollPane, BorderLayout.CENTER);

//         JPanel requestsButtonPanel = new JPanel();
//         requestsButtonPanel.add(deleteRequestButton);
//         requestsButtonPanel.add(acceptRequestButton);
//         requestsPanel.add(requestsButtonPanel, BorderLayout.SOUTH);

//         tabbedPane.addTab("Requests", requestsPanel);

       
//         acceptedTable = new JTable(new DefaultTableModel(new Object[][] {}, new String[] {"Name", "Type of Art", "Commission Summary"})) {
//             @Override
//             public boolean isCellEditable(int row, int column) {
//                 return column == 2; 
//             }
//         };

       
//         acceptedTable.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
//         acceptedTable.getColumnModel().getColumn(2).setCellEditor(new ButtonEditor(new JCheckBox(), acceptedTable));

//         JScrollPane acceptedScrollPane = new JScrollPane(acceptedTable);

//         JPanel acceptedPanel = new JPanel();
//         acceptedPanel.setLayout(new BorderLayout());
//         acceptedPanel.add(acceptedScrollPane, BorderLayout.CENTER);

//         JPanel acceptedButtonPanel = new JPanel();
//         acceptedButtonPanel.add(moveToDoneButton);
//         acceptedPanel.add(acceptedButtonPanel, BorderLayout.SOUTH);

//         tabbedPane.addTab("Accepted", acceptedPanel);

//         doneTable = new JTable(new DefaultTableModel(new Object[][] {}, new String[] {"Name", "Type of Art", "Commission Summary"}));
//         JScrollPane doneScrollPane = new JScrollPane(doneTable);

//         JPanel donePanel = new JPanel();
//         donePanel.setLayout(new BorderLayout());
//         donePanel.add(doneScrollPane, BorderLayout.CENTER);

//         JPanel doneButtonPanel = new JPanel();
//         doneButtonPanel.add(deleteDoneButton);
//         donePanel.add(doneButtonPanel, BorderLayout.SOUTH);

//         tabbedPane.addTab("Done", donePanel);

//         JLabel adminLabel = new JLabel("Admin Dashboard");

//         logoutButton.addActionListener(evt -> logoutActionPerformed());
//         deleteRequestButton.addActionListener(evt -> deleteRequestActionPerformed());
//         acceptRequestButton.addActionListener(evt -> acceptRequestActionPerformed());
//         moveToDoneButton.addActionListener(evt -> moveToDoneActionPerformed());
//         deleteDoneButton.addActionListener(evt -> deleteDoneActionPerformed());

//         setLayout(new BorderLayout());
//         add(adminLabel, BorderLayout.NORTH);
//         add(tabbedPane, BorderLayout.CENTER);
//         add(logoutButton, BorderLayout.SOUTH);

//         setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//         setSize(800, 600);
//     }

//     private void deleteRequestActionPerformed() {
//         int selectedRow = requestsTable.getSelectedRow();
//         if (selectedRow >= 0) {
//             DefaultTableModel model = (DefaultTableModel) requestsTable.getModel();
//             model.removeRow(selectedRow);
//         } else {
//             JOptionPane.showMessageDialog(this, "Please select a row to delete.");
//         }
//     }

//     private void acceptRequestActionPerformed() {
//         int selectedRow = requestsTable.getSelectedRow();
//         if (selectedRow >= 0) {
//             DefaultTableModel requestsModel = (DefaultTableModel) requestsTable.getModel();
//             DefaultTableModel acceptedModel = (DefaultTableModel) acceptedTable.getModel();

//             Object[] rowData = new Object[requestsModel.getColumnCount()];
//             for (int i = 0; i < requestsModel.getColumnCount(); i++) {
//                 rowData[i] = requestsModel.getValueAt(selectedRow, i);
//             }

//             acceptedModel.addRow(rowData);
//             requestsModel.removeRow(selectedRow);
//         } else {
//             JOptionPane.showMessageDialog(this, "Please select a row to accept.");
//         }
//     }

//     private void moveToDoneActionPerformed() {
//         int selectedRow = acceptedTable.getSelectedRow();
//         if (selectedRow >= 0) {
//             DefaultTableModel acceptedModel = (DefaultTableModel) acceptedTable.getModel();
//             DefaultTableModel doneModel = (DefaultTableModel) doneTable.getModel();

//             Object[] rowData = new Object[acceptedModel.getColumnCount()];
//             for (int i = 0; i < acceptedModel.getColumnCount(); i++) {
//                 rowData[i] = acceptedModel.getValueAt(selectedRow, i);
//             }

//             doneModel.addRow(rowData);
//             acceptedModel.removeRow(selectedRow);
//         } else {
//             JOptionPane.showMessageDialog(this, "Please select a row to mark as done.");
//         }
//     }

//     private void deleteDoneActionPerformed() {
//         int selectedRow = doneTable.getSelectedRow();
//         if (selectedRow >= 0) {
//             DefaultTableModel model = (DefaultTableModel) doneTable.getModel();
//             model.removeRow(selectedRow);
//         } else {
//             JOptionPane.showMessageDialog(this, "Please select a row to delete.");
//         }
//     }
//     private void logoutActionPerformed() {
        
//         JOptionPane.showMessageDialog(this, "Logging out.");
//         dispose();
//         new SetupAccountAdmin();
//     }

//     public void addData(String name, String type, String commission) {
//         DefaultTableModel model = (DefaultTableModel) requestsTable.getModel();
//         model.addRow(new Object[]{name, type, "View Details"});
//         lol = commission;
        
//     }

//     // Custom Renderer for Button in Table
//     class ButtonRenderer extends JButton implements TableCellRenderer {

//         public ButtonRenderer() {
//             setOpaque(true);
//         }

//         @Override
//         public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//             setText((value == null) ? "View Details" : value.toString());
//             return this;
//         }
//     }


//     class ButtonEditor extends DefaultCellEditor {
//         private JButton button;
//         private String label;
//         private boolean clicked;
//         private JTable parentTable;

//         public ButtonEditor(JCheckBox checkBox, JTable parentTable) {
//             super(checkBox);
//             this.parentTable = parentTable;
//             button = new JButton();
//             button.setOpaque(true);

//             button.addActionListener(new ActionListener() {
//                 @Override
//                 public void actionPerformed(ActionEvent e) {
//                     fireEditingStopped();
//                 }
//             });
//         }

//         @Override
//         public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
//             label = (value == null) ? "View Details" : value.toString();
//             button.setText(label);
//             clicked = true;
//             return button;
//         }

//         @Override
//         public Object getCellEditorValue() {
//             if (clicked) {
         
//                 int row = parentTable.getSelectedRow();
//                 if (row >= 0) {
//                     JOptionPane.showMessageDialog(button, "Commission Details: " + lol);
//                 }
//             }
//             clicked = false;
//             return label;
//         }

//         @Override
//         public boolean stopCellEditing() {
//             clicked = false;
//             return super.stopCellEditing();
//         }

//         @Override
//         protected void fireEditingStopped() {
//             super.fireEditingStopped();
//         }
//     }
// }
// import javax.swing.*;
// import javax.swing.table.DefaultTableModel;
// import javax.swing.table.TableCellRenderer;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// // import java.io.FileWriter;
// // import java.io.IOException;
// // import java.io.PrintWriter;

// public class DashboardAdmin extends JFrame {

//     private JTable requestsTable;
//     private JTable acceptedTable;
//     private JTable doneTable;
//     private String lol;

//     public DashboardAdmin() {
//         initComponents();
//         setVisible(true);
//     }

//     private void initComponents() {
       
//         JButton deleteRequestButton = new JButton("Delete Request");
//         JButton acceptRequestButton = new JButton("Accept Request");

    
//         JButton moveToDoneButton = new JButton("Move to Done");

        
//         JButton deleteDoneButton = new JButton("Delete Done");

//         JButton logoutButton = new JButton("Logout");
//         JTabbedPane tabbedPane = new JTabbedPane();

       
//         requestsTable = new JTable(new DefaultTableModel(new Object[][] {}, new String[] {"Name", "Type of Art", "Commission Summary"})) {
//             @Override
//             public boolean isCellEditable(int row, int column) {
//                 return column == 2; 
//             }
//         };

        
//         requestsTable.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
//         requestsTable.getColumnModel().getColumn(2).setCellEditor(new ButtonEditor(new JCheckBox(), requestsTable));

//         JScrollPane requestsScrollPane = new JScrollPane(requestsTable);

//         JPanel requestsPanel = new JPanel();
//         requestsPanel.setLayout(new BorderLayout());
//         requestsPanel.add(requestsScrollPane, BorderLayout.CENTER);

//         JPanel requestsButtonPanel = new JPanel();
//         requestsButtonPanel.add(deleteRequestButton);
//         requestsButtonPanel.add(acceptRequestButton);
//         requestsPanel.add(requestsButtonPanel, BorderLayout.SOUTH);

//         tabbedPane.addTab("Requests", requestsPanel);

        
//         acceptedTable = new JTable(new DefaultTableModel(new Object[][] {}, new String[] {"Name", "Type of Art", "Commission Summary"})) {
//             @Override
//             public boolean isCellEditable(int row, int column) {
//                 return column == 2; 
//             }
//         };

        
//         acceptedTable.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
//         acceptedTable.getColumnModel().getColumn(2).setCellEditor(new ButtonEditor(new JCheckBox(), acceptedTable));

//         JScrollPane acceptedScrollPane = new JScrollPane(acceptedTable);

//         JPanel acceptedPanel = new JPanel();
//         acceptedPanel.setLayout(new BorderLayout());
//         acceptedPanel.add(acceptedScrollPane, BorderLayout.CENTER);

//         JPanel acceptedButtonPanel = new JPanel();
//         acceptedButtonPanel.add(moveToDoneButton);
//         acceptedPanel.add(acceptedButtonPanel, BorderLayout.SOUTH);

//         tabbedPane.addTab("Accepted", acceptedPanel);

        
//         doneTable = new JTable(new DefaultTableModel(new Object[][] {}, new String[] {"Name", "Type of Art", "Commission Summary"})) {
//             @Override
//             public boolean isCellEditable(int row, int column) {
//                 return column == 2;
//             }
//         };

       
//         doneTable.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
//         doneTable.getColumnModel().getColumn(2).setCellEditor(new ButtonEditor(new JCheckBox(), doneTable));

//         JScrollPane doneScrollPane = new JScrollPane(doneTable);

//         JPanel donePanel = new JPanel();
//         donePanel.setLayout(new BorderLayout());
//         donePanel.add(doneScrollPane, BorderLayout.CENTER);

//         JPanel doneButtonPanel = new JPanel();
//         doneButtonPanel.add(deleteDoneButton);
//         donePanel.add(doneButtonPanel, BorderLayout.SOUTH);

//         tabbedPane.addTab("Done", donePanel);

//         // Layout setup
//         JLabel adminLabel = new JLabel("Admin Dashboard");

//         logoutButton.addActionListener(evt -> logoutActionPerformed());
//         deleteRequestButton.addActionListener(evt -> deleteRequestActionPerformed());
//         acceptRequestButton.addActionListener(evt -> acceptRequestActionPerformed());
//         moveToDoneButton.addActionListener(evt -> moveToDoneActionPerformed());
//         deleteDoneButton.addActionListener(evt -> deleteDoneActionPerformed());

//         setLayout(new BorderLayout());
//         add(adminLabel, BorderLayout.NORTH);
//         add(tabbedPane, BorderLayout.CENTER);
//         add(logoutButton, BorderLayout.SOUTH);

//         setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//         setSize(800, 600);
//     }

//     private void deleteRequestActionPerformed() {
//         int selectedRow = requestsTable.getSelectedRow();
//         if (selectedRow >= 0) {
//             DefaultTableModel model = (DefaultTableModel) requestsTable.getModel();
//             model.removeRow(selectedRow);
//         } else {
//             JOptionPane.showMessageDialog(this, "Please select a row to delete.");
//         }
//     }

//     private void acceptRequestActionPerformed() {
//         int selectedRow = requestsTable.getSelectedRow();
//         if (selectedRow >= 0) {
//             DefaultTableModel requestsModel = (DefaultTableModel) requestsTable.getModel();
//             DefaultTableModel acceptedModel = (DefaultTableModel) acceptedTable.getModel();

//             Object[] rowData = new Object[requestsModel.getColumnCount()];
//             for (int i = 0; i < requestsModel.getColumnCount(); i++) {
//                 rowData[i] = requestsModel.getValueAt(selectedRow, i);
//             }

//             acceptedModel.addRow(rowData);
//             requestsModel.removeRow(selectedRow);
//         } else {
//             JOptionPane.showMessageDialog(this, "Please select a row to accept.");
//         }
//     }

//     private void moveToDoneActionPerformed() {
//         int selectedRow = acceptedTable.getSelectedRow();
//         if (selectedRow >= 0) {
//             DefaultTableModel acceptedModel = (DefaultTableModel) acceptedTable.getModel();
//             DefaultTableModel doneModel = (DefaultTableModel) doneTable.getModel();

//             Object[] rowData = new Object[acceptedModel.getColumnCount()];
//             for (int i = 0; i < acceptedModel.getColumnCount(); i++) {
//                 rowData[i] = acceptedModel.getValueAt(selectedRow, i);
//             }

//             doneModel.addRow(rowData);
//             acceptedModel.removeRow(selectedRow);
//         } else {
//             JOptionPane.showMessageDialog(this, "Please select a row to mark as done.");
//         }
//     }

//     private void deleteDoneActionPerformed() {
//         int selectedRow = doneTable.getSelectedRow();
//         if (selectedRow >= 0) {
//             DefaultTableModel model = (DefaultTableModel) doneTable.getModel();
//             model.removeRow(selectedRow);
//         } else {
//             JOptionPane.showMessageDialog(this, "Please select a row to delete.");
//         }
//     }

//     private void logoutActionPerformed() {
        
//         JOptionPane.showMessageDialog(this, "Logging out.");
//         new SetupAccountAdmin();
//         dispose();
//     }

//     public void addData(String name, String type, String commission) {
//         DefaultTableModel model = (DefaultTableModel) requestsTable.getModel();
//         model.addRow(new Object[]{name, type, "View Details"});
//         lol = commission;

//         // try (FileWriter writer = new FileWriter("Artstrem-13-main\\ArtStream13-main\\DashboardAdmin.txt", true);
//         //     PrintWriter pw = new PrintWriter(writer)) {

//         //     pw.println("Commission: " + commission);
//         //     pw.println("-----------------------------");

//         // } catch (IOException e) {
//         //     JOptionPane.showMessageDialog(this, "Failed to save data to DashboardAdmin.txt");
//         // }
//     }

    
//     class ButtonRenderer extends JButton implements TableCellRenderer {

//         public ButtonRenderer() {
//             setOpaque(true);
//         }

//         @Override
//         public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//             setText((value == null) ? "View Details" : value.toString());
//             return this;
//         }
//     }

//     class ButtonEditor extends DefaultCellEditor {
//         private JButton button;
//         private String label;
//         private boolean clicked;
//         private JTable parentTable;

//         public ButtonEditor(JCheckBox checkBox, JTable parentTable) {
//             super(checkBox);
//             this.parentTable = parentTable;
//             button = new JButton();
//             button.setOpaque(true);

//             button.addActionListener(new ActionListener() {
//                 @Override
//                 public void actionPerformed(ActionEvent e) {
//                     fireEditingStopped();
//                 }
//             });
//         }

//         @Override
//         public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
//             label = (value == null) ? "View Details" : value.toString();
//             button.setText(label);
//             clicked = true;
//             return button;
//         }

//         @Override
//         public Object getCellEditorValue() {
//             if (clicked) {

//                 int row = parentTable.getSelectedRow();
//                 if (row >= 0) {
                
//                     JOptionPane.showMessageDialog(button, "Commission Details:" + lol);
//                 }
//             }
//             clicked = false;
//             return label;
//         }

//         @Override
//         public boolean stopCellEditing() {
//             clicked = false;
//             return super.stopCellEditing();
//         }

//         @Override
//         protected void fireEditingStopped() {
//             super.fireEditingStopped();
//         }
//     }
// }

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DashboardAdmin extends JFrame {

    private JTable requestsTable;
    private JTable acceptedTable;
    private JTable doneTable;
    private String lol;

    public DashboardAdmin() {
        initComponents();

        String filePath = "Artstrem-13-main\\ArtStream13-main\\DashboardAdmin.txt"; 

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            StringBuilder dataBlock = new StringBuilder();
            StringBuilder details = new StringBuilder(); 

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                   
                    if (dataBlock.length() > 0) {
                      
                        String[] parts = dataBlock.toString().split("\n");

                        if (parts.length >= 2) { 
                            String name = parts[0].trim(); 
                            String type = parts[1].trim(); 
                          
                            
                            String fullDetails = details.toString().trim();

                          
                            System.out.println("Name: " + name);
                            System.out.println("Type: " + type);
                            System.out.println("Details: " + fullDetails);
                            System.out.println("---------------");
                            addData(name, type, fullDetails);

                            
                            dataBlock.setLength(0);
                            details.setLength(0);
                        }
                    }
                } else {
                  
                    if (dataBlock.length() == 0 || dataBlock.toString().split("\n").length < 2) {
                        dataBlock.append(line).append("\n");
                    } else {
                       
                        details.append(line).append("\n");
                    }
                }
            }

            if (dataBlock.length() > 0) {
                String[] parts = dataBlock.toString().split("\n");
                if (parts.length >= 2) {
                    String name = parts[0].trim();
                    String type = parts[1].trim();
                    String fullDetails = details.toString().trim();

                    System.out.println("Name: " + name);
                    System.out.println("Type: " + type);
                    System.out.println("Details: " + fullDetails);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        setVisible(true);
    }

    private void initComponents() {

        JButton deleteRequestButton = new JButton("Delete Request");
        JButton acceptRequestButton = new JButton("Accept Request");
        JButton moveToDoneButton = new JButton("Move to Done");
        JButton deleteDoneButton = new JButton("Delete Done");
        JButton logoutButton = new JButton("Logout");
        JTabbedPane tabbedPane = new JTabbedPane();

        requestsTable = new JTable(new DefaultTableModel(new Object[][] {}, new String[] {"Name", "Type of Art", "Commission Summary"})) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 2; 
            }
        };

        requestsTable.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
        requestsTable.getColumnModel().getColumn(2).setCellEditor(new ButtonEditor(new JCheckBox(), requestsTable));

        JScrollPane requestsScrollPane = new JScrollPane(requestsTable);

        JPanel requestsPanel = new JPanel();
        requestsPanel.setLayout(new BorderLayout());
        requestsPanel.add(requestsScrollPane, BorderLayout.CENTER);

        JPanel requestsButtonPanel = new JPanel();
        requestsButtonPanel.add(deleteRequestButton);
        requestsButtonPanel.add(acceptRequestButton);
        requestsPanel.add(requestsButtonPanel, BorderLayout.SOUTH);

        tabbedPane.addTab("Requests", requestsPanel);

        acceptedTable = new JTable(new DefaultTableModel(new Object[][] {}, new String[] {"Name", "Type of Art", "Commission Summary"})) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 2; 
            }
        };

        acceptedTable.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
        acceptedTable.getColumnModel().getColumn(2).setCellEditor(new ButtonEditor(new JCheckBox(), acceptedTable));

        JScrollPane acceptedScrollPane = new JScrollPane(acceptedTable);

        JPanel acceptedPanel = new JPanel();
        acceptedPanel.setLayout(new BorderLayout());
        acceptedPanel.add(acceptedScrollPane, BorderLayout.CENTER);

        JPanel acceptedButtonPanel = new JPanel();
        acceptedButtonPanel.add(moveToDoneButton);
        acceptedPanel.add(acceptedButtonPanel, BorderLayout.SOUTH);

        tabbedPane.addTab("Accepted", acceptedPanel);

        doneTable = new JTable(new DefaultTableModel(new Object[][] {}, new String[] {"Name", "Type of Art", "Commission Summary"})) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 2;
            }
        };

        doneTable.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
        doneTable.getColumnModel().getColumn(2).setCellEditor(new ButtonEditor(new JCheckBox(), doneTable));

        JScrollPane doneScrollPane = new JScrollPane(doneTable);

        JPanel donePanel = new JPanel();
        donePanel.setLayout(new BorderLayout());
        donePanel.add(doneScrollPane, BorderLayout.CENTER);

        JPanel doneButtonPanel = new JPanel();
        doneButtonPanel.add(deleteDoneButton);
        donePanel.add(doneButtonPanel, BorderLayout.SOUTH);

        tabbedPane.addTab("Done", donePanel);

        JLabel adminLabel = new JLabel("Admin Dashboard");

        logoutButton.addActionListener(evt -> logoutActionPerformed());
        deleteRequestButton.addActionListener(evt -> deleteRequestActionPerformed());
        acceptRequestButton.addActionListener(evt -> acceptRequestActionPerformed());
        moveToDoneButton.addActionListener(evt -> moveToDoneActionPerformed());
        deleteDoneButton.addActionListener(evt -> deleteDoneActionPerformed());

        setLayout(new BorderLayout());
        add(adminLabel, BorderLayout.NORTH);
        add(tabbedPane, BorderLayout.CENTER);
        add(logoutButton, BorderLayout.SOUTH);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 600);
    }

    private void deleteRequestActionPerformed() {
        int selectedRow = requestsTable.getSelectedRow();
        if (selectedRow >= 0) {
            DefaultTableModel model = (DefaultTableModel) requestsTable.getModel();
            model.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.");
        }
    }

    private void acceptRequestActionPerformed() {
        int selectedRow = requestsTable.getSelectedRow();
        if (selectedRow >= 0) {
            DefaultTableModel requestsModel = (DefaultTableModel) requestsTable.getModel();
            DefaultTableModel acceptedModel = (DefaultTableModel) acceptedTable.getModel();

            Object[] rowData = new Object[requestsModel.getColumnCount()];
            for (int i = 0; i < requestsModel.getColumnCount(); i++) {
                rowData[i] = requestsModel.getValueAt(selectedRow, i);
            }

            acceptedModel.addRow(rowData);
            requestsModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to accept.");
        }
    }

    private void moveToDoneActionPerformed() {
        int selectedRow = acceptedTable.getSelectedRow();
        if (selectedRow >= 0) {
            DefaultTableModel acceptedModel = (DefaultTableModel) acceptedTable.getModel();
            DefaultTableModel doneModel = (DefaultTableModel) doneTable.getModel();

            Object[] rowData = new Object[acceptedModel.getColumnCount()];
            for (int i = 0; i < acceptedModel.getColumnCount(); i++) {
                rowData[i] = acceptedModel.getValueAt(selectedRow, i);
            }

            doneModel.addRow(rowData);
            acceptedModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to mark as done.");
        }
    }

    private void deleteDoneActionPerformed() {
        int selectedRow = doneTable.getSelectedRow();
        if (selectedRow >= 0) {
            DefaultTableModel model = (DefaultTableModel) doneTable.getModel();
            model.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.");
        }
    }

    private void logoutActionPerformed() {
        JOptionPane.showMessageDialog(this, "Logging out.");
        new SetupAccountAdmin();
        dispose();
    }

    public void addData(String name, String type, String commission) {
        DefaultTableModel model = (DefaultTableModel) requestsTable.getModel();
        model.addRow(new Object[]{name, type, commission});
    }

    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText("View Details");
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {
        private JButton button;
        private String label;
        private boolean clicked;
        private JTable parentTable;

        public ButtonEditor(JCheckBox checkBox, JTable parentTable) {
            super(checkBox);
            this.parentTable = parentTable;
            button = new JButton();
            button.setOpaque(true);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            String commissionDetails = parentTable.getValueAt(row, 2).toString();
            label = commissionDetails;
            button.setText(label);
            clicked = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            if (clicked) {
                int row = parentTable.getSelectedRow();
                if (row >= 0) {
                    String commissionDetails = parentTable.getValueAt(row, 2).toString();
                    JOptionPane.showMessageDialog(button, "Commission Details: " + commissionDetails);
                }
            }
            clicked = false;
            return label;
        }

        @Override
        public boolean stopCellEditing() {
            clicked = false;
            return super.stopCellEditing();
        }

        @Override
        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }

}
