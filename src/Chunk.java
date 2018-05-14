/**
 * Created by RikkiTheTramp on 14/05/18.
 */
public abstract class Chunk {

    protected String id;
    protected int size;

    public Chunk(int[] id, int[] size){
        this.id = new String(id, 0, id.length);
        this.size = extractInt(size); // mag naar int geconvert worden want maximale array lengte = max lengte integer
    }

    public abstract void extractData(int[] data);

    protected long extractLong(int[] bytes, int start, int end){
        long sum = 0 ;
        for (int i = start; i < end; i++){
            sum += bytes[i] * Math.pow(256, i - start);
        }
        return sum;
    }

    protected long extractLong(int[] bytes){
        return extractLong(bytes, 0, bytes.length);
    }

    protected int extractInt(int[] bytes, int start, int end) {
        int sum = 0 ;
        for (int i = start; i < end; i++){
            sum += bytes[i] * Math.pow(256, i - start);
        }
        return sum;
    }

    protected int extractInt(int[] bytes){
        return extractInt(bytes, 0, bytes.length);
    }

    protected String extractString(int[] bytes, int start, int end){
        return new String(bytes, start, end);
    }

    protected String extractString(int[] bytes){
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
