package com.rest.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rest.to.InventoryResult;
import com.rest.to.SearchResult;

/**
 * The Class FileUtil.
 */
@Component
public class FileUtil {

	/**
	 * Write to file.
	 *
	 * @param results
	 *            the results
	 */
	public void writeToFile(final String sku, final List<SearchResult> results) {
		
		String FILEPATH = "/tmp/logs/inventoryresults"+sku+".txt";
		//String FILEPATH = "C:/Nagesh/work/stsworkspace/inventory-checker/inventoryresults"+sku+".txt";
		

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILEPATH))) {
			String content = "Inventory Results for SKU:" + sku + "\n";
			bw.write(content);
			bw.write(
					"-----------------------------------------------------------------------------------------------------------------\n");
			for (SearchResult searchResult: results) {
				if (null != searchResult.getResults()) {
					StringBuilder sb = new StringBuilder();
					for (InventoryResult inventoryResult : searchResult.getResults()) {
						sb.append(inventoryResult.getName());
						sb.append("::");
						if (null != inventoryResult.getInventory()) {
							sb.append(inventoryResult.getInventory().getQuantity());
							sb.append("::");
							sb.append(inventoryResult.getInventory().getStatus());
							sb.append("::");
						}
						sb.append(searchResult.getPrice());
						sb.append("::");
						sb.append(searchResult.getStoreId());
					}
					bw.write(sb.toString());
					bw.write("\n");
				}
			}
			bw.write(
					"-----------------------------------------------------------------------------------------------------------------");
		} catch (IOException e) {
			e.printStackTrace();

		}

	}
}
