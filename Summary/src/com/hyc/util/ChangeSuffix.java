package com.hyc.util;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName ChangeSuffix
 * @Description 修改文件后缀
 * @Author huayingcao2
 * @Date 2018/12/26  9:25
 */
public class ChangeSuffix {

    //    private static final String dir = "C:\\Users\\huayingcao2\\AppData\\Local\\Packages\\Microsoft.Windows.ContentDeliveryManager_cw5n1h2txyewy\\LocalState\\Assets";
    private static final String dir = "E:\\WallPaper";


    public static void changeSuffix(String suffix) {
        File file = new File(dir);
        File[] files = file.listFiles();
        for (File subFile : files) {
            if (subFile.isDirectory()) {
                changeSuffix(subFile.getAbsolutePath());
            } else {
                String fName = subFile.getName();
                String oldPath = subFile.getAbsolutePath();
                String newPath = "";
                if (fName.indexOf(".") != -1) {
                    newPath = oldPath.substring(0, oldPath.indexOf(".") + 1) + suffix;
                } else {
                    newPath = oldPath + "." + suffix;
                }
                subFile.renameTo(new File(newPath));
            }
        }
    }


    public static void main(String[] args) {
        changeSuffix("jpg");
    }
}
