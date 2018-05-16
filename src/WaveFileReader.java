import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by RikkiTheTramp on 13/05/18.
 */
public class WaveFileReader implements AutoCloseable{

    private final ChunkReader reader;
    private final Map<String, ChunkMaker> chunkMaker = new HashMap<>();
    private final File file;

    public WaveFileReader(File file) throws IOException {
        this.file = file;
        this.reader = new ChunkReader(file);
        chunkMaker.put(Arrays.toString(new int[] {'f', 'a', 'c', 't'}), new FactChunkMaker());
        chunkMaker.put(Arrays.toString(new int[] {'f', 'm', 't', ' '}), new FmtChunkMaker());
        chunkMaker.put(Arrays.toString(new int[] {'J', 'U', 'N', 'K'}), new JunkChunkMaker());
        chunkMaker.put(Arrays.toString(new int[] {'d', 'a', 't', 'a'}), new DataChunkMaker());
        chunkMaker.put(Arrays.toString(new int[] {'b', 'e', 'x', 't'}), new BextChunkMaker());
        chunkMaker.put(Arrays.toString(new int[] {'L', 'I', 'S', 'T'}), new ListChunkMaker());
        chunkMaker.put(Arrays.toString(new int[] {'P', 'A', 'D', ' '}), new PadChunkMaker());
    }

    public WaveFile getWaveFile() throws IOException, NoRiffHeaderException {
        WaveFile wf = new WaveFile(file.getName());

        List<Chunk> chunks = new ArrayList<>();

        //check als RIFF file is
        int[] check = reader.read(4);
        if (!checkIsRIFF(check)){
            throw new NoRiffHeaderException("Wave file doesn't have RIFF header");
        }

        //extract de size data
        int[] rc = reader.read(4);

        //de totale bytes in het bestand
        long totalBytes = Chunk.extractLong(rc) + 8;

        //maak RiffChunk
        chunks.add(new RiffChunk(check, rc, reader.read(4)));



        //extract alle andere chunks tot aan de data chunk
        Chunk chunk = getNextChunk();
        while (reader.getBytesRead() < totalBytes){
            chunks.add(chunk);
            chunk = getNextChunk();
        }
        chunks.add(chunk);
        wf.addChunks(chunks);
        return wf;
    }

    private boolean checkIsRIFF(int[] check) {
        return check[0] == 'R' && check[1] == 'I' && check[2] == 'F' && check[3] == 'F';
    }

    /**
     * Methodes om de aparte chunks te krijgen
     * @return geeft de nieuwe chunk terug
     */
    private Chunk getNextChunk() throws IOException {
        int[] id = reader.read(4);
        int[] size = reader.read(4);
        Chunk chunk = createChunk(id, size);
        if(chunk.getType() != ChunkType.DATA) {
            int[] data = reader.read(chunk.getSize());
            chunk.extractData(data);
        }else{
            reader.skip(chunk.getSize());
        }
        return chunk;
    }

    private Chunk createChunk(int[] id, int[] size) {
        String s = Arrays.toString(id);
        System.out.println(s);
        ChunkMaker c = chunkMaker.get(s);
        if(c == null){
            return new UnknownChunk(id, size);
        }
        return c.create(id, size);
    }

    @Override
    public void close() throws Exception {
        reader.close();
    }
}
