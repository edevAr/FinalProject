package DecoratorPattern;

public class MKV implements Extension {
    private static final String EXTENSION = ".mkv";
    @Override
    public String getExtension() {
        return EXTENSION;
    }
}
