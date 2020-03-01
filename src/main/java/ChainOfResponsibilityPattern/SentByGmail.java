package ChainOfResponsibilityPattern;

import java.util.regex.Pattern;

public class SentByGmail implements EmailClient{
    private EmailClient emailClient;
    @Override
    public void setNextEmailClient(EmailClient emailClient) {
        this.emailClient = emailClient;
    }

    @Override
    public void sentEmail(Email email) {
        try{
            if(isValid(email.getTo())){
                if(email.getTo().contains("gmail")){
                    System.out.println("Enviando Gmail...");
                    System.out.println(email.toString());
                }else{
                    emailClient.sentEmail(email);
                }
            }else
                throw new Exception();
        }catch (Exception e){
            System.out.println("Direccion de correo: " +email.getTo()+ " no valido");
        }
    }
    public static boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
}
