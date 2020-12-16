package entity;

public class Trading {
    private boolean loaded;
    private int size;
    private int bytes;
    private int usage;
    private int maxmempool;
    private int mempoolminfee;
    private int minrelaytxfee;

    public boolean isLoaded() {
        return loaded;
    }

    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getBytes() {
        return bytes;
    }

    public void setBytes(int bytes) {
        this.bytes = bytes;
    }

    public int getUsage() {
        return usage;
    }

    public void setUsage(int usage) {
        this.usage = usage;
    }

    public int getMaxmempool() {
        return maxmempool;
    }

    public void setMaxmempool(int maxmempool) {
        this.maxmempool = maxmempool;
    }

    public int getMempoolminfee() {
        return mempoolminfee;
    }

    public void setMempoolminfee(int mempoolminfee) {
        this.mempoolminfee = mempoolminfee;
    }

    public int getMinrelaytxfee() {
        return minrelaytxfee;
    }

    public void setMinrelaytxfee(int minrelaytxfee) {
        this.minrelaytxfee = minrelaytxfee;
    }
}
