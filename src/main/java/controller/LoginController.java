package controller;

import db.DataBase;
import http.HttpSession;
import model.User;
import http.HttpRequest;
import http.HttpResponse;

public class LoginController extends AbstractController {
    @Override
    public void doPost(HttpRequest request, HttpResponse response) {
        User user = DataBase.findUserById(request.getParameter("userId"));
        if (user == null) {
            response.sendRedirect("/user/login_failed.html");
            return;
        }
        if (user.login(request.getParameter("password"))) {
            HttpSession session = request.getSession();
            session.setAttributes("user", user);
            response.addHeader("Set-Cookie", "logined=true");
            response.sendRedirect("/index.html");
        } else {
            response.sendRedirect("/user/login_failed.html");
        }
    }
}
