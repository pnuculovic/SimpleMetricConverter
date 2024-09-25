import java.util.Scanner;

public class Assignment3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        // Display welcome message
        System.out.println("Welcome to the Metric Converter!");
        System.out.println("Please input your query in the format: <number> <metric_from> = <metric_to>");
        System.out.println("For example: 1 km = mile.");
        System.out.println("Enter 'exit' or '-1' to exit the program.");

        // Loop to process user input until 'exit' or '-1'
        while (true) {
            System.out.print("\nEnter your conversion query: ");
            input = scanner.nextLine().toLowerCase();

            // Exit condition
            if (input.equals("exit") || input.equals("-1")) {
                System.out.println("Exiting the Metric Converter. Goodbye!");
                break;
            }

            // Split input into parts
            String[] parts = input.split(" ");
            if (parts.length != 4 || !parts[2].equals("=")) {
                System.out.println("Invalid format. Please input your query like this: 1 kg = lb.");
                continue;
            }

            // Parse input values
            double value;
            try {
                value = Double.parseDouble(parts[0]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please try again.");
                continue;
            }

            String fromUnit = parts[1];
            String toUnit = parts[3];

            // Perform conversion using if-else
            double result = -1;
            if (fromUnit.equals("kg") && toUnit.equals("lb")) {
                result = value * 2.20462;
            } else if (fromUnit.equals("g") && toUnit.equals("oz")) {
                result = value * 0.035274;
            } else if (fromUnit.equals("km") && toUnit.equals("mile")) {
                result = value * 0.621371;
            } else if (fromUnit.equals("mm") && toUnit.equals("inch")) {
                result = value * 0.0393701;
            } else {
                System.out.println("Conversion not supported. Please try another query.");
                continue;
            }

            // Display conversion result
            System.out.println(value + " " + fromUnit + " = " + result + " " + toUnit);
        }

        scanner.close();
    }
}
