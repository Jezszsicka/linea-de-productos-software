using System;
using System.Collections.Generic;
using System.Linq;

namespace Client{

    public class Client{
        /// <summary>
        /// Punto de entrada principal para la aplicación.
        /// </summary>
        [STAThread]

       public static int Main(string[] args)
        {
            /*Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new Login());
            */

            App app = new App();
            return app.main(args, "config.client");
           
    
        }
    }
}
