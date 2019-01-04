package example.zsltest;
import example.zsltest.M00_Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;






public class M00_CustomerJiemi {
//    public void Jiemi()
//    {
//        long sysDate = System.currentTimeMillis();
//        sysDate = System.currentTimeMillis();
//        System.out.println("开始执行m00密文导入操作"+sysDate);
//        Connection con = null;// 创建一个数据库连接
//        PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
//        ResultSet result = null;// 创建一个结果集对象
//        List<M00_Customer> list =new ArrayList();
//        try
//        {
//            Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序
//            Properties props = new Properties() ;
//            props.put( "user" , "bms") ;
//            props.put( "password" , "bms") ;
//            props.put( "oracle.net.CONNECT_TIMEOUT" , "10000000") ;
//            props.put( "oracle.jdbc.ReadTimeout" , "1000000" ) ;
//            con = DriverManager.getConnection( "jdbc:oracle:thin:@172.17.87.182:1521:DM" , props ) ;
//            System.loadLibrary("DecDllJavaProx64");
//            DecUtil dec = new DecUtil();
//            String sql = "select id,CONTACT_TEL_ENC,LEGAL_CARD_NO_ENC,CONTACT_TEL_ENC,REAL_CONTROL_CARD_NO_ENC,FINANCE_TEL_ENC,"
//                    + "AUTHORIZE_CARD_NO_ENC,FINANCE_MOBILE_ENC,AUTHORIZE_MOBILE_ENC,LEGAL_TEL_ENC,LEGAL_MOBILE_ENC from T_m00_customer";
//            pre = con.prepareStatement(sql);// 实例化预编译语句
//            result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
//            while (result.next()){
//                M00_Customer customer = new M00_Customer();
//                customer.setId(result.getString("Id"));
//                customer.setCONTACT_TEL_ENC(result.getString("CONTACT_TEL_ENC"));
//                customer.setLEGAL_CARD_NO_ENC(result.getString("LEGAL_CARD_NO_ENC"));
//                customer.setCONTACT_TEL_ENC(result.getString("CONTACT_TEL_ENC"));
//                customer.setREAL_CONTROL_CARD_NO_ENC(result.getString("REAL_CONTROL_CARD_NO_ENC"));
//                customer.setFINANCE_TEL_ENC(result.getString("FINANCE_TEL_ENC"));
//                customer.setAUTHORIZE_CARD_NO_ENC(result.getString("AUTHORIZE_CARD_NO_ENC"));
//                customer.setFINANCE_MOBILE_ENC(result.getString("FINANCE_MOBILE_ENC"));
//                customer.setAUTHORIZE_MOBILE_ENC(result.getString("AUTHORIZE_MOBILE_ENC"));
//                customer.setLEGAL_TEL_ENC(result.getString("LEGAL_TEL_ENC"));
//                customer.setLEGAL_MOBILE_ENC(result.getString("LEGAL_MOBILE_ENC"));
//                list.add(customer);
//            }
//            String enc=null;
//            String enc1=null;
//            String enc2=null;
//            String enc3=null;
//            String enc4=null;
//            String enc5=null;
//            String enc6=null;
//            String enc7=null;
//            String enc8=null;
//            String enc9=null;
//            System.out.println(list.size());
//
//            sysDate = System.currentTimeMillis()-sysDate;
//            System.out.println("m00开始解密"+sysDate);
//
//            for(M00_Customer customer:list){
//                enc=customer.getCONTACT_TEL_ENC();
//                if(enc!=null){
//                    customer.setTmp_CONTACT_TEL(dec.dec(enc));
//                }else{
//                    customer.setTmp_CONTACT_TEL("未提供");
//                }
//                enc1=customer.getLEGAL_CARD_NO_ENC();
//                if(enc1!=null){
//                    customer.setTmp_LEGAL_CARD_NO(dec.dec(enc1));
//                }else{
//                    customer.setTmp_LEGAL_CARD_NO("未提供");
//                }
//                enc2=customer.getCONTACT_TEL_ENC();
//                if(enc2!=null){
//                    customer.setTmp_CONTACT_TEL(dec.dec(enc2));
//                }else{
//                    customer.setTmp_CONTACT_TEL("未提供");
//                }
//                enc3=customer.getREAL_CONTROL_CARD_NO_ENC();
//                if(enc3!=null){
//                    customer.setTmp_REAL_CONTROL_CARD_NO(dec.dec(enc3));
//                }else{
//                    customer.setTmp_REAL_CONTROL_CARD_NO("未提供");
//                }
//                enc4=customer.getFINANCE_TEL_ENC();
//                if(enc4!=null){
//                    customer.setTmp_FINANCE_TEL(dec.dec(enc4));
//                }else{
//                    customer.setTmp_FINANCE_TEL("未提供");
//                }
//                enc5=customer.getAUTHORIZE_CARD_NO_ENC();
//                if(enc5!=null){
//                    customer.setTmp_AUTHORIZE_CARD_NO(dec.dec(enc5));
//                }else{
//                    customer.setTmp_AUTHORIZE_CARD_NO("未提供");
//                }
//                enc6=customer.getFINANCE_MOBILE_ENC();
//                if(enc6!=null){
//                    customer.setTmp_FINANCE_MOBILE(dec.dec(enc6));
//                }else{
//                    customer.setTmp_FINANCE_MOBILE("未提供");
//                }
//                enc7=customer.getAUTHORIZE_MOBILE_ENC();
//                if(enc7!=null){
//                    customer.setTmp_AUTHORIZE_MOBILE(dec.dec(enc7));
//                }else{
//                    customer.setTmp_AUTHORIZE_MOBILE("未提供");
//                }
//                enc8=customer.getLEGAL_TEL_ENC();
//                if(enc8!=null){
//                    customer.setTmp_LEGAL_TEL(dec.dec(enc8));
//                }else{
//                    customer.setTmp_LEGAL_TEL("未提供");
//                }
//                enc9=customer.getLEGAL_MOBILE_ENC();
//                if(enc9!=null){
//                    customer.setTmp_LEGAL_MOBILE(dec.dec(enc9));
//                }else{
//                    customer.setTmp_LEGAL_MOBILE("未提供");
//                }
//            }
//
//            sysDate = System.currentTimeMillis();
//            System.out.println("m00解密结束"+sysDate);
//
//            String sql1 = "";
//            boolean result1 = false;
//            int count=0;int count1=0;
//
//            sql1 = "insert into atmp密文明文表_m00customer (MIWEN_CONTACT_TEL,MINGWEN_CONTACT_TEL,MIWEN_LEGAL_CARD_NO,MINGWEN_LEGAL_CARD_NO,"
//                    + "MIWEN_CONTACT_MOBILE,MINGWEN_CONTACT_MOBILE,MIWEN_R_C_CARD_NO,MINGWEN_R_C_CARD_NO,"
//                    + "MIWEN_FINANCE_TEL,MINGWEN_FINANCE_TEL,MIWEN_A_CARD_NO,MINGWEN_A_CARD_NO,"
//                    + "MIWEN_FINANCE_MOBILE,MINGWEN_FINANCE_MOBILE,MIWEN_A_MOBILE,MINGWEN_A_MOBILE,"
//                    + "MIWEN_LEGAL_TEL,MINGWEN_LEGAL_TEL,MIWEN_LEGAL_MOBILE,MINGWEN_LEGAL_MOBILE,id) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//            pre = con.prepareStatement(sql1);// 实例化预编译语句
//
//            sysDate = System.currentTimeMillis()-sysDate;
//            System.out.println("开始添加数据"+sysDate);
//            for(M00_Customer customer:list){
//                if(customer.getCONTACT_TEL_ENC()!=null){
//                    pre.setString(1, customer.getCONTACT_TEL_ENC());
//                }else{
//                    pre.setString(1, "未提供");
//                }
//                if(customer.getTmp_CONTACT_TEL()!=null){
//                    pre.setString(2, customer.getTmp_CONTACT_TEL());
//                }else{
//                    pre.setString(2, "未提供");
//                }
//                if(customer.getLEGAL_CARD_NO_ENC()!=null){
//                    pre.setString(3, customer.getLEGAL_CARD_NO_ENC());
//                }else{
//                    pre.setString(3, "未提供");
//                }
//                if(customer.getTmp_LEGAL_CARD_NO()!=null){
//                    pre.setString(4, customer.getTmp_LEGAL_CARD_NO());
//                }else{
//                    pre.setString(4, "未提供");
//                }
//                if(customer.getCONTACT_TEL_ENC()!=null){
//                    pre.setString(5, customer.getCONTACT_TEL_ENC());
//                }else{
//                    pre.setString(5, "未提供");
//                }
//                if(customer.getTmp_CONTACT_TEL()!=null){
//                    pre.setString(6, customer.getTmp_CONTACT_TEL());
//                }else{
//                    pre.setString(6, "未提供");
//                }
//                if(customer.getREAL_CONTROL_CARD_NO_ENC()!=null){
//                    pre.setString(7, customer.getREAL_CONTROL_CARD_NO_ENC());
//                }else{
//                    pre.setString(7, "未提供");
//                }
//                if(customer.getTmp_REAL_CONTROL_CARD_NO()!=null){
//                    pre.setString(8, customer.getTmp_REAL_CONTROL_CARD_NO());
//                }else{
//                    pre.setString(8, "未提供");
//                }
//                if(customer.getFINANCE_TEL_ENC()!=null){
//                    pre.setString(9, customer.getFINANCE_TEL_ENC());
//                }else{
//                    pre.setString(9, "未提供");
//                }
//                if(customer.getTmp_FINANCE_TEL()!=null){
//                    pre.setString(10, customer.getTmp_FINANCE_TEL());
//                }else{
//                    pre.setString(10, "未提供");
//                }
//                if(customer.getAUTHORIZE_CARD_NO_ENC()!=null){
//                    pre.setString(11, customer.getAUTHORIZE_CARD_NO_ENC());
//                }else{
//                    pre.setString(11, "未提供");
//                }
//                if(customer.getTmp_AUTHORIZE_CARD_NO()!=null){
//                    pre.setString(12, customer.getTmp_AUTHORIZE_CARD_NO());
//                }else{
//                    pre.setString(12, "未提供");
//                }
//                if(customer.getFINANCE_MOBILE_ENC()!=null){
//                    pre.setString(13, customer.getFINANCE_MOBILE_ENC());
//                }else{
//                    pre.setString(13, "未提供");
//                }
//                if(customer.getTmp_FINANCE_MOBILE()!=null){
//                    pre.setString(14, customer.getTmp_FINANCE_MOBILE());
//                }else{
//                    pre.setString(14, "未提供");
//                }
//                if(customer.getAUTHORIZE_MOBILE_ENC()!=null){
//                    pre.setString(15, customer.getAUTHORIZE_MOBILE_ENC());
//                }else{
//                    pre.setString(15, "未提供");
//                }
//                if(customer.getTmp_AUTHORIZE_MOBILE()!=null){
//                    pre.setString(16, customer.getTmp_AUTHORIZE_MOBILE());
//                }else{
//                    pre.setString(16, "未提供");
//                }
//                if(customer.getLEGAL_TEL_ENC()!=null){
//                    pre.setString(17, customer.getLEGAL_TEL_ENC());
//                }else{
//                    pre.setString(17, "未提供");
//                }
//                if(customer.getTmp_LEGAL_TEL()!=null){
//                    pre.setString(18, customer.getTmp_LEGAL_TEL());
//                }else{
//                    pre.setString(18, "未提供");
//                }
//                if(customer.getLEGAL_MOBILE_ENC()!=null){
//                    pre.setString(19, customer.getLEGAL_MOBILE_ENC());
//                }else{
//                    pre.setString(19, "未提供");
//                }
//                if(customer.getTmp_LEGAL_MOBILE()!=null){
//                    pre.setString(20, customer.getTmp_LEGAL_MOBILE());
//                }else{
//                    pre.setString(20, "未提供");
//                }
//                if(customer.getId()!=null){
//                    pre.setString(21, customer.getId());
//                }else{
//                    pre.setString(21, "该条Id为空");
//                }
//                pre.addBatch();
//                count++;
//                count1++;
//                if (count==5000){
//                    //sysDate = System.currentTimeMillis()-sysDate;
//                    //System.out.println("每5000条时间"+sysDate);
//                    pre.executeBatch();
//                    con.commit();
//                    count=0;
//                    pre.clearBatch();
//                }
//            }
//            pre.executeBatch();
//            pre.clearBatch();
//            con.commit();
//            sysDate = System.currentTimeMillis();
//            System.out.println("解密方法操作时长"+(sysDate));
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        finally
//        {
//            try
//            {
//                // 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
//                // 注意关闭的顺序，最后使用的最先关闭
//                if (result != null)
//                    result.close();
//                if (pre != null)
//                    pre.close();
//                if (con != null)
//                    con.close();
//                System.out.println("数据库连接已关闭！");
//            }
//            catch (Exception e)
//            {
//                e.printStackTrace();
//            }
//        }
//    }
    //检查是否为空
    public int GetcountCustomer()
    {
        int count=0;
        long sysDate = System.currentTimeMillis();
        long sysDate1 = System.currentTimeMillis();
        sysDate = System.currentTimeMillis();
        System.out.println("开始执行检查操作"+sysDate);
        Connection con = null;// 创建一个数据库连接
        PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
        ResultSet result = null;// 创建一个结果集对象
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序
            //System.out.println("开始尝试连接数据库！");
            String url = "jdbc:oracle:" + "thin:@172.17.87.182:1521:DM";
            String user = "bms";
            String password = "bms";
            con = DriverManager.getConnection(url, user, password);//获取连接
            String sql = "select count(*) from atmp密文明文表_m00Customer";
            pre = con.prepareStatement(sql);// 实例化预编译语句
            result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
            while (result.next()){
                count=result.getInt(1);
                System.out.println("count:"+count);
            }
            sysDate = System.currentTimeMillis();
            System.out.println("检查操作完成时间"+sysDate);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {   // 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
                // 注意关闭的顺序，最后使用的最先关闭
                if (result != null)
                    result.close();
                if (pre != null)
                    pre.close();
                if (con != null)
                    con.close();
                System.out.println("数据库连接已关闭！");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return count;
    }
    //删除对应的明文密文表
    public void deleteCustomer()
    {
        long sysDate = System.currentTimeMillis();
        long sysDate1 = System.currentTimeMillis();
        sysDate = System.currentTimeMillis();
        System.out.println("开始执行删除操作"+sysDate);
        Connection con = null;// 创建一个数据库连接
        PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
        ResultSet result = null;// 创建一个结果集对象
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序
            String url = "jdbc:oracle:" + "thin:@172.17.87.182:1521:DM";
            String user = "bms";
            String password = "bms";
            con = DriverManager.getConnection(url, user, password);//获取连接
            System.out.println("连接成功！");
            String sql = "delete from atmp密文明文表_m00Customer";
            pre = con.prepareStatement(sql);// 实例化预编译语句
            boolean result1 = pre.execute();// 执行查询，注意括号中不需要再加参数
            System.out.println("atmp密文明文表_m00Customer 数据内容清空成功");
            sysDate = System.currentTimeMillis();
            System.out.println("删除操作完成时间"+sysDate);
            con.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (result != null)
                    result.close();
                if (pre != null)
                    pre.close();
                if (con != null)
                    con.close();
                System.out.println("数据库连接已关闭！");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    //建立T表备份并更新T表备份里的明文值
    public void UpdateTcustomer()
    {
        long sysDate = System.currentTimeMillis();
        sysDate = System.currentTimeMillis();
        System.out.println("开始执行建立T表备份并更新T表备份值的操作"+sysDate);
        Connection con = null;// 创建一个数据库连接
        PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
        ResultSet result = null;// 创建一个结果集对象
        boolean result1=false;
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序
            String url = "jdbc:oracle:" + "thin:@172.17.87.182:1521:DM";
            String user = "bms";
            String password = "bms";
            con = DriverManager.getConnection(url, user, password);//获取连接
            System.out.println("连接成功！");
            String sql = "drop table T_M00_CUSTOMER_ATMP";
            pre = con.prepareStatement(sql);// 实例化预编译语句
            result1 = pre.execute();// 执行查询，注意括号中不需要再加参数
            sysDate = System.currentTimeMillis();
            System.out.println("删除T_M00_CUSTOMER_ATMP的时间"+(sysDate));
            con.commit();
            sql = "create table T_M00_CUSTOMER_ATMP as select * from T_M00_CUSTOMER";
            pre = con.prepareStatement(sql);// 实例化预编译语句
            result1 = pre.execute();// 执行查询，注意括号中不需要再加参数
            con.commit();
            System.out.println("T_M00_CUSTOMER_ATMP 表数据已填充");
            sql="merge into T_M00_CUSTOMER_ATMP "
                    + "using  (select * FROM atmp密文明文表_M00CUSTOMER X  WHERE  X.ROWID =  "
                    + "(SELECT MAX(Y.ROWID) FROM  atmp密文明文表_M00CUSTOMER Y  WHERE  X.id = Y.id)) atmp密文明文表_M00CUSTOMER  "
                    + "on (T_M00_CUSTOMER_ATMP.id=atmp密文明文表_M00CUSTOMER.id)  "
                    + "when matched then  "
                    + "update set T_M00_CUSTOMER_ATMP.CONTACT_TEL=atmp密文明文表_M00CUSTOMER.mingwen_CONTACT_TEL,"
                    + "T_M00_CUSTOMER_ATMP.LEGAL_CARD_NO=atmp密文明文表_M00CUSTOMER.mingwen_LEGAL_CARD_NO,"
                    + "T_M00_CUSTOMER_ATMP.CONTACT_MOBILE=atmp密文明文表_M00CUSTOMER.mingwen_CONTACT_MOBILE,"
                    + "T_M00_CUSTOMER_ATMP.REAL_CONTROL_CARD_NO=atmp密文明文表_M00CUSTOMER.mingwen_R_C_CARD_NO,"
                    + "T_M00_CUSTOMER_ATMP.FINANCE_TEL=atmp密文明文表_M00CUSTOMER.mingwen_FINANCE_TEL,"
                    + "T_M00_CUSTOMER_ATMP.AUTHORIZE_CARD_NO=atmp密文明文表_M00CUSTOMER.mingwen_A_CARD_NO,"
                    + "T_M00_CUSTOMER_ATMP.FINANCE_MOBILE=atmp密文明文表_M00CUSTOMER.mingwen_FINANCE_MOBILE,"
                    + "T_M00_CUSTOMER_ATMP.AUTHORIZE_MOBILE=atmp密文明文表_M00CUSTOMER.mingwen_A_MOBILE,"
                    + "T_M00_CUSTOMER_ATMP.LEGAL_TEL=atmp密文明文表_M00CUSTOMER.mingwen_LEGAL_TEL,"
                    + "T_M00_CUSTOMER_ATMP.LEGAL_MOBILE=atmp密文明文表_M00CUSTOMER.mingwen_LEGAL_MOBILE";
            pre = con.prepareStatement(sql);// 实例化预编译语句
            result1 = pre.execute();// 执行查询，注意括号中不需要再加参数
            con.commit();
            sysDate = System.currentTimeMillis();
            System.out.println("修改T_M00_CUSTOMER_ATMP明文值的时间"+(sysDate));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (result != null)
                    result.close();
                if (pre != null)
                    pre.close();
                if (con != null)
                    con.close();
                System.out.println("数据库连接已关闭！");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    //T表备份转成STO表的方法
    public void insertSTOcustomer()
    {
        long sysDate = System.currentTimeMillis();
        sysDate = System.currentTimeMillis();
        System.out.println("开始执行T表备份插入STO表的操作"+sysDate);
        Connection con = null;// 创建一个数据库连接
        PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
        ResultSet result = null;// 创建一个结果集对象
        boolean result1=false;
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序
            String url = "jdbc:oracle:" + "thin:@172.17.87.182:1521:DM";
            String user = "bms";
            String password = "bms";
            con = DriverManager.getConnection(url, user, password);//获取连接
            System.out.println("连接成功！");
            String sql = "delete from STO_M00_CUSTOMER_ATMP";
            pre = con.prepareStatement(sql);// 实例化预编译语句
            result1 = pre.execute();// 执行查询，注意括号中不需要再加参数
            con.commit();
            sysDate = System.currentTimeMillis();
            System.out.println("删除STO_M00_CUSTOMER_ATMP表的时间"+(sysDate));
            sql = "insert into STO_M00_CUSTOMER_ATMP select ID,CUSTOMER_NO,MERCHANT_NO,NAME,BRIEF_NAME,ENG_NAME,ENG_BRIEF_NAME,EXTERNAL_NAME,"
                    + "CUSTOMER_TYPE,CUSTOMER_NATURE,LEGAL_NAME,LEGAL_CARD_TYPE,LEGAL_CARD_NO,LICENSE_NO,MAIN_BUSINESS,REGISTER_CAPITAL,LICENSE_DEADLINE,"
                    + "REGISTER_ADDRESS,REGISTER_ZIPCODE,TAX_NO,TAX_MATURITY_DATE,ORGANIZATION_NO,ENTERPRISE_NATURE,TURNOVER_YEAR,OPEN_DATE,RISK_NUM,OFFICE_ADDRESS,"
                    + "OFFICE_ZIPCODE,'null',PROVINCE,CITY,COUNTY,ROAD,HOUSE_NUMBER,ADDRESS_LAST,CONTACT_PERSON,CONTACT_DEPT,CONTACT_TEL,CONTACT_MOBILE,CONTACT_FAX,"
                    + "CONTACT_EMAIL,FINANCE_PERSON,FINANCE_TEL,FINANCE_MOBILE,FINANCE_FAX,FINANCE_EMAIL,GUARANTEE_METHOD,GUARANTEE_METHOD_DESC,ADDING_CATEGORY,"
                    + "SERVICE_NATURE,CONNECT_MODE,CONTRACTANT_NO,PROFESSION_SERVICE_INST,FOREIGN_CARD,OVER_AREA_FLAG,WITHDRAW_DATE,WITHDRAW_CATEGORY,WITHDRAWER_NAME,"
                    + "DEVELOPING_METHOD,DEVELOPING_DEPT_NAME,DEVELOPING_PERSON_NAME,DEVELOPING_SIDE,DEVELOPING_SIDE_SUB_NO,DEVELOPING_SIDE_SUB_NAME,REMARK,MERCHANT_RIGHT,"
                    + "CHECK_FLAG,CHECK_DATE,CHECK_DESC,REFUSE_REASON,STATUS,APPROVER_NAME,LAST_SERVICE_RATE,LAST_REVIEW_DATE,CLIENT_MANAGER,CLIENT_MANAGER_NAME,BMS_ID,CREATER,"
                    + "CREATE_DATE,LAST_MODIFIER,LAST_MODIFY_DATE,BRANCH,PROVINCE_BRANCH,IS_DELETE,BUSINESS_ACCEPT_METHOD,MCC_CODE,HEAD_QUARTERS_FLAG,ASSOCIATE_GROUP,"
                    + "LEGAL_DEADLINE,ORGANIZATION_DEADLINE,REAL_CONTROL_PERSON,DEVELOPING_PERSON,UNION_CREDIT_NO,FIELD_1,FIELD_2,FIELD_3,FIELD_4,FIELD_5,FIELD_6,"
                    + "FIELD_7,FIELD_8,FIELD_9,FIELD_10 from T_M00_CUSTOMER_ATMP";
            pre = con.prepareStatement(sql);// 实例化预编译语句
            result1 = pre.execute();// 执行查询，注意括号中不需要再加参数
            con.commit();
            sysDate = System.currentTimeMillis();
            System.out.println("从T_M00_CUSTOMER_ATMP向插入STO_M00_CUSTOMER_ATMP表的时间"+(sysDate));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (result != null)
                    result.close();
                if (pre != null)
                    pre.close();
                if (con != null)
                    con.close();
                System.out.println("数据库连接已关闭！");

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
