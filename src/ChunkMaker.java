/**
 * Created by RikkiTheTramp on 14/05/18.
 */
public abstract class ChunkMaker implements Createable {

    @Override
    abstract public Chunk create(int[] id, int[] size);
}
