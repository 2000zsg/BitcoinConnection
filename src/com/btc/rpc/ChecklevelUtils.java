package com.btc.rpc;

 enum Checklevel {
    zeroRank,
    oneRank,
    twoRank,
    threeRank,
    fourRank
}
public class ChecklevelUtils{
    public static int Arguments(Checklevel checklevel){
       switch (checklevel){
          case zeroRank:
             return 0;
          case oneRank:
             return 1;
          case twoRank:
             return 2;
          case threeRank:
             return 3;
          case fourRank:
             return 4;
          default:
             return -1;
       }
    }
}