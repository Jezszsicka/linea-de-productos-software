using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Client.presentation
{
   public class WaitingRoomController
    {
       private static WaitingRoomController controller;
       private WaitingRoom waitingRoomForm;

       public WaitingRoomController()
       {
       }

       public static WaitingRoomController getInstance(){
           if (controller == null)
               controller = new WaitingRoomController();

           return controller;
       }

       public void open()
       {
           waitingRoomForm = new WaitingRoom();
           waitingRoomForm.Show();
           waitingRoomForm.Activate();
       }

       public void close()
       {
           waitingRoomForm.Close();
       }


       public void showMessage(String sender, String message)
       {
           
       }
    }
}
