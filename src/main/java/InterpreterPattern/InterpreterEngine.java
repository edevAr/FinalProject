package InterpreterPattern;

import FactoryMethodPattern.IFile;
import FactoryMethodPattern.IFolder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InterpreterEngine {
    public List<IFile> And(String input,IFolder root){
        List<IFile> result = new ArrayList<>();
        List<IFile> toClient = handleAndLogic(input, root, result);
        return toClient;
    }
    private List<IFile> handleAndLogic(String input, IFolder root, List<IFile> resultFiles){
        List<IFolder> childFolders = root.getChildrenFolder();
        List<IFile> childFiles = root.getChildrenFile();
        if(childFolders.size() > 0){
            for (IFolder childFolder : childFolders) {
                if(childFolder.getChildrenFolder().size() > 0)
                    And(input, childFolder);
                if(childFolder.getChildrenFile().size() > 0){
                    List<IFile> files = childFolder.getChildrenFile();
                    for (IFile file : files) {
                        if(file.getExtension().getExtension().equalsIgnoreCase(".mp4")
                        && file.getName().contains("cat")){
                            resultFiles.add(file);
                        }
                    }
                }
            }
        }
        if(childFiles.size() > 0){
            for (IFile file : childFiles) {
                if(file.getExtension().getExtension().equalsIgnoreCase(".mp4")
                        && file.getName().toLowerCase().contains("cat")){
                    resultFiles.add(file);
                }
            }
        }
        return resultFiles;
    }
    public List<IFile> Or(String input, IFolder root){
        List<IFile> result = new ArrayList<>();
        List<IFile> toClient = handleOrLogic(input, root, result);
        return toClient;
    }
    private List<IFile> handleOrLogic(String input, IFolder root, List<IFile> resultFiles){
        List<IFolder> childFolders = root.getChildrenFolder();
        List<IFile> childFiles = root.getChildrenFile();
        if(childFolders.size() > 0){
            for (IFolder childFolder : childFolders) {
                if(childFolder.getChildrenFolder().size() > 0)
                    And(input, childFolder);
                if(childFolder.getChildrenFile().size() > 0){
                    List<IFile> files = childFolder.getChildrenFile();
                    for (IFile file : files) {
                        if(file.getExtension().getExtension().equalsIgnoreCase(".mp4")
                                || file.getExtension().getExtension().equalsIgnoreCase("mkv")){
                            resultFiles.add(file);
                        }
                    }
                }
            }
        }
        if(childFiles.size() > 0){
            for (IFile file : childFiles) {
                if(file.getExtension().getExtension().equalsIgnoreCase(".mp4")
                        || file.getExtension().getExtension().equalsIgnoreCase(".mkv")){
                    resultFiles.add(file);
                }
            }
        }
        return resultFiles;
    }
    public List<IFile> When(String input, IFolder root){
        return null;
    }
    public List<IFile> At(Date input, IFolder root){
        return null;
    }
    public List<IFile> Who(String input, IFolder root){
        return null;
    }

}
