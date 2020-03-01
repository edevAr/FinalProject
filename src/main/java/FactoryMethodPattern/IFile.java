package FactoryMethodPattern;

import DecoratorPattern.Extension;

public interface IFile {
    public String getName();
    public Extension getExtension();
    public void rename(String name);
}
