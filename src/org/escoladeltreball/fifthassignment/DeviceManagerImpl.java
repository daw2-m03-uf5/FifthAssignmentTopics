/**
 * A concrete device's manager implementation to work collection out in depth
 */
package org.escoladeltreball.fifthassignment;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author pep
 *
 */
public class DeviceManagerImpl extends DeviceManager {

	public DeviceManagerImpl(String fileName) throws Exception {
		super(fileName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Map<DeviceType, List<Device>> getMapByType() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<Device>> getMapByBrand() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getSetByBrands() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Device> getSortedList(Comparator<Device> comparator) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<DeviceType, Double> findCheapestDeviceOfEachType() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
