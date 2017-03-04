/**
 * 
 */
package com.rest.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.service.InventorySearchServiceIF;
import com.rest.to.SearchResult;
import com.rest.util.FileUtil;

/**
 * The Class InventorySearchRestController.
 */
@RestController
public class InventorySearchRestController {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(InventorySearchRestController.class);
	
	/** The inventory search service IF. */
	@Autowired
	private InventorySearchServiceIF inventorySearchServiceIF;
	
	@Autowired
	private FileUtil fileUtil;
	/**
	 * Search inventory.
	 *
	 * @param sku the sku
	 * @param storeId the store id
	 * @return the search result
	 */
	@RequestMapping(value = "/search/{sku}", method = RequestMethod.GET)
	public @ResponseBody List<SearchResult> searchInventory(@PathVariable("sku") String sku) {
		logger.info("searchInventory. sku=" + sku);
		List<SearchResult> results = inventorySearchServiceIF.searchInventory(sku);
		fileUtil.writeToFile(sku, results);
		return results;
	}
}
