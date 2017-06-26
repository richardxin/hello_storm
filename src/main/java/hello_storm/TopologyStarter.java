package hello_storm;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.topology.TopologyBuilder;

public class TopologyStarter {

	public static void main(String[] args) {
		TopologyBuilder tb = new TopologyBuilder();
		tb.setSpout("spout_id", new MySpout());
		tb.setBolt("bolt_id", new MyBolt()).shuffleGrouping("spout_id");

		Config conf = new Config();
		LocalCluster lc = new LocalCluster();
		lc.submitTopology("Hello_Storm", conf, tb.createTopology());
	}
}
