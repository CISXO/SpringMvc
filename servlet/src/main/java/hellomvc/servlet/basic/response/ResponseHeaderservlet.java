package hellomvc.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderservlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //[status-line]
        response.setStatus(HttpServletResponse.SC_OK);// = response.setStatus(200);
//        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        //[response-headers]
//        response.setHeader("Content-Type", "text/plain; charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("my-header", "hello");

//        //[Header 편의 메서드]
//        content(response);
//        //Coockie
//        cookie(response);
        //redirect
        redirect(response);

        PrintWriter writer = response.getWriter();
        System.out.println("response = " + response.getStatus());
        writer.println("안녕");
    }

    private void redirect(HttpServletResponse response) throws IOException {
//        response.setStatus(HttpServletResponse.SC_FOUND);
//        response.setHeader("Location", "/basic/hello-form.html");
        //위 코드와 아래는 같음
        response.sendRedirect("/basic/hello-form.html");
    }

    private void cookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600);//600sec
        response.addCookie(cookie);
        /**
        *
         response.addCookie(cookie) 와
         response.setHeader("Set-cookie", "myCookie=good; Max-Age=600);
         같다.
         * */
        //
    }

    private void content(HttpServletResponse response) {
//        Content-Type: text/plain;charset=utf-8
//        Content-Length: 2
//        response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
//        response.setContentLength(2); // 생략시 자동 생성
    }
}
