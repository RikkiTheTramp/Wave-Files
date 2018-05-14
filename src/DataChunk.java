/**
 * Created by RikkiTheTramp on 13/05/18.
 */
public class DataChunk extends Chunk{

    private byte[] samples;

    public DataChunk(byte[] id, byte[] size){
        super(id, size);
    }

    @Override
    public void extractData(byte[] data) {
        samples = data;
    }

    @Override
    protected String dataToString() {
        return null;
    }

    @Override
    public ChunkType getType() {
        return ChunkType.DATA;
    }

    public byte[] getSamples() {
        return samples;
    }
}
