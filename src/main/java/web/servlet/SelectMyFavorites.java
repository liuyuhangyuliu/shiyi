package web.servlet;

import com.alibaba.fastjson.JSON;
import pojo.Article;
import pojo.Favorites;
import service.ArticleService;
import service.FavoritesService;
import service.impl.ArticleServiceImpl;
import service.impl.FavoritesServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectMyFavorites", value = "/selectMyFavorites")
public class SelectMyFavorites extends HttpServlet {
   // private ArticleService articleService = new ArticleServiceImpl();
    private FavoritesService favoritesService = new FavoritesServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uid = request.getParameter("uid");
        List<Favorites> MyFavorites = favoritesService.selectMyFavorites(uid);
        String jsonString = JSON.toJSONString(MyFavorites);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request,response);
    }
}
