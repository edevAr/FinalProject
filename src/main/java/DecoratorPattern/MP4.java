package DecoratorPattern;

public class MP4 implements Extension {
    private static final String EXTENSION = ".mp4";
    public MP4() {

    }

    public String getExtension() {
        return EXTENSION;
    }
}
