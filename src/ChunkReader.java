import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by RikkiTheTramp on 14/05/18.
 */
public class ChunkReader{

    private final FileInputStream stream;

    public ChunkReader(File file) throws FileNotFoundException {
        this.stream = new FileInputStream(file);
    }

    public long skip(long n) throws IOException {
        return stream.skip(n);
    }

    public byte[] read(int n) throws IOException {
        byte[] bytes = new byte[n];
        stream.read(bytes, 0, n);
        return bytes;
    }

    public void close() throws IOException {
        stream.close();
    }
}