using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Client.domain
{
   class ServerController
    {
       private static ServerController controller;

       public ServerController()
       {

       }

       public static ServerController getInstance()
       {
           if (controller == null)
           {
               controller = new ServerController();
           }

           return controller;
       }

       public void Start()
       {
           App app = new App();
           String [] args = new String[1];
           app.main(args, "config.client");
       }
    }
}
