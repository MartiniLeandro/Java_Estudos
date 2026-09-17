public class LogLevels {
    
    public static String message(String logLine) {
        String[] partes = logLine.split(":");
        return partes[1].trim();
    }

    public static String logLevel(String logLine) {
        String[] partes = logLine.split(":");
        return partes[0].replace("[","").replace("]","").trim().toLowerCase();
    }

    public static String reformat(String logLine) {
        String[] partes = logLine.split(":");
        return message(logLine) + " " + "(" + logLevel(logLine) + ")";
    }
}
