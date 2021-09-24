package com.my.check;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MainClass {
	
	public static void main(String[] args) {
		
		try (Scanner scn = new Scanner(System.in);){
//			StringBuffer sb1 = ReadTxt.readTxt("C:\\Users\\10973\\Desktop\\test\\orig.txt");
//			StringBuffer sb2 = ReadTxt.readTxt("C:\\Users\\10973\\Desktop\\test\\orig_0.8_add.txt");
			System.out.print("请输入抄袭版论文的文件的绝对路径：");
			String path = scn.next();
			if(path.indexOf("\\") > 0 && path.indexOf("\\\\") < 0) {
				path = path.replace("\\", "\\\\");
				System.out.println(path);
				
			}
			System.out.println(path);
			StringBuffer sb1 = ReadTxt.readTxt(path);
			
			
			System.out.print("请输入论文原文的绝对路径：");
			String txtPath = scn.next();
			if(path.indexOf("\\") > 0 && path.indexOf("\\\\") < 0) {
				txtPath = txtPath.replaceAll("\\", "\\\\");
				System.out.println(txtPath);
				
			}
			StringBuffer sb2 = ReadTxt.readTxt(txtPath);

			
			SimHash hash1 = new  SimHash(sb1.toString(),  64 );
			SimHash hash2 = new  SimHash(sb2.toString(),  64 );
			
			int dis = hash1.getDistance(hash1.getStrSimHash() , hash2.getStrSimHash());
			DecimalFormat decimalFormat = new DecimalFormat(".00");
	        System.out.println(hash1.hammingDistance(hash2) + " "  + dis);
	        System.out.println("hash1和hash2的相似率："+ decimalFormat.format((dis/64.0)));
	        
	        
	        String outpath = "C:\\Users\\10973\\Desktop\\test\\output.txt";
	        
	        
	        String content = "\r\n抄袭版论文的文件的绝对路径：" + path + "\r\n论文原文的绝对路径：" + txtPath + "\r\n论文重复率为：" + decimalFormat.format((dis/64.0));
	        ReadTxt.writeTxt(outpath, content);
		} catch (NullPointerException e1) {
			System.out.println("输入路径错误或者文件不存在！");
			e1.printStackTrace();
		} catch (Exception e) {
			System.out.println("输入错误导致程序出错！");
			e.printStackTrace();
		}
		
       
	}
}
