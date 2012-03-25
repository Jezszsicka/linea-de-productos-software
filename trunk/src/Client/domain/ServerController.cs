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

       public int Start(string[] args)
       {
           App app = new App();
           return app.main(args, "config.client");
       }
    }
}
