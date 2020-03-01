package InterpreterPattern;

import FactoryMethodPattern.IFile;
import FactoryMethodPattern.IFolder;

import java.util.List;

public class OrExpression implements Expression{

    private String expression;
    public OrExpression(String expression){
        this.expression = expression;
    }

    @Override
    public List<IFile> interpret(InterpreterEngine interpreterEngine, IFolder root) {
        return interpreterEngine.Or(expression, root);
    }
}
