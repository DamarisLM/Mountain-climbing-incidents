import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;

public class HadoopMountainMapper extends MapReduceBase implements
        Mapper<LongWritable, Text, Text, IntWritable> {
    @Override
    public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
        String line = value.toString();
        String[] data = line.split("~");
        try {
            String mountainName = data[3];
            int count = 1;
            output.collect(new Text(mountainName), new IntWritable(count));
        } catch(ArrayIndexOutOfBoundsException aoe) {
            System.out.println(line);
        }
        }
    }

