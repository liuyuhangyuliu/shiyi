package web.servlet;

import service.FavoritesService;
import service.impl.FavoritesServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddToFavorites", value = "/addToFavorites")
public class AddToFavorites extends HttpServlet {
    private FavoritesService favoritesService = new FavoritesServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String articleID = request.getParameter("articleID");
        String uid = request.getParameter("uid");
        String title = request.getParameter("title");
        String imgSrc = request.getParameter("imgSrc");
        favoritesService.addFavorites(articleID,uid,title,imgSrc);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }
}
