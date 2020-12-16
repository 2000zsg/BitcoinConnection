package com.btc.rpc;

import java.util.HashMap;
import java.util.Map;

/**
 * 地址类型的枚举，可选值有三个，分别是：legacy,p2sh-segwit,bech32
 */
enum ADDRESS_TYPE {
    LEGACY,
    P2SH_SEGWTI,
    BECH32
}

public class EnumUtils {
    /**
     * 根据枚举返回对应的字符串
     *
     * @param address_type 枚举变量
     * @return 地址类型
     */
    public static String getAddressType(ADDRESS_TYPE address_type) {
        switch (address_type) {
            case BECH32:
                return "bech32";
            case LEGACY:
                return "legacy";
            case P2SH_SEGWTI:
                return "p2sh-segwit";
            default:
                return null;
        }
    }

    private static Map<ADDRESS_TYPE, String> map = new HashMap<ADDRESS_TYPE, String>();

    static {
        map.put(ADDRESS_TYPE.LEGACY, "legacy");
        map.put(ADDRESS_TYPE.P2SH_SEGWTI, "p2sh-segwit");
        map.put(ADDRESS_TYPE.BECH32, "bech32");
    }

    public static String getAddressType2(ADDRESS_TYPE address_type) {
    return map.get(address_type);
    }
}
