package za.ac.cput.factory;

import za.ac.cput.Util.Helper;
import za.ac.cput.domain.LogIn;

public class LogInFactory {
    public static LogIn createLogIn(String email, String password) {

        if (Helper.isNullorEmpty(email) || (Helper.isNullorEmpty(password)))
            return null;

        return new LogIn.Builder()
                .setEmail(email).setPassword(password).build();
    }
}
