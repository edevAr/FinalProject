package FactoryMethodPattern;

import DecoratorPattern.Extension;

import java.util.List;

public interface IFolder {
    public void createFolder(String... name);
    public void deleteFolder(String name);
    public void deleteFile(String name, Extension extension);
    public void renameFolder();
    public void addFolder(IFolder folder);
    public void addFolders(List<IFolder> folders);
    public void addFiles(List<IFile>files);
    public void addFile(IFile file);
    public String getName();
    public List<IFolder> getChildrenFolder();
    public List<IFile> getChildrenFile();
}
