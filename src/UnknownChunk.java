/**
 * Created by RikkiTheTramp on 16/05/18.
 */
public class UnknownChunk extends Chunk {

    private int[] data;

    public UnknownChunk(int[] id, int[] size) {
        super(id, size);
    }

    @Override
    public void extractData(int[] data) {
        this.data = data;
    }

    @Override
    protected String dataToString() {
        return "Data: Unknown";
    }

    @Override
    public ChunkType getType() {
        return ChunkType.UNKNOWN;
    }
}
