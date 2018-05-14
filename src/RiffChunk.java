/**
 * Created by RikkiTheTramp on 13/05/18.
 */
public class RiffChunk extends Chunk{

    private String format;

    public RiffChunk(byte[] id, byte[] size, byte[] format){
        super(id, size);
        extractData(format);
    }

    public String dataToString(){
        return "Format: " + format;
    }

    @Override
    public ChunkType getType() {
        return ChunkType.RIFF;
    }

    public void extractData(byte[] data) {
        this.format = extractString(data);
    }

    public String getFormat() {
        return format;
    }

}
