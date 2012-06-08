#include <Ice/Identity.ice>

module ProductLine {
	enum RoleType { Player, Admin };
	enum GameType {	Ludo, Chess, Trivial, Monopoly, Checkers};


	class Game {
		["protected"] string name;
		["protected"] string creator;
		["protected"] GameType typeGame;
		["protected"] void addPlayer(string user);
		["protected"] void removePlayer(string user);
	};

	["java:getset"]
	class Ranking {
		int wonGames;
		int lostGames;
		GameType game;
	};
	
	["java:type:java.util.ArrayList<String>"] sequence<string> StringList;
	["java:type:java.util.ArrayList<Ranking>"] sequence<Ranking> RankingList;
	sequence<byte> Image;
	
	["java:getset"]
	class User{
		["protected"] string username;
		["protected"] string name;
		["protected"] string lastName;
		["protected"] string password;
		["protected"] string email;
		["protected"] RoleType role;
		["protected"] int country;
		["protected"] Image avatar;
		["protected"] StringList friends;	
		["protected"] RankingList rankings;
	};
	
	["java:type:java.util.ArrayList<User>"] sequence<User> UserList;
	

	exception genericException {
		string reason;
	};
	exception UserAlreadyLoggedException extends genericException{};
	exception UserNotLoggedException extends genericException{};
	exception UserAlreadyExistsException extends genericException{};
	exception InvalidLoggingException extends genericException{};

    interface Server {
    	void registerUser(User newUser) throws UserAlreadyExistsException;
        User loginUser(string username, string password,Ice::Identity client) throws UserAlreadyLoggedException,InvalidLoggingException;
		void logoutUser(string username) throws UserNotLoggedException;
		void changeName(string username, string name, string lastname, string password) throws InvalidLoggingException;
		void changePassword(string username, string password, string newPassword) throws InvalidLoggingException;
		void changeEmail(string username, string email, string password) throws InvalidLoggingException;
		void changeAvatar(string username, Image avatar);
		UserList listUsers(string username);
		void sendGameMessage(string game,string sender, string message);
		void sendGeneralMessage(string sender,string message);
		void sendPrivateMessage(string sender, string destinatary, string message) throws UserNotLoggedException;
		void deleteAccount(string username, string password) throws InvalidLoggingException;
		void createGame(string user,string gameName, GameType type);
		void probar(Game prof);
    };
    
    interface Client {
    	void receiveGeneralMessage(string sender, string message);
    	void receivePrivateMessage(string sender, string message);
    	void userLogged(User loggedUser);
    	void userLeave(string username);
    };
    
};