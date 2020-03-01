package ChainOfResponsibilityPattern;

public interface EmailClient {
    public void setNextEmailClient(EmailClient emailClient);
    public void sentEmail(Email email);
}
