package ui;

public class EmailCreatorApp {

    public static void main(String[] args) {

        System.out.println("Email Creator\n");

        String[] csv = {"   james   ,butler,jbutler@gmail.com",
                "Josephine,Darakjy,Josephine_Darakjy@darakjy.org",
                "ART,VENERE,ART@VENERE.ORG"};

        String template =
                "To:      {email}\n" +
                        "From:    noreply@deals.com\n" +
                        "Subject: Deals!\n\n" +
                        "Hi {first_name},\n\n" +
                        "We've got some great deals for you. Check our website!";

        for (String c : csv) {
            String[] inputItems = c.split(",");
            String firstName = inputItems[0];
            String email = inputItems[2];

            firstName = firstName.trim().toLowerCase();
            StringBuilder firstNameSB = new StringBuilder();
            firstNameSB.append(firstName);
            String firstNameFormatted = firstNameSB.substring(0,1);
            firstNameFormatted = firstNameFormatted.toUpperCase();
            firstNameFormatted += firstNameSB.substring(1);
            email = email.trim().toLowerCase();

            String displayTemplate = template.replace("{email}", email);
            displayTemplate = displayTemplate.replace("{first_name}", firstNameFormatted);

            System.out.println("=========================================================");
            System.out.println(displayTemplate);

        }

    }
}
