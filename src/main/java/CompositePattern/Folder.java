package CompositePattern;

import DecoratorPattern.Extension;
import FactoryMethodPattern.IFile;
import FactoryMethodPattern.IFolder;

import java.util.ArrayList;
import java.util.List;

public class Folder implements IFolder {
    private static final String defaultName = "Nuevo Folder";
    private String folderName;
    List<IFolder> folders = new ArrayList<IFolder>();
    List<IFile> files = new ArrayList<IFile>();

    public Folder(){

    }
    public Folder(String name){
        folderName = name;
    }
    public void addFile(IFile file){
        files.add(file);
    }

    public void createFolder(String ...folderName) {
        String name = folderName.length == 0 ? defaultName : folderName[0];
        IFolder folder = new Folder(name);
        folders.add(folder);
    }

    public void deleteFolder(String name) {
        int elementPosition = getPositionElement(name);
        folders.remove(elementPosition);
    }
    private int getPositionElement(String name){
        int position = 0;
        for (int i = 0;i<folders.size(); i++) {
            if(folders.get(i).getName().equals(name))
                position = i;
        }
        return position;
    }
    @Override
    public List<IFolder> getChildrenFolder(){
        return folders;
    }
    @Override
    public List<IFile> getChildrenFile(){
        return files;
    }

    @Override
    public void deleteFile(String name, Extension extension) {

    }

    @Override
    public void renameFolder() {

    }

    @Override
    public void addFolder(IFolder folder) {

    }

    @Override
    public void addFolders(List<IFolder> folders) {

    }

    @Override
    public void addFiles(List<IFile> files) {

    }

    @Override
    public String getName() {
        return null;
    }
}
