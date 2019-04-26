package com.webapp.lay.mor.util;

import com.webapp.lay.mor.entity.Visitor;

import java.util.ArrayList;

public class SessionUtil {

	public static Object getVisitorBySessionId(ArrayList<Visitor> visitorList, String sessionIdString) {
		for (int i = 0; i < visitorList.size(); i++) {
			Visitor visitor = visitorList.get(i);
			if (visitor.getSessionIdString().equals(sessionIdString)) {
				return visitor;
			}
		}
		return null;
	}
}
