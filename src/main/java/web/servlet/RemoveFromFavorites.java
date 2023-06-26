package web.servlet;

import service.FavoritesService;
import service.impl.FavoritesServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RemoveFromFavorites", value = "/removeFromFavorites")
public class RemoveFromFavorites extends HttpServlet {

    private FavoritesService favoritesService = new FavoritesServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String articleID = request.getParameter("articleID");
        String uid = request.getParameter("uid");
        favoritesService.removeFavorites(articleID,uid);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }
}
