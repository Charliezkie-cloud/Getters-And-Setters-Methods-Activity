import java.math.BigDecimal;
import java.security.SecureRandom;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 * Concept and featured used:
 * - Encapsulation
 * - Getters and setters
 * - Constructor
 * - Constructor overloading
 */
public class CertOfDeposit {
    private final DateTimeFormatter dateTimeUsFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.US);
    private final NumberFormat usCurrencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);

    private int certificateNumber;
    private String lastName;
    private BigDecimal balance;
    private LocalDate issueDate;
    private LocalDate maturityDate;

    public CertOfDeposit(int certificateNumber, String lastName, BigDecimal balance, LocalDate issueDate, LocalDate maturityDate) {
        this.certificateNumber = certificateNumber;
        this.lastName = lastName;
        this.balance = balance;
        this.issueDate = issueDate;
        this.maturityDate = maturityDate;
    }

    public CertOfDeposit(int certificateNumber, String lastName, BigDecimal balance, LocalDate issueDate, int maturityDays) {
        this.certificateNumber = certificateNumber;
        this.lastName = lastName;
        this.balance = balance;
        this.issueDate = issueDate;

        setMaturityDate(LocalDate.now().plusDays(maturityDays));
    }

    public CertOfDeposit(String lastName, BigDecimal balance, LocalDate issueDate, LocalDate maturityDate) {
        SecureRandom secureRandom = new SecureRandom();

        this.certificateNumber = secureRandom.nextInt();
        this.lastName = lastName;
        this.balance = balance;
        this.issueDate = issueDate;
        this.maturityDate = maturityDate;
    }

    // Getters
    public int getCertificateNumber() { return certificateNumber; }
    public String getLastName() { return lastName; }
    public BigDecimal getBalance() { return balance; }
    public LocalDate getIssueDate() { return issueDate; }
    public LocalDate getMaturityDate() { return maturityDate; }

    // Setters (E butang nalang na ara gud bahalag dili magamit)
    public void setCertificateNumber(int certificateNumber) { this.certificateNumber = certificateNumber; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }
    public void setIssueDate(LocalDate issueDate) { this.issueDate = issueDate; }
    public void setMaturityDate(LocalDate maturityDate) { this.maturityDate = maturityDate; }

    // Polymorphism
    @Override
    public String toString() {
        System.out.println("==================== RESULT ====================");
        System.out.printf("Certificate number: %d\n", getCertificateNumber());
        System.out.printf("Last name: %s\n", getLastName());
        System.out.printf("Balance: %s\n", usCurrencyFormatter.format(getBalance()));
        System.out.printf("Issue date: %s\n", getIssueDate().format(dateTimeUsFormatter));
        System.out.printf("Maturity date: %s\n", getMaturityDate().format(dateTimeUsFormatter));

        return super.toString();
    }
}
