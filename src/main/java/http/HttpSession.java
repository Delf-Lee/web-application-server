package http;

import java.util.HashMap;
import java.util.Map;

public class HttpSession {
    private String id;
    private Map<String, Object> attributes = new HashMap<>();

    public HttpSession(String sessionId) {
        this.id = sessionId;
    }

    public String getId() {
        return id;
    }

    public void setAttributes(String name, Object value) {
        attributes.put(name, value);
    }

    public Object getArrtibute(String name) {
        return attributes.get(name);
    }

    public void removeAttribute(String name) {
        attributes.remove(name);
    }

    public void invalidate() {
        HttpSessions.remove(this.id);
    }
}
