package com.linyy.interest.file.change;

import io.swagger.models.auth.In;

import java.io.*;

/**
 * utf8/gbk等格式转换
 */
public class Utf82gbk {

    public static void exam2(String[] args) {
        // 文件夹转换
        String path = "C:\\Users\\lin\\Desktop\\user-12861224-1616934205\\";
        String path2 = "C:\\Users\\lin\\Desktop\\newpath\\";
        File fileParent = new File(path);
        transformFile(fileParent,path2,0); // 递归
    }

    private static void transformFile(File fileIn,String path,int count) {
        count ++;
        if(fileIn.isFile()){
            utf82gbk(fileIn,path+fileIn.getName());
        }else{
            File[] files = fileIn.listFiles();
            if(files != null) {
                for (int i = 0; i < files.length; i++) {
                    if(count == 1){
                        transformFile(files[i], path, count);
                    }else {
                        transformFile(files[i], path + fileIn.getName() + "\\",count);
                    }
                }
            }
        }
    }

    public static void exam1(String[] args) {
        // 单个文件
        String in  = "C:\\Users\\lin\\Desktop\\user-12861224-1616934205\\编程原理\\html布局.md";
        String out = "C:\\Users\\lin\\Desktop\\user-12861224-1616934206\\编程原理\\html布局2.md";
        utf82gbk(new File(in),out);
    }

    /**
     * utf8转gbk
     * @param fileIn 输入文件
     * @param filePathOut 输出文件
     */
    public static void utf82gbk(File fileIn,String filePathOut) {

        charsetTransform(fileIn,filePathOut,"UTF-8","gbk");
    }

    /**
     * gbk转utf8
     * @param fileIn 输入文件
     * @param filePathOut 输出文件
     */
    public static void gbk2utf8(File fileIn,String filePathOut) {

        charsetTransform(fileIn,filePathOut,"gbk","UTF-8");
    }

    /**
     * 文件格式转换
     * @param fileIn 输入文件
     * @param filePathOut 输出文件
     * @param charsetIn 输入类型
     * @param charsetOut 输出类型
     */
    public static void charsetTransform(File fileIn,String filePathOut,String charsetIn,String charsetOut){

        try {
            FileInputStream fis = new FileInputStream(fileIn);
            InputStreamReader isr = new InputStreamReader(fis,charsetIn);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer sb = new StringBuffer();
            String line = null;
            while((line = br.readLine())!=null){
                sb.append(line).append("\r\n");
            }

            File fout = new File(filePathOut);
            if(!fout.getParentFile().exists()){
                fout.getParentFile().mkdirs();
            }
            FileOutputStream fos = new FileOutputStream(filePathOut);
            OutputStreamWriter osw = new OutputStreamWriter(fos,charsetOut);
            osw.write(sb.toString());
            osw.flush();
            osw.close();
            isr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
