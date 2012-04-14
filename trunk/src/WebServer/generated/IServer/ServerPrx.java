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
// Generated from file `ServerPrx.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package IServer;

public interface ServerPrx extends Ice.ObjectPrx
{
    public void registerUser(String username, String password, String email)
        throws UserAlreadyExistsException;

    public void registerUser(String username, String password, String email, java.util.Map<String, String> __ctx)
        throws UserAlreadyExistsException;

    public Ice.AsyncResult begin_registerUser(String username, String password, String email);

    public Ice.AsyncResult begin_registerUser(String username, String password, String email, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_registerUser(String username, String password, String email, Ice.Callback __cb);

    public Ice.AsyncResult begin_registerUser(String username, String password, String email, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_registerUser(String username, String password, String email, Callback_Server_registerUser __cb);

    public Ice.AsyncResult begin_registerUser(String username, String password, String email, java.util.Map<String, String> __ctx, Callback_Server_registerUser __cb);

    public void end_registerUser(Ice.AsyncResult __result)
        throws UserAlreadyExistsException;

    public void loginUser(String username, String password, Ice.Identity client)
        throws InvalidLoggingException,
               UserAlreadyLoggedException;

    public void loginUser(String username, String password, Ice.Identity client, java.util.Map<String, String> __ctx)
        throws InvalidLoggingException,
               UserAlreadyLoggedException;

    public Ice.AsyncResult begin_loginUser(String username, String password, Ice.Identity client);

    public Ice.AsyncResult begin_loginUser(String username, String password, Ice.Identity client, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_loginUser(String username, String password, Ice.Identity client, Ice.Callback __cb);

    public Ice.AsyncResult begin_loginUser(String username, String password, Ice.Identity client, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_loginUser(String username, String password, Ice.Identity client, Callback_Server_loginUser __cb);

    public Ice.AsyncResult begin_loginUser(String username, String password, Ice.Identity client, java.util.Map<String, String> __ctx, Callback_Server_loginUser __cb);

    public void end_loginUser(Ice.AsyncResult __result)
        throws InvalidLoggingException,
               UserAlreadyLoggedException;

    public void logoutUser(String username)
        throws UserNotLoggedException;

    public void logoutUser(String username, java.util.Map<String, String> __ctx)
        throws UserNotLoggedException;

    public Ice.AsyncResult begin_logoutUser(String username);

    public Ice.AsyncResult begin_logoutUser(String username, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_logoutUser(String username, Ice.Callback __cb);

    public Ice.AsyncResult begin_logoutUser(String username, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_logoutUser(String username, Callback_Server_logoutUser __cb);

    public Ice.AsyncResult begin_logoutUser(String username, java.util.Map<String, String> __ctx, Callback_Server_logoutUser __cb);

    public void end_logoutUser(Ice.AsyncResult __result)
        throws UserNotLoggedException;

    public java.util.List<java.lang.String> listUsers();

    public java.util.List<java.lang.String> listUsers(java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_listUsers();

    public Ice.AsyncResult begin_listUsers(java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_listUsers(Ice.Callback __cb);

    public Ice.AsyncResult begin_listUsers(java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_listUsers(Callback_Server_listUsers __cb);

    public Ice.AsyncResult begin_listUsers(java.util.Map<String, String> __ctx, Callback_Server_listUsers __cb);

    public java.util.List<java.lang.String> end_listUsers(Ice.AsyncResult __result);

    public void sendPrivateMessage(String sender, String destinatary, String message);

    public void sendPrivateMessage(String sender, String destinatary, String message, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_sendPrivateMessage(String sender, String destinatary, String message);

    public Ice.AsyncResult begin_sendPrivateMessage(String sender, String destinatary, String message, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_sendPrivateMessage(String sender, String destinatary, String message, Ice.Callback __cb);

    public Ice.AsyncResult begin_sendPrivateMessage(String sender, String destinatary, String message, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_sendPrivateMessage(String sender, String destinatary, String message, Callback_Server_sendPrivateMessage __cb);

    public Ice.AsyncResult begin_sendPrivateMessage(String sender, String destinatary, String message, java.util.Map<String, String> __ctx, Callback_Server_sendPrivateMessage __cb);

    public void end_sendPrivateMessage(Ice.AsyncResult __result);

    public void sendGameMessage(String game, String sender, String message);

    public void sendGameMessage(String game, String sender, String message, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_sendGameMessage(String game, String sender, String message);

    public Ice.AsyncResult begin_sendGameMessage(String game, String sender, String message, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_sendGameMessage(String game, String sender, String message, Ice.Callback __cb);

    public Ice.AsyncResult begin_sendGameMessage(String game, String sender, String message, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_sendGameMessage(String game, String sender, String message, Callback_Server_sendGameMessage __cb);

    public Ice.AsyncResult begin_sendGameMessage(String game, String sender, String message, java.util.Map<String, String> __ctx, Callback_Server_sendGameMessage __cb);

    public void end_sendGameMessage(Ice.AsyncResult __result);

    public void sendGeneralMessage(String sender, String message);

    public void sendGeneralMessage(String sender, String message, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_sendGeneralMessage(String sender, String message);

    public Ice.AsyncResult begin_sendGeneralMessage(String sender, String message, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_sendGeneralMessage(String sender, String message, Ice.Callback __cb);

    public Ice.AsyncResult begin_sendGeneralMessage(String sender, String message, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_sendGeneralMessage(String sender, String message, Callback_Server_sendGeneralMessage __cb);

    public Ice.AsyncResult begin_sendGeneralMessage(String sender, String message, java.util.Map<String, String> __ctx, Callback_Server_sendGeneralMessage __cb);

    public void end_sendGeneralMessage(Ice.AsyncResult __result);
}
