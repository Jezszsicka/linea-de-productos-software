using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using Client.presentation;

namespace Client.communications{
    public class ClientI : IClient.ClientDisp_
    {
        public override void saludo(Ice.Current current__)
        {
            MessageBox.Show("Llamada que te crio", "Llamada", MessageBoxButtons.OK, MessageBoxIcon.Error);
        }

        public override void receiveMessage(string sender, string message, Ice.Current current__)
        {
           // WaitingRoomController.getInstance().showMessage(sender, message);
        }
    }
}
