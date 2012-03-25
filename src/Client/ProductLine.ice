#include <Ice/Identity.ice>

module IServer {

	sequence<string> StringSeq;
    exception genericException {
		string reason;
	};
	
	exception UserAlreadyLoggedException extends genericException{};
	exception UserNotLoggedException extends genericException{};
	exception UserAlreadyExistsException extends genericException{};
	exception InvalidLoggingException extends genericException{};

    interface Server {
    	void registerUser(string username, string password, string email) throws UserAlreadyExistsException;
        void loginUser(string username, string password,Ice::Identity client) throws UserAlreadyLoggedException,InvalidLoggingException;
		void logoutUser(string username) throws UserNotLoggedException;
		void sendPrivateMessage(string sender, string destinatary, string message);
		void sendMessage(string sender, string message);
		["java:type:java.util.ArrayList<String>"] StringSeq chatParticipants();
    };
    
};


module IClient {
    interface Client {
    	void saludo();
    	void receiveMessage(string sender, string message);
    };
};