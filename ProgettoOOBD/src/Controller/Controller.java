package Controller;

import javax.swing.*;

import LoginWindow.LoginWindow;
import MainWindow.MainWindow;

public class Controller {
	  //attributi
	  LoginWindow login;
      MainWindow main;     
      
      
      //metodi
      public static void main(String[] args) {
    	  Controller c = new Controller();
    	  
      }
      public void ShutLoginWindow() {
     	  login.setVisible(false);
     	  login.dispose();
        }  
      
      public void MainWindowOn() {
      	    main = new MainWindow(this,login.getProcuratoreTextField().getText());
      	    main.setVisible(true);
        }

      
       //costruttore
       public Controller() {
    	   
    	   login = new LoginWindow(this);
    	   login.setVisible(true);
    	   
       }
   
       
       //getter e setter
       public LoginWindow getLogin() {
   		return login;
   	}
   	   public void setLogin(LoginWindow login) {
   		this.login = login;
   	   }
   	   public MainWindow getMain() {
   		return main;
   	   }
   	   public void setMain(MainWindow main) {
   		this.main = main;
   	   }

       
    
   

	
       

	
    

}
