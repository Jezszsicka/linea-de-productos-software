using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Client.communications;
using Client.presentation;

namespace Client.domain
{
    public class MessageController
    {
        private static MessageController controller;

        private MessageController() { 
        
        }

        public static MessageController getInstance()
        {
            if (controller == null)
                controller = new MessageController();

            return controller;
        }

        public void sendMessage(String message)
        {
            ServerProxy.getInstance().sendMessage(UserController.getInstance().Username,message);
        }

        public void receiveMessage(String sender,String message) 
        {
            WaitingRoomController.getInstance().showMessage(sender, message);
        }
    }
}
