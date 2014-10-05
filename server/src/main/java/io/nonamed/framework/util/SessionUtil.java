package io.nonamed.framework.util;

import io.nonamed.framework.web.GwSession;
import io.nonamed.framework.web.SimpleGwSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtil {

    public static final String SESSION_KEY_USER = "GW_USER";

    public synchronized static void setGwSession(HttpServletRequest request, GwSession gwSession){
        HttpSession sess = request.getSession(true);
        sess.setAttribute(SESSION_KEY_USER, gwSession);
    }

    public static GwSession getGwSession(HttpServletRequest request){
        HttpSession sess = request.getSession(true);
        return (GwSession) sess.getAttribute(SESSION_KEY_USER);
    }
}
