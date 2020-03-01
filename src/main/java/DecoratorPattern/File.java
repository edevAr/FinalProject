package DecoratorPattern;

import FactoryMethodPattern.IFile;

import java.util.Date;

public class File implements IFile {

    private String fileName;
    private Extension extension;
    private Long size;
    private String location;
    private Date created;
    private Date modified;
    private Date opened;

    public File(){

    }
    public File(String fileName, Extension extension){
        this.fileName = fileName;
        this.extension = extension;
        created = new Date();
        modified = created;
        opened = created;

    }

    public String getName() {
        return fileName;
    }

    public Extension getExtension() {
        return extension;
    }

    public void rename(String name) {

    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setExtension(Extension extension) {
        this.extension = extension;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Date getOpened() {
        return opened;
    }

    public void setOpened(Date opened) {
        this.opened = opened;
    }

}
