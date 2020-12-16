package com.btc.rpc.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JSONDemo {
    public static void main(String[] args) {
        System.out.println("heelo world");
        //①通过类对象进行序列化和反序列化
        //内存中student对象
        Student student = new Student();
        student.id = "1001";
        student.name = "老王";
        student.sex = "male";
        student.age = 18;
        //序列化后的对象字符串
        String stuJson = JSONObject.toJSON(student).toString();
        System.out.println(stuJson);
        //反序列化变为内存对象；
        Student stu1 = JSON.parseObject(stuJson, Student.class);
        System.out.println(stu1.getName());
        //2、利用JSONObject直接生成；
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "王大锤");
        jsonObject.put("sex", "女");
        jsonObject.put("age", 18);
        jsonObject.put("id","1001");
        String jsonString = jsonObject.toJSONString();
        System.out.println(jsonString);
    }

    static class Student {
        String id;
        String name;
        String sex;
        int age;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}

