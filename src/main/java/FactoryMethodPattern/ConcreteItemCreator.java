package FactoryMethodPattern;

import CompositePattern.Folder;
import DecoratorPattern.Extension;
import DecoratorPattern.File;

public class ConcreteItemCreator extends CreatorItem {
    @Override
    public IFile createFile(String name, Extension extension) {
        return new File(name, extension);
    }

    @Override
    public IFolder createFolder(String name) {
        return new Folder(name);
    }
}
