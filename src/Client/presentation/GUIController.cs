using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using Client.presentation;

namespace Client.domain{
    public class GUIController{

        private static GUIController controller;
        private Login login;
        private WaitingRoom waitingRoom;

        public GUIController() {
        
        }

        public static GUIController getInstance() {
            if (controller == null) {
                controller = new GUIController();
            }

            return controller;
        }

        public void openLoginGUI() {
            login = new Login();
            login.Show();
            login.Activate();
            Application.Run();
        }

        public void closeLoginGUI() {
            login.Hide();
        }

        public void openWaitingRoomGUI() {
            waitingRoom = new WaitingRoom();
            waitingRoom.Show();
            waitingRoom.Activate();
        }
    }
}
