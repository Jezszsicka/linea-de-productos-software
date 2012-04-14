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
		["java:type:java.util.ArrayList<String>"] StringSeq listUsers();
		void sendPrivateMessage(string sender, string destinatary, string message);
		void sendGameMessage(string game,string sender, string message);
		void sendGeneralMessage(string sender,string message);
    };
    
};


module IClient {
    interface Client {
    	void receiveWaitingRoomMessage(string sender, string message);
    	void userLogged(string username);
    	void userLeave(string username);
    };
};