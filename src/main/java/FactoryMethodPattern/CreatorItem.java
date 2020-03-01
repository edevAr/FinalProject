package FactoryMethodPattern;

import DecoratorPattern.Extension;

public abstract class CreatorItem {
    public abstract IFile createFile(String name, Extension extension);
    public abstract IFolder createFolder(String name);
}
