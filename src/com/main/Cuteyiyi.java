package com.main;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zhangzhimin on 8/3/17.
 */
public class Cuteyiyi {
      void getNum(int a,int b,List<Result> ll ){
        
        for(int i=1;i<=Math.sqrt(a);i++){
            if(a%i==0){
                Result rs = new Result();
                //if(i==26){
                System.out.println(b + " + " + i + " x " + a / i + " ");
            //}
                //if(a/i==26){
                   // System.out.println(b + " + " + i + " x " + a / i + " ");
            //}
                rs.setX(b);rs.setY(i);rs.setZ(a / i);
                ll.add(rs);
            }
        }
    }
      List<Result> getNums(double a,double b){
        List<Result> ll = new ArrayList<Result>();  
        int x=1,z=1;double y=1;//y*z=zzm 
        int q =1;int w =1;
        //a = b*x +y*z;
        //a =b*q +w;
        for(int i=1;i<a/b;i++){
            for(int j=1;j<a;j++){
                if(a ==b*i+j){
                    //System.out.println("x=" + i + " j=" + j);
                    getNum(j, i,ll);
                }
            }
        }
          return ll;
    }


    public static void main(String[] args) {
        Date d1 = new Date();
        Cuteyiyi yy = new Cuteyiyi();
        int maxRowCount = 60000;
//        List<Result> list = new ArrayList<Result>();
//        list = yy.getNums(500,20);
//        for(int a=0;a<5;a++){
//        System.out.println(a + " " + list.get(a).getY());
//        }
        try {
            String info[]={"x","y","z"};
            WritableWorkbook book = Workbook.createWorkbook(new File("love11.xls"));
            WritableSheet sheet = book.createSheet("第一页", 0);
            for(int j=0;j<info.length;j++){
                Label label = new Label(j, 0, info[j]);
                sheet.addCell(label);
            }
            List<Result> list = yy.getNums(525488,35);
            System.out.println(123);
            System.out.println(list.size());
            int list_num = list.size();
            int num = list_num<60000?list_num:60000;
            for(int i=0;i<num;i++){
                sheet.addCell(new Label(0,i+1,list.get(i).getX()+""));
                sheet.addCell(new Label(1,i+1,list.get(i).getY()+""));
                sheet.addCell(new Label(2,i+1,list.get(i).getZ()+""));
            }
            if(list.size()>60000){
                WritableSheet sheet2 = book.createSheet("第二页", 1);
                for(int j=0;j<info.length;j++){
                    Label label = new Label(j, 0, info[j]);
                    sheet2.addCell(label);
                }
                for(int i=60000;i<list_num;i++){
                    sheet2.addCell(new Label(0,i-59999,list.get(i).getX()+""));
                    sheet2.addCell(new Label(1,i-59999,list.get(i).getY()+""));
                    sheet2.addCell(new Label(2,i-59999,list.get(i).getZ()+""));
                }
            }
            book.write();
            book.close();
            System.out.println("fin"+num);
            Date d2 = new Date();
            System.out.println(d1+"\n"+d2);
        }catch (Exception e){
            e.printStackTrace();
        }
//        FileWriter fw = null;
//        File directory = new File("");
//        try {
//            String ll = directory.getCanonicalPath();
//            String lll ="test.txt";
//            String s = "August";
//            //String lll = "/home/zl/yiyiyiyi.txt";
//            System.out.println(lll);
//            File f1 = new File("/home/zl","yiyiyiyi.txt");
//            f1.createNewFile();
//            System.out.println(f1.exists());
//            if(f1.exists()){
//                fw = new FileWriter(f1);
//                fw.write(s);
//                fw.flush();
//                
//            }
//            System.out.println(directory.canWrite());
//            System.out.println(directory.getCanonicalPath());//获取标准的路径 
//            System.out.println(directory.getAbsolutePath());//获取绝对路径 
//        }catch (Exception e){
//            
//        }
//            
//        Scanner s = new Scanner(System.in);
//        System.out.println("输入一个数字");
//        while(true){
//            String line = s.nextLine();
//            String line1 = s.nextLine();
////            getNum(Integer.parseInt(line));
//            Double t1 =Double.parseDouble(line);Double t3 =Double.parseDouble(line1);int t2 =(int)Double.parseDouble(line);
//            //System.out.println(t1+" "+t2);
            //getNums(t1,t3);
//        }
        //Cuteyiyi cy = new Cuteyiyi();
        //System.out.println("******************************************\n"+cy.getNums(525488,35).size()+"\n*****************************************");
    }
}
