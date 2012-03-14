using IServer;
using System.Windows.Forms;
using Client.communications;
using Client.domain;
using Client.presentation;
using System;

namespace Client
{
    public class App : Ice.Application{

        public override int run(string[] args) {
            try
            {
                ServerPrx server = ServerPrxHelper.checkedCast(communicator().propertyToProxy("Server.Proxy"));
                ServerProxy.setServerProxy(server);
                Ice.ObjectAdapter adapter = communicator().createObjectAdapter("");
                Ice.Identity ident = new Ice.Identity();
                ident.name = System.Guid.NewGuid().ToString();
                ident.category = "";
                adapter.add(new ClientI(), ident);
                adapter.activate();
                server.ice_getConnection().setAdapter(adapter);
                UserController.setCallback(ident);
                Application.EnableVisualStyles();
                Application.SetCompatibleTextRenderingDefault(false);
                LoginController.getInstance().open();
                Application.Run();
                communicator().waitForShutdown();
            }
            catch (Ice.ConnectionRefusedException e) { 
                MessageBox.Show("The server is off, try later", "Server is off", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }

               return 0;
        
        }

    }
}
