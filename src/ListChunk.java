import java.util.HashMap;
import java.util.Map;

/**
 * Created by RikkiTheTramp on 15/05/18.
 * List chunks have an extra field with the type p.e. : INFO (cf. WAVE by RIFF chunk)
 */
public class ListChunk extends Chunk {

    private String type;
    private Map<String, String> chunks;

    public ListChunk(int[] id, int[] size) {
        super(id, size);
        chunks = new HashMap<>();
    }

    @Override
    public void extractData(int[] data) {
        type = extractString(data, 0, 4);
        int teller = 4;
        while(teller < size){
            String s2 = "";
            //' ' == eerste printbare character in ASCII
            while(teller < size && data[teller] < ' ') {
                teller++;
            }
            String s1 = extractString(data, teller, teller+4);
            teller += 4;

            while(teller < size && data[teller] < ' ') {
                teller++;
            }
            while (teller < size && data[teller] != '\0'){
                s2 += (char) data[teller];
                teller++;
            }

            if (!s2.equals("")) {
                chunks.put(s1, s2);
            }
            teller++;
        }

    }

    @Override
    protected String dataToString() {
        String s = "Type: " + type + "\n";
        for (String str: chunks.keySet()){
            s += str + ": " + chunks.get(str);
        }
        return s;
    }

    @Override
    public ChunkType getType() {
        return ChunkType.LIST;
    }
}
