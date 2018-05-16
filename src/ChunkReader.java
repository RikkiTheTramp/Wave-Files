import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by RikkiTheTramp on 14/05/18.
 */
public class ChunkReader implements AutoCloseable{

    private final FileInputStream stream;
    private long bytesRead;

    public ChunkReader(File file) throws FileNotFoundException {
        this.stream = new FileInputStream(file);
        bytesRead = 0;
    }

    public long skip(long n) throws IOException {
        bytesRead += n;
        return stream.skip(n);
    }

    /**
     * geeft een integer array terug met de volgende bytes in int waarde
     * @param n hoeveel bytes er gelezen moeten worden
     * @return integer array van bytes met lengte n
     * @throws IOException als er een probleem is bij stream.read()
     */
    public int[] read(int n) throws IOException {
        int[] bytes = new int[n];
        for(int i = 0; i < n; i++){
            bytes[i] = stream.read();
        }
        bytesRead += n;
        return bytes;
    }

    @Override
    public void close() throws Exception {
        stream.close();
    }

    public long getBytesRead() {
        return bytesRead;
    }

    /**
     * Leest 1 byte in en geeft deze terug
     * @return volgende byte of -1 bij end of file
     * @throws IOException bij probleem met stream.read()
     */
    public int read() throws IOException {
        bytesRead ++;
        return stream.read();
    }

    public int[] read(int[] id, int start, int stop) throws IOException {
        for(int i = start; i < stop; i++){
            id[i] = stream.read();
        }
        bytesRead += stop-start;
        return id;
    }
}