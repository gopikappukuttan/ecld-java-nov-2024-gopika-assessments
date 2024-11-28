import java.util.Scanner;

public class BmiCalculator {
    public static String BMI(String weight, String height) {

        double weightNew = WeightConversion(weight);
        if (weightNew == -1) {
            return "Invalid weight input. Please use either 'kilos' or 'pounds'.";
        }

        double heightNew = HeightConversion(height);
        if (heightNew == -1) {
            return "Invalid height input. Please use either 'meters' or 'inches'.";
        }

        // Calculate BMI
        double bmi = weightNew / (heightNew * heightNew);
        // BMI categories
        if (bmi < 18.5) {
            return String.format("%.1f Category: Underweight", bmi);
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return String.format("%.1f Category: Normal weight", bmi);
        } else if (bmi >= 25 && bmi <= 29.9) {
            return String.format("%.1f Category: Overweight", bmi);
        } else {
            return String.format("%.1f Category: Obesity", bmi);
        }
    }

    // Weight conversion method
    public static double WeightConversion(String weight) {
        if (weight.contains("pounds")) {
            try {
                double weightInPounds = Double.parseDouble(weight.replace("pounds", "").trim());
                return weightInPounds * 0.453592;  // Convert pounds to kilograms
            } catch (NumberFormatException e) {
                return -1;
            }
        } else if (weight.contains("kilos")) {
            try {
                return Double.parseDouble(weight.replace("kilos", "").trim());
            } catch (NumberFormatException e) {
                return -1;
            }
        }

        return -1;
    }

    // Height conversion method
    private static double HeightConversion(String heightStr) {
        if (heightStr.contains("inches")) {
            try {
                double heightInInches = Double.parseDouble(heightStr.replace("inches", "").trim());
                return heightInInches * 0.0254;  // Convert inches to meters
            } catch (NumberFormatException e) {
                return -1;
            }
        } else if (heightStr.contains("meters")) {
            try {
                return Double.parseDouble(heightStr.replace("meters", "").trim());
            } catch (NumberFormatException e) {
                return -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input validation loop for weight
        String weight;
        while (true) {
            System.out.println("Enter weight in kilos or pounds (specify unit also): ");
            weight = sc.nextLine();
            if (WeightConversion(weight) != -1) {
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid weight (e.g., '70 kilos' or '154 pounds').");
            }
        }

        // Input validation loop for height
        String height;
        while (true) {
            System.out.println("Enter height in meters or inches (specify unit also): ");
            height = sc.nextLine();
            if (HeightConversion(height) != -1) {
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid height (e.g., '1.75 meters' or '70 inches').");
            }
        }

        // Calculate and display BMI category
        System.out.println("BMI Category: " + BMI(weight, height));
    }
}
