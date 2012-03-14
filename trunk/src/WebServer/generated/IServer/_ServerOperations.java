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
// Generated from file `_ServerOperations.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package IServer;

public interface _ServerOperations
{
    void registerUser(String username, String password, String email, Ice.Current __current)
        throws UserAlreadyExistsException;

    void loginUser(String username, String password, Ice.Identity client, Ice.Current __current)
        throws InvalidLoggingException,
               UserAlreadyLoggedException;

    void logoutUser(String username, Ice.Current __current)
        throws UserNotLoggedException;

    void sendPrivateMessage(String sender, String destinatary, String message, Ice.Current __current);

    void sendMessage(String sender, String message, Ice.Current __current);
}
