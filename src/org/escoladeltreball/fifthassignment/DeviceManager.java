/**
 * 
 */
package org.escoladeltreball.fifthassignment;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author pep
 *
 */
public abstract class DeviceManager {

	protected List<Device> devices;

	/**
	 * This constructors load a list of devices from a file
	 * 
	 * @param fileName
	 * @throws Exception
	 */
	public DeviceManager(final String fileName) throws Exception {
		devices = new ArrayList<>();
		List<String> devicesStr = Files.readAllLines(Paths.get(fileName));
		for (String string : devicesStr) {
			String[] fields = string.split(",");
			Device device = new Device(Long.parseLong(fields[0]), DeviceType.valueOf(fields[1]), fields[2], fields[3],
					Double.parseDouble(fields[4]));
			devices.add(device);
		}
	}

	/**
	 * This method returns a Map of a list of devices associated with a device
	 * type
	 * 
	 * @return Map of a list of devices associated with a device type
	 * @throws Exception
	 *             When devices is null
	 */
	public abstract Map<DeviceType, List<Device>> getMapByType() throws Exception;

	/**
	 * This method returns a Map of a list of devices associated with a device
	 * brand
	 * 
	 * @return Map of a list of devices associated with a device brand
	 * @throws Exception
	 *             When devices is null
	 */
	public abstract Map<String, List<Device>> getMapByBrand() throws Exception;

	/**
	 * This method returns a set of brands
	 * 
	 * @return A set of brands
	 * @throws Exception
	 *             When devices is null
	 */
	public abstract Set<String> getSetByBrands() throws Exception;

	/**
	 * This method returns a sorted list of devices according to a comparator
	 * 
	 * @param comparator
	 *            The sorting field
	 * @return A sorted list of devices according to a comparator
	 * @throws Exception
	 *             When devices null
	 */
	public abstract List<Device> getSortedList(Comparator<Device> comparator) throws Exception;

	/**
	 * This method returns the cheapest device of every type in a map
	 * 
	 * @return The cheapest device of every type in a map
	 * @throws Exception
	 *             When devices is null
	 */
	public abstract Map<DeviceType, Double> findCheapestDeviceOfEachType() throws Exception;

}
