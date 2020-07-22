package setest;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.sun.javafx.fxml.expression.Expression.add;

public class RenameFIle {

    public static Map<String, String> ipToServiceName = new HashMap<String, String>() {{
        add("10.129.6.95", "s");
    }};
    public static void main(String[] args) {
        String awrFilePath = "D:";
        renameFile(awrFilePath);

    }

    public static void renameFile(String filepath) {
        ArrayList<String> files = new ArrayList<String>();
        File file = new File(filepath);
        File[] tempLists = file.listFiles();
        for (int i = 0; i < tempLists.length; i++) {
            File templeFile = tempLists[i];
            String oldName = templeFile.toString();
            System.out.println("改名前的名字是：" + oldName);
            String newName = getNewName(oldName);
            System.out.println("改名后的名字是:" + newName);
            if (!oldName.equals(newName)) {
                templeFile.renameTo(new File(newName));
            }
        }
    }


    public static String getNewName(String oldName) {
        String[] preName = oldName.split("\\.xlsx");
        if (preName.length == 1) {
            String realName = preName[0];
            String serviceName = ipToServiceName.get(realName.split("_")[0]);
            return realName + " " + serviceName + "\\.xlsx";
        } else {
            return oldName;
        }

    }



    /**
     * 修改 status文件名称
     * @param dirPath
     */
    public static void modStatusFileName(String dirPath) {
        File dir = new File(dirPath);
        if(dir.isDirectory()) {
            File[] files = dir.listFiles();
            for(File file : files) {
                String fileName = file.getName();
                System.out.println(fileName);

                String ip = null;
                if(fileName.indexOf('_') != -1) {
                    ip = fileName.split("_")[1];
                }

                if(ipToServiceName.containsKey(ip)) {
                    String chName = ipToServiceName.get(ip);
                    String newFileName = dirPath + "/" + fileName + " " + chName;
                    System.out.println(newFileName);
                    // 重命名
                    file.renameTo(new File(newFileName));
                } else {
                    System.out.println(fileName + "文件不在数据字典中");
                }

            }
        } else {
            System.out.println("非目录");
        }
    }
}
