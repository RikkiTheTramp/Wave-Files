/**
 * Created by RikkiTheTramp on 16/05/18.
 */
public class PadChunkMaker extends ChunkMaker {
    @Override
    public Chunk create(int[] id, int[] size) {
        return new PadChunk(id, size);
    }
}
