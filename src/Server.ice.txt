module ProductLine {
    interface Server {
        void loginUser(String username, String password);
	void registerUser(String username, String password, String email);
    };
};