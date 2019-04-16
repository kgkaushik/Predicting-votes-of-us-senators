package voprob;
import java.io.*; 
import java.util.*; 
public class prob
{
	static Hashtable<String,Double> h1;
	
	
public static void main(String[] args)throws Exception 
{ 
// We need to provide file path as the parameter: 
// double backquote is to avoid compiler interpret words 
// like \test as \t (ie. as a escape sequence) 
File file = new File("/home/kaushik/hadoopdownload/votecounts"); 
Hashtable<String,Integer> h = new Hashtable<String,Integer>();
BufferedReader br = new BufferedReader(new FileReader(file)); 

String st; String vr; String[] ar = new String[2];
while ((st = br.readLine()) != null)
{
	ar = st.split("\t");
	h.put(ar[0],Integer.parseInt(ar[1]));
}

//System.out.println("values are"+h);
int ttl = h.get("R")+h.get("D");
//System.out.println(ttl);
double p_v1_y_R = (double)h.get("R_vote_1_Y")/h.get("R");
double p_v1_n_R = (double)h.get("R_vote_1_N")/h.get("R");
double p_v2_y_R = (double)h.get("R_vote_2_Y")/h.get("R");
double p_v2_n_R = (double)h.get("R_vote_2_N")/h.get("R");
double p_v3_y_R = (double)h.get("R_vote_3_Y")/h.get("R");
double p_v3_n_R = (double)h.get("R_vote_3_N")/h.get("R");
double p_v4_y_R = (double)h.get("R_vote_4_Y")/h.get("R");
double p_v4_n_R = (double)h.get("R_vote_4_N")/h.get("R");
double p_v1_y_D = (double)h.get("D_vote_1_Y")/h.get("D");
double p_v1_n_D = (double)h.get("D_vote_1_N")/h.get("D");
double p_v2_y_D = (double)h.get("D_vote_2_Y")/h.get("D");
double p_v2_n_D = (double)h.get("D_vote_2_N")/h.get("D");
double p_v3_y_D = (double)h.get("D_vote_3_Y")/h.get("D");
double p_v3_n_D = (double)h.get("D_vote_3_N")/h.get("D");
double p_v4_y_D = (double)h.get("D_vote_4_Y")/h.get("D");
double p_v4_n_D = (double)h.get("D_vote_4_N")/h.get("D");
double p_R = (double)h.get("R")/ttl; 
double p_D = (double)h.get("D")/ttl;
h1 = new Hashtable<String,Double>();
double p_R_nnnn = p_v1_n_R*p_v2_n_R*p_v3_n_R*p_v4_n_R*p_R;
double p_R_nnny = p_v1_n_R*p_v2_n_R*p_v3_n_R*p_v4_y_R*p_R;
double p_R_nnyn = p_v1_n_R*p_v2_n_R*p_v3_y_R*p_v4_n_R*p_R;
double p_R_nnyy = p_v1_n_R*p_v2_n_R*p_v3_y_R*p_v4_y_R*p_R;
double p_R_nynn = p_v1_n_R*p_v2_y_R*p_v3_n_R*p_v4_n_R*p_R;
double p_R_nyny = p_v1_n_R*p_v2_y_R*p_v3_n_R*p_v4_y_R*p_R;
double p_R_nyyn = p_v1_n_R*p_v2_y_R*p_v3_y_R*p_v4_n_R*p_R;
double p_R_nyyy = p_v1_n_R*p_v2_y_R*p_v3_y_R*p_v4_y_R*p_R;
double p_R_ynnn = p_v1_y_R*p_v2_n_R*p_v3_n_R*p_v4_n_R*p_R;
double p_R_ynny = p_v1_y_R*p_v2_n_R*p_v3_n_R*p_v4_y_R*p_R;
double p_R_ynyn = p_v1_y_R*p_v2_n_R*p_v3_y_R*p_v4_n_R*p_R;
double p_R_ynyy = p_v1_y_R*p_v2_n_R*p_v3_y_R*p_v4_y_R*p_R;
double p_R_yynn = p_v1_y_R*p_v2_y_R*p_v3_n_R*p_v4_n_R*p_R;
double p_R_yyny = p_v1_y_R*p_v2_y_R*p_v3_n_R*p_v4_y_R*p_R;
double p_R_yyyn = p_v1_y_R*p_v2_y_R*p_v3_y_R*p_v4_n_R*p_R;
double p_R_yyyy = p_v1_y_R*p_v2_y_R*p_v3_y_R*p_v4_y_R*p_R;
//democratic
double p_D_nnnn = p_v1_n_D*p_v2_n_D*p_v3_n_D*p_v4_n_D*p_D;
double p_D_nnny = p_v1_n_D*p_v2_n_D*p_v3_n_D*p_v4_y_D*p_D;
double p_D_nnyn = p_v1_n_D*p_v2_n_D*p_v3_y_D*p_v4_n_D*p_D;
double p_D_nnyy = p_v1_n_D*p_v2_n_D*p_v3_y_D*p_v4_y_D*p_D;
double p_D_nynn = p_v1_n_D*p_v2_y_D*p_v3_n_D*p_v4_n_D*p_D;
double p_D_nyny = p_v1_n_D*p_v2_y_D*p_v3_n_D*p_v4_y_D*p_D;
double p_D_nyyn = p_v1_n_D*p_v2_y_D*p_v3_y_D*p_v4_n_D*p_D;
double p_D_nyyy = p_v1_n_D*p_v2_y_D*p_v3_y_D*p_v4_y_D*p_D;
double p_D_ynnn = p_v1_y_D*p_v2_n_D*p_v3_n_D*p_v4_n_D*p_D;
double p_D_ynny = p_v1_y_D*p_v2_n_D*p_v3_n_D*p_v4_y_D*p_D;
double p_D_ynyn = p_v1_y_D*p_v2_n_D*p_v3_y_D*p_v4_n_D*p_D;
double p_D_ynyy = p_v1_y_D*p_v2_n_D*p_v3_y_D*p_v4_y_D*p_D;
double p_D_yynn = p_v1_y_D*p_v2_y_D*p_v3_n_D*p_v4_n_D*p_D;
double p_D_yyny = p_v1_y_D*p_v2_y_D*p_v3_n_D*p_v4_y_D*p_D;
double p_D_yyyn = p_v1_y_D*p_v2_y_D*p_v3_y_D*p_v4_n_D*p_D;
double p_D_yyyy = p_v1_y_D*p_v2_y_D*p_v3_y_D*p_v4_y_D*p_D;
//assigning to hashtable
h1.put("p_D_nnnn", p_D_nnnn);
h1.put("p_D_nnny", p_D_nnny);
h1.put("p_D_nnyn", p_D_nnyn);
h1.put("p_D_nnyy", p_D_nnyy);
h1.put("p_D_nynn", p_D_nynn);
h1.put("p_D_nyny", p_D_nyny);
h1.put("p_D_nyyn", p_D_nyyn);
h1.put("p_D_nyyy", p_D_nyyy);
h1.put("p_D_ynnn", p_D_ynnn);
h1.put("p_D_ynny", p_D_ynny);
h1.put("p_D_ynyn", p_D_ynyn);
h1.put("p_D_ynyy", p_D_ynyy);
h1.put("p_D_yynn", p_D_yynn);
h1.put("p_D_yyny", p_D_yyny);
h1.put("p_D_yyyn", p_D_yyyn);
h1.put("p_D_yyyy", p_D_yyyy);
h1.put("p_R_nnnn", p_R_nnnn);
h1.put("p_R_nnny", p_R_nnny);
h1.put("p_R_nnyn", p_R_nnyn);
h1.put("p_R_nnyy", p_R_nnyy);
h1.put("p_R_nynn", p_R_nynn);
h1.put("p_R_nyny", p_R_nyny);
h1.put("p_R_nyyn", p_R_nyyn);
h1.put("p_R_nyyy", p_R_nyyy);
h1.put("p_R_ynnn", p_R_ynnn);
h1.put("p_R_ynny", p_R_ynny);
h1.put("p_R_ynyn", p_R_ynyn);
h1.put("p_R_ynyy", p_R_ynyy);
h1.put("p_R_yynn", p_R_yynn);
h1.put("p_R_yyny", p_R_yyny);
h1.put("p_R_yyyn", p_R_yyyn);
h1.put("p_R_yyyy", p_R_yyyy);

//System.out.println(h1);

//prediction
File file1 = new File("/home/kaushik/hadoopdownload/testdata");
BufferedReader br1 = new BufferedReader(new FileReader(file1));
BufferedWriter writer = new BufferedWriter(new FileWriter("/home/kaushik/hadoopdownload/testdatawritten1"));
String arry[] = new String[7];
String ss="";String x="",y="";int c=0;int d=0;
String sl;
while ((sl = br1.readLine()) != null)
{
	arry = sl.split(",");
	//System.out.println(arry[6]);
	ss = (arry[3]+arry[4]+arry[5]+arry[6]).toLowerCase();
	x = "p_D_"+ss;
	y = "p_R_"+ss;
	//System.out.println(x+y);
	double m = h1.get(x);
	double n = h1.get(y);
	if(m>n)
	{
		if(arry[2].equals("D"))
		{
			//arry[7] = "1";
			writer.write(sl+",D,");
			d++;
		}
		else
		{
			//arry[7] = "0";
			writer.write(sl+",R,");
		}
	}
	else
	{
		if(arry[2].equals("R"))
		{
			//arry[7] = "1";
			writer.write(sl+",R,");
			d++;
		}
		else
		{
			writer.write(sl+",D,");
			//arry[7] = "0";
		}
	}
	c++;ss = "";x = "p_D_";y="p_R_";
}
writer.close();
System.out.println("Total entries:" + c);
System.out.println("Correct Predection:"+d);
double acc = ((double)d/c)*100;
System.out.println("File with predicted values printed in the last column locn same as input");
System.out.println("Accuracy "+acc+"%");

}

} 