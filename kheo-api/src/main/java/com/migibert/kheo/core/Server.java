package com.migibert.kheo.core;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.migibert.kheo.configuration.ViewDetail;
import com.migibert.kheo.configuration.ViewList;

public class Server {

	@JsonView({ ViewList.class, ViewDetail.class })
	@JsonProperty
	public String hostname;

	@JsonView({ ViewList.class, ViewDetail.class })
	@JsonProperty
	public String host;

	@JsonView({ ViewList.class, ViewDetail.class })
	@JsonProperty
	public String user;

	@JsonView({ ViewList.class, ViewDetail.class })
	@JsonProperty
	public String password;

	@JsonView({ ViewList.class, ViewDetail.class })
	@JsonProperty
	public String privateKey;

	@JsonView({ ViewList.class, ViewDetail.class })
	@JsonProperty
	public int ram;

	@JsonView({ ViewList.class, ViewDetail.class })
	@JsonProperty
	public int cpu;

	@JsonView(ViewDetail.class)
	@JsonProperty
	public OperatingSystem os;

	@JsonView(ViewDetail.class)
	@JsonProperty
	public List<NetworkInterface> networkInterfaces;

	@JsonView(ViewDetail.class)
	@JsonProperty
	public List<Service> services;

	@JsonView(ViewDetail.class)
	@JsonProperty
	public List<ListeningProcess> listeningProcesses;

	public Server() {
	}

	public Server(String hostname, String host, String user, String password, String privateKey, int ram, int cpu,
			List<NetworkInterface> networkInterfaces) {
		this.hostname = hostname;
		this.host = host;
		this.user = user;
		this.password = password;
		this.privateKey = privateKey;
		this.ram = ram;
		this.cpu = cpu;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cpu;
		result = prime * result + ((host == null) ? 0 : host.hashCode());
		result = prime * result + ((hostname == null) ? 0 : hostname.hashCode());
		result = prime * result + ((networkInterfaces == null) ? 0 : networkInterfaces.hashCode());
		result = prime * result + ((os == null) ? 0 : os.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((privateKey == null) ? 0 : privateKey.hashCode());
		result = prime * result + ram;
		result = prime * result + ((services == null) ? 0 : services.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Server other = (Server) obj;
		if (cpu != other.cpu)
			return false;
		if (host == null) {
			if (other.host != null)
				return false;
		} else if (!host.equals(other.host))
			return false;
		if (hostname == null) {
			if (other.hostname != null)
				return false;
		} else if (!hostname.equals(other.hostname))
			return false;
		if (networkInterfaces == null) {
			if (other.networkInterfaces != null)
				return false;
		} else if (!networkInterfaces.equals(other.networkInterfaces))
			return false;
		if (os == null) {
			if (other.os != null)
				return false;
		} else if (!os.equals(other.os))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (privateKey == null) {
			if (other.privateKey != null)
				return false;
		} else if (!privateKey.equals(other.privateKey))
			return false;
		if (ram != other.ram)
			return false;
		if (services == null) {
			if (other.services != null)
				return false;
		} else if (!services.equals(other.services))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
