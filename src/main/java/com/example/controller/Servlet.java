package com.example.controller;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

import com.example.entity.LoaiPhieuGiamGia;
import com.example.entity.PhieuGiamGia;
import com.example.service.LoaiPhieuGiamGiaService;
import com.example.service.PhieuGiamGiaService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet(urlPatterns = {
        "/phieu-giam-gia/hien-thi",
        "/phieu-giam-gia/add",
        "/phieu-giam-gia/remove"

})
public class Servlet extends HttpServlet {
    public PhieuGiamGiaService phieuGiamGiaService = new PhieuGiamGiaService();
    public LoaiPhieuGiamGiaService loaiPhieuGiamGiaService = new LoaiPhieuGiamGiaService();

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String uri = req.getRequestURI();
        if(uri.contains("/phieu-giam-gia/hien-thi")){
            this.show(req,resp);
        }else if(uri.contains("/phieu-giam-gia/remove")){
            this.remove(req,resp);
        }
    }

    private void remove(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        phieuGiamGiaService.delete(id);
        resp.sendRedirect("/phieu-giam-gia/hien-thi");
    }

    private void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("show", phieuGiamGiaService.getAll());
//        req.setAttribute("showL", loaiPhieuGiamGiaService.getAll());
        req.getRequestDispatcher("/show.jsp").forward(req,resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("/phieu-giam-gia/add")){
            this.add(req,resp);
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws  IOException, ServletException {
        try{
            PhieuGiamGia cl = new PhieuGiamGia();

            // Lấy dữ liệu từ form và gán vào các thuộc tính cùng tên
            BeanUtils.populate(cl, req.getParameterMap());

            // Gọi Service để thêm phiếu vào database
            phieuGiamGiaService.add(cl);

            // Thêm xong thì quay lại trang hiển thị
            resp.sendRedirect("/phieu-giam-gia/hien-thi");
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new ServletException("Lỗi khi lấy dữ liệu từ form", e);
        }



    }

}