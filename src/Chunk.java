/**
 * Created by RikkiTheTramp on 14/05/18.
 */
public abstract class Chunk {

    protected String id;
    protected int size;

    public Chunk(byte[] id, byte[] size){
        this.id = new String(id, 0, id.length);
        this.size = extractInt(size); // mag naar int geconvert worden want maximale array lengte = max lengte integer
    }

    public abstract void extractData(byte[] data);

    protected long extractLong(byte[] bytes, int start, int end){
        long sum = 0 ;
        for (int i = start; i < end; i++){
            sum += bytes[i] * Math.pow(256, i - start);
        }
        return sum;
    }

    protected long extractLong(byte[] bytes){
        return extractLong(bytes, 0, bytes.length);
    }

    protected int extractInt(byte[] bytes, int start, int end) {
        int sum = 0 ;
        for (int i = start; i < end; i++){
            sum += bytes[i] * Math.pow(256, i - start);
        }
        return sum;
    }

    protected int extractInt(byte[] bytes){
        return extractInt(bytes, 0, bytes.length);
    }

    protected String extractString(byte[] bytes, int start, int end){
        return new String(bytes, start, end);
    }

    protected String extractString(byte[] bytes){
        return extractString(bytes, 0, bytes.length);
    }

    @Override
    public String toString(){
        return "Chunk ID: " + id + "\n" +
                "Chunk Size: " + size + " Bytes\n" +
                dataToString();
    }

    protected abstract String dataToString();

    public String getId(){
        return id;
    }
    public long getSize() {
        return size;
    }

    public abstract ChunkType getType();
}
