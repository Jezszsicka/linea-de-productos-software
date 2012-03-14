#include <Ice/Identity.ice>

module IServer {

    exception genericException {
		string reason;
	};
	
	exception UserAlreadyLoggedException extends genericException{};
	exception UserNotLoggedException extends genericException{};

    interface Server {
    	void registerUser(string username, string password, string email);
        void loginUser(string username, string password,Ice::Identity client) throws UserAlreadyLoggedException;
		void logoutUser(string username) throws UserNotLoggedException;
    };
    
};


module IClient {
    interface Client {
    };
};