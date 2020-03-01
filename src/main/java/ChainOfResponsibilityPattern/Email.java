package ChainOfResponsibilityPattern;

import FactoryMethodPattern.IFile;

import java.util.List;

public class Email {
    private String from;
    private String to;
    private String subject;
    private String body;

    public Email() {
    }

    public Email(String from, String to, String subject, String body) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.body = body;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    public void createBody(List<IFile> files){
        body = "Los archivos que coinciden con su criterio de busqueda son: \n";
        for (IFile file : files) {
            body = body + file.getName()+file.getExtension().getExtension()+"\n";
        }
    }
    @Override
    public String toString(){
        return "from: "+from+"\n"+
                "to: "+to+"\n"+
                "subject: "+subject+"\n"+
                "body: "+body+"\n";
    }
}
