package com.baizhi.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

public class FilePrintUtil {
    /**
     * 对于选中的段落，逐行读取，将其中的每一行通过流的形式打印出来，并存入list中
     * 这个list集合的每一个元素代表此段落的一行内容。
     * 在map中通过每一段的id唯一地关联这一段的内容，将存好的list集合当做map的值存入map中
     * @param realPath  每一个章节的绝对路径
     * @param name  此章节下的某一个段落的名称
     * @param list  将段落的内容逐行拆分，每一行的内容作为一个字符串存入这个list
     *              当中作为其一个子元素
     */
    public void filePrintUtil(String realPath, String name, List<String> list){
        try{
            File file = new File(realPath,name);
            FileInputStream fs = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fs, "UTF-8"));
            String str;
            //while循环控制将每一个段落的内容逐行输出
            while((str = br.readLine()) != null){
                list.add(str);
            }
            br.close();
            fs.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
