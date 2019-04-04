package com;

import com.utils.Helper;

public class ExceptionHandler {
    public static void log(Exception e) {
        Helper.printMessage(e.getLocalizedMessage());
    }
}
