package org.apache.hadoop.hbase.replication;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HServerAddress;
import org.apache.hadoop.hbase.zookeeper.ZooKeeperWrapper;

public class ReplicationPeer {

  private final String clusterKey;
  private final String id;
  private List<HServerAddress> regionServers =
      new ArrayList<HServerAddress>(0);
  private final AtomicBoolean peerEnabled = new AtomicBoolean();
  // Cannot be final since a new object needs to be recreated when session fails
  private ZooKeeperWrapper zkw;
  private final Configuration conf;

  public ReplicationPeer(Configuration conf, String key, String id, ZooKeeperWrapper zkw) {
    this.conf = conf;
    this.clusterKey = key;
    this.id = id;
    this.zkw = zkw;
  }

  public String getClusterKey() {
    return clusterKey;
  }

  public AtomicBoolean getPeerEnabled() {
    return peerEnabled;
  }

  public List<HServerAddress> getRegionServers() {
    return regionServers;
  }

  public ZooKeeperWrapper getZkw() {
    return zkw;
  }

  public void setRegionServers(List<HServerAddress> regionServers) {
    this.regionServers = regionServers;
  }

  public String getId() {
    return id;
  }

  public Configuration getConfiguration() {
    return conf;
  }
}
