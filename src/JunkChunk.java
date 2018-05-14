/**
 * Created by RikkiTheTramp on 14/05/18.
 */
public class JunkChunk extends Chunk {

    public JunkChunk(byte[] id, byte[] size) {
        super(id, size);
    }

    @Override
    public void extractData(int[] data) {
        //DO NOTHING
    }

    @Override
    protected String dataToString() {
        return "Data: null";
    }

    @Override
    public ChunkType getType() {
        return ChunkType.JUNK;
    }
}
