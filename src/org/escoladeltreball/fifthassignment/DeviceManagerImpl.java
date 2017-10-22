/**
 * 
 */
package org.escoladeltreball.fifthassignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
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
	}

	@Override
	public Map<DeviceType, List<Device>> getMapByType() throws Exception {
		Map<DeviceType, List<Device>> retMap = new HashMap<>();
		List<Device> smartphones = new ArrayList<>();
		List<Device> smartwatches = new ArrayList<>();
		List<Device> labtops = new ArrayList<>();
		List<Device> desktops = new ArrayList<>();
		for (Device device : devices) {
			switch (device.getType()) {
			case smartphone:
				smartphones.add(device);
				break;
			case smartwatch:
				smartwatches.add(device);
				break;
			case labtop:
				labtops.add(device);
				break;
			case desktop:
				desktops.add(device);
				break;
			}
		}
		retMap.put(DeviceType.desktop, desktops);
		retMap.put(DeviceType.labtop, labtops);
		retMap.put(DeviceType.smartphone, smartphones);
		retMap.put(DeviceType.smartwatch, smartwatches);

		return retMap;
	}

	/*
	 * This method returns a set of the distinct brands (no repetitions)
	 */
	private Set<String> getDistinctBrands() {
		Set<String> retSet = new HashSet<>();
		for (Device device : devices) {
			retSet.add(device.getBrand());
		}
		return retSet;
	}

	@Override
	public Map<String, List<Device>> getMapByBrand() throws Exception {
		List<String> brands = new ArrayList<>(getDistinctBrands());
		List<Device>[] arrayListDevices = new ArrayList[brands.size()];
		for (int i = 0; i < arrayListDevices.length; i++) {
			arrayListDevices[i] = new ArrayList<>();
		}
		Map<String, List<Device>> mapByBrands = new HashMap<>();
		for (Device device : devices) {
			for (int i = 0; i < brands.size(); i++) {
				if (device.getBrand().equals(brands.get(i))) {
					arrayListDevices[i].add(device);
					break;
				}
			}
		}
		for (int i = 0; i < brands.size(); i++) {
			mapByBrands.put(brands.get(i), arrayListDevices[i]);
		}
		return mapByBrands;
	}

	@Override
	public Set<String> getSetByBrands() throws Exception {
		return getDistinctBrands();
	}

	@Override
	public List<Device> getSortedList(Comparator<Device> comparator) throws Exception {
		List<Device> sortedDevices = new ArrayList<>(devices);
		Collections.sort(sortedDevices, comparator);
		return sortedDevices;
	}

	@Override
	public Map<DeviceType, Device> findCheapestDeviceOfEachType() throws Exception {
		Map<DeviceType, List<Device>> mapByDeviceType = getMapByType();
		Map<DeviceType, Device> retCheapestDeviceByType = new HashMap<>();
		Device device = null;
		for (DeviceType deviceType : mapByDeviceType.keySet()) {
			List<Device> deviceTypeList = mapByDeviceType.get(deviceType);
			device = findCheapestDevice(deviceTypeList);
			retCheapestDeviceByType.put(deviceType, device);
		}

		return retCheapestDeviceByType;
	}

	/*
	 * This method return the cheapest device from a list of devices
	 */
	private Device findCheapestDevice(List<Device> deviceTypeList) {
		if (deviceTypeList == null || deviceTypeList.size() == 0) {
			return null;
		}
		Device cheapestDevice = deviceTypeList.get(0);
		for (int i = 1; i < deviceTypeList.size(); i++) {
			if (cheapestDevice.getPrice() > deviceTypeList.get(i).getPrice()) {
				cheapestDevice = deviceTypeList.get(i);
			}
		}
		return cheapestDevice;
	}

}
