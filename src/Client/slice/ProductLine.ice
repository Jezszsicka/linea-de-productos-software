#include <Ice/Identity.ice>

module ProductLine {
	enum RoleType { Player, Admin };
	enum GameType {	Ludo, Chess, Trivial, Monopoly, Checkers};

	["java:getset"]
	class Ranking {
		int wonGames;
		int lostGames;
		GameType game;
	};
	
	["java:type:java.util.ArrayList<String>"] sequence<string> StringList;
	["java:type:java.util.ArrayList<Ranking>"] sequence<Ranking> RankingList;

	
	["java:getset"]
	class User{
		["protected"] string username;
		["protected"] string password;
		["protected"] string email;
		["protected"] RoleType role;
		["protected"] string name;
		["protected"] string lastName;
		["protected"] string secondLastName;
		["protected"] StringList friends;	
		["protected"] RankingList rankings;
	};
	

	

	exception genericException {
		string reason;
	};
	exception UserAlreadyLoggedException extends genericException{};
	exception UserNotLoggedException extends genericException{};
	exception UserAlreadyExistsException extends genericException{};
	exception InvalidLoggingException extends genericException{};

    interface Server {
    	void registerUser(string username, string password, string email) throws UserAlreadyExistsException;
        User loginUser(string username, string password,Ice::Identity client) throws UserAlreadyLoggedException,InvalidLoggingException;
		void logoutUser(string username) throws UserNotLoggedException;
		StringList listUsers();
		void sendPrivateMessage(string sender, string destinatary, string message);
		void sendGameMessage(string game,string sender, string message);
		void sendGeneralMessage(string sender,string message);
		void saveProfile(User profile);
    };
    
    interface Client {
    	void receiveGeneralMessage(string sender, string message);
    	void userLogged(string username);
    	void userLeave(string username);
    };
    
};