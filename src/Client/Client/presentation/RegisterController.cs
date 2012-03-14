using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Client.presentation
{
    class RegisterController
    {
        private static RegisterController controller;
        private Register register;

        public RegisterController()
        {
            register = new Register();
        }

        public static RegisterController getInstance()
        {
            if (controller == null)
            {
                controller = new RegisterController();
            }
            return controller;
        }

        public void open()
        {
            register.ShowDialog();
        }

        public void close()
        {
            register.Dispose();
            controller = null;
        }
    }
}
