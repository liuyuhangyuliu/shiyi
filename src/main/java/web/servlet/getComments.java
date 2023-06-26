package web.servlet;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import pojo.Comment;
import pojo.User;
import service.CommentService;
import service.UserService;
import service.impl.CommentServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "getComments", value = "/getComments")
public class getComments extends HttpServlet {

    private CommentService commentService = new CommentServiceImpl();
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String article_id = request.getParameter("articleID");
        response.setContentType("text/json;charset=utf-8");

        List<Comment> comments = commentService.SelectAllComments(article_id);


        PrintWriter writer = response.getWriter();

        if(comments != null){
            JSONArray jsonArray = new JSONArray();


            for(int i=0;i<comments.size();i++){
                JSONObject jsonObject = new JSONObject();
                String uid = comments.get(i).getFrom_uid();
                //System.out.println(uid);
                //当然正常情况下uid不能为null 自己造数据时有可能出这样的错误
                if(uid == null ){return;}

                User user = userService.SelectUserByUid(uid);
                jsonObject.put("username",user.getUsername());
                jsonObject.put("avatarSrc",user.getAvatarSrc());
                jsonObject.put("content",comments.get(i).getContent());
                jsonObject.put("time",comments.get(i).getTime());

                jsonArray.add(jsonObject);
            }
            String jsonString = jsonArray.toJSONString();
            //System.out.println(jsonString);
            writer.write(jsonString);

        }else {
            writer.write("no comments");
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request,response);
    }
}
