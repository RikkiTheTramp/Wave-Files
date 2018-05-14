/**
 * Created by RikkiTheTramp on 13/05/18.
 */
public class FmtChunk extends Chunk{

    private int audioFormat;
    private int numChannels;
    private long sampleRate;
    private long byteRate;
    private int blockAlign;
    private int bitsPerSample;

    private int extraParamSize;
    private int[] extraParas = null;

    public FmtChunk(int[] id, int[] size){
        super(id, size);
        extraParamSize = 0;
    }

    @Override
    public void extractData(int[] data) {
        this.audioFormat = extractInt(data, 0, 2);
        this.numChannels =  extractInt(data, 2, 4);
        this.sampleRate = extractLong(data, 4, 8);
        this.byteRate = extractLong(data, 8, 12);
        this.blockAlign = extractInt(data, 12, 14);
        this.bitsPerSample = extractInt(data, 14, 16);
    }

    @Override
    public String dataToString(){
        return "Audio Format: " + audioFormat + "\n" +
        "Nummers of Channels: " + numChannels + "\n" +
         "Sample Rate: " + sampleRate + "\n" +
        "Byte Rate: " + byteRate + "\n" +
        "Block Align: " + blockAlign + "\n" +
        "Bits Per Sample: " + bitsPerSample;
    }

    @Override
    public ChunkType getType() {
        return ChunkType.FMT;
    }


    /**
     * Getters
     */
    public int getAudioFormat() {
        return audioFormat;
    }
    public int getNumChannels() {
        return numChannels;
    }
    public long getSampleRate() {
        return sampleRate;
    }
    public long getByteRate() {
        return byteRate;
    }
    public long getBlockAlign() {
        return blockAlign;
    }
    public int getBitsPerSample() {
        return bitsPerSample;
    }
    public int getExtraParamSize() {
        return extraParamSize;
    }
    public int[] getExtraParas() {
        return extraParas;
    }

    /**
     * Setters
     */
    public void setAudioFormat(int audioFormat) {
        this.audioFormat = audioFormat;
    }
    public void setNumChannels(int numChannels) {
        this.numChannels = numChannels;
    }
    public void setSampleRate(long sampleRate) {
        this.sampleRate = sampleRate;
    }
    public void setByteRate(long byteRate) {
        this.byteRate = byteRate;
    }
    public void setBlockAlign(int blockAlign) {
        this.blockAlign = blockAlign;
    }
    public void setBitsPerSample(int bitsPerSample) {
        this.bitsPerSample = bitsPerSample;
    }
    public void setExtraParamSize(int extraParamSize) {
        this.extraParamSize = extraParamSize;
    }
    public void setExtraParas(int[] extraParas) {
        this.extraParas = extraParas;
    }
}
