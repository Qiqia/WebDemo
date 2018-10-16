package example.zsltest;


import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.read.context.AnalysisContext;
import com.alibaba.excel.read.event.AnalysisEventListener;
import com.alibaba.excel.support.ExcelTypeEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zsl on 2018/10/12.
 */
public class EasyExcelDemo {
    public static void main(String[] args) throws Exception{
        EasyExcelDemo demo = new EasyExcelDemo();
        demo.noModelMultipleSheet();
        demo.writeExcelTest();
    }

    /**
     * 读excel的demo
     * @throws Exception
     */
    public void noModelMultipleSheet() throws Exception{
        InputStream inputStream =  new FileInputStream(new File("D:/sheetdemo.xlsx"));
        try {
            ExcelReader reader = new ExcelReader(inputStream, ExcelTypeEnum.XLSX, null,
                    new AnalysisEventListener<List<String>>() {
                        @Override
                        public void invoke(List<String> object, AnalysisContext context) {
                            System.out.println(
                                    "当前sheet:" + context.getCurrentSheet().getSheetNo() + " 当前行：" + context.getCurrentRowNum()
                                            + " data:" + object);
                        }
                        @Override
                        public void doAfterAllAnalysed(AnalysisContext context) {
                            System.out.println("已经全部解析完了");
                        }
                    });

            reader.read();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 写excel的demo
     * @throws FileNotFoundException
     */
    public void writeExcelTest() throws FileNotFoundException{
        OutputStream outputStream = new FileOutputStream(new File("D:\\sheetdemo1.xlsx"));
        try {
            ExcelWriter writer = new ExcelWriter(outputStream, ExcelTypeEnum.XLSX);
            //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
            Sheet sheet1 = new Sheet(1, 0,ExcelPropertyIndexModel.class);
            writer.write(getData(), sheet1);
            writer.finish();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取需要写入的数据
     * @return
     */
    private List<? extends BaseRowModel> getData() {
//        ExcelPropertyIndexModel excel = new ExcelPropertyIndexModel("xxxx","27");
//        excel.setName("zsl");
//        excel.setAge("27");
//        List<ExcelPropertyIndexModel> excelList = new ArrayList<>();
//        excelList.add(excel);
//        return  excelList;

        return new ArrayList<ExcelPropertyIndexModel>(){{
            add(new ExcelPropertyIndexModel("zhangsan","23") );
            add(new ExcelPropertyIndexModel("lisi","24") );
            add(new ExcelPropertyIndexModel("wangwu","25") );
            add(new ExcelPropertyIndexModel("zhaoliu","26") );
        }};
    }


    /**
     * 表头类定义
     */
    //这个类必须要public 否则 会报NoMethodException 也就是获取不到getter和setter方法
    public class ExcelPropertyIndexModel extends BaseRowModel {

        @Getter
        @Setter
        @ExcelProperty(value = "姓名", index = 0)
        private String name;

        @Getter
        @Setter
        @ExcelProperty(value = "年龄", index = 1)
        private String age;

        public ExcelPropertyIndexModel(String name,String age){
            this.name = name;
            this.age = age;
        }

//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public String getAge() {
//            return age;
//        }
//
//        public void setAge(String age) {
//            this.age = age;
//        }

    }
}
