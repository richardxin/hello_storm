package hello_storm;

import java.util.Map;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichBolt;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Tuple;

public class MyBolt  implements IRichBolt{
	
	private Map stormConf;
	private TopologyContext context;
	private OutputCollector collector;
	int sum = 0;

	@Override
	public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
		this.stormConf = stormConf;
		this.context = context;
		this.collector = collector;
		
	}

	@Override
	public void execute(Tuple input) {
		Integer data = input.getIntegerByField("data");  // get data based on field names
		sum += data;
		System.out.println("sum::" + sum);
	
	}

	@Override
	public void cleanup() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		// leave it empty since we are no longer emit data from this bolt
		
	}

	@Override
	public Map<String, Object> getComponentConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

}
