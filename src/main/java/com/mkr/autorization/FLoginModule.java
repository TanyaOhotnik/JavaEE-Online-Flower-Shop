package com.mkr.autorization;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.util.Map;

/**
 * Created by Tanya Ohotnik on 10.11.2016.
 */
public class FLoginModule implements LoginModule {
    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options) {

    }

    @Override
    public boolean login() throws LoginException {
        return false;
    }

    @Override
    public boolean commit() throws LoginException {
        return false;
    }

    @Override
    public boolean abort() throws LoginException {
        return false;
    }

    @Override
    public boolean logout() throws LoginException {
        return false;
    }
}
