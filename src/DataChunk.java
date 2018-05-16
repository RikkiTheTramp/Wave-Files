/**
 * Created by RikkiTheTramp on 13/05/18.
 */
public class DataChunk extends Chunk{

    private int[] samples;

    public DataChunk(int[] id, int[] size){
        super(id, size);
    }

    @Override
    public void extractData(int[] data) {
        samples = data;
    }

    @Override
    protected String dataToString() {
        return "Data: *Audio Samples*";
    }

    @Override
    public ChunkType getType() {
        return ChunkType.DATA;
    }

    public int[] getSamples() {
        return samples;
    }
}
