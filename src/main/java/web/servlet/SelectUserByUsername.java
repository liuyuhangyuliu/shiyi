package web.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "SelectUserByUsername", value = "/selectUserByUsername")
public class SelectUserByUsername extends HttpServlet {

    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(1024 * 1024);
        ServletFileUpload upload = new ServletFileUpload(factory);


        HttpServletRequest req = request;

        boolean isExisted = false;
        String username = null;
        String password = null;
        try{
            List<FileItem> items = upload.parseRequest(request);
            username = items.get(0).getString();
            password = items.get(1).getString();
            isExisted = userService.SelectUserByUsername(username);
        }catch (Exception e){
            e.printStackTrace();
        }

        response.setContentType("text/json;charset=utf-8");
        PrintWriter writer = response.getWriter();

        if(isExisted){
            writer.write("existing");
        }else{

            //转发还得往request里存要共享的数据，不是说共享同一个request对象吗，我以为直接转发就行
            //

            req.setAttribute("username",username);
            req.setAttribute("password",password);


            request.getRequestDispatcher("/insertUser").forward(req,response);
        }
    }
}
