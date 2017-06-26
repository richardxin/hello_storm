package hello_storm;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.topology.TopologyBuilder;

public class TopologyStarter {

	public static void main(String[] args) {
		TopologyBuilder tb = new TopologyBuilder();
		tb.setSpout("my_spout_id", new MySpout());
		tb.setBolt("my_bolt_id", new MyBolt()).shuffleGrouping("my_spout_id");

		Config conf = new Config();
		LocalCluster lc = new LocalCluster();
		lc.submitTopology("Hello Storm", conf, tb.createTopology());
	}
}
