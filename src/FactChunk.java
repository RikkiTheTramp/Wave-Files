/**
 * Created by RikkiTheTramp on 14/05/18.
 */
public class FactChunk extends Chunk {

    private long numberOfSamplesPerChannel;

    public FactChunk(byte[] id, byte[] size) {
        super(id, size);
    }

    @Override
    public void extractData(int[] data) {
        this.numberOfSamplesPerChannel = extractLong(data);
    }

    @Override
    protected String dataToString() {
        return "Numbers of Samples Per Channel: " + numberOfSamplesPerChannel;
    }

    @Override
    public ChunkType getType() {
        return ChunkType.FACT;
    }
}
