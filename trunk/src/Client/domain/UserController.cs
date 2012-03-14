using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Client.communications;
using IServer;
using Client.presentation;
using System.Windows.Forms;

namespace Client.domain{

    public class UserController{

        private static UserController controller;
        private static Ice.Identity callback;
        private String username;

        private UserController(){

        }

        public static UserController getInstance() {
            if (controller == null) {
                controller = new UserController();
            }

            return controller;
        
        }
        
        public void registerUser(String username, String password, String email) {
            ServerProxy.getInstance().registerUser(username, password, email);
        }

        public void loginUser(String username, String password) {
            try
            {
                ServerProxy.getInstance().loginUser(username, password, callback);
                LoginController.getInstance().close();
                WaitingRoomController.getInstance().open();
            }
            catch (InvalidLoggingException e)
            {
                switch (e.reason)
                {
                    case "Blocked account":
                        MessageBox.Show("Su cuenta está bloqueada", "Cuenta bloqueada", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        break;
                    case "Incorrect password":
                        MessageBox.Show("La contraseña introducida es incorrecta", "Contraseña incorrecta", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        break;
                    case "Incorrect username":
                        MessageBox.Show("El usuario introducido no existe", "Usuario incorrecto", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        break;
                }
            }
            catch (UserAlreadyLoggedException e)
            {
               MessageBox.Show("Su cuenta está en uso", "Cuenta en uso", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        public static void setCallback(Ice.Identity ident) {
            callback = ident;
        }


        public void logoutUser()
        {
            ServerProxy.getInstance().logoutUser(username);
        }
    }
}
