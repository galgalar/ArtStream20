

import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Client extends Informations implements Validation{
    
    private static ArrayList <String> names = new ArrayList<>();
    private static ArrayList <String> pass = new ArrayList<>();
    private static ArrayList<DashboardClient> dashboardClients = new ArrayList<>();
   
   
    public static int noOfClient = 0;
    private int index = 0;

    public Client(String username,String password)
    {
        super(username,password);
        
        try
        {           
            names.add(username);
            pass.add(password);

            

             System.out.println(names.get(noOfClient));
             System.out.println(pass.get(noOfClient));
           
            dashboardClients.add(new DashboardClient(username));
 
             
             
            ++noOfClient;
            
        }catch(Exception e)
        {
            System.out.print("sdfdsf");
        }
        

    }

    public Client()
    {
        super("Unknown","LOL");
    }
    @Override
    public boolean validateLogin(String name, String password) {

        for (int i = 0; i < names.size(); ++i) {
            if (name.equals(names.get(i)) && password.equals(pass.get(i))) {
                index = i;       
                System.out.print(index);       
                return true; 
            }
        }
        return false; 
    }
    @Override
    public boolean validateRegister(String name, String password) {

        for (int i = 0; i < names.size(); ++i) {
            if (name.equals(names.get(i)) && password.equals(pass.get(i))) {
                return true; 
            }
        }
        return false; 
    }
    
    public void displayDashboard()
    {       
        dashboardClients.get(index).setVisible(true);; 
    }

    
    




}
