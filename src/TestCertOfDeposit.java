import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * Name: Charles Henry M. Tinoy Jr.
 * Course, Year & Section: BSIT - 1 - Non-blocked
 */
public class TestCertOfDeposit {
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final int maturityDays = 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Getters and Setters Method Activity by Charles Henry M. Tinoy Jr.");
        System.out.println("==================== INPUT ====================");

        System.out.print("Enter the certificate number: ");
        while (!scanner.hasNextInt()) {
            System.err.print("Invalid input, please try again: ");
            scanner.next();
        }
        int certificateNumber = scanner.nextInt();

        System.out.print("Enter the account name: ");
        scanner.nextLine();
        String name = scanner.nextLine();

        System.out.print("Enter the balance: ");
        while (!scanner.hasNextDouble()) {
            System.err.print("Invalid input, please try again: ");
            scanner.next();
        }
        BigDecimal balance = BigDecimal.valueOf(scanner.nextDouble());

        LocalDate issueDate = null;
        while (issueDate == null) {
            System.out.print("Enter the issue date (Format: yyyy-MM-dd): ");
            String issueDateInput = scanner.next();

            try {
                issueDate = LocalDate.parse(issueDateInput, dateTimeFormatter);
            } catch (DateTimeParseException ex) {
                System.err.printf("Invalid date format: %s, Please try again.\n", issueDate);
            }
        }

        CertOfDeposit certOfDeposit = new CertOfDeposit(certificateNumber, name, balance, issueDate, maturityDays);
        certOfDeposit.toString();

        scanner.close();
    }
}
