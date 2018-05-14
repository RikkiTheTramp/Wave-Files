import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by RikkiTheTramp on 13/05/18.
 */
public class WaveFileReader {

    private final ChunkReader reader;
    private final Map<String, ChunkMaker> chunkMaker = new HashMap<>();

    public WaveFileReader(File file) throws IOException {
        this.reader = new ChunkReader(file);
        chunkMaker.put(Arrays.toString(new int[] {'f', 'a', 'c', 't'}), new FactChunkMaker());
        chunkMaker.put(Arrays.toString(new int[] {'f', 'm', 't', ' '}), new FmtChunkMaker());
        chunkMaker.put(Arrays.toString(new int[] {'J', 'U', 'N', 'K'}), new JunkChunkMaker());
        chunkMaker.put(Arrays.toString(new int[] {'d', 'a', 't', 'a'}), new DataChunkMaker());
        chunkMaker.put(Arrays.toString(new int[] {'b', 'e', 'x', 't'}), new BextChunkMaker());
    }

    public WaveFile getWaveFile() throws IOException {
        WaveFile wf = new WaveFile();

        List<Chunk> chunks = new ArrayList<>();

        //maak RiffChunk
        chunks.add(new RiffChunk(reader.read(4), reader.read(4), reader.read(4)));


        //extract alle andere chunks tot aan de data chunk

        Chunk chunk = getNextChunk();
        while (chunk.getType() != ChunkType.DATA){
            chunks.add(chunk);
            chunk = getNextChunk();
        }
        chunks.add(new DataChunk(reader.read(4), reader.read(4)));
        wf.addChunks(chunks);
        reader.close();
        return wf;
    }

    /**
     * Methodes om de aparte chunks te krijgen
     */
    private Chunk getNextChunk() throws IOException {
        byte[] id = reader.read(4);
        byte[] size = reader.read(4);
        Chunk chunk = createChunk(id, size);
        byte[] data = reader.read((int) chunk.getSize());
        chunk.extractData(data);
        return chunk;
    }

    private Chunk createChunk(byte[] id, byte[] size) {
        return chunkMaker.get(Arrays.toString(id)).create(id, size);
    }
}
