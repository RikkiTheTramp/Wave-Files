/**
 * Created by RikkiTheTramp on 14/05/18.
 */
public class DataChunkMaker extends ChunkMaker {
    @Override
    public Chunk create(byte[] id, byte[] size) {
        return new DataChunk(id, size);
    }
}
