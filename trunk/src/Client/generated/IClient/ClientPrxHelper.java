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
// Generated from file `ClientPrxHelper.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package IClient;

public final class ClientPrxHelper extends Ice.ObjectPrxHelperBase implements ClientPrx
{
    public void
    receiveWaitingRoomMessage(String sender, String message)
    {
        receiveWaitingRoomMessage(sender, message, null, false);
    }

    public void
    receiveWaitingRoomMessage(String sender, String message, java.util.Map<String, String> __ctx)
    {
        receiveWaitingRoomMessage(sender, message, __ctx, true);
    }

    private void
    receiveWaitingRoomMessage(String sender, String message, java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __delBase = __getDelegate(false);
                _ClientDel __del = (_ClientDel)__delBase;
                __del.receiveWaitingRoomMessage(sender, message, __ctx);
                return;
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, null, __cnt);
            }
        }
    }

    private static final String __receiveWaitingRoomMessage_name = "receiveWaitingRoomMessage";

    public Ice.AsyncResult begin_receiveWaitingRoomMessage(String sender, String message)
    {
        return begin_receiveWaitingRoomMessage(sender, message, null, false, null);
    }

    public Ice.AsyncResult begin_receiveWaitingRoomMessage(String sender, String message, java.util.Map<String, String> __ctx)
    {
        return begin_receiveWaitingRoomMessage(sender, message, __ctx, true, null);
    }

    public Ice.AsyncResult begin_receiveWaitingRoomMessage(String sender, String message, Ice.Callback __cb)
    {
        return begin_receiveWaitingRoomMessage(sender, message, null, false, __cb);
    }

    public Ice.AsyncResult begin_receiveWaitingRoomMessage(String sender, String message, java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_receiveWaitingRoomMessage(sender, message, __ctx, true, __cb);
    }

    public Ice.AsyncResult begin_receiveWaitingRoomMessage(String sender, String message, Callback_Client_receiveWaitingRoomMessage __cb)
    {
        return begin_receiveWaitingRoomMessage(sender, message, null, false, __cb);
    }

    public Ice.AsyncResult begin_receiveWaitingRoomMessage(String sender, String message, java.util.Map<String, String> __ctx, Callback_Client_receiveWaitingRoomMessage __cb)
    {
        return begin_receiveWaitingRoomMessage(sender, message, __ctx, true, __cb);
    }

    private Ice.AsyncResult begin_receiveWaitingRoomMessage(String sender, String message, java.util.Map<String, String> __ctx, boolean __explicitCtx, IceInternal.CallbackBase __cb)
    {
        IceInternal.OutgoingAsync __result = new IceInternal.OutgoingAsync(this, __receiveWaitingRoomMessage_name, __cb);
        try
        {
            __result.__prepare(__receiveWaitingRoomMessage_name, Ice.OperationMode.Normal, __ctx, __explicitCtx);
            IceInternal.BasicStream __os = __result.__os();
            __os.writeString(sender);
            __os.writeString(message);
            __os.endWriteEncaps();
            __result.__send(true);
        }
        catch(Ice.LocalException __ex)
        {
            __result.__exceptionAsync(__ex);
        }
        return __result;
    }

    public void end_receiveWaitingRoomMessage(Ice.AsyncResult __result)
    {
        __end(__result, __receiveWaitingRoomMessage_name);
    }

    public void
    userLeave(String username)
    {
        userLeave(username, null, false);
    }

    public void
    userLeave(String username, java.util.Map<String, String> __ctx)
    {
        userLeave(username, __ctx, true);
    }

    private void
    userLeave(String username, java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __delBase = __getDelegate(false);
                _ClientDel __del = (_ClientDel)__delBase;
                __del.userLeave(username, __ctx);
                return;
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, null, __cnt);
            }
        }
    }

    private static final String __userLeave_name = "userLeave";

    public Ice.AsyncResult begin_userLeave(String username)
    {
        return begin_userLeave(username, null, false, null);
    }

    public Ice.AsyncResult begin_userLeave(String username, java.util.Map<String, String> __ctx)
    {
        return begin_userLeave(username, __ctx, true, null);
    }

    public Ice.AsyncResult begin_userLeave(String username, Ice.Callback __cb)
    {
        return begin_userLeave(username, null, false, __cb);
    }

    public Ice.AsyncResult begin_userLeave(String username, java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_userLeave(username, __ctx, true, __cb);
    }

    public Ice.AsyncResult begin_userLeave(String username, Callback_Client_userLeave __cb)
    {
        return begin_userLeave(username, null, false, __cb);
    }

    public Ice.AsyncResult begin_userLeave(String username, java.util.Map<String, String> __ctx, Callback_Client_userLeave __cb)
    {
        return begin_userLeave(username, __ctx, true, __cb);
    }

    private Ice.AsyncResult begin_userLeave(String username, java.util.Map<String, String> __ctx, boolean __explicitCtx, IceInternal.CallbackBase __cb)
    {
        IceInternal.OutgoingAsync __result = new IceInternal.OutgoingAsync(this, __userLeave_name, __cb);
        try
        {
            __result.__prepare(__userLeave_name, Ice.OperationMode.Normal, __ctx, __explicitCtx);
            IceInternal.BasicStream __os = __result.__os();
            __os.writeString(username);
            __os.endWriteEncaps();
            __result.__send(true);
        }
        catch(Ice.LocalException __ex)
        {
            __result.__exceptionAsync(__ex);
        }
        return __result;
    }

    public void end_userLeave(Ice.AsyncResult __result)
    {
        __end(__result, __userLeave_name);
    }

    public void
    userLogged(String username)
    {
        userLogged(username, null, false);
    }

    public void
    userLogged(String username, java.util.Map<String, String> __ctx)
    {
        userLogged(username, __ctx, true);
    }

    private void
    userLogged(String username, java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __delBase = __getDelegate(false);
                _ClientDel __del = (_ClientDel)__delBase;
                __del.userLogged(username, __ctx);
                return;
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, null, __cnt);
            }
        }
    }

    private static final String __userLogged_name = "userLogged";

    public Ice.AsyncResult begin_userLogged(String username)
    {
        return begin_userLogged(username, null, false, null);
    }

    public Ice.AsyncResult begin_userLogged(String username, java.util.Map<String, String> __ctx)
    {
        return begin_userLogged(username, __ctx, true, null);
    }

    public Ice.AsyncResult begin_userLogged(String username, Ice.Callback __cb)
    {
        return begin_userLogged(username, null, false, __cb);
    }

    public Ice.AsyncResult begin_userLogged(String username, java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_userLogged(username, __ctx, true, __cb);
    }

    public Ice.AsyncResult begin_userLogged(String username, Callback_Client_userLogged __cb)
    {
        return begin_userLogged(username, null, false, __cb);
    }

    public Ice.AsyncResult begin_userLogged(String username, java.util.Map<String, String> __ctx, Callback_Client_userLogged __cb)
    {
        return begin_userLogged(username, __ctx, true, __cb);
    }

    private Ice.AsyncResult begin_userLogged(String username, java.util.Map<String, String> __ctx, boolean __explicitCtx, IceInternal.CallbackBase __cb)
    {
        IceInternal.OutgoingAsync __result = new IceInternal.OutgoingAsync(this, __userLogged_name, __cb);
        try
        {
            __result.__prepare(__userLogged_name, Ice.OperationMode.Normal, __ctx, __explicitCtx);
            IceInternal.BasicStream __os = __result.__os();
            __os.writeString(username);
            __os.endWriteEncaps();
            __result.__send(true);
        }
        catch(Ice.LocalException __ex)
        {
            __result.__exceptionAsync(__ex);
        }
        return __result;
    }

    public void end_userLogged(Ice.AsyncResult __result)
    {
        __end(__result, __userLogged_name);
    }

    public static ClientPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
        ClientPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (ClientPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA(ice_staticId()))
                {
                    ClientPrxHelper __h = new ClientPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static ClientPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        ClientPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (ClientPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA(ice_staticId(), __ctx))
                {
                    ClientPrxHelper __h = new ClientPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static ClientPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        ClientPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA(ice_staticId()))
                {
                    ClientPrxHelper __h = new ClientPrxHelper();
                    __h.__copyFrom(__bb);
                    __d = __h;
                }
            }
            catch(Ice.FacetNotExistException ex)
            {
            }
        }
        return __d;
    }

    public static ClientPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        ClientPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA(ice_staticId(), __ctx))
                {
                    ClientPrxHelper __h = new ClientPrxHelper();
                    __h.__copyFrom(__bb);
                    __d = __h;
                }
            }
            catch(Ice.FacetNotExistException ex)
            {
            }
        }
        return __d;
    }

    public static ClientPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
        ClientPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (ClientPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                ClientPrxHelper __h = new ClientPrxHelper();
                __h.__copyFrom(__obj);
                __d = __h;
            }
        }
        return __d;
    }

    public static ClientPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        ClientPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            ClientPrxHelper __h = new ClientPrxHelper();
            __h.__copyFrom(__bb);
            __d = __h;
        }
        return __d;
    }

    public static final String[] __ids =
    {
        "::IClient::Client",
        "::Ice::Object"
    };

    public static String
    ice_staticId()
    {
        return __ids[0];
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
        return new _ClientDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
        return new _ClientDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, ClientPrx v)
    {
        __os.writeProxy(v);
    }

    public static ClientPrx
    __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            ClientPrxHelper result = new ClientPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }
}