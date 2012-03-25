using System;
using System.Collections.Generic;
using System.Linq;
using Client.domain;

namespace Client{

    public class Client{
        /// <summary>
        /// Punto de entrada principal para la aplicación.
        /// </summary>
        [STAThread]

       public static int Main(string[] args)
        {
            return ServerController.getInstance().Start(args);
        }
    }
}
