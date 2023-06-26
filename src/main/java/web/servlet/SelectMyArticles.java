package web.servlet;

import com.alibaba.fastjson.JSON;
import pojo.Article;
import service.ArticleService;
import service.impl.ArticleServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectMyArticles", value = "/selectMyArticles")
public class SelectMyArticles extends HttpServlet {
    private ArticleService articleService = new ArticleServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uid = request.getParameter("uid");
        List <Article> MyArticles = articleService.selectByAuthor(uid);

        String jsonString = JSON.toJSONString(MyArticles);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request,response);
    }
}
