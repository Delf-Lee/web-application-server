package http;

import java.util.HashMap;
import java.util.Map;

public class HttpSessions {
    private static Map<String, HttpSession> sessions = new HashMap<>();

    public static void addSession(String sesionId, HttpSession session) {
        sessions.put(sesionId, session);
    }

    public static HttpSession getSession(String id) {
        HttpSession session = sessions.get(id);
        if (session == null) {
            session = new HttpSession(id);
            sessions.put(id, session);
        }
        return session;
    }

    public static void remove(String id) {
        sessions.remove(id);
    }

}
