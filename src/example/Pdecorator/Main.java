package example.Pdecorator;

public class Main {
    public static void main(String[] args) {
        FileStream fileStream = new BufferedStreamReader(new FileStreamReader());
        fileStream.read();
    }
}
interface FileStream {
    void read();
}
class FileStreamReader implements FileStream {
    @Override
    public void read() {
        System.out.println("FileStreamReader");
    }
}

abstract class Decorator implements FileStream {

    FileStream fileStream = null;

    public Decorator(FileStream fileStream) {
        this.fileStream = fileStream;
    }

    public abstract void read();
}

class BufferedStreamReader extends Decorator {

    public BufferedStreamReader(FileStream fileStream) {
        super(fileStream);
    }

    @Override
    public void read() {
        fileStream.read();
        System.out.println("decorator");
    }
}


