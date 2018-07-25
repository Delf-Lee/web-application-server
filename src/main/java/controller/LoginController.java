package controller;

import db.DataBase;
import model.User;
import util.HttpRequest;
import util.HttpResponse;

public class LoginController implements Controller {
    @Override
    public void service(HttpRequest request, HttpResponse response) {
        User user = DataBase.findUserById(request.getParameter("userId"));
        if (user == null) {
            response.sendRedirect("/user/login_failed.html");
            return;
        }
        if (user.login(request.getParameter("password"))) {
            response.addHeader("Set-Cookie", "logined=true");
            response.sendRedirect("index.html");
        } else {
            response.sendRedirect("/user/login_failed.html");
        }
    }
}
