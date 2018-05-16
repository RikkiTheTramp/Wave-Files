/**
 * Created by RikkiTheTramp on 16/05/18.
 */
public class PadChunk extends Chunk {

    public PadChunk(int[] id, int[] size) {
        super(id, size);
    }

    @Override
    public void extractData(int[] data) {
        //Not Relevant
    }

    @Override
    protected String dataToString() {
        return "Data: Not Relevant";
    }

    @Override
    public ChunkType getType() {
        return ChunkType.PAD;
    }
}
