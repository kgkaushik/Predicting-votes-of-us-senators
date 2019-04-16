package vc;


import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class VCMapper extends Mapper<LongWritable,Text,Text,Text> {

	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String record = value.toString().trim();
		StringTokenizer tokenizer = new StringTokenizer(record);
		String s = "";
		ArrayList<String> elements = new ArrayList<String>();
		String x = "";
		int flag = 0;
		while(tokenizer.hasMoreTokens()) {
			 
            // add tokens to AL
			x = tokenizer.nextToken();
			int r = x.compareTo("-");
			if(r!=0)
			{
            elements.add(x);
			}
			else
			{
				flag = 1;
				elements.clear();
				break;
			}
		}
		
		int n = elements.size();
		String name="";
		if(n==9)
		{
			name = name + elements.get(1) +" " +elements.get(2) +" "+ elements.get(3);
			elements.set(1,name);
			elements.set(2, elements.get(4));
			elements.set(3, elements.get(5));
			elements.set(4, elements.get(6));
			elements.set(5, elements.get(7));
			elements.set(6, elements.get(8));
			elements.set(7,"");
			elements.set(8,"");
			
		}
		if(n==8)
		{
			name = name + elements.get(1) + " " + elements.get(2);
			elements.set(1,name);
			elements.set(2, elements.get(3));
			elements.set(3, elements.get(4));
			elements.set(4, elements.get(5));
			elements.set(5, elements.get(6));
			elements.set(6, elements.get(7));
			elements.set(7, "");
		}
		int d;
		for(int i=0;i<n;i++)
		{
			x = elements.get(i);
			d = x.compareTo("");
			if(d != 0)
			s = s + x +",";
		}
		
		Text valueout = new Text(s);
		Text keyout = new Text("");
		if(flag==0)
		context.write(valueout,keyout);
		
	}}

