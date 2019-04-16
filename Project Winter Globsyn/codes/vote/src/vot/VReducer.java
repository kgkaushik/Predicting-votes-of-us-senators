package vot;

import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;

public class VReducer extends Reducer<Text,IntWritable,Text,IntWritable> {

	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		int sum = 0;
		for(IntWritable v : values)
		{
			sum = sum + v.get();
		}
		context.write(key, new IntWritable(sum));
	}
			
			
		
	}