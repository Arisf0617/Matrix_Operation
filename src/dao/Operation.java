package dao;

import bean.Matrix;
import caculateEigen.CaculateEigen;


public class Operation {
		   
     /**
      * 矩阵加法
      * @param matrix1
      * @param matrix2
      * @return
      * @throws Exception
      */
     @SuppressWarnings("null")
     public Matrix addOperation(Matrix matrix1,Matrix matrix2) throws Exception{
         //如果输入有误，则停止运算
         if(matrix1==null){
        	 System.out.println("第一个矩阵不能为空");
             throw new Exception();
         }
         //如果输入有误，则停止运算
         if(matrix2==null){
        	 System.out.println("第二个矩阵不能为空");
             throw new Exception();
         }
         //计算---首先判断一下两个矩阵行和列的关系是否可以计算
         if(matrix1.getRow()!=matrix2.getRow()||matrix1.getLine()!=matrix2.getLine()){
             System.out.println("两个矩阵不满足运算要求");
             throw new Exception();
         }
         
         Matrix matrix=new Matrix();
         matrix.setRow(matrix1.getRow());
         matrix.setLine(matrix1.getLine());
         //执行运算
         String[][]matString1=matrix1.getMatrix();
         String[][]matString2=matrix2.getMatrix();
         String[][]matString=new String[matrix.getRow()][matrix.getLine()];//结果矩阵的数组
         for(int i=0;i<matrix.getLine();++i) {
        	 for(int j=0;j<matrix.getRow();++j) {
        		 if(!isNumber(matString1[i][j]) || !isNumber(matString2[i][j])) {
        			 matString[i][j] = matString1[i][j]+"+"+matString2[i][j];
        		 }else {
        			 Float resultFloat = Float.parseFloat(matString1[i][j])+Float.parseFloat(matString2[i][j]);
        			 matString[i][j] = String.valueOf(resultFloat);
				}
        	 }
         }
         matrix.setMatrix(matString);
         return matrix;
     }
     /**
      * 
      * 减
      * @param matrix1
      * @param matrix2
      * @return
      * @throws Exception
      */
     public Matrix reduceOperation(Matrix matrix1,Matrix matrix2)throws Exception{
         //如果输入有误，则停止运算
         if(matrix1==null){
        	 System.out.println("第一个矩阵不能为空");
             throw new Exception();
         }
         //如果输入有误，则停止运算
         if(matrix2==null){
        	 System.out.println("第二个矩阵不能为空");
             throw new Exception();
         }
         //计算---首先判断一下两个矩阵行和列的关系是否可以计算
         if(matrix1.getRow()!=matrix2.getRow()||matrix1.getLine()!=matrix2.getLine()){
             System.out.println("两个矩阵不满足运算要求");
             throw new Exception();
         }
         Matrix matrix=new Matrix();
         matrix.setRow(matrix1.getRow());
         matrix.setLine(matrix1.getLine());
         //执行运算
         String[][]matString1=matrix1.getMatrix();
         String[][]matString2=matrix2.getMatrix();
         String[][]matString=new String[matrix.getRow()][matrix.getLine()];//结果矩阵的数组
         
         for(int i=0;i<matrix.getRow();++i){
             for(int j=0;j<matrix.getLine();++j){
                 if(!isNumber(matString1[i][j])||!isNumber(matString2[i][j])){
                     matString[i][j]=matString1[i][j]+"-"+matString2[i][j];
                 }else{
                     //将结果再转换成string
                     //转换成float的值相加减
                     float result=Float.parseFloat(matString1[i][j])-Float.parseFloat(matString2[i][j]);
                     matString[i][j]=String.valueOf(result);
                 }
             }
             
         }
         matrix.setMatrix(matString);
         return matrix;
     }
     
     /**
      * 乘
      * @param matrix1
      * @param matrix2
      * @return
      * @throws Exception
      */
     public Matrix multiplyOperation(Matrix matrix1,Matrix matrix2)throws Exception{
         //如果输入有误，则停止运算
                 if(matrix1==null){
                	 System.out.println("第一个矩阵不能为空");
                     throw new Exception();
                 }
                 //如果输入有误，则停止运算
                 if(matrix2==null){
                	 System.out.println("第二个矩阵不能为空");
                     throw new Exception();
                 }
                 //计算---首先判断一下两个矩阵行和列的关系是否可以计算
                 if(matrix1.getLine()!=matrix2.getRow()){
                     System.out.println("两个矩阵不满足运算要求");
                     throw new Exception();
                 }
                 Matrix matrix=new Matrix();
                 matrix.setRow(matrix1.getRow());//结果矩阵行数等于第一个矩阵行数，列数等于第二个矩阵列数
                 matrix.setLine(matrix2.getLine());
                 //执行运算
                 String[][]matString1=matrix1.getMatrix();
                 String[][]matString2=matrix2.getMatrix();
                 String[][]matString=new String[matrix.getRow()][matrix.getLine()];//结果矩阵的数组
                                 
//                 for(int i=0;i<matrix.getRow();++i){
//                     for(int j=0;j<matrix.getLine();++j){
//                    	 matString[i][j]="";
//                    	 for(int k=0;k<matrix1.getLine();++k) {
//                    		 matString[i][j]+=Float.parseFloat(matString1[i][k])*Float.parseFloat(matString2[k][j]);
//                             matString[i][j]=String.valueOf(result);
//                    		 matString[i][j]+=matString[i][k]+"*"+matString2[k][j]+"+";
//                    	 }
//                    	 matString[i][j] = doAnalyze(matString[i][j]);
//                     }
//                     
//                 }
                  
                 int sameNum=matrix1.getLine();//=matrix2.getRow()
                 for(int i=0;i<matrix.getRow();++i){
                     for(int j=0;j<matrix.getLine();++j){
                         matString[i][j]="";
                         for(int k=0;k<sameNum;++k){
                             matString[i][j]+=matString1[i][k]+"*"+matString2[k][j]+"+";
                         }
                         matString[i][j] = doAnalyze(matString[i][j]);//把计算式合并同类项并计算，重新赋给矩阵相应元素
                     }
                 }
                 
                 matrix.setMatrix(matString);
                 return matrix;
     }
     
     
     
