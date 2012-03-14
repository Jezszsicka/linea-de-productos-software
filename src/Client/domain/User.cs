using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Client.domain{
    public class User{

        private String username;
        private String password;

        
        private String name;
        private String first_Name;
        private String last_Name;
        private String email;
        private HashSet<String> friends;


        public User() { 
        
        }

        public User(String username,String password, String name, String first_Name, String last_Name, String email) {
            this.username = username;
            this.password = password;
            this.name = name;
            this.first_Name = first_Name;
            this.last_Name = last_Name;
            this.email = email;
        }

        public String Username
        {
            get { return username; }
            set { username = value; }
        }

        public String Password
        {
            get { return password; }
            set { password = value; }
        }
    }
}
