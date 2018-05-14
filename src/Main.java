import java.io.*;

/**
 * Created by RikkiTheTramp on 13/05/18.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        //System.out.println("Geef een wav-file");
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //String fs = br.readLine();
        //System.out.println(fs);
        File file = new File("/Users/RikkiTheTramp/Desktop/Click(2).wav");
        WaveFileReader wfr = new WaveFileReader(file);
        WaveFile wf = wfr.getWaveFile();

        for(Chunk chunk: wf.getChunks()){
            System.out.println(chunk + "\n");
        }
    }
}
