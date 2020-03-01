package ObserverPattern;

import ChainOfResponsibilityPattern.Email;
import ChainOfResponsibilityPattern.EmailClient;
import ChainOfResponsibilityPattern.SentByGmail;
import ChainOfResponsibilityPattern.SentByHotmail;
import FactoryMethodPattern.IFile;

import java.net.InetAddress;
import java.util.List;

public class Client implements Observer{

    private String clientName;
    private String email;
    private Subject subject;

    private EmailClient emailClient;

    public Client(String clientName, String email){
        this.clientName = clientName;
        this.email = email;
        emailClient = new SentByGmail();
        emailClient.setNextEmailClient(new SentByHotmail());
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void update(List<IFile> files) {
        try{
            InetAddress inetAddress = InetAddress.getLocalHost();

            Email email = new Email();
            email.setFrom(inetAddress.getHostAddress());
            email.setTo(this.email);
            email.createBody(files);
            emailClient.sentEmail(email);
        }catch (Exception e){

        }
    }

    @Override
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
