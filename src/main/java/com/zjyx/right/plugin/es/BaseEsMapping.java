package com.zjyx.right.plugin.es;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.apache.commons.lang3.StringUtils;

@Service
public class BaseEsMapping {

	@Autowired
	ESTransportClient transportClient;
	
	@SuppressWarnings("deprecation")
	public <T> String save(String index,String type,T t){
		TransportClient client=transportClient.getClient();
		IndexRequestBuilder indexRequestBuilder =client.prepareIndex(index, type);
		IndexResponse response = indexRequestBuilder.setSource(t.toString()).execute().actionGet();
		return response.getId();
	}
	
	public int deleteById(String index,String type,String id) {
		TransportClient client=transportClient.getClient();
		DeleteResponse response=client.prepareDelete(index, type, id).execute().actionGet();
		return StringUtils.isBlank(response.getId())?0:1;
	}
	
}
