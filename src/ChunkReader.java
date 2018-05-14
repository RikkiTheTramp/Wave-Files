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

    public int[] read(int n) throws IOException {
        int[] bytes = new int[n];
        for(int i = 0; i < n; i++){
            bytes[i] = stream.read();
        }

        return bytes;
    }

    public void close() throws IOException {
        stream.close();
    }
}