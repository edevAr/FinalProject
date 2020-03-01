package DecoratorPattern;

public  class Video extends Multimedia {

    public Video(Extension extension){
        super(extension);
    }
    public String getExtension() {
        return extension.getExtension();
    }
}
