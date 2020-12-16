package entity;

import java.util.ArrayList;
import java.util.List;

public class BlockChainInfo {
    private int headers;
    private String chain;
    private long size_on_disk;
    private long mediantime;
    private int blocks;
    private boolean pruned;
    private String warnings;
    private double difficulty;
    private BipSoftforks bip9_softforks;
    private String chainwork;
    private double verificationprogress;
    private String bestblockhash;
    private boolean initialblockdownload;
    private SoftForks softforks;

    public int getHeaders() {
        return headers;
    }

    public void setHeaders(int headers) {
        this.headers = headers;
    }

    public String getChain() {
        return chain;
    }

    public void setChain(String chain) {
        this.chain = chain;
    }

    public long getSize_on_disk() {
        return size_on_disk;
    }

    public void setSize_on_disk(long size_on_disk) {
        this.size_on_disk = size_on_disk;
    }

    public long getMediantime() {
        return mediantime;
    }

    public void setMediantime(long mediantime) {
        this.mediantime = mediantime;
    }

    public int getBlocks() {
        return blocks;
    }

    public void setBlocks(int blocks) {
        this.blocks = blocks;
    }

    public boolean isPruned() {
        return pruned;
    }

    public void setPruned(boolean pruned) {
        this.pruned = pruned;
    }

    public String getWarnings() {
        return warnings;
    }

    public void setWarnings(String warnings) {
        this.warnings = warnings;
    }

    public double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(double difficulty) {
        this.difficulty = difficulty;
    }

    public BipSoftforks getBip9_softforks() {
        return bip9_softforks;
    }

    public void setBip9_softforks(BipSoftforks bip9_softforks) {
        this.bip9_softforks = bip9_softforks;
    }

    public String getChainwork() {
        return chainwork;
    }

    public void setChainwork(String chainwork) {
        this.chainwork = chainwork;
    }

    public double getVerificationprogress() {
        return verificationprogress;
    }

    public void setVerificationprogress(double verificationprogress) {
        this.verificationprogress = verificationprogress;
    }

    public String getBestblockhash() {
        return bestblockhash;
    }

    public void setBestblockhash(String bestblockhash) {
        this.bestblockhash = bestblockhash;
    }

    public boolean isInitialblockdownload() {
        return initialblockdownload;
    }

    public void setInitialblockdownload(boolean initialblockdownload) {
        this.initialblockdownload = initialblockdownload;
    }

    public SoftForks getSoftforks() {
        return softforks;
    }

    public void setSoftforks(SoftForks softforks) {
        this.softforks = softforks;
    }
}
