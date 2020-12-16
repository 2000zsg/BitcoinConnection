package com.btc.rpc;

import entity.*;

import java.util.ArrayList;
import java.util.List;

public class TestBc {
    public static void main(String[] args) {
        BTCService service = new BTCService();
        //测试：获取当前节点的区块链的信息
        BlockChainInfo chainInfo = service.getBlockChainInfo();
        if (chainInfo != null) {
            System.out.println("当前节点区块难度：" + chainInfo.getDifficulty());
            System.out.println("当前节点区块数：" + chainInfo.getBlocks());
            SoftForks softForks = chainInfo.getSoftforks();
            System.out.println("bip34高度:" + softForks.getBip34().getHeight()    );
            System.out.println("bip66高度:" + softForks.getBip66().getHeight());
        }

        //  for (String )
        //测试：获取指定高度的区块的hash值
        String hash = service.getBlockHash(0);
        System.out.println("该区块的hash:" + hash);
        //测试：根据hash获取区块的信息
        Block data = service.getBlock(hash);
        System.out.println("区块交易信息:" + data.getTx());
        //测试:获取节点的区块总数
        int count = service.getBlockCount();
        System.out.println("区块的总个数:" + count);
        //生成一个新的比特币地址
        String address = service.getnewAddress(null, null);
        String address1 = service.getnewAddress("yhw", ADDRESS_TYPE.P2SH_SEGWTI);
        String address2 = service.getnewAddress("jr", ADDRESS_TYPE.LEGACY);
        System.out.println("新地址是：" + address);
        System.out.println("新地址是：" + address1);
        System.out.println("新地址是：" + address2);
        System.out.println("=========作业=========");
        //1.获取当前区块的难度
        String difficulty = service.getDifficulty();
        System.out.println("当前区块的难度：" + difficulty);
        //2.基于最近n个区块估算的全网每秒可生成的哈希数量。
        String hashNumber = service.getnetworkhashps(-1, -1);
        System.out.println("根据区块每秒生成的哈希数量：" + hashNumber);
        //3.钱包交易支付时采用的每千字节手续费率。
        String rate = service.setTxfee(2);
        System.out.println(rate);
        //4.节点旳内存交易池信息
        Trading trading = service.getMempoolinfo();
        System.out.println("池内交易数量：" + trading.getSize());
        //5.检查区块返回验证结果
        String verify = service.veriFychain(Checklevel.oneRank, 10);
        System.out.println("验证区块返回结果：" + verify);
        //6调用返回挖矿相关的信息
        miningMessage Message = service.getMininginfo();
        System.out.println("本地最高位区块的高度:" + Message.getBlocks());
        System.out.println("内存交易池中的交易数量:" + Message.getPooledtx());
        //7调用返回确认的UTXO集合的统计信息.
        UTXOMessage utxoMessage = service.getTxoutsetinfo();
        System.out.println("utxo总数:" + utxoMessage.getTxouts());
        System.out.println("包含utxo的交易数量:" + utxoMessage.getTransactions());
        //8.验证地址有效性
        AddressMessage addressMessage = service.validateAddress(address2);
        System.out.println("地址是否有效:" + addressMessage.isIsvalid());
        //9.修改钱包密码
//        String passwode = service.walletPassPhrasechange("111111","123456");
//        System.out.println(passwode);
        //10.调用远程关闭节点软件
//        String stop=service.stop();
//        System.out.println("关闭比特币："+stop);
    }
}
