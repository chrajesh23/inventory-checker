/**
 * 
 */
package com.rest.service.impl;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.rest.service.InventorySearchServiceIF;
import com.rest.service.InventoryService;
import com.rest.to.InventorySearchResponse;
import com.rest.util.FileUtil;

/**
 * The Class RestServiceImpl.
 *
 * @author mandn007
 */
public class InventoryServiceImpl implements InventoryService {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(InventoryServiceImpl.class);

	/** The inventory search service IF. */
	@Autowired
	private InventorySearchServiceIF inventorySearchServiceIF;

	/** The file util. */
	@Autowired
	private FileUtil fileUtil;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rest.service.RestService#searchInventory(java.lang.String)
	 */
	@Override
	public Response searchInventory(final String sku, final String prodDesc, final String zipCode) {
		logger.info("searchInventory. sku=" + sku);
		logger.info(fileUtil.toString());
		List<InventorySearchResponse> results = inventorySearchServiceIF.searchInventory(sku, prodDesc, zipCode);
		// fileUtil.writeToFile(sku, results);
		return Response.status(Status.OK).entity(results).build();
	}

}
