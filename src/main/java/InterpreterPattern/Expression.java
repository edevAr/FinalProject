package InterpreterPattern;

import FactoryMethodPattern.IFile;
import FactoryMethodPattern.IFolder;

import java.util.List;

public interface Expression {
    public List<IFile> interpret(InterpreterEngine interpreterEngine, IFolder root);
}
