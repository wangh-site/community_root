package com.wangh.community_root.utils;
import tk.mybatis.mapper.genid.GenId;
import java.util.UUID;

public class UUIdGenId implements GenId<String> {
    @Override
    public String genId(String s, String s1) {
        return UUID.randomUUID().toString().substring(20);
    }
}