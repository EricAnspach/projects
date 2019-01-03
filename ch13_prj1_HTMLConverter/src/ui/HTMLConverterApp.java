package ui;

public class HTMLConverterApp {

    public static void main(String[] args) {

        System.out.println("HTML Converter");

        System.out.println("\nINPUT");
        String html =   "<h1>Grocery List</h1>\n" +
                        "<ul>\n" +
                        "   <li>Eggs</li>\n" +
                        "   <li>Milk</li>\n" +
                        "   <li>Butter</li>\n" +
                        "<ul>";

        System.out.println(html);

        System.out.println("\nOUTPUT");

        String[] htmlLines = html.split("\n");
        String output = "";
        for (String h : htmlLines) {
            output += h.trim() + "\n";
        }

        output = output.replace("<h1>", "")
                .replace("</h1>", "")
                .replace("<ul>", "")
                .replace("<li>", "* ")
                .replace("</li>", "")
                .replace("</ul>", "")
                .replace("\n\n", "\n");

        System.out.println(output);

    }
}
