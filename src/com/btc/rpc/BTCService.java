package com.btc.rpc;

import com.alibaba.fastjson.JSON;
import entity.*;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 比特币服务类，用于封装rpc各个命令的功能调用方法
 */
public class BTCService {
    private static Map<String, String> map = new HashMap<>();

    static {
        map.put("Encoding", "UTF-8");
        map.put("Content-Type", "application/json");
        map.put("Authorization", "Basic " + RPCUtlis.Base64Str(Constants.RPCUSER + ":" + Constants.RPCPASSWORD));
    }

    /**
     * 根据指定高度获取该高度区块的hash
     *
     * @param height 指定高度
     * @return
     */
    public String getBlockHash(int height) {
        String json = RPCUtlis.prepareJSON("getblockhash", height);
        RPCResult result = RPCUtlis.doPost(Constants.RPCURL, map, json);
        //System.out.println(map);
        if (result == null) {
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            return result.getData().getResult();
        }
        return null;
    }

    /**
     * 获取最新区块的hash
     *
     * @return 返回最新区块的hash值，查询失败返回null
     */
    public String getBestBlockHash() {
        String json = RPCUtlis.prepareJSON("getbestblockhash");
        RPCResult rpcResult = RPCUtlis.doPost(Constants.RPCURL, map, json);
        if (rpcResult == null) {
            return null;
        }
        if (rpcResult.getCode() == HttpStatus.SC_OK) {
            return rpcResult.getData().getResult();
        }
        return null;//空代表请求失败
    }


    /**
     * 根据区块hash获取区块信息
     *
     * @param hash 指定区块的hash
     * @return 指定区块的信息
     */
    public Block getBlock(String hash) {
        String json = RPCUtlis.prepareJSON("getblock", hash);
        RPCResult result = RPCUtlis.doPost(Constants.RPCURL, map, json);
        if (result == null) {
            return null;
        }
        // System.out.println(result.getCode());
        if (result.getCode() == HttpStatus.SC_OK) {
            String jsonStr = result.getData().getResult();
            return JSON.parseObject(jsonStr, Block.class);
        }
        return null;
    }

    /**
     * 该方法用于获取比特币当前节点的区块数
     *
     * @return节点的区块数量
     */
    public int getBlockCount() {
        String json = RPCUtlis.prepareJSON("getblockcount");
        RPCResult result = RPCUtlis.doPost(Constants.RPCURL, map, json);
        if (result.getCode() == HttpStatus.SC_OK) {
            String count = result.getData().getResult();
            return Integer.parseInt(count);
        }
        return -1;
    }

    /**
     * 获取区块链节点的信息
     *
     * @return返回区块链信息类对象
     */
    public BlockChainInfo getBlockChainInfo() {
        String json = RPCUtlis.prepareJSON("getblockchaininfo");
        RPCResult result = RPCUtlis.doPost(Constants.RPCURL, map, json);
        if (result == null) {
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            String data = result.getData().getResult();
            return JSON.parseObject(data, BlockChainInfo.class);
        }
        return null;
    }

    /**
     * 生成一个新的比特币地址
     *
     * @param labey        标签，可以自定义指定
     * @param address_type 地址的类型，
     * @return
     */
    public String getnewAddress(String labey, ADDRESS_TYPE address_type) {
        String json = null;
        if (address_type != null && labey != null) {
            String type = EnumUtils.getAddressType(address_type);
            json = RPCUtlis.prepareJSON("getnewaddress", labey, type);
        }
        if (address_type == null && labey == null) {
            json = RPCUtlis.prepareJSON("getnewaddress");
        }
        RPCResult result = RPCUtlis.doPost(Constants.RPCURL, map, json);
        if (result == null) {
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            return result.getData().getResult();
        }
        return null;
        //String type = EnumUtils.getAddressType(address_type);
        //        String json = RPCUtils.prepareJSON("getnewaddress", label, type);
        //        RPCResult rpcResult = RPCUtils.doPost(Constants.RPCURL, map, json);
        //        if (rpcResult == null) {
        //            return null;
        //        }
        //        if (rpcResult.getCode() == HttpStatus.SC_OK) {
        //            return rpcResult.getData().getResult();
        //        }
        //        return null;
    }

    //1、返回当前区块难度
    public String getDifficulty() {
        String json = RPCUtlis.prepareJSON("getdifficulty");
        RPCResult result = RPCUtlis.doPost(Constants.RPCURL, map, json);
        if (result == null) {
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            return result.getData().getResult();

        }
        return null;
    }

