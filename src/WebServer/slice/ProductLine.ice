#include <Ice/Identity.ice>

module ProductLine {
	enum RoleType { Player, Admin };
	enum SlotState {Human,Computer,Empty,Closed};
	enum GameType {	Checkers,Chess, Connect4, Goose,Ludo};
	enum Players { TwoPlayers, ThreeOrMore};
	enum MessageType {Normal,Invitation};
	
	
	["java:getset"]
	class Slot{
		string player;
		SlotState type;
	};
	
	
	
	["java:type:java.util.ArrayList<String>"] sequence<string> StringList;
	["java:type:java.util.ArrayList<Slot>"] sequence<Slot> SlotList;
	["java:type:java.util.ArrayList<GameType>"] sequence<GameType> GameTypeList;
	["java:type:java.util.ArrayList<Players>"] sequence<Players> PlayersList;
	sequence<int> intArray;
	sequence<intArray> bidimensionalIntArray;
	
	["java:getset"]
	class Game {
		["protected"] string name;
		["protected"] GameType typeGame;
		["protected"] bool started;
		["protected"] SlotList slots;
		["protected"] bidimensionalIntArray board;
		["protected"] int turn;
		bool addPlayer(string user);
		void removePlayer(string user);
		Slot getSlot(int slot);
		void setSlot(int slotIndex,Slot newSlot);
		int freeSlots();
		int players();
		int changeTurn();
	};

	["java:getset"]
	class Filter{
		["protected"] GameTypeList gamesFilter;
		["protected"] PlayersList playersFilter;
		void addGame(GameType game);
		void removeGame(GameType game);
		void addPlayers(Players numPlayers);
		void removePlayers(Players numPlayers);
	};
	
	["java:getset"]
	class Message{
		["protected"] string from;
		["protected"] string to;
		["protected"] string subject;
		["protected"] string content;
		["protected"] MessageType type;
		["protected"] bool read; 
	};

	["java:getset"]
	class Ranking {
		["protected"] int wonGames;
		["protected"] int lostGames;
		["protected"] GameType game;
	};
	
	["java:type:java.util.ArrayList<Ranking>"] sequence<Ranking> RankingList;
	["java:type:java.util.ArrayList<Game>"] sequence<Game> GameList;
	["java:type:java.util.ArrayList<Message>"] sequence<Message> MessageList;
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
		["protected"] MessageList messages;
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
	exception FullGameException extends genericException{};
	exception NotEnoughPlayersException extends genericException{};

    interface Server {
    	void registerUser(User newUser) throws UserAlreadyExistsException;
        User loginUser(string username, string password,Ice::Identity client) throws UserAlreadyLoggedException,InvalidLoggingException;
		void logoutUser(string username);
		UserList listUsers(string username);
		void resetPassword(string identifier) throws InvalidLoggingException;
		
		void changeName(string username, string name, string lastname, string password) throws InvalidLoggingException;
		void changePassword(string username, string password, string newPassword) throws InvalidLoggingException;
		void changeEmail(string username, string email, string password) throws InvalidLoggingException;
		void changeAvatar(string username, Image avatar);
		void deleteAccount(string username, string password) throws InvalidLoggingException;
		
		
		void sendGeneralMessage(string sender,string message);
		void sendPrivateMessage(string sender, string receiver, string message) throws UserNotLoggedException;
		void sendGameMessage(string game,string sender, string message);
		void sendGamePrivateMessage(string game, string sender, string receiver, string message) throws UserNotInGameException;
		void sendMessage(Message msg);
		
		void createGame(string game,string creator, GameType type) throws GameAlreadyExistsException;
		Game joinGame(string game, string player) throws FullGameException;
		void leaveGame(string game, string player);
		void deleteGame(string game,string creator);
		void kickPlayer(string game, string player);
		void changeSlotState(string game, int slot, SlotState state);
		GameList listGames(string user, string gameName, Filter gamesFilter);
		void startGame(string game);
		void updateGame(string game, string player, int nextTurn ,bidimensionalIntArray board);
		void updateDiceGame(string game, string player, int nextTurn, bidimensionalIntArray board, int dice, int movedPiece);
		void finishGame(string game, string player);
    };
    
    interface Client {
    	void receiveGeneralMessage(string sender, string message);
    	void receivePrivateMessage(string sender, string message);
    	void receiveGameMessage(string game,string sender, string message);
    	void receiveGamePrivateMessage(string game, string sender, string message);
    	
    	void userLogged(User loggedUser);
    	void userLeave(string username);
    	void userJoinGame(string game, string user);
    	void userLeaveGame(string game, string user);
    	void slotStateChanged(string game, int slot, SlotState state);
    	void kickedFromGame(string game);
    	void gameStarted(string game);
    	void gameUpdated(string game,int nextTurn,bidimensionalIntArray board);
    	void gameFinished(string game);
    };
    
};