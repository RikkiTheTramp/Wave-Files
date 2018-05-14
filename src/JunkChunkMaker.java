/**
 * Created by RikkiTheTramp on 14/05/18.
 */
public class JunkChunkMaker extends ChunkMaker {
    @Override
    public Chunk create(byte[] id, byte[] size) {
        return new JunkChunk(id, size);
    }
}