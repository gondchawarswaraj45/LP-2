import java.util.*;

public class HospitalExpertSystem {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<String> symptoms = new ArrayList<>();

    static void title() {

        System.out.println("==========================================");
        System.out.println("      HOSPITAL EXPERT SYSTEM");
        System.out.println("==========================================");
    }

    static void menu() {

        System.out.println("\nSample Symptoms:");
        System.out.println("1. fever");
        System.out.println("2. cough");
        System.out.println("3. headache");
        System.out.println("4. cold");
        System.out.println("5. stomach pain");
        System.out.println("6. vomiting");
        System.out.println("7. weakness");
        System.out.println("8. body pain");
        System.out.println("\nType stop to finish entering symptoms\n");
    }

    static void inputSymptoms() {

        while (true) {

            System.out.print("Enter symptom: ");

            String s = sc.nextLine().toLowerCase();

            if (s.equals("stop"))
                break;

            symptoms.add(s);
        }
    }

    static void diagnose() {

        System.out.println("\n==========================================");
        System.out.println("              DIAGNOSIS");
        System.out.println("==========================================");

        if (symptoms.contains("fever") &&
                symptoms.contains("cough") &&
                symptoms.contains("headache")) {

            System.out.println("Possible Disease : Flu");
            System.out.println("Severity         : Medium");
            System.out.println("Suggestion       :");
            System.out.println("- Take proper rest");
            System.out.println("- Drink plenty of water");
            System.out.println("- Consult doctor if fever increases");
        }

        else if (symptoms.contains("cold") &&
                symptoms.contains("cough")) {

            System.out.println("Possible Disease : Common Cold");
            System.out.println("Severity         : Low");
            System.out.println("Suggestion       :");
            System.out.println("- Take cold medicine");
            System.out.println("- Avoid cold drinks");
            System.out.println("- Take proper sleep");
        }

        else if (symptoms.contains("stomach pain") &&
                symptoms.contains("vomiting")) {

            System.out.println("Possible Disease : Food Poisoning");
            System.out.println("Severity         : High");
            System.out.println("Suggestion       :");
            System.out.println("- Drink ORS");
            System.out.println("- Avoid outside food");
            System.out.println("- Consult doctor immediately");
        }

        else if (symptoms.contains("weakness") &&
                symptoms.contains("body pain")) {

            System.out.println("Possible Disease : Viral Infection");
            System.out.println("Severity         : Medium");
            System.out.println("Suggestion       :");
            System.out.println("- Take healthy diet");
            System.out.println("- Drink warm water");
            System.out.println("- Take proper medication");
        }

        else {

            System.out.println("No disease matched");
            System.out.println("Please consult doctor for proper diagnosis");
        }
    }

    static void exitMessage() {

        System.out.println("\n==========================================");
        System.out.println("     THANK YOU FOR USING THE SYSTEM");
        System.out.println("==========================================");
    }

    public static void main(String[] args) {

        title();

        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Patient Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.println("\nWelcome " + name);

        menu();

        inputSymptoms();

        diagnose();

        exitMessage();

        sc.close();
    }
}