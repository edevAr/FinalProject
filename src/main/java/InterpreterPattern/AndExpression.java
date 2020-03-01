package InterpreterPattern;

import FactoryMethodPattern.IFile;
import FactoryMethodPattern.IFolder;

import java.util.List;

public class AndExpression implements Expression {
    private String expression;
    public AndExpression(String expression){
        this.expression = expression;
    }
    @Override
    public List<IFile> interpret(InterpreterEngine interpreterEngine, IFolder root) {
        return interpreterEngine.And(expression, root);
    }
}
