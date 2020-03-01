package ChainOfResponsibilityPattern;

import java.util.regex.Pattern;

public class SentByHotmail implements EmailClient {
    private EmailClient emailClient;
    @Override
    public void setNextEmailClient(EmailClient emailClient) {
        this.emailClient = emailClient;
    }

    @Override
    public void sentEmail(Email email) {
        try{
            if(isValidEmail(email.getTo())){
                if(email.getTo().contains("hotmail")){
                    System.out.println("Enviando Hotmail...");
                    System.out.println(email.toString());
                }else{
                    System.out.println("Cliente: "+email.getTo()+" no soportado");
                }
            }else
                throw new Exception();
        }catch (Exception e){
            System.out.println("Direccion de correo: " +email.getTo()+ " no valido");
        }
    }
    public static boolean isValidEmail(String email)
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
