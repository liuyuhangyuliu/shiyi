package web.servlet;

import service.FavoritesService;
import service.impl.FavoritesServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CheckFavorites", value = "/checkFavorites")
public class CheckFavorites extends HttpServlet {
    private FavoritesService favoritesService = new FavoritesServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String articleID = request.getParameter("articleID");
        String uid = request.getParameter("uid");

        int isFavorites = favoritesService.isFavorites(articleID,uid);
        //System.out.println(isFavorites);
        response.setContentType("text/json;charset=utf-8");

        //应该把int转成String，response写int的话会出现奇怪的字符
        response.getWriter().write(Integer.toString(isFavorites));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request,response);
    }
}
