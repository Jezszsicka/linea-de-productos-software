module IServer {
    interface Server {
        void loginUser(string username, string password);
	void registerUser(string username, string password, string email);
    };
};