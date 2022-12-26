package com.example.mirucasey;

import android.app.Application;

import com.example.mirucasey.service.DBManager;
import com.example.mirucasey.service.NetworkingService;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class MyApp extends Application {

    public static ExecutorService executorService = Executors.newFixedThreadPool(6);
    NetworkingService networkingService = new NetworkingService();
    public DBManager dbManager = new DBManager();
}
