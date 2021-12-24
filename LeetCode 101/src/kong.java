import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import javax.naming.Context;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class WordCount {
    public static class TokenizerMapper extends
            Mapper<Object, Text, Text, IntWritable> {
        // 实现map函数
        private final static IntWritable one = new IntWritable(1);
        private Text word = new Text();
        public void map(Object key, Text value, Context context)
                throws IOException, InterruptedException {
            // 将输入的纯文本文件的数据转化成String
            String line = value.toString();
            // 将输入的数据首先按行进行分割
            //StringTokenizer tokenizerArticle = new StringTokenizer(line, "\n");
            // 分别对每一行进行处理
            StringTokenizer tokenizerLine = new StringTokenizer(value.toString());
            while (tokenizerLine.hasMoreTokens()) {
                // 每行按空格划分
                String strStudentId = tokenizerLine.nextToken();// 学生ID
                String strName = tokenizerLine.nextToken();// 科目名称
                String strScore = tokenizerLine.nextToken();// 成绩部分
                word.set(strName);
                int scoreInt = Integer.parseInt(strScore);
                // 输出姓名和成绩
                context.write(word, new IntWritable(scoreInt));
            }
        }
    }

    public static class  IntSumReducer extends
            Reducer<Text, IntWritable, Text, IntWritable> {
        private IntWritable result = new IntWritable();
        // 实现reduce函数
        public void reduce(Text key, Iterable<IntWritable> values,
                           Context context) throws IOException, InterruptedException {
            int sum = 0;
            int count = 0;
            for(IntWritable val : values){
                sum += val.get();
                ++count;
            }
            int average = (int) sum / count;// 计算平均成绩
            result.set(average);
            context.write(key, result);
        }
    }
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        // "localhost:9000" 需要根据实际情况设置一下

        Job job = Job.getInstance(conf, "Score Average");
        job.setJarByClass(WordCount.class);
        // 设置Map、Combine和Reduce处理类
        job.setMapperClass(TokenizerMapper.class);
        job.setCombinerClass(IntSumReducer.class);
        job.setReducerClass(IntSumReducer.class);
        // 设置输出类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        // 设置输入和输出目录
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}