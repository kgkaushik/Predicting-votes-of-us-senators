package vc;

import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class VCDriver  {
         /**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Configuration conf = new Configuration();
		//it contains configuration data taken from xml files
		//hdfs-site.xml,yarn-site.xml
		Job job = Job.getInstance(conf);
		
		
		
		job.setJarByClass(VCDriver.class);
		job.setMapperClass(VCMapper.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		FileInputFormat.addInputPath(job,new Path("votein"));
		//above line specifies where to get input data(in hdfs);
		//an object of path class represents a file or folder in hdfs
		//why add? (not set?)
		FileOutputFormat.setOutputPath(job,new Path("votecleaned"));
		//"wcout" must not exist before. if exists, we will get error
		try {
				job.waitForCompletion(true);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}