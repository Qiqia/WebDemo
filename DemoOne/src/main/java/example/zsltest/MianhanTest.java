package example.zsltest;

/**
 * Created by zsl on 2018/12/28.
 */
public class MianhanTest {


    public  static void main(String [] args)
    {
		/*

		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			String dateString = formatter.format(new Date());
			//System.out.println(dateString);
			String fileName ="G:\\testlog\\"+dateString+".txt";
			System.setOut(new PrintStream(new FileOutputStream(fileName)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("出错了");
		}
*/
        //System.out.println("This is test output");
        int num=0;
/*
        try {
			Socket s= new Socket("172.17.87.182",1521);
			s.setSoTimeout(100000);
			System.out.println("Connected.");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/

//终端表
        System.out.println("================================================终端表开始====================================================");
        M03_TERMINALJiemi terminalJiemi=new M03_TERMINALJiemi();
        //删除
        terminalJiemi.deleteSubmer();
        //查询是否删除成功
        num=terminalJiemi.GetcountSubmer();
        if(num==0){
            //删除成功后解密
            terminalJiemi.Jiemi();
        }else{
            System.out.println("atmp密文明文表_m03TERMINAL "+num+" 条!-----------数据库清空失败---未进行解密操作");
        }
        System.out.println("================================================终端表结束====================================================");
//分店表
        System.out.println("================================================分店表开始====================================================");
        M02_SubmerJiemi submerjiemi=new M02_SubmerJiemi();
        //删除
        submerjiemi.deleteSubmer();
        //查询是否删除成功
        num=submerjiemi.GetcountSubmer();
        if(num==0){
            //删除成功后解密
            submerjiemi.Jiemi();
            //解密后建立T表备份并updateT表备份
            //submerjiemi.UpdateTsubmer();
            //submerjiemi.insertSTOsubmer();
        }else{
            System.out.println("atmp密文明文表_m02submer "+num+" 条!-----------数据库清空失败---未进行解密操作");
        }
        System.out.println("================================================分店表表结束====================================================");
//商户表
        System.out.println("================================================商户表开始====================================================");
        M00_CustomerJiemi customerjiemi=new M00_CustomerJiemi();
        //删除
        customerjiemi.deleteCustomer();
        //查询是否删除成功
        num=customerjiemi.GetcountCustomer();
        if(num==0){
            //删除成功后解密
            customerjiemi.Jiemi();
            //解密后建立T表备份并updateT表备份
            //customerjiemi.UpdateTcustomer();
            //customerjiemi.insertSTOcustomer();
        }else{
            System.out.println("atmp密文明文表_m00Customer "+num+" 条!-----------数据库清空失败---未进行解密操作");
        }
        System.out.println("================================================商户表结束====================================================");

//STO_C12_MEMBER_INST
        System.out.println("================================================STO_C12_MEMBER_INST表开始====================================================");
        C12_MEMBERJiemi c12_memberJiemi=new C12_MEMBERJiemi();
        //删除
        c12_memberJiemi.deleteSubmer();
        //查询是否删除成功
        num=c12_memberJiemi.GetcountSubmer();
        if(num==0){
            //删除成功后解密
            c12_memberJiemi.Jiemi();
        }else{
            System.out.println("atmp密文明文表_C12_MEMBER_INST "+num+" 条!-----------数据库清空失败---未进行解密操作");
        }
        System.out.println("================================================STO_C12_MEMBER_INST表结束====================================================");
//STO_C13_MEMBER_SUB_INST
        System.out.println("================================================STO_C13_MEMBER_SUB_INST表开始====================================================");
        C13_MEMBERJiemi c13_memberJiemi=new C13_MEMBERJiemi();
        //删除
        c13_memberJiemi.deleteSubmer();
        //查询是否删除成功
        num=c13_memberJiemi.GetcountSubmer();
        if(num==0){
            //删除成功后解密
            c13_memberJiemi.Jiemi();
        }else{
            System.out.println("atmp密文明文表_C13_MEMBER_SUB_INST "+num+" 条!-----------数据库清空失败---未进行解密操作");
        }
        System.out.println("================================================STO_C13_MEMBER_SUB_INST表结束====================================================");

//T_SYS_USER
        System.out.println("================================================T_SYS_USER表开始====================================================");
        SYS_USERJiemi sysuserJiemi=new SYS_USERJiemi();
        //删除
        sysuserJiemi.deleteSubmer();
        //查询是否删除成功
        num=sysuserJiemi.GetcountSubmer();
        if(num==0){
            //删除成功后解密
            sysuserJiemi.Jiemi();
        }else{
            System.out.println("atmp密文明文表_T_SYS_USER "+num+" 条!-----------数据库清空失败---未进行解密操作");
        }
        System.out.println("================================================T_SYS_USER表结束====================================================");
//T_M04_MER_MULTI_APP
        System.out.println("================================================T_M04_MER_MULTI_APP表开始====================================================");
        M04_MER_Jiemi m04_MER_Jiemi=new M04_MER_Jiemi();
        //删除
        m04_MER_Jiemi.deleteSubmer();
        //查询是否删除成功
        num=m04_MER_Jiemi.GetcountSubmer();
        if(num==0){
            //删除成功后解密
            m04_MER_Jiemi.Jiemi();
        }else{
            System.out.println("atmp密文明文表_T_M04_MER_MULTI_APP "+num+" 条!-----------数据库清空失败---未进行解密操作");
        }
        System.out.println("================================================T_M04_MER_MULTI_APP表结束====================================================");
//T_M05_term_MULTI_APP
        System.out.println("================================================T_M05_term_MULTI_APP表开始====================================================");
        M05_Term_Jiemi m05_Term_Jiemi=new M05_Term_Jiemi();
        //删除
        m05_Term_Jiemi.deleteSubmer();
        //查询是否删除成功
        num=m05_Term_Jiemi.GetcountSubmer();
        if(num==0){
            //删除成功后解密
            m05_Term_Jiemi.Jiemi();
        }else{
            System.out.println("atmp密文明文表_T_M05_term_MULTI_APP "+num+" 条!-----------数据库清空失败---未进行解密操作");
        }
        System.out.println("================================================T_M05_term_MULTI_APP表结束====================================================");
//M10_MER_ACCOUNT
        System.out.println("================================================M10_MER_ACCOUNT表开始====================================================");
        M10_MER_ACCOUNTJiemi m10_MER_ACCOUNTJiemi=new M10_MER_ACCOUNTJiemi();
        //删除
        m10_MER_ACCOUNTJiemi.deleteSubmer();
        //查询是否删除成功
        num=m10_MER_ACCOUNTJiemi.GetcountSubmer();
        if(num==0){
            //删除成功后解密
            m10_MER_ACCOUNTJiemi.Jiemi();
        }else{
            System.out.println("atmp密文明文表_T_m10_MER_ACCOUNT "+num+" 条!-----------数据库清空失败---未进行解密操作");
        }
        System.out.println("================================================M10_MER_ACCOUNT表结束====================================================");
//WT02_TERMINAL
        System.out.println("================================================WT02_TERMINAL表开始====================================================");
        WT02_TERMINALJiemi wt02_TERMINALJiemi = new WT02_TERMINALJiemi();
        // 删除
        wt02_TERMINALJiemi.deleteSubmer();
        // 查询是否删除成功
        num = wt02_TERMINALJiemi.GetcountSubmer();
        if (num == 0) {
            // 删除成功后解密
            wt02_TERMINALJiemi.Jiemi();
        } else {
            System.out.println("atmp密文明文表_T_WT02_TERMINAL " + num + " 条!-----------数据库清空失败---未进行解密操作");
        }
        System.out.println("================================================WT02_TERMINAL表结束====================================================");
//WT01_TASK
        System.out.println("================================================WT01_TASK表开始====================================================");
        WT01_TASK_Jiemi wt01_TASK_Jiemi = new WT01_TASK_Jiemi();
        // 删除
        wt01_TASK_Jiemi.deleteSubmer();
        // 查询是否删除成功
        num = wt01_TASK_Jiemi.GetcountSubmer();
        if (num == 0) {
            // 删除成功后解密
            wt01_TASK_Jiemi.Jiemi();
        } else {
            System.out.println("atmp密文明文表_WT01_TASK " + num + " 条!-----------数据库清空失败---未进行解密操作");

        }
        System.out.println("================================================WT01_TASK表结束====================================================");

//M03_TERMINAL_TELPOS
        System.out.println("================================================M03_TERMINAL_TELPOS表开始====================================================");
        M03_TERMINAL_TELPOSJiemi m03_TERMINAL_TELPOSJiemi= new M03_TERMINAL_TELPOSJiemi();
        // 删除
        m03_TERMINAL_TELPOSJiemi.deleteSubmer();
        // 查询是否删除成功
        num = m03_TERMINAL_TELPOSJiemi.GetcountSubmer();
        if (num == 0) {
            // 删除成功后解密
            m03_TERMINAL_TELPOSJiemi.Jiemi();
        } else {
            System.out.println("atmp密文明文表_m03T_T_POS " + num + " 条!-----------数据库清空失败---未进行解密操作");

        }
        System.out.println("================================================M03_TERMINAL_TELPOS表结束====================================================");
//WT05_POS_TASK
        System.out.println("================================================WT05_POS_TASK表开始====================================================");
        WT05_POS_TASKJiemi wt05_POS_TASKJiemi= new WT05_POS_TASKJiemi();
        // 删除
        wt05_POS_TASKJiemi.deleteSubmer();
        // 查询是否删除成功
        num = wt05_POS_TASKJiemi.GetcountSubmer();
        if (num == 0) {
            // 删除成功后解密
            wt05_POS_TASKJiemi.Jiemi();
        } else {
            System.out.println("atmp密文明文表_wt05POSTASK " + num + " 条!-----------数据库清空失败---未进行解密操作");

        }
        System.out.println("================================================WT05_POS_TASK表结束====================================================");





//C12_M_EXTEND
        System.out.println("================================================C12_M_EXTEND表开始====================================================");
        C12_M_EXTENDJiemi c12_M_EXTENDJiemi= new C12_M_EXTENDJiemi();
        // 删除
        c12_M_EXTENDJiemi.deleteSubmer();
        // 查询是否删除成功
        num = c12_M_EXTENDJiemi.GetcountSubmer();
        if (num == 0) {
            // 删除成功后解密
            c12_M_EXTENDJiemi.Jiemi();
        } else {
            System.out.println("atmp密文明文表_m12ME_EXTEND " + num + " 条!-----------数据库清空失败---未进行解密操作");
        }
        System.out.println("================================================C12_M_EXTEND表结束====================================================");

//C15_TERMINAL_TELPHONES
        System.out.println("================================================C15_TERMINAL_TELPHONES表开始====================================================");
        C15_TERMINAL_TELPHONESJiemi c15_TERMINAL_TELPHONESJiemi= new C15_TERMINAL_TELPHONESJiemi();
        // 删除
        c15_TERMINAL_TELPHONESJiemi.deleteSubmer();
        // 查询是否删除成功
        num = c15_TERMINAL_TELPHONESJiemi.GetcountSubmer();
        if (num == 0) {
            // 删除成功后解密
            c15_TERMINAL_TELPHONESJiemi.Jiemi();
        } else {
            System.out.println("atmp密文明文表_C15_T_T " + num + " 条!-----------数据库清空失败---未进行解密操作");

        }
        System.out.println("================================================C15_TERMINAL_TELPHONES表结束====================================================");

//T_m06_PUBLIC_RELATION
        System.out.println("================================================m06_PUBLIC_RELATION表开始====================================================");
        M06_PUBLIC_RELATIONJiemi m06_PUBLIC_RELATIONJiemi= new M06_PUBLIC_RELATIONJiemi();
        // 删除
        m06_PUBLIC_RELATIONJiemi.deleteSubmer();
        // 查询是否删除成功
        num = m06_PUBLIC_RELATIONJiemi.GetcountSubmer();
        if (num == 0) {
            // 删除成功后解密
            m06_PUBLIC_RELATIONJiemi.Jiemi();
        } else {
            System.out.println("atmp密文明文表_m06_public_r " + num + " 条!-----------数据库清空失败---未进行解密操作");

        }
        System.out.println("================================================m06_PUBLIC_RELATION表结束====================================================");

//T_k01_task
        System.out.println("================================================T_k01_task表开始====================================================");
        K01_TASKJiemi k01_TASKJiemi= new K01_TASKJiemi();
        // 删除
        k01_TASKJiemi.deleteSubmer();
        // 查询是否删除成功
        num = k01_TASKJiemi.GetcountSubmer();
        if (num == 0) {
            // 删除成功后解密
            k01_TASKJiemi.Jiemi();
        } else {
            System.out.println("atmp密文明文表_k01_task " + num + " 条!-----------数据库清空失败---未进行解密操作");

        }
        System.out.println("================================================T_k01_task表结束====================================================");

//t_p02_customer_self_apply
        System.out.println("================================================t_p02_customer_self_apply表开始====================================================");
        P02_CUSTOMER_SELF_APPLYJiemi p02_CUSTOMER_SELF_APPLYJiemi= new P02_CUSTOMER_SELF_APPLYJiemi();
        // 删除
        p02_CUSTOMER_SELF_APPLYJiemi.deleteSubmer();
        // 查询是否删除成功
        num = p02_CUSTOMER_SELF_APPLYJiemi.GetcountSubmer();
        if (num == 0) {
            // 删除成功后解密
            p02_CUSTOMER_SELF_APPLYJiemi.Jiemi();
        } else {
            System.out.println("atmp密文明文表_P02_c_s_a " + num + " 条!-----------数据库清空失败---未进行解密操作");

        }
        System.out.println("================================================t_p02_customer_self_apply表结束====================================================");

    }

}
