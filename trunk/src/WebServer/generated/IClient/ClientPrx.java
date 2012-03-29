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
// Generated from file `ClientPrx.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package IClient;

public interface ClientPrx extends Ice.ObjectPrx
{
    public void receiveMessage(String sender, String message);

    public void receiveMessage(String sender, String message, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_receiveMessage(String sender, String message);

    public Ice.AsyncResult begin_receiveMessage(String sender, String message, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_receiveMessage(String sender, String message, Ice.Callback __cb);

    public Ice.AsyncResult begin_receiveMessage(String sender, String message, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_receiveMessage(String sender, String message, Callback_Client_receiveMessage __cb);

    public Ice.AsyncResult begin_receiveMessage(String sender, String message, java.util.Map<String, String> __ctx, Callback_Client_receiveMessage __cb);

    public void end_receiveMessage(Ice.AsyncResult __result);
}