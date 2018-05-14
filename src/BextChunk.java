/**
 * Created by RikkiTheTramp on 14/05/18.
 */
public class BextChunk extends Chunk {

    public BextChunk(int[] id, int[] size) {
        super(id, size);
    }

    @Override
    public void extractData(int[] data) {
        //Weet Niet Wat er In staat
    }

    @Override
    protected String dataToString() {
        return "Data: not known";
    }

    @Override
    public ChunkType getType() {
        return ChunkType.BEXT;
    }
}
