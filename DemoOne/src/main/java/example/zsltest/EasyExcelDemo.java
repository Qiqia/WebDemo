package example.zsltest;


import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.read.context.AnalysisContext;
import com.alibaba.excel.read.event.AnalysisEventListener;
import com.alibaba.excel.support.ExcelTypeEnum;

import java.io.*;
import java.util.List;

/**
 * Created by zsl on 2018/10/12.
 */
public class EasyExcelDemo {
    public static void main(String[] args) throws Exception{
        EasyExcelDemo demo = new EasyExcelDemo();
        demo.noModelMultipleSheet();
    }

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


//    public void writeExcelTest()throws FileNotFoundException{
//        OutputStream outputStream = new FileOutputStream(new File("D:/sheetdemo1.xlsx"));
//        try {
//            ExcelWriter writer = new ExcelWriter(outputStream, ExcelTypeEnum.XLSX);
//            //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
//            Sheet sheet1 = new Sheet(1, 0,ExcelPropertyIndexModel.class);
//            writer.write(getData(), sheet1);
//            writer.finish();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                outputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private List<? extends BaseRowModel> getData() {
//
//
//    }
//
//    private class ExcelPropertyIndexModel extends BaseRowModel {
//    }
}
