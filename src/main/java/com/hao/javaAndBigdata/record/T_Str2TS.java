package com.hao.javaAndBigdata.record;

import org.junit.Test;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Java页大数据
 * @Date: 2022-08-08:23:54
 * @Describe:
 */
public class T_Str2TS {
    /**
     * 时间字符串转换为时间戳长整型类型，时间戳需要再除以1000L
     * @throws ParseException
     */
    @Test
    public void testParseStr2Ts() throws ParseException {
        String timeStr = "2022-01-20 14:58:23,282";
        String pattern = "yyyy-MM-dd HH:mm:ss,SSS";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date date = format.parse(timeStr);
        long time = date.getTime();
        System.out.println(time);
    }


    /**
     * 逐行读取文本内容并写入新文件
     * @throws IOException
     */
    @Test
    public void testInputAndOutputLine() throws IOException {
        String location = "D:\\test\\aaa.csv";
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(location)));
        String outLocation = "D:\\test\\bbb.csv";
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outLocation)));
        String line = null;
        while ((line = br.readLine()) != null){
            System.out.println(line);
            bw.write(line);
            bw.write("\n");
        }
        bw.close();
        br.close();
    }

    /**
     * 字节流读取文件内容
     * @throws IOException
     */
    @Test
    public void testInputStream() throws IOException {
        String location = "D:\\test\\aaa.csv";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(location));
        byte[] buffer = new byte[1024];
        while (bis.read(buffer,0, 1024) != -1){
            System.out.println(new String(buffer));
        }
        bis.close();
    }


}
