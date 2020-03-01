package DecoratorPattern;

public abstract class Multimedia implements Extension{
    protected Extension extension;
    public Multimedia(Extension extension){
        this.extension = extension;
    }

    public String getExtension() {
        return extension.getExtension();
    }
}
