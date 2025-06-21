public class VerifyJava25 {
    public static void main(String[] args) {
        System.out.println("Java Version Details:");
        System.out.println("---------------------");
        System.out.println("Java Version: " + System.getProperty("java.version"));
        System.out.println("Java Vendor: " + System.getProperty("java.vendor"));
        System.out.println("Java Home: " + System.getProperty("java.home"));
        System.out.println("Java VM Version: " + System.getProperty("java.vm.version"));
        System.out.println("Java VM Name: " + System.getProperty("java.vm.name"));
        System.out.println("Java Class Version: " + System.getProperty("java.class.version"));
        System.out.println("OS Name: " + System.getProperty("os.name"));
        System.out.println("OS Architecture: " + System.getProperty("os.arch"));
        
        // Check for Java 25 specific features
        try {
            // Try to use a Java 25 feature if available
            System.out.println("\nChecking for Java 25 specific features...");
            // This is just a placeholder - replace with actual Java 25 features when known
            System.out.println("No specific Java 25 features checked.");
        } catch (Exception e) {
            System.out.println("Exception when checking Java 25 features: " + e.getMessage());
        }
    }
}
