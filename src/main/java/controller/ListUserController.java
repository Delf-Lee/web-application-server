package controller;

import util.HttpRequest;
import util.HttpResponse;

public class ListUserController implements Controller {
    @Override
    public void service(HttpRequest request, HttpResponse response) {

    }

    public boolean isLogined(String logined) {
        return true;
    }
}
