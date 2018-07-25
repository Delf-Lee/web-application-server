import util.RequestLine;
import org.junit.Test;
import util.HttpRequest;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class HttpRequestTest {
    private String testDirectory = "./src/test/resources/";

    @Test
    public void requets_GET() throws Exception {
        InputStream in = new FileInputStream(new File(testDirectory + "Http_GET.txt"));
        HttpRequest request = new HttpRequest(in);

        assertEquals("GET", request.getMethod().toString());
        assertEquals("/user/create", request.getPath());
        assertEquals("keep-alive", request.getHeader("Connection"));
        assertEquals("javajigi", request.getParameter("userId"));
    }

    @Test
    public void requets_POST() throws Exception {
        InputStream in = new FileInputStream(new File(testDirectory + "Http_POST.txt"));
        HttpRequest request = new HttpRequest(in);

        assertEquals("POST", request.getMethod().toString());
        assertEquals("/user/create", request.getPath());
        assertEquals("keep-alive", request.getHeader("Connection"));
        assertEquals("javajigi", request.getParameter("userId"));
    }

    @Test
    public void create_method() throws IllegalAccessException {
        RequestLine line = new RequestLine("GET /index.html HTTP/1.1");
        assertEquals("GET", line.getMethod().toString());
        assertEquals("/index.html", line.getPath());

        line = new RequestLine("POST /index.html HTTP/1.1");
        assertEquals("/index.html", line.getPath());
    }

    @Test
    public void create_path_and_params() throws IllegalAccessException {
        RequestLine line = new RequestLine("GET /user/create?userId=javajigi&password=pass HTTP/1.1");
        assertEquals("GET", line.getMethod().toString());
        assertEquals("/user/create", line.getPath());
        Map<String, String> params = line.getParams();
        assertEquals(2, params.size());
    }
}