    /**
     * 返回基于最近n个区块估算的全网每秒可生成的哈希数量。
     *
     * @param Blocks 用于估算的区块数量，默认值：120，设置为-1则使用自上次难度变化之后的所有区块进行估算
     * @param Height 用于计算平均值的最后一个区块高度。默认值：-1，表示使用最高位区块
     * @return 返回基于最近n个区块估算的全网每秒可生成的哈希数量。
     */
    public String getnetworkhashps(int Blocks, int Height) {
        String json = RPCUtlis.prepareJSON("getnetworkhashps", Blocks, Height);
        RPCResult result = RPCUtlis.doPost(Constants.RPCURL, map, json);
        if (result == null) {
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            return result.getData().getResult();
        }
        return null;
    }

    /**
     * 调用设置钱包交易支付时采用的每千字节手续费率。该调用需要节点启用钱包功能。
     *
     * @param FeePerKB 每千字节的手续费
     * @return 调用在成功时返回true
     */
    public String setTxfee(float FeePerKB) {
        String json = RPCUtlis.prepareJSON("settxfee", FeePerKB);
        RPCResult result = RPCUtlis.doPost(Constants.RPCURL, map, json);
        if (result == null) {
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            return result.getData().getResult();
        }
        return null;
    }

    /**
     * 调用返回节点旳内存交易池信息
     *
     * @return
     */
    public Trading getMempoolinfo() {
        String json = RPCUtlis.prepareJSON("getmempoolinfo");
        RPCResult result = RPCUtlis.doPost(Constants.RPCURL, map, json);
        if (result == null) {
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            String jsonStr = result.getData().getResult();
            return JSON.parseObject(jsonStr, Trading.class);
        }
        return null;
    }

    /**
     * 检查区块返回验证结果，true或false
     *
     * @param checkLevel  指定检查的细致等级，0~4，默认值：3，等级越高 检查越细致。
     * @param NumOfBlocks 要检查的区块数量，0表示检查所有区块，默认值：288
     * @return 调用返回验证结果，true或false
     */
    public String veriFychain(Checklevel checkLevel, int NumOfBlocks) {
        int price = ChecklevelUtils.Arguments(checkLevel);
        String json = RPCUtlis.prepareJSON("verifychain", price, NumOfBlocks);
        RPCResult result = RPCUtlis.doPost(Constants.RPCURL, map, json);
        if (result == null) {
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            return result.getData().getResult();
        }
        return null;
    }

    /**
     * 调用返回挖矿相关的信息
     *
     * @return
     */
    public miningMessage getMininginfo() {
        String json = RPCUtlis.prepareJSON("getmininginfo");
        RPCResult result = RPCUtlis.doPost(Constants.RPCURL, map, json);
        if (result == null) {
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            String jsonStr = result.getData().getResult();
            return JSON.parseObject(jsonStr, miningMessage.class);
        }
        return null;
    }

    /**
     * 调用返回确认的UTXO集合的统计信息.
     *
     * @return
     */
    public UTXOMessage getTxoutsetinfo() {
        String json = RPCUtlis.prepareJSON("gettxoutsetinfo");
        RPCResult result = RPCUtlis.doPost(Constants.RPCURL, map, json);
        if (result == null) {
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            String jsonStr = result.getData().getResult();
            return JSON.parseObject(jsonStr, UTXOMessage.class);
        }
        return null;
    }

    /**
     * 验证地址有效性
     *
     * @param address 地址
     * @return 调用返回指定比特币地址的相关信息
     */
    public AddressMessage validateAddress(String address) {
        String json = RPCUtlis.prepareJSON("validateaddress", address);
        RPCResult result = RPCUtlis.doPost(Constants.RPCURL, map, json);
        if (result == null) {
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            String jsonStr = result.getData().getResult();
            return JSON.parseObject(jsonStr, AddressMessage.class);
        }
        return null;
    }

    /**
     * 修改钱包密码
     *
     * @param oldpassphrase 旧密码
     * @param newpassphrase 新密码
     * @return 返回修改钱包密码
     */
    public String walletPassPhrasechange(String oldpassphrase, String newpassphrase) {
        String json = RPCUtlis.prepareJSON("walletpassphrasechange", oldpassphrase, newpassphrase);
        RPCResult result = RPCUtlis.doPost(Constants.RPCURL, map, json);
        if (result.getCode() == HttpStatus.SC_OK) {
            return result.getData().getResult();
        }
        return null;
    }

    /**
     * 调用远程关闭节点软件
     *
     * @return
     */
    public String stop() {
        String json = RPCUtlis.prepareJSON("stop");
        RPCResult result = RPCUtlis.doPost(Constants.RPCURL, map, json);
        if (result.getCode() == HttpStatus.SC_OK) {
            return result.getData().getResult();
        }
        return null;
    }
}
