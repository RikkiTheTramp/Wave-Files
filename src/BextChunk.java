/**
 * Created by RikkiTheTramp on 14/05/18.
 */
public class BextChunk extends Chunk {

    public BextChunk(byte[] id, byte[] size) {
        super(id, size);
    }

    @Override
    public void extractData(byte[] data) {
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
