package ObserverPattern;

import FactoryMethodPattern.IFile;
import FactoryMethodPattern.IFolder;
import InterpreterPattern.Interpreter;
import SingletonPattern.Rules;
import java.util.ArrayList;
import java.util.List;

public class Server implements Subject {
    private List<Observer> clients;
    private final Object MUTEX = new Object();
    private boolean changed;

    private Interpreter interpreter;

    public Server(){
        clients = new ArrayList<>();
        interpreter = new Interpreter();
    }
    @Override
    public void register(Observer observer) {
        if(null == observer) throw new NullPointerException("Null Observer");
        synchronized (MUTEX){
            if(!clients.contains(observer))
                clients.add(observer);
        }
    }

    @Override
    public void unregister(Observer observer) {
        synchronized (MUTEX){
            clients.remove(observer);
        }
    }

    @Override
    public void notifyObservers(List<IFile> files) {
        List<Observer> clientsLocal = null;
        synchronized (MUTEX){
            if(!changed)
                return;
            clientsLocal = new ArrayList<Observer>(this.clients);
            this.changed = false;
        }
        for (Observer observer : clientsLocal) {
            observer.update(files);
        }
    }
    public void checkTime(IFolder folder){
        try{
            while (true){

                if(Rules.isHour(Rules.getDate("Todos los dias"))){
                    changed = true;
                    notifyObservers(interpretRule(Rules.RULE_ONE, folder));
                }
                if(Rules.isToday(Rules.SATURDAY) && Rules.isHour(Rules.getDate("Todos los domingos"))){
                    changed = true;
                    notifyObservers(interpretRule(Rules.RULE_TWO, folder));
                }
                Thread.sleep(1000);
            }
        }catch (Exception e){
            System.out.println("There is a problem with the server, plese restar the service");
        }
    }
    private List<IFile> interpretRule(String rule, IFolder root){
        return interpreter.interpret(rule, root);
    }
}
