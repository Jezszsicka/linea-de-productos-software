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
    public partial class Register : Form
    {
        public Register()
        {
            InitializeComponent();
        }

        private void btnRegister_Click(object sender, EventArgs e)
        {
            if (!txtPassword.Text.Equals(txtRetypePassword.Text))
            {
                MessageBox.Show("The passwords must be the same", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
            {
                UserController.getInstance().registerUser(txtUsername.Text, txtPassword.Text, txtRetypePassword.Text);
                MessageBox.Show("Registered successfully", "Register done", MessageBoxButtons.OK, MessageBoxIcon.Asterisk);
                RegisterController.getInstance().close();
            }
        }

        private void Register_Load(object sender, EventArgs e)
        {
            this.Top = (Screen.PrimaryScreen.WorkingArea.Height - this.Height) / 2;
            this.Left = (Screen.PrimaryScreen.WorkingArea.Width - this.Width) / 2;
        }

 
        public bool ValidEmailAddress(string emailAddress, out string errorMessage)
        {
            // Confirm that the e-mail address string is not empty.
            if (emailAddress.Length == 0)
            {
                errorMessage = "e-mail address is required.";
                return false;
            }

            // Confirm that there is an "@" and a "." in the e-mail address, and in the correct order.
            if (emailAddress.IndexOf("@") > -1)
            {
                if (emailAddress.IndexOf(".", emailAddress.IndexOf("@")) > emailAddress.IndexOf("@"))
                {
                    errorMessage = "";
                    return true;
                }
            }

            errorMessage = "e-mail address must be valid e-mail address format.\n" +
               "For example 'someone@example.com' ";
            return false;
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            RegisterController.getInstance().close();
        }

    }



}
