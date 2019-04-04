package com.controller;

import com.Shortener;
import com.strategy.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/shortener")
public class Controller extends HttpServlet {
    private Shortener shortener;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StorageStrategy storageStrategy = null;

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

    }
}
