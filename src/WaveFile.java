import java.util.List;

/**
 * Created by RikkiTheTramp on 13/05/18.
 *
 * RIFF Chunk
 */
public class WaveFile {

    private String fileName;
    private List<Chunk> chunks;

    public WaveFile(String fileName) {
        this.fileName = fileName;
    }

    public void addChunks(List<Chunk> chunks) {
        this.chunks = chunks;
    }

    public List<Chunk> getChunks() {
        return chunks;
    }

    public String getFileName() {
        return fileName;
    }
}
