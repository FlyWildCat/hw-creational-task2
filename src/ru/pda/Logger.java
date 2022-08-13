package ru.pda;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm:ss");
    protected int num = 1;

    private static Logger logger = null;

    private Logger() {}

    public static Logger getInstance() {
        if (logger == null) logger = new Logger();
        return logger;
    }

    public void log(String msg) {
        System.out.printf("[ %d %s ] %s", num++, LocalDateTime.now().format(DATE_FORMAT), msg);
//        System.out.println("[" + num++ + " " +
//                "] " + msg);
    }
}
