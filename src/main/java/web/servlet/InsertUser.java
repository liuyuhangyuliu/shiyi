package web.servlet;

import com.alibaba.fastjson.JSON;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "InsertUser", value = "/insertUser")
public class InsertUser extends HttpServlet {

    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        DiskFileItemFactory factory = new DiskFileItemFactory();
//        factory.setSizeThreshold(1024 * 1024);
//        ServletFileUpload upload = new ServletFileUpload(factory);

        try{

            //List<FileItem> items = upload.parseRequest(request);

            //System.out.println(items.size());

            //String username = items.get(0).getString();
           // String password = items.get(1).getString();
            String username = request.getAttribute("username").toString();
            String password = request.getAttribute("password").toString();

            int rows = userService.InsertUser(username,password);
            User user = userService.SelectUser(username,password);

            //response.setContentType("text/json;charset=utf-8");
            Cookie username_cookie = new Cookie("username",username);
            Cookie avatarSrc_cookie = new Cookie("avatarSrc",user.getAvatarSrc());
            Cookie coverSrc_cookie = new Cookie("coverSrc",user.getCoverSrc());
            Cookie uid_cookie = new Cookie("uid",user.getUid());

            response.addCookie(username_cookie);
            response.addCookie(avatarSrc_cookie);
            response.addCookie(coverSrc_cookie);
            response.addCookie(uid_cookie);




            //response.getWriter().write(rows);




            return;



        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
