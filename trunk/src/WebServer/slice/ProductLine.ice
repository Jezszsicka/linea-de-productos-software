#include <Ice/Identity.ice>

module ProductLine {
	enum RoleType { Player, Admin };
	enum GameType {	Ludo, Chess, Trivial, Monopoly, Checkers};
	["java:type:java.util.ArrayList<String>"] sequence<string> StringList;
	
	["java:getset"]
	class Game {
		["protected"] string name;
		["protected"] GameType typeGame;
		["protected"] int maxPlayers;
		["protected"] StringList players;
		["protected"] bool started;
		void addPlayer(string user);
		void removePlayer(string user);
		
	};

	["java:getset"]
	class Ranking {
		["protected"] int wonGames;
		["protected"] int lostGames;
		["protected"] GameType game;
	};
	
	["java:type:java.util.ArrayList<Ranking>"] sequence<Ranking> RankingList;
	["java:type:java.util.ArrayList<Game>"] sequence<Game> GameList;
	
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
	exception GameAlreadyExistsException extends genericException{};
	exception UserNotInGameException extends genericException{};

    interface Server {
    	void registerUser(User newUser) throws UserAlreadyExistsException;
        User loginUser(string username, string password,Ice::Identity client) throws UserAlreadyLoggedException,InvalidLoggingException;
		void logoutUser(string username) throws UserNotLoggedException;
		UserList listUsers(string username);
		
		void changeName(string username, string name, string lastname, string password) throws InvalidLoggingException;
		void changePassword(string username, string password, string newPassword) throws InvalidLoggingException;
		void changeEmail(string username, string email, string password) throws InvalidLoggingException;
		void changeAvatar(string username, Image avatar);
		void deleteAccount(string username, string password) throws InvalidLoggingException;
		
		
		void sendGeneralMessage(string sender,string message);
		void sendPrivateMessage(string sender, string destinatary, string message) throws UserNotLoggedException;
		void sendGameMessage(string game,string sender, string message);
		void sendGamePrivateMessage(string game, string sender, string destinatary, string message) throws UserNotInGameException;
		
		void createGame(string user,string game, GameType type) throws GameAlreadyExistsException;
		void joinGame(string game, string player);
		void deleteGame(string game,string creator);
		void kickPlayer(string game, string player);
		GameList listGames(string user);
    };
    
    interface Client {
    	void receiveGeneralMessage(string sender, string message);
    	void receivePrivateMessage(string sender, string message);
    	void receiveGameMessage(string game,string sender, string message);
    	void receiveGamePrivateMessage(string game, string sender, string message);
    	
    	void userLogged(User loggedUser);
    	void userLeave(string username);
    	void userJoinGame(string user, string game);
    	void userLeaveGame(string user, string game);
    	void kickedFromGame(string game);
    };
    
};