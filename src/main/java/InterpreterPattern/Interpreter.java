package InterpreterPattern;

import FactoryMethodPattern.IFile;
import FactoryMethodPattern.IFolder;

import java.util.List;

public class Interpreter {
    private InterpreterEngine interpreterEngine;

    public Interpreter(){
        interpreterEngine = new InterpreterEngine();
    }
    public List<IFile> interpret(String input, IFolder root){
        Expression expression = null;
        if(input.toLowerCase().contains("and")){
            expression = new AndExpression(input);
        }
        if(input.toLowerCase().contains("or")){
            expression = new OrExpression(input);
        }
        return expression.interpret(interpreterEngine, root);
        /*String example = "United (Arab) Emirates Dirham (AED)";
        Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(example);
        while(m.find()) {
            System.out.println(m.group(1));
        }
        return null;*/
    }
}
