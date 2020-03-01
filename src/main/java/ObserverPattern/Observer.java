package ObserverPattern;

import FactoryMethodPattern.IFile;

import java.util.List;

public interface Observer {
    public void update(List<IFile> files);
    public void setSubject(Subject subject);
}
