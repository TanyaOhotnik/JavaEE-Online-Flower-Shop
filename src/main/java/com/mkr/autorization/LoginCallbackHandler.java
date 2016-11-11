package com.mkr.autorization;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;

/**
 * Created by Tanya Ohotnik on 10.11.2016.
 */
public class LoginCallbackHandler implements CallbackHandler {
    private String user = null;
    private String password = null;

    public LoginCallbackHandler(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {

    }
}
