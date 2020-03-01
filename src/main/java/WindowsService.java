import DecoratorPattern.MKV;
import DecoratorPattern.MP4;
import DecoratorPattern.Video;
import DecoratorPattern.WAV;
import FactoryMethodPattern.ConcreteItemCreator;
import FactoryMethodPattern.IFile;
import FactoryMethodPattern.IFolder;
import ObserverPattern.Client;
import ObserverPattern.Server;
import SingletonPattern.Rules;


public class WindowsService {
    public static void main(String[]args){
        Rules.addDate("Todos los dias", 20, 46, 0);
        Rules.addDate("Todos los domingos", 20, 47, 0);

        ConcreteItemCreator concreteItemCreator = new ConcreteItemCreator();
        IFile file = concreteItemCreator.createFile("Catrina", new Video(new MP4()));
        IFile otherFormat = concreteItemCreator.createFile("Catalina", new Video(new WAV()));
        IFile mkv = concreteItemCreator.createFile("Gherra de dos mundos", new Video(new MKV()));
        IFolder root = concreteItemCreator.createFolder("Musics");
        root.addFile(file);
        root.addFile(otherFormat);
        root.addFile(mkv);

        Server server = new Server();
        Client client = new Client("Pedro", "pedro@gmail.com");
        Client client1 = new Client("Franklin", "franklin@hotmail.com");

        server.register(client);
        server.register(client1);
        client.setSubject(server);
        client1.setSubject(server);
        server.checkTime(root);

    }
}
