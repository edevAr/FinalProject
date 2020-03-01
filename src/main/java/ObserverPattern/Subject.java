package ObserverPattern;

import FactoryMethodPattern.IFile;

import java.util.List;

public interface Subject {
    public void register(Observer observer);
    public void unregister(Observer observer);
    public void notifyObservers(List<IFile> files);
}
