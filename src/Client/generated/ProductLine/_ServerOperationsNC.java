// **********************************************************************
//
// Copyright (c) 2003-2011 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.4.2
//
// <auto-generated>
//
// Generated from file `_ServerOperationsNC.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package ProductLine;

public interface _ServerOperationsNC
{
    void registerUser(User newUser)
        throws UserAlreadyExistsException;

    User loginUser(String username, String password, Ice.Identity client)
        throws InvalidLoggingException,
               UserAlreadyLoggedException;

    void logoutUser(String username)
        throws UserNotLoggedException;

    void changeName(String username, String name, String lastname, String password)
        throws InvalidLoggingException;

    void changePassword(String username, String password, String newPassword)
        throws InvalidLoggingException;

    void changeEmail(String username, String email, String password)
        throws InvalidLoggingException;

    void changeAvatar(String username, byte[] avatar);

    java.util.List<User> listUsers(String username);

    void sendGameMessage(String game, String sender, String message);

    void sendGeneralMessage(String sender, String message);

    void sendPrivateMessage(String sender, String destinatary, String message)
        throws UserNotLoggedException;

    void deleteAccount(String username, String password)
        throws InvalidLoggingException;

    void createGame(String user, String gameName, GameType type);

    void probar(Game prof);
}
