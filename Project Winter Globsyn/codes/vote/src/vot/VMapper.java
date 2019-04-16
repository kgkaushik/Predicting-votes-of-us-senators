package vot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class VMapper extends Mapper<LongWritable,Text,Text,IntWritable> {

	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String record = value.toString().trim();//value = this is bigdata
		String words[] = record.split(","); //creates memory issue
		int c = 8;
		String word = "";
		String y="";
		
		for(int i=words.length-1;i>=0;i--)
		{
			
			word= words[i];
			
			if(c==4)
			{
			Text keyout = new Text(word);
			IntWritable valueout = new IntWritable(1);
			context.write(keyout,valueout);
			break;
			}
			
			c--;
		}
		c = 8;
		String x = "";
		for(int i=words.length-1;c>=5;i--)
		{
			String s =  words[i];
			if(s.equals("Y"))
			{
				x = x + (c-4);
				Text keyout = new Text(word+"_vote_"+x+"_Y");
				IntWritable valueout = new IntWritable(1);
				context.write(keyout,valueout);
				x = "";
			}
			else if(s.equals("N"))
			{
				x = x + (c-4);
				Text keyout = new Text(word+"_vote_"+x+"_N");
				IntWritable valueout = new IntWritable(1);
				context.write(keyout,valueout);
				x = "";
			}
			else
			{
				x = x + (c-4);
				Text keyout = new Text(word+"_vote_"+x+"NoVote");
				IntWritable valueout = new IntWritable(1);
				context.write(keyout,valueout);
				x = "";
			}
				
			c--;
		}
		
		
	}

}