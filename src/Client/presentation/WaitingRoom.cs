using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using Client.domain;
using Client.communications;

namespace Client.presentation
{
    public partial class WaitingRoom : Form
    {
        public WaitingRoom()
        {
            InitializeComponent();
        }

        private void WaitingRoom_Load(object sender, EventArgs e)
        {
            this.Top = (Screen.PrimaryScreen.WorkingArea.Height - this.Height) / 2;
            this.Left = (Screen.PrimaryScreen.WorkingArea.Width - this.Width) / 2;
            String [] chatParticipants = ServerProxy.getInstance().chatParticipants();
            participants.Items.Clear();
            for (int i = 0; i < chatParticipants.Length; i++)
                participants.Items.Add(chatParticipants[i]);
            
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            DialogResult response = MessageBox.Show("Are you sure?", "Exit", MessageBoxButtons.YesNo,MessageBoxIcon.Question);
            if (response == DialogResult.Yes)
            {
                UserController.getInstance().logoutUser();
                LoginController.getInstance().open();
                WaitingRoomController.getInstance().close();
            }
        }

        private void btnSend_Click(object sender, EventArgs e)
        {
            MessageController.getInstance().sendMessage(txtMessage.Text);
            txtMessages.SelectionColor = Color.Black;
            txtMessages.SelectedText = UserController.getInstance().Username +": " + txtMessage.Text + "\n";
            txtMessage.Text = "";
        }

        private void txtMessage_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode.Equals(Keys.Enter))
            {
                MessageController.getInstance().sendMessage(txtMessage.Text);
                txtMessages.SelectionColor = Color.Black;
                txtMessages.SelectedText = UserController.getInstance().Username + ": " + txtMessage.Text + "\n";
                txtMessage.Text = "";
            }
        }

        public void showMessage(String sender, String message) 
        {
            txtMessages.SelectionColor = Color.Black;
            txtMessages.SelectedText = sender + ": " + txtMessage.Text + "\n";
        }

        private void btnProfile_Click(object sender, EventArgs e)
        {

        }
    }
}
