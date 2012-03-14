using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using Client.domain;

namespace Client.presentation
{
    public partial class WaitingRoom : Form
    {
        public WaitingRoom()
        {
            InitializeComponent();
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            UserController.getInstance().logoutUser();
            WaitingRoomController.getInstance().close();
        }
    }
}
