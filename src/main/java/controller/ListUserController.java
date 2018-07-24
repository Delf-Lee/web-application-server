package controller;

import util.HttpRequest;
import util.HttpResponse;

public class ListUserController extends AbstractController {
    @Override
    public void service(HttpRequest request, HttpResponse response) {

    }

    @Override
    public void doGet(HttpRequest request, HttpResponse response) {
        super.doGet(request, response);
    }

    public boolean isLogined(String logined) {
        return true;
    }
}
