using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Client.presentation
{
   public class LoginController
    {
       private static LoginController controller;
       private Login loginForm;

       private LoginController()
       {
           loginForm = new Login();
       }

       public static LoginController getInstance(){
           if (controller == null)
               controller = new LoginController();

           return controller;
       }

       public void open()
       {
           loginForm.Show();
           loginForm.Activate();
       }

       public void close() {
           loginForm.Hide();
       }

    }
}


