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

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, IOException, ServletException {
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

    private void add(HttpServletRequest req, HttpServletResponse resp) throws InvocationTargetException, IllegalAccessException, IOException {
        PhieuGiamGia cl = new PhieuGiamGia();
        BeanUtils.populate(cl, req.getParameterMap());
        phieuGiamGiaService.add(cl);
        resp.sendRedirect("/phieu-giam-gia/hien-thi");

        PhieuGiamGia cl = new PhieuGiamGia();
                BeanUtils.populate(cl, req.getParameterMap());
                // 2. Lấy idNxb mà người dùng đã chọn từ combobox
                String idNxbStr = req.getParameter("idNxb");

                if (idNxbStr != null && !idNxbStr.isEmpty()) {
                    Integer idNxb = Integer.parseInt(idNxbStr);

                    // 3. Tìm đối tượng Nxb đầy đủ trong CSDL bằng id
                    LoaiPhieuGiamGia nxb = loaiPhieuGiamGiaService.getOne(idNxb);

                    // 4. Gán đối tượng Nxb này vào cho Sách
                    cl.setNxb(nxb);
                }
                sachservice.add(cl);
                resp.sendRedirect("/show");
    }

}