package com.controller;

import com.Shortener;
import com.strategy.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
public class Controller extends HttpServlet {
    private Shortener shortener;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = null;

        String string = req.getParameter("string");
        if (req.getParameter("option").equals("full")) {
            result = shortener.getId(string).toString();
        } else if (req.getParameter("option").equals("short")) {
            if (string.matches("\\d")) {
                result = !shortener.containsKey(Long.parseLong(string)) ? "Value does not exist. Try Again" :
                        shortener.getString(Long.parseLong(string));
            } else {
                result = "Invalid data. Please write digit";
            }
        }

        req.setAttribute("result", result);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("result.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StorageStrategy storageStrategy = new DataBaseStorageStrategy();

        String strategy = req.getParameter("strategy");
        switch (strategy) {
            case "DualHashBidiMapStorageStrategy":
                storageStrategy = new DualHashBidiMapStorageStrategy();
                break;
            case "HashBiMapStorageStrategy":
                storageStrategy = new HashBiMapStorageStrategy();
                break;
            case "HashMapStorageStrategy":
                storageStrategy = new HashMapStorageStrategy();
                break;
            case "OurHashBiMapStorageStrategy":
                storageStrategy = new OurHashBiMapStorageStrategy();
                break;
            case "OurHashMapStorageStrategy":
                storageStrategy = new OurHashMapStorageStrategy();
                break;
        }

        shortener = new Shortener(storageStrategy);

        if (storageStrategy instanceof DataBaseStorageStrategy) {
            shortener.setLastId(((DataBaseStorageStrategy) storageStrategy).getLastID());
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("shortener.jsp");
        requestDispatcher.forward(req, resp);
    }
}
