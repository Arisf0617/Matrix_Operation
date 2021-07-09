package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.Operation;
import bean.Matrix;

public class Main {
	public static Scanner scan = new Scanner(System.in); 
	
    public static void main(String[] args){
         int chooseChar=0;
         while(chooseChar!=5){
             System.out.println("请选择要执行的运算");
             System.out.println("1、加法\n2、减法\n3、乘法\n4、求矩阵的特征值和特征向量\n5、退出");
             try {
                 chooseChar=scan.nextInt();
                 scan.nextLine();//用于处理输入结束之后的回车，否则会影响后面的输入
             } catch (Exception e) {
                 e.printStackTrace();
             }
             Main beg=new Main();
             switch(chooseChar){
                 case 1:{
                     beg.addOperation();
                     break;
                 }
                 case 2:{
                     beg.reduceOperation();
                    break;
                 }
                 case 3:{
                     beg.multiplyOperation();
                     break;
                 }
                 case 4:{
                     beg.complexOperation();
                     break;
                 }
                 default:{
                	 System.out.println("请重新选择");
                 }
             }
             if(chooseChar==5){
                 System.out.println("已停止工作");
             }
         }
     }
          
     /**
      * 65~90:A~Z
      * 97~122:a~z
      * 选择加
      * @param list
      */
     public void addOperation(){
    	 Main beg=new Main();
         System.out.println("您选择的是矩阵的加法运算，注意两个矩阵行数和列数要相等");
         Operation caculate=new Operation();
         firstPrint();
         Matrix matrix1=beg.inputMatrix();
         System.out.println("请输入下一个矩阵：");
         Matrix matrix2=beg.inputMatrix();
         Matrix matrix=null;
         try {
             matrix=caculate.addOperation(matrix1, matrix2);//调用封装方法计算
         } catch (Exception e) {
             e.printStackTrace();
         }
         System.out.println("运算结果为：");
         beg.printMatrix(matrix);
     }
     
     /**
      * 65~90:A~Z
      * 97~122:a~z
      * 选择减
      * @param list
      */
     public void reduceOperation(){
    	 Main beg=new Main();
         System.out.println("您选择的是矩阵的减法运算，注意两个矩阵行数和列数要相等");
         Operation caculate=new Operation();
         firstPrint();
         Matrix matrix1=beg.inputMatrix();
         System.out.println("请输入下一个矩阵：");
         Matrix matrix2=beg.inputMatrix();
         Matrix matrix=null;
         try {
             matrix=caculate.reduceOperation(matrix1, matrix2);//调用封装方法计算
         } catch (Exception e) {
             e.printStackTrace();
         }
         System.out.println("运算结果为：");
         beg.printMatrix(matrix);
     }
     
     /**
      * 65~90:A~Z
      * 97~122:a~z
      * 选择乘
      * @param list
      */
     public void multiplyOperation(){
    	 Main beg=new Main();
         System.out.println("您选择的是矩阵的乘法运算，注意第一个矩阵的列数要和第二个矩阵的行数相等");
         Operation caculate=new Operation();
         firstPrint();
         Matrix matrix1=beg.inputMatrix();
         System.out.println("请输入下一个矩阵：");
         Matrix matrix2=beg.inputMatrix();
         Matrix matrix=null;
         try {
             matrix=caculate.multiplyOperation(matrix1, matrix2);//调用封装方法计算
         } catch (Exception e) {
             e.printStackTrace();
         }
         System.out.println("运算结果为：");
         beg.printMatrix(matrix);
     }
     /**
      * 65~90:A~Z
      * 97~122:a~z
      * 选择特征值特征向量
      * @param list
      */
     public void complexOperation(){
    	 Main beg=new Main();
         System.out.println("您选择的是计算矩阵的特征值特征向量，注意要求方阵");
         Operation caculate=new Operation();
         firstPrint();
         Matrix matrix=beg.inputMatrix();
         System.out.println("运算结果为：");
         try {
			caculate.caculateEigen(matrix);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
     }    
     
     public static void  firstPrint() {
         System.out.println("请输入第一个矩阵，元素之间用半角逗号隔开，输入“end”结束，如：\n"
                 + "1,2,3\n"
                 + "2,3,4\n"
                 + "3,4,5\n"
                 + "end");
     }
        
	 /**
      * 从输入到创建一个矩阵
      * @return
      */
     public Matrix inputMatrix(){
         @SuppressWarnings("resource")
         Scanner scan = new Scanner(System.in); 
         ArrayList<String> list=new ArrayList<String>();//用来存放用户的输入
         String firstString=scan.nextLine();
         while(!firstString.equals("end")){
             if(!"".equals(firstString))
                 list.add(firstString);
             firstString=scan.nextLine();
         }
         int row=list.size();//获得矩阵的行数
         int line=list.get(0).split(",").length;//获得矩阵列数
         for(int i=1;i<row;++i){
             if(line!=(list.get(i).split(",").length)){
                 System.out.println("每行的元素个数不相等");
                 System.exit(0);
                 return null;
             }
         }
         Matrix matrix=new Matrix();
         matrix.setRow(row);
         matrix.setLine(line);
         String matrixString[][]=new String[row][line];
         int i=0,j=0;
         for (String string : list) {//分出每一行
             String tempString[]=string.split(",");
             for (String str : tempString) {
                 matrixString[i][j]=str.trim();//删除空格
                 ++j;
             }
             if(j==line)
                 j=0;
             ++i;
         }
         matrix.setMatrix(matrixString);
         return matrix;
     }
     
     /**
      * 输出矩阵
      * @param matrix
      */
     public void printMatrix(Matrix matrix){
         String matrixString[][]=matrix.getMatrix();
         for(int i=0;i<matrix.getRow();++i){
             for(int j=0;j<matrix.getLine();++j){
                 System.out.print(matrixString[i][j]+"\t");
             }
             System.out.println();
         }
     }
         
}
