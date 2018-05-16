/**
 * Created by RikkiTheTramp on 15/05/18.
 */
public class ListChunkMaker extends ChunkMaker {
    @Override
    public Chunk create(int[] id, int[] size) {
        return new ListChunk(id, size);
    }
}
