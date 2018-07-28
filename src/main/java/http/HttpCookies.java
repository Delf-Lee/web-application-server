package http;

import util.HttpRequestUtils;

import java.util.Map;

public class HttpCookies {
    private Map<String, String> cookies;

    public HttpCookies(String cookieValue) {
        cookies = HttpRequestUtils.parseQueryString(cookieValue);
    }

    public String getCookie(String name) {
        return cookies.get(name);
    }
}
