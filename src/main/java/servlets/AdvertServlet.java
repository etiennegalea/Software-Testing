package servlets;

import cps3222.classes.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Etienne G on 14/12/2016.
 */
@WebServlet(name = "AdvertServlet", urlPatterns = "/advert")
public class AdvertServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdPlatform adplatform = (AdPlatform)request.getSession().getAttribute("adplatform");

        String advertKeyword = request.getParameter("keyword");
        System.out.println(advertKeyword);

        // add new advert
        ArrayList<String> array = new ArrayList<String>();
        adplatform.registerAdvert(new Advert(1 , "Elon Musk", new AdDescription(array,MediaType.IMAGE,Dimensions.LARGE)));
        Advert ad = adplatform.serveAdvert(new AdFormat(MediaType.IMAGE,Dimensions.LARGE, advertKeyword));

        request.getSession().setAttribute("adname", ad.getName());
        response.sendRedirect("accountadmin.jsp");
    }
}
