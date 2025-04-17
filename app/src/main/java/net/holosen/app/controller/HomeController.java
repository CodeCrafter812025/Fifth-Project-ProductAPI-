package net.holosen.app.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class HomeController {

    @GetMapping("")
    public String index(
            @CookieValue(value = "name",
                    defaultValue = "Friend",
                    required = false) String name) {
        return "Hello " + name;
    }

    @SneakyThrows
    @GetMapping("s")
    public String s(HttpServletRequest request,
                    HttpServletResponse response,
                    HttpSession session) {
        String x = request.getParameter("x");
        String agent = request.getHeader("User-Agent");
        String url = request.getRequestURL().toString();
        String ipAddress = request.getRemoteAddr();
        Cookie[] cookies = request.getCookies();
        response.setHeader("My-Name", "Hossein");
        //response.sendRedirect("http://127.0.0.1:8080/api/product");
        //response.getWriter().write("Salam, inja chi mikhay?");

        Cookie cookie = new Cookie("MyCookie", "SweetCookie");
        cookie.setMaxAge(7 * 24 * 60 * 60); // 1week
        response.addCookie(cookie);

        HttpSession session1 = request.getSession(true);

        session.setAttribute("userId", "1");
        Object userId = session.getAttribute("userId");
        session1.invalidate();


        return "Hello";
    }
}
