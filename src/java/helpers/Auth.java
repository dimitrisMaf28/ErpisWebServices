package helpers;

import javax.servlet.http.HttpServletRequest;
import db.PersistanceCon;
import db.User;

public class Auth {
   
    public final static String USER = "username";
    public final static String PASS = "password";

    public boolean logIn (HttpServletRequest request) {
        /* TODO: Remove comment when db is fixed
        PersistanceCon dbCon = new PersistanceCon();

        // Connect to the database and check if user exists
        User user = dbCon.authCredentials(
            request.getParameter(USER),
            request.getParameter(PASS)
        );

        if (user == null)
            return false;
        */
        // Save username to session so that we know
        // if a user has already logged in
        request.getSession().setAttribute(USER, request.getParameter(USER));
        
        return true;
    }
    
    public void logOut (HttpServletRequest request) {
        request.getSession().setAttribute(USER, null);
    }

    public boolean isLoggedIn (HttpServletRequest request) {
        return request.getSession().getAttribute(USER) != null;
    }
}
