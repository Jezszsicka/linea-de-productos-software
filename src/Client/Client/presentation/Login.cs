using System;
using System.Windows.Forms;
using Client.communications;
using IServer;
using Client.domain;
using Client.presentation;

namespace Client
{
    public partial class Login : Form
    {
        public Login()
        {
            InitializeComponent();
        }

        private void Login_Load(object sender, EventArgs e)
        {
            this.Top = (Screen.PrimaryScreen.WorkingArea.Height - this.Height) / 2;
            this.Left = (Screen.PrimaryScreen.WorkingArea.Width - this.Width) / 2;
        }

        private void btnLogin_Click(object sender, EventArgs e)
        {
            UserController.getInstance().loginUser(username.Text, password.Text);
            LoginController.getInstance().close();
            WaitingRoomController.getInstance().open();
        }

        private void btnRegister_Click(object sender, EventArgs e)
        {
            RegisterController.getInstance().open();
        }
    }
}
