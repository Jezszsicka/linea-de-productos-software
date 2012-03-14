using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using IServer;

namespace Client.communications
{
   public class ServerProxy{
       private static ServerPrx server;


       public static void setServerProxy(ServerPrx serverPrx){
           server = serverPrx;
       }


       public static ServerPrx getInstance(){
           return server;
       }

       
   }
}
