package com.webapp.lay.mor.servlets;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/captche")
public class CaptcheServlet extends HttpServlet {
    private final int WIDTH = 80;
    private final int HEIGHT = 36;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BufferedImage bufferedImage = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.getGraphics();

        g.setColor(new Color(255,255,255));
        g.fillRect(0,0,WIDTH,HEIGHT);

        String key = "ABCDEFGHJKLMNPQRSTUVWXY3456789abcdefghjkmnpqrstuvwxy";
        StringBuffer code = new StringBuffer();
        Random random = new Random();
        int pot;

        for(int i=0;i<=100;i++){
            pot = random.nextInt(key.length());
            int x=random.nextInt(WIDTH);
            int y=random.nextInt(HEIGHT);
            g.setColor(new Color(random.nextInt(100)+155,random.nextInt(100)+155,random.nextInt(100)+155));
            g.setFont(new Font("Times New Roman",Font.ITALIC,8));
            g.drawString(key.substring(pot,pot+1),x,y);
        }

        for(int i=0;i<4;i++){
            pot = random.nextInt(key.length());
            g.setColor(new Color(random.nextInt(88),random.nextInt(188),random.nextInt(255)));
            g.setFont(new Font("Times New Roman",Font.BOLD,20));
            g.drawString(key.substring(pot,pot+1),(i*18)+random.nextInt(8)+3,random.nextInt(16)+16);
            code.append(key.substring(pot,pot+1));
        }

        //用Session保存生成的验证码
        req.getSession().setAttribute("code",code.toString().toLowerCase());

        ServletOutputStream sos = resp.getOutputStream();
        ImageIO.write(bufferedImage,"jpeg",sos);

        g.dispose();
        sos.flush();
        sos.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
