package com.migibert.kheo.core.event;

public enum EventType {
	OS_HARDWARE_PLATFORM_CHANGED, 
	OS_KERNEL_NAME_CHANGED, 
	OS_KERNEL_RELEASE_CHANGED, 
	OS_NAME_CHANGED, 
	NETWORK_INTERFACE_REMOVED, 
	NETWORK_INTERFACE_ADDED, 
	NETWORK_INTERFACE_BROADCAST_CHANGED, 
	NETWORK_INTERFACE_ENCAPSULATION_TYPE_CHANGED, 
	NETWORK_INTERFACE_INET6_ADDRESS_CHANGED, 
	NETWORK_INTERFACE_INET4_ADDRESS_CHANGED, 
	NETWORK_INTERFACE_MAC_ADDRESS_CHANGED, 
	NETWORK_INTERFACE_MASK_CHANGED, 
	SERVICE_REMOVED,
	SERVICE_ADDED,
	LISTENING_PROCESS_ADDED, 
	LISTENING_PROCESS_REMOVED
}