     public void caculateEigen(Matrix matrix)throws Exception{
         //如果输入有误，则停止运算
                 if(matrix==null || matrix.getRow() != matrix.getLine() ){
                	 System.out.println("输入的矩阵有误");
                	 throw new Exception();
                 }
                         
             	double[][] matDouble = new double[matrix.getRow()][matrix.getLine()];             	
//             	double[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
             
                 CaculateEigen ce = new CaculateEigen();                 
                 String[][]matString=matrix.getMatrix();
                 
//               int row = matrix.getRow();
//               System.out.println("row:"+row);
                 
                 for(int i=0;i<matrix.getRow();++i){
                     for(int j=0;j<matrix.getLine();++j){
                    	 matDouble[i][j] = Double.valueOf(matString[i][j]);
                     }
                 }
                 
                 Object[] rs = ce.caculateEigen(2,matDouble);

                 System.out.println("说明：矩阵B的对角线元素为相应的特征值，矩阵X的列向量为输入矩阵特征值对应的特征向量");
                 System.out.println("**************************************************");
                 
//               MWNumericArray  mw=(MWNumericArray)rs[0]; //0<=k<n,假如要取返回列表中第k个返回变量的值
//               MWNumericArray  mw1=(MWNumericArray)rs[1]; //0<=k<n,假如要取返回列表中第k个返回变量的值
//               
//               int[][] db=(int[][])(mw.toIntArray());    //如果rs[k]是二维int型数组
//               int[][] db1=(int[][])(mw1.toIntArray());    //如果rs[k]是二维int型数组
//                 
//               //System.out.println(db);
//               //System.out.println(db1);
                 
     }
          
     /**
      * 判断矩阵的一个元素是字母还是数字
      * @param str
      * @return
      */
     public boolean isNumber(String str){
         for (int i = 0; i < str.length(); i++){
             if (!Character.isDigit(str.charAt(i))){
                 return false;
             }
         }
         return true;
     }
     
     
     
     /**
      * 把形如“1*1+2*1+3*1+”的式子进行分析计算
      * 返回处理结果
      * @param toAnalizeString
      * @return
      */
     public String doAnalyze(String toAnalizeString){
         String disAdd[]=toAnalizeString.split("\\+");//“+”是转义字符
         int addLength=disAdd.length;//获取有几项相加
         String disMul[][]=new String[addLength][2];//所有项都在这一个二维数组里面了
         for (int i = 0; i < disAdd.length; i++) {
             disMul[i]=disAdd[i].split("\\*");
         }
         //移项，先不考虑系数为0的情况
         for(int i = 0; i < disMul.length; i++){ 
             if(isNumber(disMul[i][0])){
                 if(isNumber(disMul[i][1])){
                     //都是数字，让第一项等于两数运算结果，第二项等于0
                     float result=Float.parseFloat(disMul[i][0])*Float.parseFloat(disMul[i][1]);
                     disMul[i][0]=String.valueOf(result);
                     disMul[i][1]="0";
                 }else{
                     //一是二不是，不用做什么
                 }
             }else{
                 if(isNumber(disMul[i][1])){
                     //一不是二是，互换
                     String tempString=disMul[i][0];
                     disMul[i][0]=disMul[i][1];
                     disMul[i][1]=tempString;
                 }else{
                     //都不是数字，让第一项等于1，第二项等于两数运算结果
                     if(disMul[i][0].equals(disMul[i][1])){
                         disMul[i][1]=disMul[i][1]+"^2";
                     }else{//按abc顺序写
                         if(disMul[i][0].compareTo(disMul[i][1])>0){
                             disMul[i][1]=disMul[i][1]+""+disMul[i][0];
                         }else{
                             disMul[i][1]=disMul[i][0]+""+disMul[i][1];
                         }
                     }
                     disMul[i][0]="1";
                 }
             }
         }//移项完成
         
         //合并同类项，算法会处理系数为0的情况
         for(int i = 0; i < disMul.length-1; i++){
             for(int j=i+1;j<disMul.length;j++){
                 if(!disMul[i][0].equals("0")){
                     if(disMul[i][1].equals(disMul[j][1])){//如果是同类项，系数相加，赋值给上面的系数，下面的系数置为0
                         disMul[i][0]=String.valueOf(Float.parseFloat(disMul[i][0])+Float.parseFloat(disMul[j][0]));
                         disMul[j][0]="0";
                     }
                 }
             }
         }//合并同类项完成
         
         //写成多项式的形式，用result拼接
         String result="";
         for(int i = 0; i < disMul.length; i++){
             if(!disMul[i][0].equals("0")){//忽略为0的项
                 if(disMul[i][1].equals("0")){//如果是常数项
                     result+=disMul[i][0]+"+";
                 }else{
                     result+=disMul[i][0]+disMul[i][1]+"+";
                 }
             }
         }
          result=result.substring(0, result.length()-1);//删除最后一个“+”号
         return result;
     }   
               
}
