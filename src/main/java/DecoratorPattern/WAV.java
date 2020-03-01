package DecoratorPattern;

public class WAV implements Extension {
    private static final String EXTENSION = ".wav";
    @Override
    public String getExtension() {
        return EXTENSION;
    }
}
