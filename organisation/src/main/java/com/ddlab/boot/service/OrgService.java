package com.ddlab.boot.service;

import com.ddlab.boot.entity.Location;

public interface OrgService {
	Location getLocationByPincode(String pincode);
}
