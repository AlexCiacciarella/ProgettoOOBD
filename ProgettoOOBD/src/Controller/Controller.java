package Controller;

import javax.swing.*;

import LoginWindow.LoginWindow;
import MainWindow.MainWindow;

public class Controller {
	  //attributi
	  LoginWindow LoginWindow;
      MainWindow MainWindow;     
      
      
      //metodi
      public static void main(String[] args) {
    	  Controller c = new Controller();
    	  
      }
      public void ShutLoginWindow() {
     	  LoginWindow.setVisible(false);
     	  LoginWindow.dispose();
        }  
      
      public void MainWindowOn() {
      	    MainWindow = new MainWindow(this,LoginWindow.getProcuratoreTextField().getText());
      	    MainWindow.setVisible(true);
        }

      
       //costruttore
       public Controller() {
    	   
    	   LoginWindow = new LoginWindow(this);
    	   LoginWindow.setVisible(true);
    	   
       }
   
       
       //getter e setter
       public LoginWindow getLogin() {
   		return LoginWindow;
   	}
   	   public void setLogin(LoginWindow login) {
   		this.LoginWindow = login;
   	   }
   	   public MainWindow getMain() {
   		return MainWindow;
   	   }
   	   public void setMain(MainWindow main) {
   		this.MainWindow = main;
   	   }

       
    
   

	
       

	
    

}
