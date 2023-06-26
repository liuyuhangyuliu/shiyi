package web.servlet;

import com.alibaba.fastjson.JSON;
import pojo.Article;
import service.ArticleService;
import service.impl.ArticleServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SelectByIDServlet", value = "/selectByIDServlet")
public class SelectByIDServlet extends HttpServlet {

    private ArticleService articleService = new ArticleServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String ID = request.getParameter("articleID");
        Article article = articleService.selectByID(Integer.parseInt(ID));

        String jsonString = JSON.toJSONString(article);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }
}
