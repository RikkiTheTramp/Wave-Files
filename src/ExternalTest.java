import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by RikkiTheTramp on 16/05/18.
 *
 *
 *
 * /Users/RikkiTheTramp/Documents/Pro Tools/Sound Libraries/First Avid Loopmasters 1.0/TURF_SMOKE/KIT LOOPS/Bel Loops/093 mLP Mixx Bel.wav
 found 'RIFF' descriptor
 skip: 8
 found 'fmt ' descriptor
 skip: 16
 found 'data' descriptor
 skip: 1365678
 found 'SAUR' descriptor
 skip: 512
 found 'str2' descriptor
 skip: 20
 found 'bmrk' descriptor
 skip: 316
 found 'dtbt' descriptor
 skip: 244
 found 'acid' descriptor
 skip: 24
 found 'strc' descriptor
 skip: 284
 found 'id3 ' descriptor
 skip: 1214
 found 'minf' descriptor
 skip: 16
 found 'regn' descriptor
 skip: 92
 end of file
 Total bytes in file: 1368516
 */
public class ExternalTest {
    public static void main(String[] args) throws IOException {
        printWaveDescriptors(new File("/Users/RikkiTheTramp/Documents/Pro Tools/Sound Libraries/First Avid Loopmasters 1.0/TURF_SMOKE/KIT LOOPS/Bel Loops/093 mLP Mixx Bel.wav"));
    }

    public static void printWaveDescriptors(File file) throws IOException {
        try (FileInputStream in = new FileInputStream(file)) {
            byte[] bytes = new byte[4];

            long bytesRead = 0;

            // read first 4 bytes
            // should be RIFF descriptor
            if (in.read(bytes) < 0) {
                return;
            }
            bytesRead += 4;
            printDescriptor(bytes);

            // first subchunk will always be at byte 12
            // there is no other dependable constant
            in.skip(8);
            bytesRead += 8;
            System.out.println("skip: 8");

            for (;;) {
                // read each chunk descriptor
                if (in.read(bytes) < 0) {
                    break;
                }
                bytesRead += 4;

                printDescriptor(bytes);

                // read chunk length
                if (in.read(bytes) < 0) {
                    break;
                }
                bytesRead += 4;

                // skip the length of this chunk
                // next bytes should be another descriptor or EOF
                long l = (bytes[0] & 0xFF)
                        | (bytes[1] & 0xFF) << 8
                        | (bytes[2] & 0xFF) << 16
                        | (bytes[3] & 0xFF) << 24;
                System.out.println("skip: " + l);
                in.skip(l);
                bytesRead += l;
            }

            System.out.println("end of file");
            System.out.println("Total bytes in file: " + bytesRead);
        }
    }

    private static void printDescriptor(byte[] bytes)
            throws IOException {
        String desc = new String(bytes, "US-ASCII");
        System.out.println("found '" + desc + "' descriptor");
    }


}
