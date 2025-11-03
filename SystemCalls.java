public class SystemCalls {
    public static void main(String[] args) {

        System.out.println("Operating System: " + System.getProperty("os.name"));

        System.out.println("Version: " + System.getProperty("os.version"));

        System.out.println("Architecture: " + System.getProperty("os.arch"));

        System.out.println("User: " + System.getProperty("user.name"));

        System.out.println("Home Directory: " + System.getProperty("user.home"));

    }
}